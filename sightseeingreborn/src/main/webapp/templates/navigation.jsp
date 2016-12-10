<%--
  NAVIGATION for Sightseeing Reborn
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/10/2016
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Navbar -->
<div class="navbar navbar-default">
    <div class="container-fluid">
        <ul>
            <!-- Home -->
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
            <ul class="nav navbar-nav">

                <!-- Add Sight -->
                <c:if test="${pageContext.request.isUserInRole('registeredUser')}">
                    <li><a href="/addSight">Add Sight</a></li>
                </c:if>

                <!-- External Links -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">External Links <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="http://na.finalfantasyxiv.com/lodestone/">The Lodestone</a></li>
                        <li><a href="http://ffxiv.gamerescape.com/">FFXIV Wiki - GamerEscape</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="http://ffxiv.consolegameswiki.com/wiki/Sightseeing_Log">In-game Sightseeing Log</a></li>
                        <li><a href="http://ffxiv.consolegameswiki.com/wiki/Sightseeing_Log">XIV Vistas</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="https://www.reddit.com/r/ffxiv/">/r/FFXIV</a></li>
                    </ul>
                </li>
            </ul>
        </ul>
    </div>
</div>