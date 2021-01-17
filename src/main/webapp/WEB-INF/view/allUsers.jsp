<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.01.2021
  Time: 10:13
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
    <title>Title</title>
</head>
<body>

<h2>All Users:</h2>

<%--<c:if test="${currentUser.role}"--%>
<table border="1">
    <tr>
        <td>ID</td>
        <td>E-mail</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Role</td>
        <%--<td>Tickets</td>--%>
        <td></td>
    </tr>

<c:forEach items="${allUsers.users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.email}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.role}</td>
            <%--<td>Tickets</td>--%>i
        <td><c:url value="/user/${user.id}"/> </td>
    </tr>
</c:forEach>
</table>

</body>
</html>
