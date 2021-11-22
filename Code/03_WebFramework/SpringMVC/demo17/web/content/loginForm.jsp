<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/24
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="../login" method="post">
        <%--提示信息--%>
        <font color="#dc143c">${requestScope.message}</font>
        <table>
            <tr>
                <td><label>登录名：</label></td>
                <td><input type="text" id="loginname" name="loginname"></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
