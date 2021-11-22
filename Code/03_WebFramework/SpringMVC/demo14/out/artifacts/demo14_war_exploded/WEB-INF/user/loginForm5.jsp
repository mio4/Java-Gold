<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/24
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>登录页面</h3>
<br>
<form action="login5" method="post">
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
            <td><input type="submit" id="submit" value="登录"/></td>
        </tr>
    </table>
</form>
