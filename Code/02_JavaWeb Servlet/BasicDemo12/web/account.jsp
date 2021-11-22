<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/5
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account表单</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/accountServlet">
        <table>
            <tr>
                <td>转账人</td>
                <td><input type="text" name="fromUser"></td>
            </tr>
            <tr>
                <td>收款人</td>
                <td><input type="text" name="toUser"></td>
            </tr>
            <tr>
                <td>金额</td>
                <td><input type="text" name="money"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="转账"></td>
            </tr>
        </table>
    </form>
</body>
</html>
