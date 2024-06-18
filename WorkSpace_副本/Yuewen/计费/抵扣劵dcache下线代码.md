
PayGateWayServer   pre.UserBase.PayGateWayServer.sh100961       11.180.159.26:17659

BookBillingServer  pre.Book.BookBillingServer.sh100073          11.180.158.170:19113

技术方案】

    1、修改PayGateWayServer服务代码，剥离BookBillingServer的依赖
    2、修改BookBillingServer服务代码，删除Dcache的读写代码。
    3、2024-05-26之后，查看BookBillingServer的007监控，确认已没有payV4接口调用
    4、去除货币1101的应用绑定，灰度生效
    5、灰度上线PayGateWayServer
    6、灰度上线BookBillingServer

【收益】   
    1、去除PayGateWayServer对BookBillingServer调用，提升余额查询性能。  
    2、去除BookBillingServer对Dcache的依赖，彻底下线Dcache，节省成本。

【验收标准】  
    1、完成PayGateWayServer和BookBillingServer上线  
    2、完成Dcache的下线。

本次提测的taf服务及代码分支(tag)：   
Book.BookBillingServer feature/remove_dcache_dev   
UserBase.PayGatewayServer feature/remove_bookbilling

是否涉及jce的改动？
1. PayGatewayServer 删除有关BookbillingServer的调用
2. BookbillingServer 删除有关Dcache的调用，涉及一下接口      
    有改动的接口   
            getBalanceV4   
        getIntegralBalance   
    下线接口   
        getSpecialBalance   
        payV4   
        payV5   
        getBalanceDetailBatch   
        cleanBalance   

是否设计jce的改动？  
1，payGateWayServer 删除有关BookBillingServer的调用   
2，BookBillingServer 删除有关Dcache的调用，涉及以下接口   
    有改动的接口:   
        getBalanceV4   
        getIntegralBalance   
    下线接口   
        getSpecialBalance   
        payV4   
        payV5    
        getBalanceDetailBatch    
        cleanBalance    

public void getBalanceV4(JsonNode date) throws Exception {
    String msg = "getBalanceV4";
    
}