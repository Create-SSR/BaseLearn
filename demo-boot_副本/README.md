springboot项目创建  
地址  
https://start.spring.io/



创建数据库：
CREATE DATABASE springTest CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
创建表：
CREATE TABLE student(id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(50) NOT NULL,email VARCHAR(100) NOT NULL,age INT);

常用注解
https://blog.csdn.net/happy_a_bin/article/details/120013976?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522171869605916800182117556%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=171869605916800182117556&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-4-120013976-null-null.142^v100^pc_search_result_base8&utm_term=%20because%20this.studentRepository%20is%20null&spm=1018.2226.3001.4187


打包：
mvn clean install 

cd /Users/wangqian/Documents/github/BaseLearn/demo-boot_副本/target/demo-boot-0.0.1-SNAPSHOT.jar
在taiget文件下使用命令行运行：
java -jar demo-boot-0.0.1-SNAPSHOT.jar

maven环境配置

open ~/.bash_profile

#Maven
export MAVEN_HOME=/Users/lhx/devlop_for_mac/devlop/apache-maven-3.9.6
export PATH=${MAVEN_HOME}/bin:$PATH:.

source ~/.bash_profile


linux 命令：
目录文件  
![alt 图标] ![iShot_2024-06-19_10.22.26.png](..%2F..%2F..%2F..%2FDownloads%2FiShot_2024-06-19_10.22.26.png)  

查看目录下的文件属性
ll
ls -al

{10:20}~/Documents/github/BaseLearn/demo-boot_副本:main ✗ ➭ ll
total 72
-rw-r--r--@  1 wangqian  staff   1.3K Jun 18 10:20 HELP.md
-rw-r--r--@  1 wangqian  staff   1.2K Jun 19 10:24 README.md
-rw-r--r--@  1 wangqian  staff   205B Jun 18 10:31 demo-boot.iml

文件类型     属主权限           属组权限      其他用户权限
0            123               456           789
d 目录文件   rwx 读/写/执行      r-x            r-x        -代表没有该权限

cd  切换目录
ls  列出目录下文件
pwd  输出目录路径
tree  以树形结构展示
touch  新建文件
ln -s 1.log  1    为该文件建立一个链接

cat 查看文件内容

chmod   修改文件权限
chmod +x  1.log
chmod a+x  1.log 对所有用户添加权限

chmod 777 1.log   所有用户添加权限

chown 修改文件所处属组
useradd 添加用户
chown  user:user 1.log

find . -name 1.log

cp 复制
cp 1.log  2.log

scp 从两个IP之间传输文件

mv 1.log dir/ 移动文件目录

rm  删除文件
rm -rf 1.log   强制删除

head -n 1 1.log 查看文件前几行
tail  -n 2 1.log  查看文件末尾几行
tail -f 1.log   文件有更新，一直查看文件末尾

less  
more

sed -n '1p' 1.log







