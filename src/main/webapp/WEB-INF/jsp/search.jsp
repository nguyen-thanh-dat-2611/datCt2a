<%-- 
    Document   : home
    Created on : Sep 20, 2020, 11:52:57 PM
    Author     : LENOVO
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
                            <a class="nav-link" href="cart">Giỏ hàng</a>
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

  <!-- Page Content -->
  <div class="container">

    <div id="banner" style="margin-top: 10px" >
        <img src="resources/images/bia.jpg" width="1110" height="400" alt="" />
    </div>

    <!-- Page Features -->
    <a href="textList/1"><h3 class="my-4"></h3></a>
    <div class="row text-center">
        <c:forEach var="book" items="${bookList}">
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card h-100">
                    <div>
                        <img class="card-img-top" src= "${pageContext.request.contextPath}/resources/images/${book.image}" alt="">
                    </div>
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

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-light">
      <div class="container">
          <p>Mỗi cuốn sách là một bức tranh kì diệu về cuộc sống, mở ra trước mắt chúng ta những chân trời tri thức mới. Có những cuốn sách đã trở thành kim chỉ nam soi sáng trên con đường chúng ta đi, hoặc đơn giản chỉ là lưu giữ những kỉ niệm bồi đắp cho tâm hồn. Trong thế giới sách phong phú và ngập tràn như hiện nay, có rất nhiều cuốn sách hay và ý nghĩa khiến bạn yêu thích.</p>
      </div>
    <div class="container">
      <p class="m-0 text-center text-black">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>
    </body>
</html>
