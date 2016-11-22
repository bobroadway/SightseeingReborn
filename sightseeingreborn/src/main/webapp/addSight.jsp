<%--
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

<div class="container-fluid">
    <h3 class="sectionTitle">Share Your Sight</h3>
</div>

<div class="container-fluid">
    <form class="form-horizontal" id="addSight" >
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="name" name="name" placeholder="Name">
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="description" name="description" placeholder="Description">
            </div>
        </div>
        <div class="form-group">
            <label for="zoneName" class="col-sm-2 control-label">Zone</label>
            <div class="col-sm-8">
                <select id="zoneName" name="zoneName" class="form-control" >
                    <option value="1">Ul'dah - Steps of Nald</option>
                    <option value="2">Ul'dah - Steps of Thal</option>
                    <option value="3">The Goblet</option>
                    <option value="4">Central Thanalan</option>
                    <option value="5">Western Thanalan</option>
                    <option value="6">Eastern Thanalan</option>
                    <option value="7">Southern Thanalan</option>
                    <option value="8">Northern Thanalan</option>
                    <option value="9">The Gold Saucer</option>
                    <option value="10">Old Gridania</option>
                    <option value="11">New Gridania</option>
                    <option value="12">Lavender Beds</option>
                    <option value="13">Central Shroud</option>
                    <option value="14">East Shroud</option>
                    <option value="15">South Shroud</option>
                    <option value="16">North Shroud</option>
                    <option value="17">Limsa Lominsa Upper Decks</option>
                    <option value="18">Limsa Lominsa Lower Decks</option>
                    <option value="19">The Mist</option>
                    <option value="20">Middle La Noscea</option>
                    <option value="21">Western La Noscea</option>
                    <option value="22">Eastern La Noscea</option>
                    <option value="23">Lower La Noscea</option>
                    <option value="24">Upper La Noscea</option>
                    <option value="25">Outer La Noscea</option>
                    <option value="26">The Wolves' Den</option>
                    <option value="27">Mor Dhona</option>
                    <option value="28">Coerthas Central Highlands</option>
                    <option value="29">Ishgard - Foundation</option>
                    <option value="30">Ishgard - The Pillars</option>
                    <option value="31">Coerthas Western Highlands</option>
                    <option value="32">Idyllshire</option>
                    <option value="33">The Dravanian Forelands</option>
                    <option value="34">The Dravanian Hinterlands</option>
                    <option value="35">The Churning Mists</option>
                    <option value="36">The Sea of Clouds</option>
                    <option value="37">Azys Lla</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="coordinates" class="col-sm-2 control-label">Coordinates</label>
            <div class="row" id="coordinates">

                <div class="col-xs-1">
                    <input type="text" name="xCord" class="form-control" placeholder="X">
                </div>
                <div class="col-xs-1">
                    <input type="text" name="yCord" class="form-control" placeholder="Y">
                </div>
                <div class="col-xs-1">
                    <input type="text" name="zCord" class="form-control" placeholder="Z">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="screenshot" class="col-sm-2 control-label">Upload Screenshot</label>
            <div class="col-sm-8">
                <input type="file" id="screenshot">
                <p class="help-block">Share your sight with a screenshot!</p>
            </div>
        </div>
        <div class="form-group center">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form>
</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>
