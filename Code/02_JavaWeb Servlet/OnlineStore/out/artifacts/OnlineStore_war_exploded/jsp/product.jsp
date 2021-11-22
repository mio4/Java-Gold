<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/20
  Time: 20:56
  To change this template use File | Settings | File Templates.
  展示最新商品和热门商品
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<h1>热门商品</h1>
<c:forEach items="${hotProductList}" var="p">
    <div class="col-md-2 col-sm-4 col-xs-12" style="height: 200px; width: 150px">
        <img src="${pageContext.request.contextPath}/${p.pimage}" alt="nothing" width="150" height="150"/>
        <center><a href="${pageContext.request.contextPath}/product?method=getById&pid=${p.pid}">${p.pname}</a></center>
        <center>￥${p.shop_price}</center>
    </div>
</c:forEach>


<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>

<h1>最新商品</h1>
<c:forEach items="${newProductList}" var="p">
    <div class="col-md-2 col-sm-4 col-xs-12" style="height: 200px; width: 150px">
        <img src="${pageContext.request.contextPath}/${p.pimage}" alt="nothing" width="150" height="150"/>
        <center><a href="${pageContext.request.contextPath}/product?method=getById&pid=${p.pid}">${p.pname}</a></center>
        <center>￥${p.shop_price}</center>
    </div>
</c:forEach>




