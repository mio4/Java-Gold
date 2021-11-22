<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mio4.web.User" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/3
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用EL表达式进行四则运算</title>
</head>
<body>
    <%
        request.setAttribute("a",1);
        request.setAttribute("b",2);
        request.setAttribute("c",3);
        request.setAttribute("d",4);
        request.setAttribute("e","5");
        request.setAttribute("f","f");

        List list = null;
        request.setAttribute("list",list);
        List list2 = new ArrayList<String>();
        list2.add("mio");
        request.setAttribute("list2",list2);

        User user = new User();
        request.setAttribute("user",user);
    %>

    ${a+b}<br/>
    ${a+e}<br/>
    <hr>
    list的长度是否为零：${empty list} <br/>
    list2的长度是否为零：${empty list2} <br/>
    user是否为空：${empty user} <br/>
    3和4比较：${3>4?"yes":"no"} <br/>
    a是否和1相等：${a == 1} <br/>
</body>
</html>
