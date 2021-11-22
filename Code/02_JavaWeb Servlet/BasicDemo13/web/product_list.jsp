<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/8
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品展示页面</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <td colspan="7">
                <form action="${pageContext.request.contextPath}/findProductByCondition" method="post">
                    商品名称：<input type="text" name="pname">&nbsp&nbsp
                    关键词：<input type="text" name="keywords">
                    <input type="submit" value="查询">
                </form>
            </td>
            <td colspan="1" align = "center">
                <input type="button" value="删除选中商品" onclick="delChecked()">
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" onclick="checkAll(this)">全选|全不选</td>
            <td>商品ID</td>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>market price</td>
            <td>shop price</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <form action="${pageContext.request.contextPath}/delCheckedProduct" method="post" id="formId">
            <c:forEach items="${plist}" var="p">
                <tr>
                    <td><input type="checkbox" name="pid" value="${p.pid}"></td>
                    <td>${p.pid}</td>
                    <td><img src="${pageContext.request.contextPath}/${p.pimage}" width="80px"></td>
                    <%--<td>${p.pimage}</td>--%>
                    <td>${p.pname}</td>
                    <td>${p.market_price}</td>
                    <td>${p.shop_price}</td>
                    <td>${p.pdesc}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/getProductById?pid=${p.pid}">修改</a>
                        <a href=javascript:void(0) onclick="deleteP('${p.pid}')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </form>
    </table>
</body>
</html>

<!--********************************JS脚本********************************************* -->
<!--使用JavaScript脚本，弹窗并且跳转到Servlet-->
<script type="text/javascript">
    function deleteP(obj){
        //alert(obj);
        if(confirm("删除该商品")){
            //发送请求
            location.href="${pageContext.request.contextPath}/deleteProductById?pid=" + obj;
        }
    }
</script>

<!--全选 全不选checkbox-->
<script>
    function checkAll(obj){
        //获取所有的复选框
        var arr = document.getElementsByName("pid");
        //遍历数组
        for(var i=0; i < arr.length; i++){
            arr[i].checked = obj.checked;
        }
    }
</script>

<!--删除选中的商品-->
<script>
    function delChecked(){
        //提交表单
        document.getElementById("formId").submit();
    }
</script>