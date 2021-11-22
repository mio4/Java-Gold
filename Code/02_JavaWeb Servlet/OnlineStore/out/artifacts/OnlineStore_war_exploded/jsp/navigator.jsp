<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/19
  Time: 11:08
  To change this template use File | Settings | File Templates.
  备注：导航栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">商品导航</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" id="menuId">
                <%--<c:forEach items="${clist}" var="c">
                    <li><a href="">${c.cname}</a></li>
                </c:forEach>--%>
            </ul>
        </div>
    </div>
</nav>

<script type="text/javascript">
    $(function(){
        //发送AJAX请求
        $.get("${pageContext.request.contextPath}/category?method=findAll",function(data){
            //alert(data); print the element
            var $ul = $("#menuId"); //get the element
            //array loop
            $(data).each(function(){
               $ul.append($("<li><a href='${pageContext.request.contextPath}/product?method=findByPage&cid=" + this.cid +"&currPage=1'>" + this.cname +"</a></li>"));
            });
        },"json")
    });
</script>
