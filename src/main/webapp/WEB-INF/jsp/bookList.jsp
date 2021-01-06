<%-- 
    Document   : bookList
    Created on : Dec 1, 2020, 10:55:15 AM
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
        
        <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
        <script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="index.html">Online Library</a>
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
                            <a class="nav-link" href="http://localhost:8081/book/Trang chủ
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
        
        <div style="margin-top: 20px" class="container" >
            <div class="row text-center">
                <c:forEach var="book" items="${bookList}">
                    <div class="col-lg-3 col-md-6 mb-4">
                        <div class="card h-100">
                            <div><img class="card-img-top" src= "${pageContext.request.contextPath}/resources/images/${book.image}" alt=""></div>
                            <div class="card-body">
                                <h4 class="card-title">${book.bookName}</h4>
                            </div>
                            <div class="card-footer">
                                <a href="${pageContext.request.contextPath}/detail/${book.bookID}" class="btn btn-primary">Tìm hiểu thêm</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        <footer class="py-5 bg-light">
            <div class="container">
                <p class="m-0 text-center text-black">Copyright &copy; Your Website 2020</p>
            </div>
        <!-- /.container -->
        </footer>
    </body>
</html>
