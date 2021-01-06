 <%-- 
    Document   : rental
    Created on : Dec 15, 2020, 9:44:04 AM
    Author     : Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Online Library</title>
        <link href="<c:url value='/resources/css/heroic-features.css'/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value='/resources/jquery/jquery.js'/>" type="text/javascript"></script>
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
        
        <script src="<c:url value='/resources/jquery/jquery.min.js'/>"></script>
        <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
        <link href="<c:url value='/resources/css/cart.css'/>" rel="stylesheet" type="text/css"/>
        <script src="https://use.fontawesome.com/c560c025cf.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="">Online Library</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <form class="form-inline active-purple-3 active-purple-4" action="${pageContext.request.contextPath}/search" method="get">
                    <i class="fas fa-search" aria-hidden="true"></i>
                    <input class="form-control form-control-sm ml-3 w-auto" type="text" name="searchText" id="searchText" placeholder="Search">
                </form>  
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="http://localhost:8081/book/">Trang chủ
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giỏ hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng ký</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Tên sách</th>
                            <th>Tác giả</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Số tiền</th>
                            <th>Xoá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="h" value="0"></c:set>
                        <c:forEach var="borrowedDetail" items="${rental.borrowedDetailList}">
                            <tr>
                                <td>
                                    <img src="${pageContext.request.contextPath}/resources/images/${borrowedDetail.book.image}" class="img-cart" >
                                </td>
                                <td>${borrowedDetail.book.bookName}</td>
                                <td>${borrowedDetail.book.author}</td>
                                <td>${borrowedDetail.book.untiPrice}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/update1" method="post">
                                        <input type="hidden" name="id"
                                            value='${borrowedDetail.book.bookID}'/>
                                        <input type="number" name="quantity"
                                            accept="" value='${borrowedDetail.quantity}'style="width: 100px"/>
                                    </form>
                                </td>
                                <td>${borrowedDetail.total}</td>
                                <td><a href="${pageContext.request.contextPath}/delete1/${borrowedDetail.book.bookID}"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tr>
                        <th colspan="2">Tổng tiền</th> 
                        <td colspan="5">${rental.total}</td>         
                    </tr>
                </table>
            </div>
        </div>
        <a href="http://localhost:8080/book/" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Trở lại trang chủ</a>
        <a href="${pageContext.request.contextPath}/newBorrowed" class="btn btn-primary pull-right">Tiếp tục</a>
    </body>
</html>
