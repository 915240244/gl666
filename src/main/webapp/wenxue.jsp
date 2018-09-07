<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书馆</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--webfont-->
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
            });
        });
    </script>
    <style type="text/css">
        .blog-posts {
            width: 31.4%;
            padding: 0;
            margin-right: 1.333%;
        }

        a {
            color: #000000;
        }

        .search {
            padding: 7px 8px;
            margin: 10px 20px 0 0;
        }

        /*
		.search input[type="submit"] {
			top: 5px;
			right: 5px;
		}*/
    </style>

</head>
<body>
<!-- header-section-starts -->
<div class="header" id="header">
    <div class="container">
        <div class="logo">
            <a href="/wenxue.do"><img src="images/logo.png" alt=""/></a>
        </div>
        <div class="social-icons header-social-icons">
            <a href="zhuce.html">登录</a>&&
            <a href="zhuce.html">注册</a>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="header-bottom">
    <div class="container">
        <h3><span>鸟欲高飞先振翅，人求上进先读书。</span></h3>
    </div>
</div>
<div class="navigation-strip">
    <div class="container">
        <div class="nav_content">
            <div class="home">
                <a href="/asd.do"><img src="images/home.png" alt=""/></a>
            </div>
            <%--				<div class="search">
                                    <input id="sousuo" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '书名或作者相应关键字';}"/>
                                    <input onclick="sou();" type="submit" value="">
                            </div>--%>
            <form action="/researchBook.do">
                <div class="search">
                    <input style=" border-width: 0;" name="title"/>
                    <input type="submit" value=" "/>

                    </table>
                </div>
            </form>
            <span class="menu"></span>
            <div class="top-menu">
                <ul>
                    <li><a href="/index.do">首页</a></li>
                    <li><a href="/wenxue.do">文学类</a></li>
                    <li><a href="keji.do">科技类</a></li>
                    <li><a href="shenghuo.do">生活类</a></li>
                    <li><a href="lishi.do">历史类</a></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <!-- script for menu -->
            <script>
                $("span.menu").click(function () {
                    $(".top-menu").slideToggle("slow", function () {
                        // Animation complete.
                    });
                });
            </script>
            <!-- script for menu -->
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="content">
    <div class="container">
        <div class="blog-section">
            <h4 class="head">文学类书籍<span class="line"></span></h4>
            <div class="blog-post-grids">
                <c:forEach var="book" items="${wxbooks}">
                    <div class="col-md-4 blog-posts">
                        <div class="blog-post">
                            <a href="#"><img src="${book.url}"></a>
                            <div style="margin: auto 4%;margin-top:5px">书名:${book.title}</div>
                            <div style="margin: auto 4%;margin-top:5px">书籍编号:${book.book_ID}</div>
                            <div style="margin: auto 4%;margin-top:5px">作者:${book.author}</div>
                            <div style="margin: auto 4%;margin-top:5px">出版日期:${book.publication_Date}</div>
                            <div style="margin: auto 4%;margin-top:5px">状态:<c:choose>
                                <c:when test="${book.stocks==0}">不可借</c:when>
                                <c:when test="${book.stocks==1}">可借</c:when>
                            </c:choose> <button class="btnAll" lang="${book.book_ID}" >【查看租用信息】</button></div>
                            <span></span>
                            <p>简介：${book.synopsis}</p>
                        </div>
                    </div>
                </c:forEach>
                <div class="clearfix"></div>
                <div class="blog-post-grids">
                    <c:forEach var="book" items="${researchBook}">
                        <div class="col-md-4 blog-posts">
                            <div class="blog-post">
                                <a href="#"><img src="${book.url}" alt=""></a>
                                <div style="margin: auto 4%;margin-top:5px">书名:${book.title}</div>
                                <div style="margin: auto 4%;margin-top:5px">书籍编号:${book.book_ID}</div>
                                <div style="margin: auto 4%;margin-top:5px">作者:${book.author}</div>
                                <div style="margin: auto 4%;margin-top:5px">出版日期:${book.publication_Date}</div>
                                <div style="margin: auto 4%;margin-top:5px">状态:<c:choose>
                                    <c:when test="${book.stocks==0}">不可借</c:when>
                                    <c:when test="${book.stocks==1}">可借</c:when>
                                </c:choose> <button class="btnAll" lang="${book.book_ID}" >【查看租用信息】</button></div>
                                <span></span>
                                <p>简介：${book.synopsis}</p>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="pagination text-center">
                <div class="j_page" style="height: 100px;">

                    <%--这里有问题，分页value问题--%>
                    <input type="hidden" id="pageNum" value="${wxbooks.getPageNum()}">
                    <input type="hidden" id="totalPage" value="${wxbooks.getPages()}">
                    <span onclick="firstPage()">首页</span> <span onclick="prePage()">上一页</span>
                    <input style="width: 50px;" type="text" value="${wxbooks.getPageNum()}">
                    <span onclick="nextPage()">下一页</span> <span onclick="lastPage()">尾页</span>
                </div>
            </div>
        </div>
        <!---/start-text-slider----->
        <div class="testimonials">
            <!--<h4>Testimonials</h4>-->
            <div id="testimonials">
                <div class="wmuSlider example1">
                    <div class="container-flueid">

                        <script src="js/jquery.wmuSlider.js"></script>
                        <script>
                            $('.example1').wmuSlider();
                        </script>
                        <div class="clearfix"></div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<div class="footer">

    <div class="footer-bottom">
        <div class="container">
            <div class="copyrights">
                <p>Copyright &copy; 2015.Company name All rights reserved.</p>
            </div>
            <div class="go-top">
                <a href="#header" class="scroll"><img src="images/go-to-top.png" alt=""/></a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>


<script type="text/javascript">


    function firstPage() {
        var pageNum = document.getElementById("pageNum").value;
        if (1 == pageNum) {
            alert("亲，已经是首页了");
        } else {
            window.location.href = "<%=request.getContextPath()%>wenxue.do?pageNum=" + 1;
        }
    }

    function prePage() {
        var pageNum = document.getElementById("pageNum").value;
        if (pageNum == 1) {
            alert("已经是第一页了")
        } else {
            pageNum--;
            window.location.href = "<%=request.getContextPath()%>wenxue.do?pageNum=" + pageNum;
        }

    }

    function nextPage() {
        var pageNum = document.getElementById("pageNum").value;
        var totalPage = document.getElementById("totalPage").value;
        if (pageNum == totalPage) {
            alert("已经是最后一页了")
        } else {
            pageNum++;
            window.location.href = "<%=request.getContextPath()%>wenxue.do?pageNum=" + pageNum;
        }

    }

    function lastPage() {
        var pageNum = document.getElementById("pageNum").value;
        var totalPage = document.getElementById("totalPage").value;
        if (pageNum == totalPage) {
            alert("亲，已经是尾页了");
        } else {
            window.location.href = "<%=request.getContextPath()%>wenxue.do?pageNum=" + totalPage;
        }
    }
</script>

</body>
</html>