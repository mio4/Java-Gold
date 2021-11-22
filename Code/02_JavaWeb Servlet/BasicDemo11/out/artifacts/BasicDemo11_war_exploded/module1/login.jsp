<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/4
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <!--防止中文乱码-->
    <% request.setCharacterEncoding("UTF-8"); %>
    <!--将表单中的数据封装为一个JavaBean-->
    <jsp:useBean id="u" class="com.mio4.web.domain.User"> </jsp:useBean>
    <jsp:setProperty name="u" property="name"/>
    <jsp:setProperty name="u" property="password"/>

    <!--从JavaBean中获取数据-->
    <jsp:getProperty name="u" property="name"/><br/>
    <jsp:getProperty name="u" property="password"/><br/>

</body>
</html>

