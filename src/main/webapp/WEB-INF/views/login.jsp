<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Prashant Pant
  Date: 4/3/2019
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/style.css" media="screen" type="text/css" />

</head>
<body>

<div class="login-card">
<spring:form action="/login" method="post" modelAttribute="user">
    <h2>Login Page</h2>
    <p style="color: red"> ${errors}</p>

    <table>

    <tr>
    <td><spring:label path="name">UserName</spring:label>
    <td><spring:input path="name" class="fadeIn second" placeholder="Enter Username." required="required"/></td>

    </tr>

    <tr>
    <td><spring:label path="emailId">Email</spring:label>
    <td><spring:input path="emailId" type="email" placeholder="Enter email"/>


    </tr>

    <tr>
    <td><spring:label path="password">Password</spring:label>
    <td><spring:input type="password"  path="password" placeholder="Enter Password." required="required"/></td>
    <%--<td><spring:errors path="password" cssClass="errors" ></spring:errors></td>--%>

    </tr>

    <tr>
    <td><input type="submit" value="login"/></td>
    </tr>

    </table>
    </spring:form>

</body>
</html>
