<%--
  The CREATE USER page.
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

<!-- Heading -->
<div class="container-fluid">
    <h3 class="sectionTitle">Create Login</h3>
</div>

<!-- Create User Form -->
<div class="container-fluid">
    <form class="form-horizontal" id="createUser" action="${pageContext.request.contextPath}/addUser" method="post">

        <!-- UserName -->
        <div class="form-group">
            <label class="sr-only" for="user">Username</label>
            <input type="text" class="form-control" id="user" name="username" placeholder="Username" maxlength="25" required>
        </div>

        <!-- Password -->
        <div class="form-group">
            <label class="sr-only" for="firstPassword">Password</label>
            <input type="password" class="form-control passwordMatch" id="firstPassword" name="password" placeholder="Password" maxlength="25" required>
        </div>

        <!-- Confirm Password -->
        <div class="form-group">
            <label class="sr-only" for="confirmPassword">Confirm Password</label>
            <input type="password" class="form-control passwordMatch"  id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" maxlength="25" required>
        </div>

        <!-- Create Button -->
        <button id="submitNewUser" type="submit" class="btn btn-default">Create</button>

    </form>
</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>
