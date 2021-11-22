<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/30
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示页面</title>
</head>
<body>
    <div><small>这是一个简单的商品购买页面</small></div>
    <hr>
    <div>
        <img src="${pageContext.request.contextPath}/${product.pimage}" />
    </div>
    商品名称：${product.pname} <br>
    商城价格：￥${product.shop_price} <br>
    市场价格：￥${product.market_price} <br>
    商品ID：${product.pid} <br>
    <br>
        <form action="${pageContext.request.contextPath}/cart?method=add" method="post" id="submitBuy">
            <input type="hidden" name="pid" value="${product.pid}">
            <div>
                购买数量：<input type="text" name="count" value="1">
                <a href="javascript:void(0)" onclick="addCart()">
                    <input style="background: url('${pageContext.request.contextPath}/images/product.gif') ;height:36px;width:127px;" value="加入购物车" type="button">
                </a>
            </div>
        </form>
    <hr>
    <h3>商品描述</h3>
    ${product.pdesc} <br>
</body>
</html>

<script type="text/javascript">
    function addCart(){
        //提交表单
        document.getElementById("submitBuy").submit();
    }
</script>
