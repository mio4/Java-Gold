<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/10
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <input type="button" value="click me" onclick="btnClick(this)">
</body>
</html>


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
            if(xmlhttp.readyState==4 && xmlhttp.status==200){
                alert(xmlhttp.responseText);
            }
        }

        //3.open
        xmlhttp.open("post","/BasicDemo14/ajax2?username=中文姓名");

        //4.send
        xmlhttp.send();
    }
</script>