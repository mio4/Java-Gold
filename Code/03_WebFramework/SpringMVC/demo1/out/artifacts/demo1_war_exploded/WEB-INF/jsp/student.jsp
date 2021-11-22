<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Spring MVC表单处理</title>
    </head>

    <body>
        <h2>Student Information</h2>
        <form:form method="post" action="/demo1/addStudent">
            <table>
                <tr>
                    <td><form:label path="name">名字：</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="age">年龄：</form:label></td>
                    <td><form:input path="age"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">编号：</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="表单提交"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>