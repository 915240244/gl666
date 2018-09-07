<%--
  Created by IntelliJ IDEA.
  User: 差距
  Date: 2018/8/27
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户申请</title>
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
            width: 850px;
            height: 400px;
        }
    </style>

    <script>
        //定义全局变量 实现操作完成自动刷新
        i=0;
        // i=1 显示全部申请
        // i=2 姓名查询功能
        // i=3 书名查询

    //显示全部申请
        $(function selectback() {
            var row = $("#t1").datagrid('getSelected');
            if(row.give_Back==1){
                $("#huan").attr("disabled", true);
            }

            //0表示归还  1 表示未归还 2表示申请状态  显示全部申请就默认 为归还 1
            // var back = $("#return_name").val();
            var back = 0;
            var url="/AdminSelectBack.do";

            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    back:back
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                    i=1;//刷新状态
                }

            })
        });

    //姓名查询功能
        function selectname() {

            var name = $("#query_name").val();

            var url="/AdminNameSelect.do";
            $.ajax({
                type:'get',
                url:url,
                dataType:'json',
                data:{
                    name:name
                },
                success:function (data) {
                    $("#t1").datagrid("loadData",data);
                    i=2;//刷新状态
                }

            })
        }
    //书名查询功能
    function titleSelect() {

        var name = $("#book_name").val();

        var url="/AdminTitleSelect.do";
        $.ajax({
            type:'get',
            url:url,
            dataType:'json',
            data:{
                name:name
            },
            success:function (data) {
                $("#t1").datagrid("loadData",data);
                i=3;//刷新状态
            }

        })
    }
//申请人身份证查询
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

        //修改借阅操作--此方法先产生一条借书记录 在修改借书状态
    function upBack() {
        var row = $("#t1").datagrid('getSelected');
        if (row){
          var borId = row.borrowed_ID;
          var title = row.title;
          var name = row.reader_Name;
            //当 归还状态为 0 时 表示已归还 ； 不是0 时表示 未归还
          if (row.give_Back==0)
           return;

                var url="/AdminReturnBook.do";
                $.ajax({
                    type:'get',
                    url:url,
                    dataType:'text',
                    data:{
                        borId:borId,
                        title:title,
                        name:name
                    },
                    success:function (data) {
                        //修改借书状态 0 表示已归还
                        upGive(borId,0);

                    }
                })

        }
    }

    //修改借书状态
    function upGive(borId,back) {
        var url="/AdminUpBack.do";
        $.ajax({
            type:'get',
            url:url,
            dataType:'text',
            data:{
                borId:borId,
                back:back
            },
            success:function (data) {
                if (data=="yes") alert("审核通过");
                else if (data=="no") alert("通过失败啦");
                //刷新数据
                switch (i){
                    case 1: selectback(); break;
                    case 2: selectname(); break;
                    case 3: titleSelect(); break;
                }
            }

        })
    }


    //通过申请的方法
    function huanshu() {
        var row = $("#t1").datagrid('getSelected');
        if(row.give_Back==1){
            $("#huan").attr("disabled", true);
        }

        var borrowed_ID=row.borrowed_ID;
        var title=row.title;
        var reader_Name=row.reader_Name;
        var staff_Number=row.staff_Number;
        var staff_Name=row.staff_Name;
        var return_Time=row.return_Time;

        $.ajax({
            type:'post',
            url:'/AdminHuanshu.do',
            dataType:'json',
            data:{
                borrowed_ID:borrowed_ID,
                title:title,
                reader_Name:reader_Name,
                staff_Number:staff_Number,
                staff_Name:staff_Name
            },
            success:function (data) {
                alert("666");

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

<div id="conter"> <!-----这个是中间的搜索框外框-->

    <div id="conter_above">  <!-- 放搜索框及对应按钮-->
        <input type="text"  id="query_book" >
        <input type="button"  value="申请人身份证" onclick="readerID()">       <font color="white" size="+1">——</font>  <!-- 用于美化-->
        <input type="text"  id="book_name" >
        <input type="button"  value="书名" onclick="titleSelect()">             <font color="white" size="+1">——</font>
        <input type="text"  id="query_name" >
        <input type="button"  value="查询申请人" onclick="selectname()"> <!--查询申请人= 姓名查询-->
    </div>

    <div id="conter_below"> <!--用于存放按钮-->
        <input type="button"  value="显示全部申请" onclick="selectback()">      <font color="white" size="+1">——</font>
        <input type="button"  value="全部拒绝">          <font color="white" size="+1">——</font>
        <input type="button"  value="还书" onclick="huanshu()">
        <input type="button"  value="通过" onclick="upBack()">
    </div>

</div>


<div id="botton">  <!-- 这个是页面底部空出来用于显示数据的一个div大框-->

    <table class="easyui-datagrid" id="t1" data-options="singleSelect:true, fitColumns: true">
        <thead>
        <tr>
            <th data-options="field:'borrowed_ID'">业务编号</th>
            <th data-options="field:'book_ID'">书籍编号</th>
            <th data-options="field:'reader_ID'">身份证</th>
            <th data-options="field:'title'">书名</th>
            <th data-options="field:'reader_Name'">读者姓名</th>
            <th data-options="field:'staff_Number'">员工姓名</th>
            <th data-options="field:'staff_Name'">员工编号</th>
            <th data-options="field:'borrowed_Time'">借阅时间</th>
            <th data-options="field:'give_Back'">是否归还</th>
        </tr>
        </thead>

    </table>

</div>
</body>
</html>