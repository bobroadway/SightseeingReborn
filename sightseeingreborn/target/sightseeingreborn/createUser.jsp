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
<body>
<%@ include file="templates/header.jsp" %>
<%@ include file="templates/navigation.jsp" %>

<div>
    <h3>Create Login</h3>
</div>

<div>
    <form id="createUser" action="" method="post">

        <label for="username">Username</label>
        <input type="text" name="username" id="username" />
        <br />

        <label for="password">Password</label>
        <input type="password" name="password" id="password" />
        <br />

        <label for="confirmPassword">Confirm Password</label>
        <input type="password" name="confirmPassword" id="confirmPassword" />
        <br />

        <button>Create</button>

    </form>
</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>
