<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/2
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <a href="jsp/page.jsp">Page页面</a>
        <hr>
        <a href="jsp/include/pagecontext.jsp">关于pageContext的测试</a>
        <hr>
        <a href="jsp/action/forward.jsp">跳转页面</a>
        <hr>
        <a href="jsp/action/include.jsp">include动态包含页面</a>
        <hr>
        <a href="jsp/include/include.jsp">@include表达式</a>
        <hr>
        el表达式：
        <a href="jsp/el/demo1.jsp">el demo1</a>
        <a href="jsp/el/demo2.jsp">el demo2</a>
        <a href="jsp/el/demo3.jsp">el demo3</a>
        <a href="jsp/el/demo4.jsp">el demo4</a>
        <a href="jsp/el/demo5.jsp?username=mio&password=123">el demo5</a>
        <a href="jsp/el/demo6.jsp">el demo6</a>
        <a href="${pageContext.request.contextPath}/jsp/el/demo7.jsp">el demo7</a>
        <hr>
        jstl:
        <a href="${pageContext.request.contextPath}/jsp/jstl/if.jsp">jstl if</a>
        <a href="${pageContext.request.contextPath}/jsp/jstl/forEach.jsp">jstl forEach</a>
        <a href="${pageContext.request.contextPath}/jsp/jstl/forEach2.jsp">jstl forEach2</a>
        <a href="${pageContext.request.contextPath}/jsp/jstl/choose.jsp">jstl choose</a>
        <a href="${pageContext.request.contextPath}/jsp/jstl/fn.jsp">jstl fn</a>
    </body>
</html>
