<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/10
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>原生的ajax</title>
</head>
<body>
    <input type="submit" onclick="btnClick()" value="发送ajax">
</body>
</html>

<!-- ajax -->
<script type="text/javascript">
    function btnClick(){
        //1.创建核心对象
        xmlhttp = null;
        if(window.XMLHttpRequest){
            //firefox chrome
            xmlhttp = new XMLHttpRequest();
        } else if(window.ActiveXObject){
            //ie
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        //2.编写回调函数
        xmlhttp.onreadystatechange=function(){
            //alert("回调函数");
            alert(xmlhttp.readyState);
        }

        //3. 设置请求的方式和请求路径
        xmlhttp.open("get","${pageContext.request.contextPath}/ajax1");

        //4. 发送请求
        xmlhttp.send();

    }
</script>
