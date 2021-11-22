<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>文件下载</h3>
    <a href="download?filename=${requestScope.user.file.originalFilename}">
        ${requestScope.user.file.originalFilename}
    </a>
</body>
</html>