<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/10/2016
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
  <form class="form-inline" action="j_security_check" method="post">
      <div class="form-group">
          <label class="sr-only" for="j_username">Username</label>
          <input type="text" class="form-control" id="j_username" name="j_username" placeholder="Username">
      </div>
      <div class="form-group">
          <label class="sr-only" for="j_password">Password</label>
          <input type="password" class="form-control" id="j_password" name="j_password" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-default">Log in</button>
    <br />
    <a href="/createUser">Create Login</a>
  </form>
</div>
