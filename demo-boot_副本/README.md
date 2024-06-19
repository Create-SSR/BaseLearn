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
