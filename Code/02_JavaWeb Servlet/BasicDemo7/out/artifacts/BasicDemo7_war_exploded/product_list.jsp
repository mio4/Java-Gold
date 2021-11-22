<%@ page import="com.mio4.utils.CookieUtils" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/2
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/BasicDemo7/productServlet?id=1">p1</a>
    <a href="/BasicDemo7/productServlet?id=2">p2</a>
    <a href="/BasicDemo7/productServlet?id=3">p3</a>
    <a href="/BasicDemo7/productServlet?id=4">p4</a>
    <a href="/BasicDemo7/productServlet?id=5">p5</a>

    <p>商品的浏览记录</p>

    <%
        //获取指定名称的Cookie
        Cookie c = CookieUtils.getCookieByName("ids",request.getCookies());
        //判断ids是否为空
        if(c == null){
        	out.print("<hr><h2>没有浏览记录</h2>");
        } else{
        	String[] arr = c.getValue().split("-");
        	int len = arr.length;
        	for(int i=0; i < len; i++){
        		out.print("浏览的页面：" + arr[i] + "<br/>");
            }
        }
    %>

    <a href="/BasicDemo7/clearHistory">清空浏览记录</a>
</body>
</html>
