<%-- 
    Document   : login-success
    Created on : Dec 11, 2018, 5:56:41 PM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>
<%@page import="com.cigist.belajarweb.model.Login"%> 

<%@ include file = "header.jsp" %>
<div class="container">
    <%
        Login bean = (Login) request.getAttribute("bean");
        out.print("<h1>Hai!, " + bean.getName() + "</h1>");
    %> 
    <a href="/belajar-web/" >Back to home</a>
</div>
<%@ include file = "footer.jsp" %>
