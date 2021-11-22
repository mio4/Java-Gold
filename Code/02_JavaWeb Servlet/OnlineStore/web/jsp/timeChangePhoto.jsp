<%--
  Created by IntelliJ IDEA.
  User: 461152465
  Date: 2018/10/20
  Time: 20:31
  To change this template use File | Settings | File Templates.
  备注：一个轮播图片效果的模块
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container pull-left">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <!--使用相对路径不能正常显示图片，后修改为绝对路径-->
                <img src="${pageContext.request.contextPath}/img/1.jpg" alt="图片1">
                <div class="carousel-caption">
                    第一张图片
                </div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/img/2.jpg" alt="图片2" >
                <div class="carousel-caption">
                    第二张图片
                </div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/img/3.jpg" alt="图片3" >
                <div class="carousel-caption">
                    第三张图片
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
