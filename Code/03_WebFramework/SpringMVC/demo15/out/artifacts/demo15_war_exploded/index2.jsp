<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/24
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/json2.js"></script>
<script>
    $(document).ready(function(){
        testResponseBody();
    });

    function testResponseBody(){
        //.post()是jQuery中的方法，文档：http://api.jquery.com/jQuery.post/
        //url：请求发送的路径
        //data：null:发送的data为空
        //success:function(data){} 请求成功后的回调函数
        //dataType:"json" 期望从服务器传来的数据u
        $.post("${pageContext.request.contextPath}/json/testResponseBody",null,
            function(data){
            $.each(data,function(){//遍历JSON
                var tr = $("<tr align='center'/>"); //新建一行
                $("<td/>").html(this.id).appendTo(tr); //将<td>id</td>插入tr
                $("<td/>").html(this.name).appendTo(tr);
                $("<td/>").html(this.author).appendTo(tr);
                $("#bookTable").append(tr); //插入tr
            })
        },"json");
    }
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table id="bookTable" border="1" style="border-collapse:collapse;">
        <tr align="center">
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
        </tr>
    </table>
</body>
</html>
