<%-- 
    Document   : detail
    Created on : Nov 27, 2020, 9:58:21 AM
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
        <link href="<c:url value='/resources/css/detail.css'/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value='/resources/jquery/jquery.min.js'/>"></script>
        <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
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
        
        <div style="margin-top: 10px" class="container">
            <div class="card">
                <div class="row">
                    <aside class="col-sm-5 border-right">
                        <article class="gallery-wrap">
                            <div class="img-big-wrap">
                                <div>
                                    <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/${book.image}" alt="">
                                </div>
                            </div>
                        </article>
                    </aside>
                    <aside class="col-sm-7">
                        <article class="card-body p-5">
                            <h2>${book.bookName}</h2>
                            <p class="price-detail-wrap">
                                <span class="price h3 text-warning">
                                    <h6>Tác giả: ${book.author} </h6>
                                </span>
                            </p>
                            <p class="price-detail-wrap">
                                <span class="price h3 text-warning">
                                    <h6>Nhà xuất bản: ${book.producer}</h6>
                                </span>
                            </p>
                            <p class="price-detail-wrap">
                                <span class="price h3 text-warning">
                                    <h6>Hình thức bìa: ${book.bookInformaton}</h6>
                                </span>
                                <span class="price h3 text-warning">
                                    <h2>${book.untiPrice}</h2>
                                </span>
                            </p>
                            
                            <hr>
                            <a href="http://localhost:8080/book/" class="btn btn-lg btn-primary text-uppercase"> Trở về </a>
                            <a href="${pageContext.request.contextPath}/addToCart/${book.bookID}" class="btn btn-lg btn-outline-primary text-uppercase"> Tiếp tục </a>
                        </article>
                    </aside>            
                </div>
            </div>
        </div>
        
        <footer style="margin-top: 10px" class="py-5 bg-light">
            <div class="container">
                <p>Mỗi cuốn sách là một bức tranh kì diệu về cuộc sống, mở ra trước mắt chúng ta những chân trời tri thức mới. Có những cuốn sách đã trở thành kim chỉ nam soi sáng trên con đường chúng ta đi, hoặc đơn giản chỉ là lưu giữ những kỉ niệm bồi đắp cho tâm hồn. Trong thế giới sách phong phú và ngập tràn như hiện nay, có rất nhiều cuốn sách hay và ý nghĩa khiến bạn yêu thích.</p>
            </div>
            <div class="container">
                <p class="m-0 text-center text-black">Copyright &copy; Your Website 2020</p>
            </div>
        </footer>
    </body>
</html>
