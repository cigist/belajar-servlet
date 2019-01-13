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
    <h1>Daftar Transaksi</h1>
    <a class="btn btn-flat btn-warning" href="${pageContext.servletContext.contextPath}/transaksi/pinjam" >PINJAM BUKU</a>
    <div class="table-responsive">
        <table class="table table-hover table-bordered" style="margin-top: 5px;">
            <thead>
            <th>No</th>
            <th>ID Transaksi</th>
            <th>Nama Buku</th>
            <th>Nama Peminjam</th>
            <th>Alamat</th>
            <th>Tanggal Pinjam</th>
            <th>Tanggal Kembali</th>
            <th>#</th>
            </thead>
            <tbody>
                <c:forEach items="${listTransaksi}" var="item"  varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${item.id}</td>
                        <td>${item.buku.judulBuku}</td>
                        <td>${item.pengunjung.nama}</td>
                        <td>${item.pengunjung.alamat}</td>
                        <td>${item.tanggalPinjam}</td>
                        <td>${item.tanggalKembali}</td>
                        <td>
                            <c:if test="${item.tanggalKembali != null}">
                                <button class="btn btn-flat btn-success" >DONE</button>
                            </c:if>
                            <c:if test="${item.tanggalKembali == null }">
                                <a class="btn btn-flat btn-warning" href="${pageContext.servletContext.contextPath}/transaksi/kembali?idTransaksi=${item.id}&kodeBuku=${item.buku.id}" >OPEN</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file = "./../../footer.jsp" %>
