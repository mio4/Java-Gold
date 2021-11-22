<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/17
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>商城首页</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
        <!--最开始使用相对路径找不到js文件，发现使用绝对路径时可以显示BootStrap样式-->
        <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

        <style>
            button{
                margin:5px
            }
        </style>
    </head>
    <body>
        <div class="container">
            <!--静态包含-->
            <!--头信息-->
            <%@include file="user.jsp"%>
            <!--商品导航-->
            <%@include file="navigator.jsp"%>
            <!--轮播图片-->
            <%@include file="timeChangePhoto.jsp"%>
            <!--商品展示-->
            <%@include file="product.jsp"%>
        </div>
    </body>
</html>

