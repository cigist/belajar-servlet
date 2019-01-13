<%-- 
    Document   : addTransaksi
    Created on : Jan 8, 2019, 11:25:51 PM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<%@ include file ="./../../header.jsp" %>
<center>
    <div class="container">
        <h1>ADD BOOKS</h1>
        <form class="form-horizontal" action="${pageContext.servletContext.contextPath}/transaksi/pinjam" method="post">
            <div class="form-group">
                <label for="judulBuku" class="control-label col-sm-2">Judul Buku :</label>
                <div class="col-sm-10">
                    <select name="kodeBuku" class="form-control" id="kodeBuku">
                        <option value="" disabled="true">Choose..</option>  
                        <c:forEach items="${listBuku}" var="buku">                        
                         <option value="${buku.id}">${buku.judulBuku}</option>   
                        </c:forEach>
                    </select>
                </div>
            </div>
             <div class="form-group">
                <label for="judulBuku" class="control-label col-sm-2">Pengunjung :</label>
                <div class="col-sm-10">
                    <select name="pengunjung" class="form-control" id="pengunjung">
                        <option value="" disabled="true">Choose..</option>
                       <c:forEach items="${listPengunjung}" var="p">
                         <option value="${p.id}">${p.nama}</option>   
                        </c:forEach>
                    </select>
                </div>
            </div>
       
            <div class="form-group">
                <button type="submit" class="btn btn-flat">SUBMIT</button>
                <button type="reset" class="btn btn-flat">RESET</button>
            </div>
    </div>
</center>
<%@ include file ="./../../footer.jsp" %>

