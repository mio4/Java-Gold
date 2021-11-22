<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/3
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el demo2</title>
</head>
<body>
    获取复杂的数据
    <hr>
    <%
        //往request域中放入list、map
        request.setAttribute("arr",new String[]{"11","aa","!!"});
    %>
    获取request域中的数组
    JSP表达式： <%= ((String[])request.getAttribute("arr"))[1]%>
    EL表达式： ${arr[1]}

    <hr>
    <%
        List list = new ArrayList<String>();
        list.add("aa");
        list.add("11");
        list.add("!!");
        request.setAttribute("list",list);
    %>
    获取request域中的list
    JSP表达式<%=(((List)request.getAttribute("list")).get(1))%>
    EL表达式${list.get(1)}
    <hr>

    <%
        Map map = new HashMap<String,Integer>();
        map.put("mio",20);
        request.setAttribute("map",map);
    %>
    获取request域中的map：
    JSP表达式：<%=((Map)request.getAttribute("map")).get("mio")%>
    EL表达式：${map.get("mio")}


</body>
</html>
