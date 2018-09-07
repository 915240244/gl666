<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>个人信息中心</title>
    <link href="css/sty.css" rel='stylesheet' type='text/css'/>
    <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,400" rel="stylesheet">
    <link href="css/popuo.css" rel="stylesheet" type="text/css" media="all" />

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Accessible Profile Widget Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>


    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

    <!-- pop-up-box-js-file -->
    <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
    <!--//pop-up-box-js-file -->
    <script>$(document).ready(function(c) {
        $('.alert-close').on('click', function(c){
            $('.main-agile').fadeOut('slow', function(c){
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

        .button a {
            margin-right: 40px;
            font-size: 17px;
            padding: 8px 32px;
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
        .button input {
            margin-right: 40px;
            font-size: 17px;
            padding: 8px 32px;
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
        .button button {
            margin-right: 40px;
            font-size: 17px;
            padding: 8px 32px;
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

        label{
            position: relative;
        }
        #picFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #btn{
            margin-right: 5px;
        }

        img {
            max-width: 150px;
            max-height: 180px;
            min-width: 150px;
            min-height: 180px;
        }
    </style>
</head>
<body>
<h1>个人信息中心</h1>
<div class="main-agileits">
    <div class="right-wthree">
        <img id="Resume_TouXiang" src="${user.reader_Photo}" />
        <label for="picFile">
            <input type="button" id="btn" value="修改头像">
            <input type="file" name="picFile" id="picFile" style="width: 70px">
        </label>

        <h2>借书记录：<a href="/find.do">点击查询</a></h2>
        <p>Web Designer & DeveloperWeb Designer & DeveloperWeb Designer</p>
    </div>
    <div class="left-w3ls">
        <ul class="address">
            <li>
                <ul class="address-text">
                    <li><b>身份证 </b></li>
                    <li><a>:</a><input id="reader_ID" type="text" value="${user.reader_ID}" readonly="readonly" /></li>
                </ul>
            </li>
            <li>
                <ul class="address-text">
                    <li><b>姓名 </b></li>
                    <li><a>:</a><input id="reader_Name" name="name" type="text" value="${user.reader_Name}" /></li>
                </ul>
            </li>
            <li>
                <ul class="address-text">
                    <li><b>手机号码 </b></li>
                    <li><a>:</a><input id="reader_Phone" name="phone" type="text" value="${user.reader_Phone}" /></li>
                </ul>
            </li>
            <li>
                <ul class="address-text">
                    <li><b>性别 </b></li>
                    <li><a>:</a><input id="reader_Gender" name="gender" type="text" placeholder="请输入男或女" value="${user.reader_Gender}" checked="checked" /></li>
                </ul>
            </li>
            <li>
                <ul class="address-text">
                    <li><b>邮箱 </b></li>
                    <li><a>:</a><input id="reader_Email" type="email" value="${user.reader_Email}" readonly="readonly"/></li>
                </ul>
            </li>
            <li>
                <ul class="address-text">
                    <li><b>地址 </b></li>
                    <li><a>:</a><input id="reader_Address" name="address" type="text" placeholder="请输入居住地" value="${user.reader_Address}" /></li>
                </ul>
            </li>
        </ul>

        <div class="button">
<%--            <input type="submit" onclick="tijiao();"></input>
            <input type="submit" onclick="location='/index.do'" value="返回"></input>--%>
            <button id="tijiao">提交</button>
            <button onclick="location='/index.do'">返回</button>
        </div>

    </div>

    <div class="clear"></div>
</div>
<footer>
    <p class="agileinfo">Copyright &copy; 2015.Company name All rights reserved.</p>
</footer>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

    $("#tijiao").click(function () {

        var reader_ID=$("#reader_ID").val();
        var reader_Name=$("#reader_Name").val();
        var reader_Phone=$("#reader_Phone").val();
        var raader_Email=$("#reader_Email").val();
        var reader_Address=$("#reader_Address").val();
        var reader_Gender=$("#reader_Gender").val();


        //浏览器控制台输出
        console.log(reader_Name);
        console.log(reader_Phone);
        console.log(reader_Address);
        console.log(raader_Email);
        console.log(reader_ID);

       /* window.location.href="updatereaderInfo.do";*/

        if (reader_Name==''){
            alert("姓名不能为空");
        }

        var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (!reg.test(reader_Phone)){
            alert("请输入正确的手机号码")
        }
        if (reader_Address==''){
            alert("地址不能为空");
        }

        // alert("你点击了我");
        var url = "updatereaderInfo.do";
        $.ajax({
            data:{
                reader_ID:reader_ID,
                reader_Name:reader_Name,
                reader_Phone:reader_Phone,
                reader_Gender:reader_Gender,
                reader_Email:raader_Email,
                reader_Address:reader_Address
            },
            url:url,
            dataType:'text',
            type:'post',
            success:function(data){
                if(data=="success"){
                    alert("修改成功");
                    window.location.href="asd.do"}
                else if(data=="failaaa"){
                    alert("你没有修改个人信息");
                }else if (data=="fail"){
                    alert("修改失败");
                }
            }
        });



    });

</script>
<script src="js/lrz.bundle.js"></script>
<script type="text/javascript">
    $("input[type=file]").on('change', function (event) {
        var file = this.files[0];
        var rReg = /\.(jpg)|(jpeg)|(gif)|(png)$/i;
        var maxSize = 20 * 1024 * 1024;
        if (!rReg.test(file.name)) {
//      	检查图片类型！！！！！！！！！！！！！！！！！！！！！！
            alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
            return false;
        }
        lrz(this.files[0], { width: 180, height: 180 })
        //      替换头像图片！！！！！！！！！！！！！！！！！！
            .then(function (rst) {
                $('#Resume_TouXiang').attr("src", rst.base64);
                return rst;
            })
            //      保存图片
            .then(function (rst) {
                /*$(logoForm).submit()rst.base64*/
                var formData = new FormData();
                formData.append("picFile", $("#picFile")[0].files[0]);
                $.ajax({
                    url: 'uploadLogo.do',
                    type: 'POST',
                    data: formData,
                    dataType:"json",
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (ret) {
                        console.log(ret);
                    },
                    error: function (ret) {
                        console.log(ret);
                    }
                });
                return rst;


            })
            .then(function (rst) {
                $('#Resume_TouXiang').attr("src", rst.base64);
                return rst;
            })

    })


</script>
</body>
</html>
