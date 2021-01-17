<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.01.2021
  Time: 15:55
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

<h1>Add station:</h1>
<form:form method="post" action="/addStation" modelAttribute="newStation">
    <label>E-mail:</label><form:input path="name" />
    <input type="submit" value="Log in!"/>
</form:form>


<h1>Delete Station:</h1>
<form:form method="post" action="/deleteStation" modelAttribute="deletedStation">
    <form:select path="id">
    <c:forEach items="${allStations}" var="station">
        <form:option value="${station.id}"><c:out value="${station.name}" /></form:option>
    </c:forEach>
        <input type="submit" value="Delete!"/>
</form:select>
</form:form>






</body>
</html>
