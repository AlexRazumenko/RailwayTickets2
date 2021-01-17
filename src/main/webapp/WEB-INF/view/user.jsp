<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.01.2021
  Time: 09:50
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

<h2>User <c:out value="${user}"/>'s page:</h2>





<form:form method="post" action="/login" modelAttribute="logUserDTO">
    <p>Log in:</p>
    <label>E-mail:</label><form:input path="email" />
    <label>Password:</label><form:password path="password" />

    <input type="submit" value="Log in!"/>


    <%--<h3>or <a href="/register">register</a></h3>--%>
</form:form>
<h3>or
    <form:form method="get" action="/register" modelAttribute="currentUser"><input type="submit" value="register"/></h3>
</form:form>
</body>
</html>

