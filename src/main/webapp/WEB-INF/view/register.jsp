<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.01.2021
  Time: 00:10
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

<h2>Input your data to register:</h2>

<form:form method="post" action="/register" modelAttribute="currentUser">
    <p>Log in:</p>
    <label>E-mail:</label><form:input path="email" />
    <label>Password:</label><form:password path="password" />
    <label>First Name:</label><form:input path="firstName" />
    <label>Last Name:</label><form:input path="lastName" />

    <input type="submit" value="Register"/>

</form:form>
.
</body>
</html>

