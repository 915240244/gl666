<%--
  Created by IntelliJ IDEA.
  User: 差距
  Date: 2018/8/29
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>还书记录</title>
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
            left: 0px;
            width: 100%;
            height: 200px;
        }
        /*中间 搜索框外框内 上面*/
        #conter_above{
            position: absolute;
            top: 10px;
            left: 250px;
            width: 70%;
            height: 50px;
        }
        /*中间 搜索框外框内 下面*/
        #conter_below{
            position: absolute;
            top: 70px;
            left: 550px;
            width: 55%;
            height: 50px;
        }


        /*底部 文本大框 用于显示数据的一个大框*/
        #botton{
            background-color: #82d021;
            position: absolute;
            top: 250px;
            left: 250px;
            width: 800px;
            height: 400px;
        }
    </style>
    <script>
        //身份证查询
        function readerID() {
            var reader = $("#query_book").val();
            var url="/AdminReaderId.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    reader:reader
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                    alert("返回数据成功");
                }
            })
        }
    //姓名查询
        function nameSelectname() {
            var reader = $("#query_name").val();
            var url="/AdminReaderId.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    reader:reader
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                    alert("返回数据成功");
                }
            })
        }
        function bookname() {
            var reader = $("#book_name").val();
            var url="/AdminBookName.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    reader:reader
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                    alert("返回数据成功");
                }
            })
        }

        //显示全部借书记录
        function recordSe() {
            var url="/AdminRecordList.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                    alert("返回数据成功");
                }

            })
        }

    </script>
</head>
<body  bgcolor="#8b008b">


<div id="head">  <!----- 版头----->

    <img src="img3/Logo.png" width="160" height="100">
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



<div id="conter"> <!-----这个是中间的搜索框外框-->

    <div id="conter_above">  <!-- 放搜索框及对应按钮-->
        <input type="text"  id="query_book" >
        <input type="button"  value="读者身份证查找" onclick="readerID()"> <font color="white" size="+1">——</font>  <!--用于美化界面-->
        <input type="text"  id="book_name" >
        <input type="button"  value="书名" onclick="bookname()">       <font color="white" size="+1">——</font>
        <input type="text"  id="query_name" >
        <input type="button"  value="姓名" onclick="nameSelectname()">
    </div>

    <div id="conter_below"> <!--用于存放按钮-->
        <input type="button"  value="显示全部记录" onclick="recordSe()">  <font color="white" size="+1">——</font>

    </div>

</div>

<div id="botton">  <!-- 这个是页面底部空出来用于显示数据的一个div大框-->

    <table class="easyui-datagrid" id="t1" data-options="singleSelect:true,fitColumns: false,fit:true">
        <thead>
        <tr>
            <th data-options="field:'borrowed_ID'">业务编号</th>
            <th data-options="field:'title'">书籍名称</th>
            <th data-options="field:'reader_Name'">读者姓名</th>
            <th data-options="field:'staff_Number'">管理员编号</th>
            <th data-options="field:'staff_Name'">管理员姓名</th>
            <th data-options="field:'return_Time'">还书日期</th>
        </tr>
        </thead>
    </table>

</div>



</body>
</html>