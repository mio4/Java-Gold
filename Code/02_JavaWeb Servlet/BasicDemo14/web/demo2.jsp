<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/10
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<html>
<head>
    <title>检查用户名是否被占用</title>
</head>
<body>
<form method="post" action="#">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
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
<script type="text/javascript">
    $(function(){
        $("input[name='username']").blur(function(){
            //获取输入的值
            var $username = $(this).val();
            //alert($username);
            $.get("/BasicDemo14/checkUsername4Ajax",{"username":$username},function(d){
                //alert(d);
                if(d == 1){
                    document.getElementById("username_msg").innerHTML="<font color='green'>用户名可以使用</font>";
                } else if(d == 0){ //不能用
                    document.getElementById("username_msg").innerHTML="<font color='red'>用户名不能使用</font>";
                    document.getElementById("submitId").disabled = true;
                }
            });
        });
    });
</script>
