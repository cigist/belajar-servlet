<%-- 
    Document   : AddBuku
    Created on : Dec 30, 2018, 1:33:31 AM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<%@ include file ="./../../header.jsp" %>
<center>
    <div class="container">
        <h1>EDIT BOOKS</h1>
        <form class="form-horizontal" action="${pageContext.servletContext.contextPath}/buku/update" method="post">
            <div class="form-group">
                <label for="kodeBuku" class="control-label col-sm-2">Kode Buku :</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="kodeBuku" id="kodeBuku" value="${buku.id}"  readonly/>
                </div>
            </div>
            <div class="form-group">
                <label for="judulBuku" class="control-label col-sm-2">Judul Buku :</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="judulBuku" id="judulBuku" value="${buku.judulBuku
                           }" />
                </div>
            </div>
            <div class="form-group">
                <label for="tahunTerbit" class="control-label col-sm-2">Tahun Terbit :</label>
                <div class="col-sm-10">
                    <input class="form-control" type="number" name="tahunTerbit" id="tahunTerbit" value="${buku.tahunTerbit}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="pengarang" class="control-label col-sm-2">Pengarang :</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="pengarang" id="pengarang" value="${buku.pengarang}" />
                </div>
            </div>
            <div class="form-group">
                <label for="jumlahBuku" class="control-label col-sm-2">Jumlah Buku :</label>
                <div class="col-sm-10">
                    <input class="form-control" type="number" name="jumlahBuku" id="jumlahBuku" value="${buku.jumlahBuku}" readonly/>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-flat">SUBMIT</button>
                <button type="reset" class="btn btn-flat">RESET</button>
            </div>
    </div>
</center>
<%@ include file ="./../../footer.jsp" %>
