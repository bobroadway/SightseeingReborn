<%--
  The ADD SIGHT page.
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/23/2016
  Time: 7:23 PM
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
    <h3 class="sectionTitle">Share Your Sight</h3>
</div>

<!-- Add Sight Form -->
<div class="container-fluid">
    <form class="form-horizontal" id="addSight" action="${pageContext.request.contextPath}/insertSight" method="post" enctype="multipart/form-data">

        <!-- Name -->
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="name" name="name" placeholder="Name" maxlength="25" required>
            </div>
        </div>

        <!-- Description -->
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="description" name="description" placeholder="Description" maxlength="140" >
            </div>
        </div>

        <!-- Zone -->
        <div class="form-group">
            <label for="zone" class="col-sm-2 control-label">Zone</label>
            <div class="col-sm-8">
                <select id="zone" name="zone" class="form-control" required>
                    <c:forEach var="zone" items="${allZones}">
                        <option value="${zone.zoneId}">${zone.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Coordinates -->
        <div class="form-group">
            <label for="coordinates" class="col-sm-2 control-label">Coordinates</label>
            <div class="row" id="coordinates">

                <div class="col-xs-1">
                    <input type="text" name="xCord" class="form-control" placeholder="X" maxlength="2" required>
                </div>
                <div class="col-xs-1">
                    <input type="text" name="yCord" class="form-control" placeholder="Y" maxlength="2" required>
                </div>
                <div class="col-xs-1">
                    <input type="text" name="zCord" class="form-control" placeholder="Z" maxlength="2">
                </div>
            </div>
        </div>

        <!-- Upload Screenshot -->
        <div class="form-group">
            <label for="screenshot" class="col-sm-2 control-label">Upload Screenshot</label>
            <div class="col-sm-8">
                <input type="file" id="screenshot" name="screenshot">
                <p class="help-block">Share your sight with a screenshot!</p>
            </div>
        </div>

        <!-- Submit Button -->
        <div class="form-group center">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form>
</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>
