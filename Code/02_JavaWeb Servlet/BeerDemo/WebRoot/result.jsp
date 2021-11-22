<%@ page import="java.util.*" language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
	<base href="<%=basePath%>">
    <h1 align="center">Beer Recommendations JSP </h1>
    <p>
    <%
    	ArrayList styles = (ArrayList)request.getAttribute("styles");
    	Iterator it = styles.iterator();
    	while(it.hasNext()){
    		out.print("<br/>try: " + it.next());
    	}
     %>
  </body>
</html>
