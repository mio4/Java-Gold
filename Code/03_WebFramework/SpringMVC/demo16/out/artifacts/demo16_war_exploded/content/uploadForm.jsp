<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/24
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h2>文件上传</h2>
    <form action="../upload" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>文件描述：</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>选择文件：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
