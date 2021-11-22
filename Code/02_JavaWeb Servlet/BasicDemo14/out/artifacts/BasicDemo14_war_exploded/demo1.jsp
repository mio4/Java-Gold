<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/10
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查用户名是否被占用</title>
</head>
<body>
    <form method="post" action="#">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" onblur="checkUsername(this)"></td>
                <td><span id="username_msg"></span></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="注册" id="submitId"></td>
            </tr>
        </table>
    </form>
</body>
</html>

<!--失去焦点之后检测用户名是否被占用-->
<script>
    function checkUsername(obj){
        //alert(obj.value);

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
                //alert(xmlhttp.responseText);
                if(xmlhttp.responseText == 1){ //能用 responseText接受从response写回的参数
                    document.getElementById("username_msg").innerHTML="<font color='green'>用户名可以使用</font>";
                } else if(xmlhttp.responseText == 0){ //不能用
                    document.getElementById("username_msg").innerHTML="<font color='red'>用户名不能使用</font>";
                    document.getElementById("submitId").disabled = true;
                }
            }
        }

        //3.open操作
        xmlhttp.open("get","${pageContext.request.contextPath}/checkUsername4Ajax?username=" + obj.value);

        //4.send
        xmlhttp.send();
    }
</script>
