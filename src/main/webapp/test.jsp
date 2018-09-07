<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>个人信息中心</title>
    <link href="css/sty.css" rel='stylesheet' type='text/css'/>
    <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,400" rel="stylesheet">
    <link href="css/popuo.css" rel="stylesheet" type="text/css" media="all"/>

    <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/styl.css" rel="stylesheet" type="text/css" media="all"/><!--style_sheet-->
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
    <link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome_Icons-CSS -->

    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Accessible Profile Widget Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"/>
    <link rel="stylesheet" type="text/css"
          href="../css/jqe/themes/default/easyui.css" />

    <script type="text/javascript" src="<%=basePath %>js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery.easyui.min.js"></script>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>




    <!-- pop-up-box-js-file -->
    <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
    <!--//pop-up-box-js-file -->
    <script>$(document).ready(function (c) {
        $('.alert-close').on('click', function (c) {
            $('.main-agile').fadeOut('slow', function (c) {
                $('.main-agile').remove();
            });
        });
    });
    </script>
    <style>
        ul.address li ul.address-text li {
            margin-top: 0;
            font-size: 15px;
        }

        ul.address li ul.address-text li {
            margin-bottom: 1em;
        }


        .button button {
            margin-right: 25px;
            font-size: 17px;
            padding: 10px 32px;
            display: inline-block;
            background: #bb2849;
            border: 2px solid #bb2849;
            color: #fff;
            outline: none;
            -webkit-transition: 0.5s all;
            -o-transition: 0.5s all;
            -moz-transition: 0.5s all;
            -ms-transition: 0.5s all;
            transition: 0.5s all;
        }
    </style>
</head>



<div  id="small-dialog1" >
    <div class="wthree-container">
        <div class="wthree-form">
            <div class="agileits-2">
                <h2>借书记录</h2>

            </div>
            <c:forEach var="rec" items="${re}">
                <div class="w3-user">
                    <span><i style="width: 25%" class="fa" aria-hidden="true">书籍编号</i></span>
                    <input style="width: 75%" id="Reader" type="text" name="reader_ID" value="${rec.book_ID}" readonly="readonly" >
                </div>
                <div class="clear"></div>
                <div class="w3-psw">
                    <span><i style="width: 25%" class="fa" aria-hidden="true">书名</i></span>
                    <input style="width: 75%" id="password" type="text" name="title"   value="${rec.title}"  readonly="readonly">
                </div>
                <div class="clear"></div>
                <div class="w3-psw">
                    <span><i style="width: 25%" class="fa" aria-hidden="true">还书时间</i></span>
                    <input style="width: 75%" id="password3" type="text" name="borrowed_Time"  value="${rec.borrowed_Time}" readonly="readonly">
                </div>
                <div class="clear"></div>
                <div class="button">

                    <button id="tj">还书</button>
                    <button onclick="location='/asd.do'">返回</button>
                </div>
            </c:forEach>
            <div class="clear"></div>

            <div style="padding-top: 10px;" class="button">
                <input type="hidden" id="pageNum" value="${re.getPageNum()}">
                <input type="hidden" id="totalPage" value="${re.getPages()}">
                <button id="t" onclick="prePage()">上一页</button>
                <button onclick="nextPage()">下一页</button>
            </div>
        </div>
    </div>
</div>
</div>



<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

<!-- pop-up-box-js-file -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box-js-file -->


<script type="text/javascript">



    function firstPage(){
        var pageNum=document.getElementById("pageNum").value;
        if(1==pageNum){
            alert("亲，已经是首页了");
        }else{
            window.location.href="find.do?pageNum="+1;
        }
    }
    function prePage(){
        var pageNum=document.getElementById("pageNum").value;
        if (pageNum==1){
            alert("已经是第一页了")
        }else {
            pageNum--;
            window.location.href="find.do?pageNum="+pageNum;
        }

    }
    function nextPage(){
        var pageNum=document.getElementById("pageNum").value;
        var totalPage=document.getElementById("totalPage").value;
        if (pageNum==totalPage){
            alert("已经是最后一页了")
        }else {
            pageNum++;
            window.location.href="find.do?pageNum="+pageNum;
        }

    }
    function lastPage(){
        var pageNum=document.getElementById("pageNum").value;
        var totalPage=document.getElementById("totalPage").value;
        if(pageNum==totalPage){
            alert("亲，已经是尾页了");
        }else{
            window.location.href="find.do?pageNum="+totalPage;
        }
    }

</script>
</body>
</html>

