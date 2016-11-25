<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/10/2016
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <h3>Welcome, <c:out value="${pageContext.request.getUserPrincipal().getName()}" default="Sightseeing Reborn" />!</h3>
    <a href="/logOut">Log Out</a>
</div>
