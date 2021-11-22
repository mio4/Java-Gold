<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/25
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h3>登录页面</h3>
    <%--绑定user--%>
    <form:form modelAttribute="user" method="post" action="login">
        <table>
            <tr>
                <td>登录名：</td>
                <td><form:input path="loginname"/></td>
                <%--显示loginname属性的错误信息--%>
                <td><form:errors path="loginname" cssStyle="color:red"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><form:input path="password"/></td>
                <td><form:errors path="password" cssStyle="color:red"/> </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
