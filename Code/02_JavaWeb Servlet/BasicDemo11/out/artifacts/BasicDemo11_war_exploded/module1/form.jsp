<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/4
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/module1/login.jsp">
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"></td>
            </tr>
        </table>
    </form>

</body>
</html>
