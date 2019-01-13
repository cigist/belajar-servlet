<%-- 
    Document   : dashboard
    Created on : Jan 9, 2019, 11:27:54 AM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<div class="container">
    <%
        out.println("<b>Your IP address is " + request.getRemoteAddr()+"</b>");
    %>
</div>
    <%@ include file ="../footer.jsp" %>
