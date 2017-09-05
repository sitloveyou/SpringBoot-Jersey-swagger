# SpringBoot-Jersey-swagger
在Springboot 框架中 使用Jersey 作为Restful前端框架，并使用Swagger作为文档工具

## Kotlin
在框架中是哦用Kotlin代码替代原始的Java 代码，在Api层完成了GET POST 请求、在Dao层完成了JPA的数据库操作

## 数据库连接
使用了阿里巴巴提供的druid连接池，并配置了连接池监控。
Spring boot JPA 提供了 ORM方式操作数据库

## 多模块架构
使用gradle构建工具，比Maven更方便、快捷
在框架方案中，采用了多模块设计，将api 和 dao 分离为两个模块
