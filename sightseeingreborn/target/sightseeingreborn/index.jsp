<!--
  HOME PAGE for Sightseeing Reborn
  Author: Bo Broadway
-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<%@ include file="templates/head.jsp" %>

<body class="container-fluid">
<%@ include file="templates/header.jsp" %>
<%@ include file="templates/navigation.jsp" %>

<div class="container-fluid">

    <!-- Heading -->
    <h3>The Sights of Eorzea</h3>

    <!-- All Sights Table -->
    <table class="table table-striped">

        <!-- Header Row -->
        <tr>
            <th>Date Added</th>
            <th>Name</th>
            <th>Description</th>
            <th>Zone</th>
            <th>Coordinates</th>
            <th>Screenshot</th>
        </tr>

        <!-- Sight Records Row(s) -->
        <c:forEach var="sight" items="${allSights}">
            <tr>

                <!-- MM/DD/YYYY at 00:00 by USER [conditional: (remove)] -->
                <td>
                    ${sight.created.getMonthValue()}/${sight.created.getDayOfMonth()}/${sight.created.getYear()}<br />
                    <span class="small">at ${sight.created.getHour()}:${sight.created.getMinute()}</span><br />
                    <span class="text-muted small">by ${sight.userName}</span><br />
                    <c:if test="${sight.userName.equals(pageContext.request.getUserPrincipal().getName())}">
                        <a href="/deleteSight?sightId=${sight.id}">(remove)</a>
                    </c:if>
                </td>

                <!-- Name -->
                <td>${sight.name}</td>

                <!-- Description -->
                <td>${sight.description}</td>

                <!-- Zone Name, Region, Expansion -->
                <td>
                    ${sight.zone.name}<br />
                    <span class="text-muted small">${sight.zone.region}<br />
                    <span class="text-muted small">(${sight.zone.expansion})</span>
                    </span>
                </td>

                <!-- X: __, Y: __, Z: __ -->
                <td>
                    X: ${sight.cordX}<br />
                    Y: ${sight.cordY}<br />
                    <c:if test="${not empty sight.cordZ}">
                        Z: ${sight.cordZ}
                    </c:if>
                </td>

                <!-- Screenshot -->
                <td>
                    <c:choose>
                        <c:when test="${not empty sight.ssUrl}">
                            <a href="/sightImage/${sight.id}" data-lightbox="sights" data-title="${sight.name} - ${sight.zone.name}">
                                <img class="preview" src="/sightImage/${sight.id}" alt="Image for Sight ${sight.id}">
                            </a>
                        </c:when>
                        <c:otherwise>
                            <img class="preview" src="images/previewUnavailable.png" alt="Preview Unavailable">
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="templates/footer.jsp" %>
<script type="text/javascript" src="js/lightbox.js"></script>
</body>
</html>