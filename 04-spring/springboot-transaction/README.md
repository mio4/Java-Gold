
### 0x1 创建用户表
```sql
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '用户昵称',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`),
  KEY `idx_user_uid` (`uid`),
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';
```

```sql
CREATE TABLE `user_back` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '用户昵称',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`),
  KEY `idx_user_uid` (`uid`),
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表备份';
```

### 0x2 添加@Transactional 

### 0x3 产生异常