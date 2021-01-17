<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 14.01.2021
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/JSP/Page" prefix="jsp" %>--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Railway Tickets</title>
</head>
<body>

<h1>Railway Tickets index page</h1>

<H2>Wellcome,<c:choose>
 <c:when test="${currentUser = null}">Guest</c:when>
<c:otherwise><c:out value="${currentUser.firstName}"/> <c:out value="${currentUser.lastName}"/></c:otherwise>
</c:choose>
</H2>


<form:form method="post" action="/login" modelAttribute="currentUser">
    <p>Log in:</p>
    <label>E-mail:</label><form:input path="email" />
    <label>Password:</label><form:password path="password" />

    <input type="submit" value="Log in!"/>
</form:form>

</body>
</html>
