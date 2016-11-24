<c:choose>

    <c:when test="${pageContext.request.isUserInRole('registeredUser')}">
        <%@ include file="welcome_message.jsp" %>
    </c:when>

    <c:otherwise>
        <%@ include file="login_form.jsp"      %>
    </c:otherwise>

</c:choose>