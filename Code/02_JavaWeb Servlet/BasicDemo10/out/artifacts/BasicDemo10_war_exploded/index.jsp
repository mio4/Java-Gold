<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/25
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Title</title>
  <link rel="stylesheet" href="css/bootstrap.css"/>
  <!--<script src="js/jquery-1.11.0.js"></script>-->
  <script src="js/jquery-1.8.3.js"></script>
  <script src="js/bootstrap.js"></script>

  <style>
    button{
      margin:5px
    }
  </style>
</head>
<body>
<div class="container">
    <h1>${user.username}:welcome back</h1>
  <a href="login.jsp">
    <button type="button" class="btn btn-default pull-left">登录</button>
  </a>

  <a href="register.html">
    <button type="button" class="btn btn-primary pull-left">注册</button>
  </a>
</div>
</body>
</html>
