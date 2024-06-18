【背景】
    用户反馈月费会员订阅成功，app会员状态不更新。

    经过排查定位，这个用户在2024-04-21 20:41:04通过ios客户端首次购买了连续包月，在2024-05-01 14:15:50关闭了连续包月，又在2024-05-23 02:15:56通过apptore上恢复连续订阅。并产生一笔扣费。
    计费侧在2024-05-23 02:15:56接收到苹果server端的签约(恢复订阅)通知，将签约信息放到延迟队列中，再由独立的进程处理，避免跟客户端的通知重复处理。由于延迟队列存在脏数据，新增消息没有及时得到处理。导致该用户没有恢复自动续费成功。


【技术方案】

    1、充值网关的doContractNotice接口处理接收苹果iap server端的签约/解约通知，并放入延迟队列，由独立进程延迟15分钟再调用doReplenishContract接口进行签约的兜底。对于同一个用户，之前开通并且关闭了自动续费，再次再app端内开通自动续费，延迟消息就会处理不成功，成为脏数据。因此需要做以下几点优化：
    a、doReplenishContract接口识别为脏数据，返回成功，由延迟队列消费进程及时销毁。
    b、延迟队列消息拉取机制优化，返回每批次成功处理的消息，并通过游标读取下一批次。处理失败消息>0，发送企微告警通知。

【收益】
    解决server端签约消息堵塞和已签约用户在appstore恢复订阅不到账问题。

【验收标准】
1、测试环境复现这种异常场景，并验证修复
2、完成充值网关代码开发和上线，历史脏数据得到清理。



问题现象及原因：

1,用户用苹果手机在设置-订阅中，做续费会员操作，苹果这边签约成功，一，发给服务端签约消息，二，从设置中续费没有订单号，客户端由于处理掉单的逻辑会使用了很早的一笔未发货的订单处理，发给服务端签约消息；

2，redis消息堵塞：收到消息后，服务端根据很早的这笔订单时间判断该订单是否已经处理，查到该订单未发货，进行补单操作，补单失败，导致消息不能删除，发生堵塞


本次提测的taf服务及代码分支(tag)：   
UserBase.ChargeGateWayReplenishServer ：feature/oldbug   
UserBase.ChargeGateWayServer  feature/oldbug

二、改动范围  
补签约接口  
doContractNotice  
iapContractNotifyJob

三、影响范围
线上iap渠道的签约

1.iap 虚拟币与包月正常  
2.iap 连续包月会员到账与签约数据正常  
3.iap渠道自动续费与签约信息维护正常  
4.iap解约逻辑正常  
5.iap第二次购买连续包月，会员到账与签约正常  
6.iap解约后，在设置中恢复订阅正常  



机器：go 11.180.154.59
命令：
    redis-cli -h cacheins1.ywchargetest.TXWX.db -p 30018 -a 'ywcharge#Test0823'

    key：IAP_CONTRACT_NOTIFY

查询堵塞数据
    ZRANGEBYSCORE IAP_CONTRACT_NOTIFY 1717549062 1717549063 WITHSCORES LIMIT  0 10

测试环境构造red is堵塞数据
zadd IAP_CONTRACT_NOTIFY  1717549062 "{\"channelId\":7,\"contractCode\":7376575216505419958,\"contractId\":\"1490000004177360\",\"expiredDate\":\"2024-07-04 17:19:24\",\"orderNo\":\"1490000004177360\",\"productId\":\"m.qidian.QDReaderAppStore.month.continue.1000dian.1stperiod.500dian\",\"userGuid\":119191121540}"

iapContractNotifyJob 补签约定时任务    充值补单服务  定时任务
执行定时任务，堵塞数据被清除，查询堵塞数据，已被删除


测试环境同步线上阻塞的数据 指定guid  
tb_pre_deposit_order  
tb_iap_log   
tb_contract_info   
tb_contract_log   
tb_third_contract_info  
tb_iap_transaction_id  
tb_channel_order_relation  
+redis 

854061476082
120345908304
120148871415
3118372404
119101681634


/*slave*/select order_id,order_no,yworder_id,product_id,user_guid,log_time,channelid,amount,ywamount,order_status,updatetime from tb_pre_deposit_order WHERE user_guid = 120061051633 and order_status =2 order by log_time desc;

