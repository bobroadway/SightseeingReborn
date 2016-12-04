<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/23/2016
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="templates/head.jsp" %>
<body class="container-fluid">

    <h2>Admin Page for Admins that only an Admin can see if they're an Admin.</h2>

    <div class="container-fluid">

        <table class="table table-condensed table-bordered table-striped">
            <tr>
                <th>Action </th>
                <th>Sight Id </th>
                <th>Name </th>
                <th>Added By </th>
                <th>Date Added </th>
            </tr>
            <c:forEach var="sight" items="${allSights}">
                <tr>
                    <td>
                        <form class="form-horizontal" id="adminDelete" action="/deleteSight" method="get">
                            <input type="hidden" name="sightId" value="${sight.id}">
                            <button type="submit" class="btn btn-danger btn-xs">Remove</button>
                        </form>
                    </td>
                    <td>${sight.id}</td>
                    <td>${sight.name}</td>
                    <td>${sight.userName}</td>
                    <td>${sight.created.getMonthValue()}/${sight.created.getDayOfMonth()}/${sight.created.getYear()}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <a href="/home">Home</a>

<%@ include file="templates/footer.jsp" %>

</body>
</html>
