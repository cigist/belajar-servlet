<%-- 
    Document   : listBuku
    Created on : Dec 30, 2018, 4:16:29 PM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<%@ include file ="./../../header.jsp" %>
<div class="container">
    <h1>Daftar Buku</h1>
    <a class="btn btn-flat btn-warning" href="${pageContext.servletContext.contextPath}/buku/new" >ADD BOOK</a>
    <table class="table table-hover table-bordered" style="margin-top: 5px;">
        <thead>
        <th>No</th>
        <th>ID</th>
        <th>Nama Buku</th>
        <th>Tahun Terbit</th>
        <th>Pengarang</th>
        <th>Jumlah Buku</th>
        <th>#</th>
        </thead>
        <tbody>
            <c:forEach items="${listBuku}" var="item"  varStatus="index">
                <tr>
                    <td>${index.count}</td>
                    <td>${item.id}</td>
                    <td>${item.judulBuku}</td>
                    <td>${item.tahunTerbit}</td>
                    <td>${item.pengarang}</td>
                    <td>${item.jumlahBuku}</td>
                    <td style="width:160px;">
                        <a class="btn btn-flat" href="${pageContext.servletContext.contextPath}/buku/edit?idBuku=${item.id}">EDIT</a>
                        <a class="btn btn-flat" href="${pageContext.servletContext.contextPath}/buku/delete?idBuku=${item.id}">DELETE</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file = "./../../footer.jsp" %>
