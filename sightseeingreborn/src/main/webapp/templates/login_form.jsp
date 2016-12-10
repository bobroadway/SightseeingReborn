<%--
  LOGIN_FORM for the header.
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/10/2016
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Login Form -->
<div class="container-fluid">
  <form class="form-inline" action="${pageContext.request.contextPath}/logIn" method="post">

      <!-- UserName -->
      <div class="form-group">
          <label class="sr-only" for="username">Username</label>
          <input type="text" class="form-control" id="username" name="username" placeholder="Username" maxlength="25" >
      </div>

      <!-- Password -->
      <div class="form-group">
          <label class="sr-only" for="password">Password</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Password" maxlength="25" >
      </div>

      <!-- Submit -->
      <button type="submit" class="btn btn-default">Log in</button>
    <br />

    <!-- Create Login -->
    <a href="${pageContext.request.contextPath}/createUser">Create Login</a>
  </form>
</div>
