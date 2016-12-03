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
                <td>
                    ${sight.created.getMonthValue()}/${sight.created.getDayOfMonth()}/${sight.created.getYear()}<br />
                    <span class="small">at ${sight.created.getHour()}:${sight.created.getMinute()}</span><br />
                    <span class="text-muted small">by ${sight.userName}</span><br />
                    <c:if test="${sight.userName.equals(pageContext.request.getUserPrincipal().getName())}">
                        <span class="small"><a href="#">(remove)</a></span>
                    </c:if>
                </td>
                <td>${sight.name}</td>
                <td>${sight.description}</td>
                <td>
                    ${sight.zone.name}<br />
                    <span class="text-muted small">${sight.zone.region}<br />
                    <span class="text-muted small">(${sight.zone.expansion})</span>
                    </span>
                </td>
                <td>
                    X: ${sight.cordX}<br />
                    Y: ${sight.cordY}<br />
                    <c:if test="${not empty sight.cordZ}">
                        Z: ${sight.cordZ}
                    </c:if>
                </td>
                <td><img class="preview" src="uploads/${sight.ssUrl}" alt="Image for Sight ${sight.id}"></td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>