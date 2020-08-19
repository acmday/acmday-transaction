# acmday-transaction

## 一、说明
- 该工程用于数据库相关技术的学习实践,不仅仅是事物
- 功能入口在test目录下

## 二、DDL

```sql
CREATE TABLE `student` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL DEFAULT '""' COMMENT '姓名',
  `address` varchar(45) NOT NULL DEFAULT '""' COMMENT '家庭住址',
  `age` tinyint(4) NOT NULL DEFAULT '1' COMMENT '年龄',
  PRIMARY KEY (`id`),
  KEY `name_idx` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```
