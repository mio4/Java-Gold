<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/4
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        request.setAttribute("list",list);
    %>

    <c:forEach items="${list}" var="i">
        ${i}
    </c:forEach>

    <hr>
    <%
        Set s = new HashSet();
        s.add(111);
        s.add(222);
        s.add(333);
        request.setAttribute("set",s);
    %>

    <c:forEach items="${set}" var="i" varStatus="vs">
        ${i} -- ${vs.count} <br/>
    </c:forEach>

    <hr>
    <%
        Map m = new HashMap();
        m.put("mio",20);
        m.put("jack",30);
        request.setAttribute("map",m);
    %>

    <c:forEach items="${map}" var="m">
        ${m}
    </c:forEach>
</body>
</html>
