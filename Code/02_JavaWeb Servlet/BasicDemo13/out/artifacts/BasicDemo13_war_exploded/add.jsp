<%@ page import="com.mio4.web.utils.UUIDUtils" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/8
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
    <%
        String token = UUIDUtils.getToken(); //生成令牌Token
        session.setAttribute("sessionToken",token); //将token放入Session中
        pageContext.setAttribute("requestToken",token); //
    %>
    <form action="${pageContext.request.contextPath}/addProduct" method="post">
        <input type="hidden" name="requestToken" value="${requestToken}">
        <table border="1" align="center">
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="pname"></td>
            </tr>
            <tr>
                <td>market price</td>
                <td><input type="text" name="market_price"></td>
            </tr>
            <tr>
                <td>shop price</td>
                <td><input type="text" name="shop_price"></td>
            </tr>
            <tr>
                <td>商品描述</td>
                <td><input type="text" name="pdesc"></td>
            </tr>
            <tr>
                <td>提交</td>
                <td><input type="submit" value="提交" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
