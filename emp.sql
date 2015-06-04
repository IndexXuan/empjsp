show databases;
create table t_emp(
	id  bigint primary key auto_increment,
	name varchar(50) unique,
	salary double,
	age int
);
<!--查看表结构-->
desc t_emp;
insert into t_emp(name,salary,age) values('张三',5000,23);
insert into t_emp(name,salary,age) values('zhangsan',5000,23);
insert into t_emp(name,salary,age) values('李四',5000,23);
delete from t_emp;
select * from t_emp;
set character_set_database=utf8;
alter database york character set utf8;
alter table t_emp character set utf8;
show variables like 'character%';

<!--创建用户表-->
create table t_user(
	id bigint primary key auto_increment,
	username varchar(50) unique,
	name varchar(50),
	pwd varchar(20),
	gendar char(1)
);
insert into t_user (username,name,pwd,gendar) values ('管理员','张三','1234','f');
select * from t_user;
desc t_user;




