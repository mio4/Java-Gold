<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/9
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/editProduct" method="post">
        <!--使用隐藏域将商品ID传递过去-->
        <input type="hidden" name="pid" value="${bean.pid}">
        <table border="1" align="center">
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="pname" value="${bean.pname}"></td>
            </tr>
            <tr>
                <td>market price</td>
                <td><input type="text" name="market_price" value="${bean.market_price}"></td>
            </tr>
            <tr>
                <td>shop price</td>
                <td><input type="text" name="shop_price" value="${bean.shop_price}"></td>
            </tr>
            <tr>
                <td>商品描述</td>
                <td><input type="text" name="pdesc" value="${bean.pdesc}"></td>
            </tr>
            <tr>
                <td>提交</td>
                <td><input type="submit" value="提交" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
