<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/20
  Time: 19:48
  To change this template use File | Settings | File Templates.
  备注：这个页面单纯是为了展示使用AJAX从数据库中异步查询得到商品分类的效果
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>异步展示导航栏</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
    <%@include file="/jsp/navigator.jsp"%>
</body>
</html>
