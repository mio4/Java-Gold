<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/9
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>

<!--
    典型的网页
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>分页展示商品</title>
</head>
<body>
    <table border="1" align="center" width="88%">
        <tr>
            <td>商品ID</td>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>market price</td>
            <td>shop price</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageBean.list}" var="p">
            <tr>
                <td><input type="checkbox" name="pid" value="${p.pid}"></td>
                <td>${p.pid}</td>
                <td><img src="${pageContext.request.contextPath}/${p.pimage}" width="80px"></td>
                <td>${p.pname}</td>
                <td>${p.market_price}</td>
                <td>${p.shop_price}</td>
                <td>${p.pdesc}</td>
            </tr>
        </c:forEach>
    </table>

    <center>
        <!--对于第一页的情况 不展示-->
        <c:if test="${pageBean.currPage!=1}">
            <a href="showProductByPage?currPage=1">[首页]</a> <!-- currPage=1 -->
            <a href="showProductByPage?currPage=${pageBean.currPage-1}">[上一页]</a> <!-- currPage-=1 -->
        </c:if>

        <!-- 将所有的页码展示出来 -->
        <c:forEach begin="1" end="${pageBean.totalPage}" var="n">
            <c:if test="${pageBean.currPage == n}">
                ${n}
            </c:if>
            <c:if test="${pageBean.currPage != n}">
                <a href="showProductByPage?currPage=${n}">${n}</a>
            </c:if>
        </c:forEach>

        <!--对于最后一页的情况 不展示-->
        <c:if test="${pageBean.currPage!=pageBean.totalPage}">
            <a href="showProductByPage?currPage=${pageBean.currPage+1}">[下一页]</a> <!-- currPage+=1 -->
            <a href="showProductByPage?currPage=${pageBean.totalPage}">[尾页]</a> <!-- totalPage -->
        </c:if>
        <br/>第${pageBean.currPage}页/共${pageBean.totalPage}页
    </center>
</body>
</html>
