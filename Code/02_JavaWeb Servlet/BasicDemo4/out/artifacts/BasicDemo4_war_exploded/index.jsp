<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/9/3
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Html的Form表单元素</title>
</head>
<fieldset style="width:500px;">
    <legend>Html的Form表单元素</legend>
    <!--form表单的action属性规定当提交表单时，向何处发送表单数据，method属性指明表单的提交方式，分为get和post，默认为get-->
    <form action="${pageContext.request.contextPath}/servlet/RequestDemo03" method="post">
        <!--输入文本框，SIZE表示显示长度，maxlength表示最多输入长度-->
        编&nbsp;&nbsp;号(文本框)：
        <input type="text" name="userid" value="NO." size="2" maxlength="2"><br>
        <!--输入文本框，通过value指定其显示的默认值-->
        用户名(文本框)：<input type="text" name="username" value="请输入用户名"><br>
        <!--密码框，其中所有输入的内容都以密文的形式显示-->
        密&nbsp;&nbsp;码(密码框)：
        <!--&nbsp;表示的是一个空格-->
        <input type="password" name="userpass" value="请输入密码"><br>
        <!--单选按钮，通过checked指定默认选中，名称必须一样，其中value为真正需要的内容-->
        性&nbsp;&nbsp;别(单选框)：
        <input type="radio" name="sex" value="男" checked>你是男
        <input type="radio" name="sex" value="女">你是女<br>
        <!--下拉列表框，通过<option>元素指定下拉的选项-->
        部&nbsp;&nbsp;门(下拉框)：
        <select name="dept">
            <option value="技术部">技术部</option>
            <option value="销售部" SELECTED>销售部</option>
            <option value="财务部">财务部</option>
        </select><br>
        <!--复选框，可以同时选择多个选项，名称必须一样，其中value为真正需要的内容-->
        兴&nbsp;&nbsp;趣(复选框)：
        <input type="checkbox" name="inst" value="唱歌">唱歌
        <input type="checkbox" name="inst" value="游泳">游泳
        <input type="checkbox" name="inst" value="跳舞">跳舞
        <input type="checkbox" name="inst" value="编程" checked>编程
        <input type="checkbox" name="inst" value="上网">上网
        <br>
        <!--大文本输入框，宽度为34列，高度为5行-->
        说&nbsp;&nbsp;明(文本域)：
        <textarea name="note" cols="34" rows="5">
     </textarea>
        <br>
        <!--隐藏域，在页面上无法看到，专门用来传递参数或者保存参数-->
        <input type="hidden" name="hiddenField" value="hiddenvalue"/>
        <!--提交表单按钮，当点击提交后，所有填写的表单内容都会被传输到服务器端-->
        <input type="submit" value="提交(提交按钮)">
        <!--重置表单按钮，当点击重置后，所有表单恢复原始显示内容-->
        <input type="reset" value="重置(重置按钮)">
    </form>
    <!--表单结束-->
</fieldset>
</body>
<!--完结标记-->
</html>
<!--完结标记-->
