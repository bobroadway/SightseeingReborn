<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 10/23/2016
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ include file="templates/head.jsp" %>
<body>
<%@ include file="templates/header.jsp" %>
<%@ include file="templates/navigation.jsp" %>

<div>
    <h3>Share Your Sight</h3>
</div>

<div>
    <form id="createSight" action="" method="post">
        <table>
            <tr>
                <td><label for="name">Name</label></td>
                <td><input type="text" name="name" id="name" /></td>
            </tr>
            <tr>
                <td><label for="description">Description</label></td>
                <td><input type="text" name="description" id="description" /></td>
            </tr>
            <tr>
                <td>Zone</td>
                <td>
                    <select id="zoneExpansion">
                        <option value="arr">A Realm Reborn</option>
                        <option value="hw">Heavensward</option>
                    </select>
                    <select id="arrRegion">
                        <option value="thanalan">Thanalan</option>
                        <option value="shroud">The Black Shroud</option>
                        <option value="noscea">La Noscea</option>
                        <option value="morDhona">Mor Dhona</option>
                        <option value="coerthas">Coerthas</option>
                    </select>
                    <!--
                    <select id="hwRegion">
                        <option value="coerthas">Coerthas</option>
                        <option value="dravania">Dravania</option>
                        <option value="abalathia">Abalathia</option>
                    </select>
                    -->
                    <select id="zoneName">
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
                </td>
            </tr>
            <tr>
                <td>Coordinates</td>
                <td>
                    <input type="text" name="x_cord" id="x_cord" value="x" />
                    <input type="text" name="y_cord" id="y_cord" value="y" />
                    <input type="text" name="z_cord" id="z_cord" value="z" />
                </td>
            </tr>
            <tr>
                <td>Screenshot</td>
                <td><button>Upload...</button></td>
            </tr>
        </table>
        <button>Submit</button>

    </form>
</div>

<%@ include file="templates/footer.jsp" %>
</body>
</html>
