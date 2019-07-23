---
title: studentSystem
tags: QLazy
grammar_cjkRuby: true
grammar_code: true
---


> 前言

这是一个基于Spring Boot的简单学生系统，虽然真的是一个很简单的系统，但也学到了不少东西，后端写了一天不到，前端弄了好久，还好找到了Bootstrap这个很好用的前端轮子库

> 开发环境

- JDK 1.8
- Maven
- Orcal 11g
- Spring Tool Suite4（eclipse）




> 技术选型
###### 前端技术：

- Thymeleaf：Spring Boot官方推荐的模板引擎
- JavaScript

###### 后端技术：

- Spring Boot框架：很好用的基础层框架
- Lombok：一个很好用的jar包，暂时只用到它自动创建set、get和toString方法
- Mybatis：暂时只用到它Mapper映射功能，持久层框架

>基本思路

用Soring Boot 与Mybatis联动来调用数据库，Lombok来给项目中的实体类自动创建set、get和toString方法，用Thymeleaf来连接前后端，JavaScript+HTML来编写前端代码

> 实现功能

 - 数据库的增删改查
 - 根据上传的Excel文件更新或创建相应的班级
 - 后续待加
 
> 注意点
 
 - Lombok导入jar包后，还要安装后才能使用
 - 使用ajax的时候要注意Controller层的注解，使用@Controller会导致返回报错，它只能返回到页面，想要返回Json数据就要使用@RestController注解，这个注解相当于@Controller+@ResponseBody
 - Spring Boot是默认不让访问template中的文件，需要更改权限后才能访问
 - form表单的name与ID问题，尽量保持一致，好辨认
 - Mybatis中的#与$问题，#会自动给内容加上“”，$则不会，所以$一般被用来注入表名
 
> 简单感想

真的做得很简陋，期待之后能把它不断完善起来，在这几天的编写过程中学到了很多，也把之前的知识点串起来了，之后想到什么意思的功能就会把它加到这来，最终想法是能将其打造成学生与老师两个版本，再加上一个公共的聊天场地。

---
**2019-7-23更新**

- 修复一些BUG
- 将部分功能改为ajax
 