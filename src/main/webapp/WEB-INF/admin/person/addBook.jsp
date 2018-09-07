<%--
  Created by IntelliJ IDEA.
  User: 差距
  Date: 2018/8/26
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加书籍</title>

    <style>
        /*头部的选择栏-大框*/

        #head {
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

        #sousuo a {
            font-size: 20px;
            background-color: #8b008b;
            color: white;
            padding: 20px;
            border: 0px solid black;
            border-radius: 15px;
            box-shadow: 0px 2px grey;
        }
        /*版中-中间的内容外框*/

        #conter {
            position: absolute;
            top: 100px;
            left: 200px;
            width: 900px;
            height: 1000px;
        }
        /*版中-外框内上面的输入框*/

        #input {
            background-color: blueviolet;
            position: absolute;
            top: 10px;
            left: 300px;
            width: 350px;
            height: 400px;
        }
        /*版中-外框下面的文本框*/

        #textbox {
            width: 345px;
            height: 100px;
        }
    </style>

    <script>
        //图片预览
        function c() {
            var r = new FileReader();
            f = document.getElementById('file').files[0];
            r.readAsDataURL(f);

            r.onload = function(e) {
                document.getElementById('show').src = this.result;
            };
        }
        //书籍添加
        function addBook() {
            var book_Id = $("#book_Id").val();
            var title = $("#title").val();
            var author = $("#author").val();
            var publisher = $("#publisher").val();
            var positions = $("#position").val();
            var type_Number = $("#type_Number").val();
            //图片地址可能需要改
            // var imgPath = $("#url").val();
            var imgPath = "图片地址"
            var publisher_Date = $("#publication_Date").val();
            var price = $("#price").val();
            var Total = $("#Total").val();
            var Stocks = $("#Stocks").val();
            var state = $("#state").val();
            var Synopsis = $("#textbox").val();
            var urlbook="/AdminAddBook.do";
            $.ajax({
                url:urlbook,
                type:'POST',
                DateType:'text',
                data:{
                    book_Id:book_Id,
                    title:title,
                    author:author,
                    publisher:publisher,
                    positions:positions,
                    type_Number:type_Number,
                    imgPath:imgPath,
                    publisher_Date:publisher_Date,
                    price:price,
                    Total:Total,
                    Stocks:Stocks,
                    state:state,
                    Synopsis:Synopsis
                }
                ,success:function(data){
                    if(data=="yes")
                        alert("添加成功");
                    else if(data=="no")
                        alert("添加失败啦");
                },error:function(){
                    alert("添加数据成功");
                }
            })

        }
    </script>
    <script src="js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>

</head>

<body bgcolor="#8b008b">

<div id="head">
    <!----- 版头----->

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

<div id="conter">
    <!-------版中-中间的内容外框------->

    <div id="input">
        <font color="white" size="+2">书名： </font> <input type="text" id="title" > <br>
        <font color="white" size="+2">作者：</font> <input type="text" id="author"> <br>
        <font color="white" size="+2">出版社：</font> <input type="text" id="publisher"> <br>
        <font color="white" size="+2">楼层： </font> <input type="text" id="position"> <br>
        <font color="white" size="+2">类型</font> <input type="text" id="type_Number" >(1:生活类；2:科技类；3:文学类；4:历史类) <br>
        <font color="white" size="+2">封面 ：</font> <input type="text" id="url"  > <br>
        <font color="white" size="+2">日期</font> <input type="text" id="publication_Date" placeholder="2018-2-1"> <br>
        <font color="white" size="+2">价格</font> <input type="text" id="price" placeholder="999.99"> <br>
        <font color="white" size="+2">总藏书量</font> <input type="text" id="Total" placeholder="整数"><br>
        <font color="white" size="+2">剩余</font> <input type="text" id="Stocks" placeholder="整数"> <br>
         <textarea id="textbox"> 书籍简介</textarea>
        <!--封面预览-->
        <div>
            <img src="" id="show" width="200">
        </div>
        <div>
            <button onclick="addBook()">保存书籍</button>
        </div>

    </div>
</div>
</body>

</html>
