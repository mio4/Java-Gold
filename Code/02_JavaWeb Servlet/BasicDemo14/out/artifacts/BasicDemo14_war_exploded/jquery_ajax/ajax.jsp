<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/11
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery下的AJAX</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                var url = "/BasicDemo14/jqueryAjax";
                //var params = "username=一个中文姓名"; get方式
                //var params={"username":"一个中文姓名2"}; post方式
                /*$(this).load(url,params,function(d){
                    alert(d);
                });*/

                //get方式
                var params = {"username":"一个中文姓名3"};
                /*$.get(url,params,function(data){
                   alert(data);
                });*/

                //post方式
               /* $.post(url,params,function(d){
                   alert(d);
                });*/

                $.ajax({
                   url:url,
                   type:"post",
                   data:params,
                   success:function(d){
                       alert(d);
                   },
                    error:function(){},
                    dataType:"json"
                });
            });
        });
    </script>
</head>
<body>
    <input type="button" value="click me" id="btn">
</body>
</html>
