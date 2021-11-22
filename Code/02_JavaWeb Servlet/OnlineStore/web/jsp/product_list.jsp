<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/31
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类</title>
</head>
<body>
    <h4>一个简易的商品展示页面</h4>
    <c:forEach items="${pageBean.list}" var="p">
        <div>
            <a href="">
                <img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170" style="display: inline-block;"/>
                <a href="${pageContext.request.contextPath}/product?method=getById&pid=${p.pid}">${p.pname}</a>

            </a>
        </div>
    </c:forEach>

    <!--实现商品分页-->
    <!--TODO-->
</body>
</html>
