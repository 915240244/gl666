<%--
  Created by IntelliJ IDEA.
  User: 差距
  Date: 2018/8/28
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>读者信息</title>
    <link rel="stylesheet"  type="text/css" href="js/themes/default/easyui.css"/>
    <script src="js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
    <style>
        /*头部的选择栏-大框*/
        #head{
            background-color: blueviolet;
            position: absolute;
            top: 0px;
            left: 0px;
            height: 100px;
            width: 100%;
        }
        /*头部框内的按钮选项*/
        #sousuo {
            margin-top: 20px;
            width: 1200px;
            height: 50px;
            line-height: 50px;
            position: absolute;
            top: -10px;
            left: 255px;
        }
        #sousuo a{
            font-size: 20px;
            background-color: #8b008b;
            color: white;
            padding: 20px;
            border-radius: 15px;
        }

        /*中间 搜索框外框*/
        #conter{
            position: absolute;
            top: 100px;
            left: 100px;
            width: 1200px;
            height: 50px;
        }
        /*底部 文本大框 用于显示数据的一个大框*/
        #botton{
            background-color: #82d021;
            position: absolute;
            top: 250px;
            left: 250px;
            width: 850px;
            height: 400px;
        }
    </style>
    <script>
        //姓名查新
        function readerName() {
            var reader = $("#query_name").val();
            var url="/AdminReaderName.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    name:reader
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                },error:function () {
                    alert("查询数据异常！！！");
                }
            })
        }
        //读者身份证查询
          function readerID() {
            var reader = $("#query_book").val();
            var url="/AdminReaderID.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    reader:reader
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                },error:function () {
                    alert("查询数据异常！！！");
                }
            })
        }







    </script>

</head>
<body  bgcolor="#8b008b">  <!--=================================-->


<div id="head">  <!----- 版头----->

    <img src="js/img3/Logo.png" width="160" height="100">
    <div id="sousuo">
        <a href="/AdminUpBooksJsp.do">图书修改</a>
        <a href="/AdminAddBookJsp.do">添加书籍</a>
        <a href="/AdminReaderJsp.do">读者信息</a>
        <a href="/AdminBorrowedJsp.do">用户申请</a>
        <a href="/AdminBook_ztJsp.do">书籍状态</a>
        <a href="/AdminReturnJsp.do">还书记录</a>
        <a href="#">更多</a>
        <a href="/login.html">退出</a>
    </div>

</div>




<div id="conter">  <!-- 这个是中间的搜索框外框-->
    <input type="text"  id="query_name" >   <!-- 搜索框（query_name) 和 按钮-->
    <input type="button"  value="姓名查询" onclick="readerName()">

    <input type="text"  id="query_book" >
    <input type="button"  value="身份证查询" onclick="readerID()">

    <input type="text"  id="query_num" >
    <input type="button"  value="搜索书号">

    <input type="text"  id="return_name" >
    <input type="button"  value="未归还用户">
</div>
<div id="botton">  <!-- 这个是页面底部空出来用于显示数据的一个div大框-->
    <!--
    <table class="easyui-datagrid" id="t1" data-options="singleSelect:true,fitColumns: false,fit:true">
        <thead>
        <tr>
            <th data-options="field:'reader_ID'">身份证</th>
            <th data-options="field:'reader_Name'">读者姓名</th>
            <th data-options="field:'reader_Password'">读者密码</th>
            <th data-options="field:'reader_Phone'">联系方式</th>
            <th data-options="field:'reader_Address'">地址</th>
            <th data-options="field:'reader_Gender'">性别</th>
            <th data-options="field:'book_Number'">借书数量</th>
            <th data-options="field:'reader_Photo'">头像</th>
            <th data-options="field:'reader_Email'">邮箱</th>
            <th data-options="field:'borrow_Count'">已借书本</th>
        </tr>
        </thead>
    </table>-->

    <table id="dg" title="用户管理" class="easyui-datagrid" fitColumns="true"
           pagination="true" rownumbers="true"
           url="${pageContext.request.contextPath}/AdminReader.do" fit="true"
           toolbar="#tb">
        <thead>
        <tr>
            <th data-options="field:'reader_ID'">身份证</th>
            <th data-options="field:'reader_Name'">读者姓名</th>
            <th data-options="field:'reader_Password'">读者密码</th>
            <th data-options="field:'reader_Phone'">联系方式</th>
            <th data-options="field:'reader_Address'">地址</th>
            <th data-options="field:'reader_Gender'">性别</th>
            <th data-options="field:'book_Number'">借书数量</th>
            <th data-options="field:'reader_Photo'">头像</th>
            <th data-options="field:'reader_Email'">邮箱</th>
            <th data-options="field:'borrow_Count'">已借书本</th>
        </tr>
        </thead>
    </table>
</div>

</body>
</html>
