<%--
  Created by IntelliJ IDEA.
  User: mio
  Date: 2018/11/24
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/json2.js"></script>
<script>
    $(document).ready(function(){
        testRequestBody();
    });
    function testRequestBody(){
        $.ajax({
            url:"${pageContext.request.contextPath}/json/testRequestBody", //发送的地址
            dataType:"json", //预期服务器发送的数据类型
            type: "post", //请求方式
            contentType:"application/json", //发送信息到服务器时的内容编码格式
            data:JSON.stringify({id:1,name:"SpringMVC企业应用实战"}), //发送的JSON数据
            async:true, //异步发送
            success:function(data){ //请求成功后的回调函数
                console.log(data);
                $("#id").html(data.id);
                $("#name").html(data.name);
                $("#author").html(data.author);
            },
            error:function(){ //请求失败后调用的函数
                alert("数据发送失败");
            }
        });
    }
</script>
<html>
  <head>
    <title>发送接收JSON数据</title>
  </head>
  <body>
    编号：<span id="id"></span> <br>
    书名：<span id="name"></span> <br>
    作者：<span id="author"></span> <br>
  </body>
</html>
