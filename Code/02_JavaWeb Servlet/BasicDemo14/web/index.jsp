<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/10
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/js_ajax/hello.jsp">入门程序</a> <br/>
  <a href="${pageContext.request.contextPath}/js_ajax/get.jsp">get请求</a> <br/>
  <a href="${pageContext.request.contextPath}/js_ajax/post.jsp">post请求</a> <br/>
  <a href="${pageContext.request.contextPath}/demo1.jsp">案例1——检查用户名是否被占用 Ajax</a> <br/>
  <a href="${pageContext.request.contextPath}/demo2.jsp">案例2——检查用户名是否被占用 jQuery + Ajax</a> <br/>
  <a href="${pageContext.request.contextPath}/jquery_ajax/ajax.jsp">jQuery下的AJAX</a> <br/>

  <hr>
  <a href="${pageContext.request.contextPath}/demo3.jsp">模拟搜索</a> <br/>
  </body>
</html>
