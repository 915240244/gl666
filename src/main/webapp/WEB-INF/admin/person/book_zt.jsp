<%--
  Created by IntelliJ IDEA.
  User: 差距
  Date: 2018/8/25
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>书籍状态</title>

    <link rel="stylesheet"  type="text/css" href="js/themes/default/easyui.css"/>
    <script src="js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>

    <style>
        /*头部的选择栏-大框*/
        #head{
            background-color:blueviolet;
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
        /*中间 搜索框内左边框*/
        #conter_left{
            position: absolute;
            top: 10px;
            left: 230px;
            width: 250px;
            height: 170px;
        }
        /*中间 搜索框内右边框*/
        #conter_right{
            position: absolute;
            top: 10px;
            left: 680px;
            width: 400px;
            height: 170px;
        }


        /*底部  文本大框 用于显示数据的一个大框*/
        #botton{
            background-color: #82d021;
            position: absolute;
            top: 250px;
            left: 100px;
            width: 1300px;
            height: auto;
        }

    </style>
    <script>
        i=0;//定义一个全局变量 当数据进行删除时 实现 自动刷新
            //1 书名查询
            //2 书号搜索
            //3 在馆库存范围查询



        $(function(){
            bookName();

        });
        //书名查询
        function bookName() {

                    var book_name =$("#book_name").val();
                    var selectURl = "AdminBookNameSelect.do";
                    $.ajax({
                        data:{
                            bookName:book_name
                        },
                        url:selectURl,
                        json:'json',
                        type:'get',
                        success:function(data){
                            //回调数据
                            if (data==""){

                                $("#tishi").html("查无此数据");
                            }else{
                                i=1;//全局
                                //    和 table 控件绑定
                                $("#t1").datagrid("loadData", data);
                                //清除提示
                                $("#tishi").html("");

                            }
                        },
                        error:function(){
                            $("#tishi").html("搜索数据异常数据异常");
                        }
                    })
        }


        //书号搜索
        function  booknumber() {
           var number = $("#query_num").val();
            $.ajax({
                url:"AdminBookNumber.do",
                json:'json',
                type:'get',
                data:{
                    number: number
                },
                success:function (data) {
                        if (!data)
                            $("#tishi").html("没有数据");
                        else {
                            i=2;
                            //绑定table 控件
                            $("#t1").datagrid("loadData", data);
                            //清空提示
                            $("#tishi").html("");
                        }
                }

            })
        }

            //在馆库存范围查询
        function stocksSelect() {
            var stocksUrl = "AdminStocksSelect.do";
            var min = $("#number_of1").val();
            var max = $("#number_of2").val();
            $.ajax({
                type:'get',
                url:stocksUrl,
                json:'json',
                data:{
                  min:min,
                  max:max
                },
                success:function (data) {
                    i=3;
                    $("#t1").datagrid("loadData", data);
                },
                error:function () {
                    alert("哎呀 数据查询数据异常啦 ");
                }




            })
        }


        //更新书籍信息
        function upbook() {

                var row = $("#t1").datagrid('getSelected');
                if (row){
                    var bookid = row.book_ID;
                    var url="AdminBookID.do";
                    $.ajax({
                        type:'get',
                        url:url,
                        dataType:'text',
                        data:{
                            bookid:bookid
                        },success:function () {
                            window.location.href="up.do";
                        }
                    })
                }
        }
        //删除书籍
        function deleteBook() {
            var row = $("#t1").datagrid('getSelected');
            if (row){
                var bookid = row.book_ID;
                var url="AdminDeleteBook.do";
                $.ajax({
                    type:'get',
                    url:url,
                    dataType:'text',
                    data:{
                        bookid:bookid
                    },success:function (data) {
                        switch (i){
                            case 1:bookName(); break;
                            case 2:booknumber(); break;
                            case 3:stocksSelect(); break;
                        }
                        if (data=="yes") alert("成功删除了书籍编号为："+bookid);
                        else if (data=="no") alert("删除 "+bookid+" 失败啦！！");
                    },error:function () {
                        alert("删除数据异常！！！");
                    }
                })
            }




        }

    </script>
</head>



<body bgcolor="#8b008b"> <!--==============================-->


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



<div id="conter"> <!---------这个是 中间 的搜索框外框------->

    <div id="conter_left">  <!-- 中间框内 左 框-->
        <input type="text"  id="query_num" >  <!--搜索框 和 按钮-->
        <input type="button"  value="搜索书号" onclick="booknumber()">  <br>
        <input type="text"  id="book_name"  class="easyui-textbox">
        <input  type="button"  value="书名" onclick="bookName()">
        <p><span id="tishi"></span></p>
    </div>

    <div id="conter_right">   <!-- 中间框内 右 框-->
        <input type="text"  id="number_of1" placeholder="0">  <span>--</span>
        <input type="text"  id="number_of2" placeholder="9999"> <!-- 这里查看库存是查看在馆数量-->
        <input type="button"  value="查看库存" onclick="stocksSelect()">
        <br /><br />  <button  onclick="upbook()">修改</button>
        <br /><br /> <button  onclick="deleteBook()">删除</button>
    </div>
</div>



<div id="botton">  <!-- 这个是页面底部空出来用于显示数据的一个div大框-->

    <table class="easyui-datagrid" id="t1" data-options="
    singleSelect:true,
    fitColumns:true
">
        <thead>
        <tr>
            <th data-options="field:'book_ID'">书籍编号</th>
            <th data-options="field:'title'">书名</th>
            <th data-options="field:'author'">作者</th>
            <th data-options="field:'press'">出版社</th>
            <th data-options="field:'location'">所在位置</th>
            <th data-options="field:'type_Number'">类型编号</th>
            <!--<th data-options="field:'url'">封面</th>-->
            <th data-options="field:'publication_Date'">出版日期</th>
            <th data-options="field:'price'">价格</th>
            <th data-options="field:'total'">总藏数量</th>
            <th data-options="field:'stocks'">库存</th>
            <!--<th data-options="field:'Synopsis'">备注</th>-->
        </tr>
        </thead>

    </table>

</div>


</body>
</html>