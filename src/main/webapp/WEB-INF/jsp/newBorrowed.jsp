<%-- 
    Document   : newBorrowed
    Created on : Dec 14, 2020, 4:34:33 PM
    Author     : Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Library</title>
        <link href="<c:url value='/resources/css/heroic-features.css'/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value='/resources/jquery/jquery.js'/>" type="text/javascript"></script>
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
        
        <script src="<c:url value='/resources/jquery/jquery.min.js'/>"></script>
        <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
    </head>
    <body>
        <<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="index.html">Online Library</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <form class="form-inline active-purple-3 active-purple-4">
                    <i class="fas fa-search" aria-hidden="true"></i>
                    <input class="form-control form-control-sm ml-3 w-auto" type="text" placeholder="Search" aria-label="Search">
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
        
        <div class="container wrapper">
            <mvc:form class="form-horizontal" modelAttribute="borrowed" action="${pageContext.request.contextPath}/newBorrowed1" method="post" >
                <div class="panel panel-info">
                    <div class="panel-body">
                        <div class="form-group">
                            <div style="margin-top: 30px" class="col-md-12">
                                <h4>Shipping Address</h4>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Full Name:</strong></div>
                            <div class="col-md-12">
                                <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Full Name" path="name" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Library Code:</strong></div>
                            <div class="col-md-12">
                                <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="••••••" path="librarycode" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Pay Day:</strong></div>
                            <div class="col-md-12">
                                <mvc:input id="cc-exp" class="input-lg form-control cc-exp" autocomplete="cc-exp" placeholder="•• / ••" path="payDate" type="Date"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Address:</strong></div>
                            <div class="col-md-12">
                                <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Address" path="address" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Number Phone:</strong></div>
                            <div class="col-md-12">
                                <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Number Phone" path="phone" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Email Address:</strong></div>
                            <div class="col-md-12">
                                <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Email Address" path="email" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <button type="submit" value="Save" class="btn btn-success">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </mvc:form>
        </div>
    </body>
</html>
