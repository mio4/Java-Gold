create table tb_user(
	id int(11) primary key auto_increment,
	name varchar(20) default null,
	sex varchar(10) default null,
	age int(10) default null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
CREATE TABLE TB_USER2(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(20),
	user_sex VARCHAR(20),
	user_age INT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO TB_USER2(user_name,user_sex,user_age) VALUES ('jack','男',22);
INSERT INTO TB_USER2(user_name,user_sex,user_age) VALUES ('rose','女',18);
INSERT INTO TB_USER2(user_name,user_sex,user_age) VALUES ('tom','男',25);
INSERT INTO TB_USER2(user_name,user_sex,user_age) VALUES ('mary','女',28);

-- 
CREATE TABLE TB_CLAZZ(
	id INT PRIMARY KEY AUTO_INCREMENT,
	CODE VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO TB_CLAZZ(CODE) VALUES ('J001');
INSERT INTO TB_CLAZZ(CODE) VALUES ('J002');
INSERT INTO TB_CLAZZ(CODE) VALUES ('J003');

CREATE TABLE TB_STUDENT(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	sex VARCHAR(20),
	clazz_id INT,
	FOREIGN KEY (clazz_id) REFERENCES TB_CLAZZ(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO TB_STUDENT(NAME,sex,age,claZZ_id) VALUES('jack','男',22,1);
INSERT INTO TB_STUDENT(NAME,sex,age,claZZ_id) VALUES('rose','女',18,1);
INSERT INTO TB_STUDENT(NAME,sex,age,claZZ_id) VALUES('tom','男',25,2);
INSERT INTO TB_STUDENT(NAME,sex,age,claZZ_id) VALUES('mary','女',28,2);

-- 第10章 Mybaits中的关联映射
-- 一对一映射
CREATE TABLE tb_card(
	id INT PRIMARY KEY AUTO_INCREMENT,
	CODE VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_card(CODE) VALUES ('432801198009191038');

CREATE TABLE tb_person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
	sex VARCHAR(20),
	age INT,
	card_id INT UNIQUE,
	FOREIGN KEY(card_id) REFERENCES tb_card(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_person(name,sex,age,card_id) VALUES('jack','男',23,1);

-- 一对多映射
CREATE TABLE tb_clazz(
	id INT PRIMARY KEY AUTO_INCREMENT,
	CODE VARCHAR(20),
	NAME VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_clazz (CODE,NAME) VALUES ('J001','淑芬');

CREATE TABLE tb_student(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	SEX VARCHAR(20),
	AGE INT,
	clazz_id INT,
	FOREIGN KEY (clazz_id) REFERENCES tb_clazz(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_student(NAME,SEX,AGE,clazz_id) VALUES('jack','男',22,1);
INSERT INTO tb_student(NAME,SEX,AGE,clazz_id) VALUES('rose','女',18,1);
INSERT INTO tb_student(NAME,SEX,AGE,clazz_id) VALUES('tom','男',25,2);
INSERT INTO tb_student(NAME,SEX,AGE,clazz_id) VALUES('mary','女',28,2);




-- 多对多映射

#用户表
CREATE TABLE TB_USER(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20),
	loginname VARCHAR(20),
	password VARCHAR(20),
	phone VARCHAR(10),
	address VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_USER(username,loginname,password,phone,address) VALUES('杰克','JACK','123456','13920001616','广州')

#创建商品表
CREATE TABLE TB_ARTICLE(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
	price DOUBLE,
	remark VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_ARTICLE(name,price,remark) VALUES('疯狂Java讲义',100.0,'a book');
INSERT INTO TB_ARTICLE(name,price,remark) VALUES('疯狂C++讲义',111.0,'a book');
INSERT INTO TB_ARTICLE(name,price,remark) VALUES('疯狂IOS讲义',122.0,'a book');
INSERT INTO TB_ARTICLE(name,price,remark) VALUES('疯狂Android讲义',130.0,'a book');


#创建订单表
CREATE TABLE TB_ORDER(
	id INT PRIMARY KEY AUTO_INCREMENT,
	code VARCHAR(20),
	total DOUBLE,
	user_id INT,
	FOREIGN KEY (user_id) REFERENCES TB_USER(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_ORDER(code,total,user_id) VALUES('4444448888',300.1,1);
INSERT INTO TB_ORDER(code,total,user_id) VALUES('4414545658',400.1,1);

#创建中间表
CREATE TABLE TB_ITEM(
	order_id INT,
	article_id INT,
	amount INT,
	PRIMARY KEY(order_id,article_id),
	FOREIGN KEY(order_id) REFERENCES TB_ORDER(id),
	FOREIGN KEY(article_id) REFERENCES TB_ARTICLE(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_ITEM(order_id,article_id,amount) VALUES(1,1,1);
INSERT INTO TB_ITEM(order_id,article_id,amount) VALUES(1,2,1);
INSERT INTO TB_ITEM(order_id,article_id,amount) VALUES(1,3,2);
INSERT INTO TB_ITEM(order_id,article_id,amount) VALUES(2,1,1);

-- 动态SQL
CREATE TABLE TB_EMPLOYEE(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	loginname VARCHAR(20),
	password VARCHAR(20),
	name VARCHAR(20) DEFAULT NULL,
	sex char(2) DEFAULT NULL,
	age INT(11) DEFAULT NULL,
	phone VARCHAR(20),
	sal DOUBLE,
	state VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_EMPLOYEE(loginname,password,name,sex,age,phone,sal,state) VALUES ('JACK','123456','杰克','男',26,'1390201999',9800,'ACTIVE');
INSERT INTO TB_EMPLOYEE(loginname,password,name,sex,age,phone,sal,state) VALUES ('ROSE','123456','罗斯','女',21,'1390201888',6800,'ACTIVE');
INSERT INTO TB_EMPLOYEE(loginname,password,name,sex,age,phone,sal,state) VALUES ('tom','123456','汤姆','男',27,'1390201777',8800,'ACTIVE');
INSERT INTO TB_EMPLOYEE(loginname,password,name,sex,age,phone,sal,state) VALUES ('alice','123456','阿里斯','女',30,'13901021666',10000,'ACTIVE');

-- MyBatis缓存

create table tb_user(
	id int(11) primary key auto_increment,
	name varchar(20) default null,
	sex varchar(10) default null,
	age int(10) default null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_USER(name,sex,age) VALUES('JAKC','男',20);
INSERT INTO TB_USER(name,sex,age) VALUES('ROSE','女',21);
INSERT INTO TB_USER(name,sex,age) VALUES('TOM','男',22);
INSERT INTO TB_USER(name,sex,age) VALUES('ALICE','女',23);
INSERT INTO TB_USER(name,sex,age) VALUES('MOSE','女',23);


-- MyBatis注解开发

create table tb_user(
	id int(11) primary key auto_increment,
	name varchar(20) default null,
	sex varchar(10) default null,
	age int(10) default null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_USER(name,sex,age) VALUES('JAKC','男',20);
INSERT INTO TB_USER(name,sex,age) VALUES('ROSE','女',21);
INSERT INTO TB_USER(name,sex,age) VALUES('TOM','男',22);
INSERT INTO TB_USER(name,sex,age) VALUES('ALICE','女',23);
INSERT INTO TB_USER(name,sex,age) VALUES('MOSE','女',23);


-- Spring4+MyBatis3整合

USE DATABASE mybatis4;
#创建用户表
CREATE TABLE TB_USER(
	id INT PRIMARY KEY AUTO_INCREMENT,
	loginname VARCHAR(20) UNIQUE, #用户名
	password VARCHAR(20), #密码
	username VARCHAR(20), #用户名
	phone VARCHAR(20), #电话
	address VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_USER (loginname,password,username,phone,address) VALUES('jack','123456','杰克','13920001234','广州中山');

CREATE TABLE TB_BOOK(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	author VARCHAR(20),
	publicationdate DATE,
	publication VARCHAR(100),
	price DOUBLE,
	image VARCHAR(20),
	remark VARCHAR(20) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_BOOK (id,name,author,publicationdate,publication,price,image,remark) VALUES (1,'疯狂Java讲义','none','2008-01-01','电子工业出版社',40.0,'java.jpg','我就解放快乐圣诞节爱发科');
INSERT INTO TB_BOOK (id,name,author,publicationdate,publication,price,image,remark) VALUES (2,'疯狂Android讲义','none','2010-01-08','电子工业出版社',50.0,'ee.jpg','家法律的建安费');
INSERT INTO TB_BOOK (id,name,author,publicationdate,publication,price,image,remark) VALUES (3,'疯狂IOS讲义','none','2012-10-01','电子工业出版社',60.0,'andrio.jpg','国家劳动节快乐发');
INSERT INTO TB_BOOK (id,name,author,publicationdate,publication,price,image,remark) VALUES (4,'疯狂C','none','2015-06-12','电子工业出版社',70.0,'c.jpg','华科大姐夫');


-- 
-- 人事管理项目
-- 


#创建数据库hrm_db
CREATE DATABASE hrm_db3;
#使用数据库hrm_db
USE hrm_db;
#创建表dept_inf
	CREATE TABLE dept_inf (
	  ID INT(11) NOT NULL AUTO_INCREMENT,
	  NAME VARCHAR(50) NOT NULL,
	  REMARK VARCHAR(300) DEFAULT NULL,
	  PRIMARY KEY (ID)
	) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
INSERT  INTO dept_inf(ID,NAME,REMARK) VALUES (1,'技术部','技术部'),(2,'运营部','运营部'),(3,'财务部','财务部'),(5,'总公办','总公办'),(6,'市场部','市场部'),(7,'教学部','教学部');
#创建表job_inf
CREATE TABLE job_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  REMARK VARCHAR(300) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
INSERT  INTO job_inf(ID,NAME,REMARK) VALUES (1,'职员','职员'),(2,'Java开发工程师','Java开发工程师'),(3,'Java中级开发工程师','Java中级开发工程师'),(4,'Java高级开发工程师','Java高级开发工程师'),(5,'系统管理员','系统管理员'),(6,'架构师','架构师'),(7,'主管','主管'),(8,'经理','经理'),(9,'总经理','总经理');
#创建表user_inf
CREATE TABLE user_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  loginname VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(16) NOT NULL,
  STATUS INT(11) NOT NULL DEFAULT '1',
  createdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  username VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT  INTO user_inf(ID,loginname,PASSWORD,STATUS,createdate,username) VALUES (1,'admin','123456',2,'2016-03-12 09:34:28','超级管理员');
#创建表employee_inf
CREATE TABLE employee_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  DEPT_ID INT(11) NOT NULL,
  JOB_ID INT(11) NOT NULL,
  NAME VARCHAR(20) NOT NULL,
  CARD_ID VARCHAR(18) NOT NULL,
  ADDRESS VARCHAR(50) NOT NULL,
  POST_CODE VARCHAR(50) DEFAULT NULL,
  TEL VARCHAR(16) DEFAULT NULL,
  PHONE VARCHAR(11) NOT NULL,
  QQ_NUM VARCHAR(10) DEFAULT NULL,
  EMAIL VARCHAR(50) NOT NULL,
  SEX INT(11) NOT NULL DEFAULT '1',
  PARTY VARCHAR(10) DEFAULT NULL,
  BIRTHDAY DATETIME DEFAULT NULL,
  RACE VARCHAR(100) DEFAULT NULL,
  EDUCATION VARCHAR(10) DEFAULT NULL,
  SPECIALITY VARCHAR(20) DEFAULT NULL,
  HOBBY VARCHAR(100) DEFAULT NULL,
  REMARK VARCHAR(500) DEFAULT NULL,
  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID),
  KEY FK_EMP_DEPT (DEPT_ID),
  KEY FK_EMP_JOB (JOB_ID),
  CONSTRAINT FK_EMP_DEPT FOREIGN KEY (DEPT_ID) REFERENCES dept_inf (ID),
  CONSTRAINT FK_EMP_JOB FOREIGN KEY (JOB_ID) REFERENCES job_inf (ID)
) ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT  INTO employee_inf(ID,DEPT_ID,JOB_ID,NAME,CARD_ID,ADDRESS,POST_CODE,TEL,PHONE,QQ_NUM,EMAIL,SEX,PARTY,BIRTHDAY,RACE,EDUCATION,SPECIALITY,HOBBY,REMARK,CREATE_DATE) 
VALUES (1,1,8,'爱丽丝','4328011988','广州天河','510000','020-77777777','13902001111','36750066','251425887@qq.com',0,'党员','1980-01-01 00:00:00','满','本科','美声','唱歌','四大天王','2016-03-14 11:35:18'),
(2,2,1,'杰克','22623','43234','42427424','42242','4247242','42424','251425887@qq.com',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-03-14 11:35:18'),
 (3,1,2,'bb','432801197711251038','广州','510000','020-99999999','13907351532','36750064','36750064@qq.com',1,'党员','1977-11-25 00:00:00','汉','本科','计算机','爬山','无','2016-07-14 09:54:52');
#创建表notice_inf
CREATE TABLE notice_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  TITLE VARCHAR(50) NOT NULL,
  CONTENT TEXT NOT NULL,
  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  USER_ID INT(11) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY FK_NOTICE_USER (USER_ID),
  CONSTRAINT FK_NOTICE_USER FOREIGN KEY (USER_ID) REFERENCES user_inf (ID)
) ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
#创建表document_inf
CREATE TABLE document_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  TITLE VARCHAR(50) NOT NULL,
  filename VARCHAR(300) NOT NULL,
  REMARK VARCHAR(300) DEFAULT NULL,
  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  USER_ID INT(11) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY FK_DOCUMENT_USER (USER_ID),
  CONSTRAINT FK_DOCUMENT_USER FOREIGN KEY (USER_ID) REFERENCES user_inf (ID)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;














