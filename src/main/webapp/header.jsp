<%-- 
    Document   : header
    Created on : Dec 16, 2018, 10:26:39 PM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%!
    int pageCount = 0;

    void addCount() {
        pageCount++;
    }
%>

<% addCount();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/css/bootstrap/js/bootstrap.min.js" />" type="javascript"></script>
        <title>jsp</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/buku">Master Buku</a></li>
                    <li><a href="#">Page 2</a></li>
                    <li><a href="#">Page 3</a></li>
                </ul>
            </div>
        </nav>