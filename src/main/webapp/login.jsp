<%-- 
    Document   : hello
    Created on : Dec 11, 2018, 3:26:10 PM
    Author     : Irwan Cigist <cigist.developer@gmail.com>
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file = "header.jsp" %>
  <div class="container">
            <h1>Hello World!</h1>
            <c:set var="today" value ="<%=new java.util.Date()%>" />
            <h2>Today is <fmt:formatDate value="${today}" pattern="yyy-MM-dd" /></h2>
            <form action="processLogin" method="post" class="form-horizontal">  
                Name:<input type="text" class="form-control input-sm" name="name"><br>  
                Password:<input type="password" class="form-control input-flat" name="password"><br>  
                <input class="al-btn-success" type="submit" value="login">  
            </form>  
        </div>
<%@ include file = "footer.jsp" %>
