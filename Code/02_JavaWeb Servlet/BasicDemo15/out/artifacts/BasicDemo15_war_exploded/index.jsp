<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/11
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/request.jsp">MyServletRequestListener生命周期</a><br/>
  <a href="${pageContext.request.contextPath}/session.jsp">MyHttpSesssionListener生命周期</a><br/>
  <a href="${pageContext.request.contextPath}/attr.jsp">ServletContextAttributeListener 添加属性</a><br/>
  <a href="${pageContext.request.contextPath}/attr_replace.jsp">ServletContextAttributeListener 替换属性</a><br/>
  <a href="${pageContext.request.contextPath}/attr_remove.jsp">ServletContextAttributeListener 删除属性</a><br/>
  <a href="${pageContext.request.contextPath}/user_session_set.jsp">HttpSessionBindingListener set属性</a><br/>
  <a href="${pageContext.request.contextPath}/user_session_remove.jsp">HttpSessionBindingListener remove属性</a><br/>
  <hr>
  <a href="${pageContext.request.contextPath}/helloFilter">Hello Filter</a><br/>
  <a href="${pageContext.request.contextPath}/lifeFilter">Filter生命周期</a><br/>
  <a href="${pageContext.request.contextPath}/a/b/demo3">Filter Chain执行顺序</a><br/>


  </body>
</html>
