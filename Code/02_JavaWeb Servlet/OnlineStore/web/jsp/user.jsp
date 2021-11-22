<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/20
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--用户-->
<!-- 注意这里jstl的使用 -->

    <c:if test="${empty user}">
        <a href="${pageContext.request.contextPath}/user?method=loginUI">
            <button type="button" class="btn btn-default pull-left">登录</button>
        </a>
        <a href="${pageContext.request.contextPath}/user?method=registUI">
            <button type="button" class="btn btn-primary pull-left">注册</button>
        </a>
    </c:if>
    <c:if test="${not empty user}">
        <a href="${pageContext.request.contextPath}/user?method=logOut">
            <button type="button" class="btn btn-warning pull-left">账号退出</button>
        </a>
        <a href="#">
            <button type="button" class="btn btn-primary pull-left">我的订单</button>
        </a>
    </c:if>
    <a href="${pageContext.request.contextPath}/#">
        <button type="button" class="btn btn-danger pull-left">购物车</button>
    </a>
    <a href="${pageContext.request.contextPath}/jsp/ajaxShow.jsp">
        <!-- AJAX：测试导航栏的异步查询 -->
        <button type="button" class="btn btn-default pull-left">异步展示导航栏</button>
    </a>
    <hr/>
