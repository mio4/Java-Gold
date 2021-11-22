<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/11
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟搜索引擎</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        //文本框keyup时发送AJAX
        $(function(){
            $("#tid").keyup(function(){
                //alert("!!!");
               var $value = $(this).val(); //获取#tid文本框的值
               if($value != null && $value.length != 0){
                   //每次清空div
                   $("#did").html("");

                   $.post("/BasicDemo14/searchKw","kw="+$value,function(d){ //这里向Servlet提交参数
                      var arr = d.split(",");
                      $(arr).each(function(){
                          //alert(this);
                          $("#did").append($("<div>" + this + "</div>"));
                      });
                      $("#did").show();
                   });
               } else{
                    $("#did").hide();
               }
            });
        });
    </script>
</head>
<body>
    <center>
        <div>
            <h1>Search it!</h1>
            <div>
                <input type="text" name="keyword" id="tid">
                <input type="submit" name="search" value="search">
            </div>
            <div id = "did" style=" border:1px solid red; width:162px;height:162px;position:relative;left:-30px"></div>
        </div>
    </center>
</body>
</html>
