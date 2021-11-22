<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/13
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="checkbox" name="autoLogin" value="OK">自动登录</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"> </td>
            </tr>
        </table>
    </form>
</body>
</html>
