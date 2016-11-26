<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<%@ include file="templates/head.jsp" %>

<body class="container-fluid">
<%@ include file="templates/header.jsp" %>
<%@ include file="templates/navigation.jsp" %>

<div class="container-fluid">

    <h3>The Sights of Eorzea</h3>
    <table class="table table-striped">
        <tr>
            <th>Date Added</th>
            <th>Name</th>
            <th>Description</th>
            <th>Zone</th>
            <th>Coordinates</th>
            <th>Screenshot</th>
        </tr>
        <c:forEach var="sight" items="${allSights}">
            <tr>
                <td>${sight.created}</td>
                <td>${sight.name}</td>
                <td>${sight.description}</td>
                <td>${sight.zoneId}</td>
                <td>X: ${sight.cordX}, Y: ${sight.cordY}, Z: ${sight.cordZ}</td>
                <td><img class="preview" src="uploads/${sight.ssUrl}" alt="Image for Sight ${sight.id}"></td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>