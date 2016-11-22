<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/23/2016
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="templates/head.jsp" %>
<body class="container-fluid">
<%@ include file="templates/header.jsp" %>
<%@ include file="templates/navigation.jsp" %>

<div class="container-fluid">
    <h3 class="sectionTitle">Create Login</h3>
</div>

<div class="container-fluid">
    <form class="form-horizontal" id="createUser" action="" method="post">

        <div class="form-group">
            <label class="sr-only" for="username">Username</label>
            <input type="text" class="form-control" id="username" placeholder="Username">
        </div>
        <div class="form-group">
            <label class="sr-only" for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <div class="form-group">
            <label class="sr-only" for="confirmPassword">Confirm Password</label>
            <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
        </div>

        <button type="submit" class="btn btn-default">Create</button>

    </form>
</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>
