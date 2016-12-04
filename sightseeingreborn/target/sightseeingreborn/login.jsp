<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 11/24/2016
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<div class="container-fluid">
    <h3>You need to log in for that.</h3>
    <form class="form-inline" action="j_security_check" method="post">
        <div class="form-group">
            <label class="sr-only" for="j_username">Username</label>
            <input type="text" class="form-control" id="j_username" name="j_username" placeholder="Username" maxlength="25" required>
        </div>
        <div class="form-group">
            <label class="sr-only" for="j_password">Password</label>
            <input type="password" class="form-control" id="j_password" name="j_password" placeholder="Password" maxlength="25" required>
        </div>
        <button type="submit" class="btn btn-default">Log in</button>
    </form>
</div>
</body>
</html>
