<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/17
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize_login.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
    <!--[if IE]>
    <script src="${pageContext.request.contextPath}/js/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>注册一个新的账号</h3>
                <form action="${pageContext.request.contextPath}/user?method=regist" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                    </div>
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入真实姓名">
                    </div>
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="email" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入邮箱">
                    </div>
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="sex" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入性别">
                    </div>
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="birthday" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入生日,形式如2018-06-10">
                    </div>
<%--
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="hobby" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入爱好">
                    <div class="mb2">
--%>
                        <!--<a class="act-but submit" href="/BasicDemo5/register" style="color: #FFFFFF">注册</a>-->
                        <input type="submit" class="act-but" value="                             注册                             " style="color: #FFFFFF">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
</body>
</html>
