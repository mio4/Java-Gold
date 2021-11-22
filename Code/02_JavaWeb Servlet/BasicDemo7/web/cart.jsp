<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/2
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>商品名称</td>
            <td>商品数量</td>
        </tr>
        <tr>
            <td><% %></td>
            <td><% %></td>
        </tr>

        <%
            //1.获取购物车
            HashMap<String,Integer> map = (HashMap<String,Integer>) session.getAttribute("cart");

            //2.若购物车为空
            if(map == null){
            	out.print("<tr><td colspan='2'>购物车为空</tr>");
            } else{
            	for(String name : map.keySet()){
            		out.print("<tr>");
            		out.print("<td>");
            		out.print(name);
                    out.print("</td>");

                    out.print("<td>");
                    out.print(map.get(name));
            		out.print("</td>");
            		out.print("</tr>");
                }
            }
       %>
    </table>

    <hr>
    <a href="/BasicDemo7/product_list.jsp">继续购物</a>
    <a href="/BasicDemo7/clearCart">清空购物车</a>
</body>
</html>
