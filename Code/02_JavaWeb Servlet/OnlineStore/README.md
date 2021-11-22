# 项目简介

从零开始实现一个简单网上商城项目

 - 实现功能
    - 1. 购物页面
     - 2. 登录注册
     - 3. 后台管理
     - 4. 购物车系统
- 前端
    - BootStrap
    - JQuery
 - 后端
  - Servlet + Service + Dao + MySQL
  - 缓存：Ehcache  	

# 项目完成度

### Part 1

- [x] 用户注册
- [x] 邮件激活
- [x] 用户登录
- [x] 异步展示导航栏
- [x] 首页展示热门 | 最新商品
- [x] 点击商品，跳转到商品详情页面
- [x] 点击导航栏，实现商品的分页展示
- [ ] 购物车：将商品添加到购物车，从购物车删除商品，清空购物车
- [ ] 生成订单





### Part 2

- [ ] 虚拟机上线
- [ ] 个人网站上线

# 数据库

- 表
  - 用户表
  - 商品表
  - 订单表
  - 分类表
  - order item 订单项

 - 用户表分析 User Table
      - username
      - password
      - id
      - true name 真实姓名
      - email
      - gender 性别
      - phone
      - birthday
      - active code 激活码
      - 用户状态

- 订单 orders  Orders Table
  - 订单id
  - 总金额
  - 订单状态
  - 姓名
  - 地址
  - 电话
  - **用户ID** 外键
- 商品 Product
  - id
  - 商品名称
  - 市场价
  - 商城价
  - 库存
  - **分类id** 外键 
- 分类 Category
  - id
  - 分类名称
- order item
  - 订单项id
  - 订单id
  - 商品id
  - 商品购买数量id

## 用户表

CREATE TABLE `user` (
`uid` varchar(32) NOT NULL,
`username` varchar(20) DEFAULT NULL,
`password` varchar(100) DEFAULT NULL,
`name` varchar(20) DEFAULT NULL,
`email` varchar(30) DEFAULT NULL,
`telephone` varchar(20) DEFAULT NULL,
`birthday` varchar(20) DEFAULT NULL,
`sex` varchar(10) DEFAULT NULL,
`state` int(11) DEFAULT NULL,
`code` varchar(64) DEFAULT NULL,
PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



## 分类表

CREATE TABLE `category` (
`cid` varchar(32) NOT NULL,
`cname` varchar(20) DEFAULT NULL,
PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



##商品表

CREATE TABLE `product` (
	  `pid` varchar(32) NOT NULL,
	  `pname` varchar(50) DEFAULT NULL,
	  `market_price` double DEFAULT NULL,
	  `shop_price` double DEFAULT NULL,
	  `pimage` varchar(200) DEFAULT NULL,
	  `pdate` date DEFAULT NULL,
	  `is_hot` int(11) DEFAULT NULL,
	  `pdesc` varchar(255) DEFAULT NULL,
	  `pflag` int(11) DEFAULT NULL,
	  `cid` varchar(32) DEFAULT NULL,
	  PRIMARY KEY (`pid`),
	  KEY `sfk_0001` (`cid`),
	  CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 技术分析-待定

- 技术分析

  - 数据库和表
  - jar包
    - 驱动
    - c3p0
    - dbutils
    - beanutils
    - jstl
    - 发送邮件的jar包
  - 工具类
    - datasourceutils
    - c3p0配置文件
    - uploadutils
    - md5utils 加密
    - mailutils 邮件

- 包结构

  - com.mio4

    - web.servlet
    - service 接口
    - service implementsClass 实现类
    - domain
    - dao 接口
    - dao implementsClass 实现类
    - utils
    - constant
    - filter


## 项目框架

- BaseServlet：所有Servlet的基类，Service（）方法重写
- index.jsp：不直接访问，使用/index访问servlet转发到/jsp/index.jsp

- UserService
  - 调用Dao
  - 发送激活邮件

### 密码保护

	 - 使用MD5对密码加密：MD5Utils.md5(String password)

### 模拟激活邮件

- 邮件服务器：设置域名 @store.com
- 添加账号
- 添加管理员账号

---

## 用户行为

- 注册
  - 邮件激活
- 登录
- 退出


## 缓存

 - 对于同一个用户，查询数据库的结果保存下来，减轻服务器压力
 - 使用ehcache
    - 导入Jar包
    - 配置文件
    - 调用API
    

















































