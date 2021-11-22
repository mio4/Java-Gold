<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>注册页面</h3>
<br>

<%--action提交之后，会调用UserController中的register方法--%>
<form action="register" method="post">
    <table>
        <tr>
            <td><label>登录名：</label></td>
            <td><input type="text" id="loginname" name="loginname"></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><label>真实姓名：</label></td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="注册"/></td>
        </tr>
    </table>
</form>