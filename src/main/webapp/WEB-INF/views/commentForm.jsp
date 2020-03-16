<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Prashant Pant
  Date: 4/3/2019
  Time: 3:22 PM
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
    <spring:form action="comment" method="post" modelAttribute="comment">


        <table>


                <td><spring:label path="name">Name</spring:label></td>
                <td><spring:input path="name"/></td>
                <%--<td><spring:errors path="name" cssClass="errors" ></spring:errors></td>--%>
            </tr>

            <tr>
                <td><spring:label path="emailId">Email</spring:label></td>
                <td><spring:input path="emailId" /></td>
                <%--<td><spring:errors path="comments" cssClass="errors" ></spring:errors></td>--%>
            </tr>

            <tr>
                <td><spring:label path="comments">Comment</spring:label></td>
                <td><spring:textarea path="comments" rows="5" cols="25"/></td>
                    <%--<td><spring:errors path="comments" cssClass="errors" ></spring:errors></td>--%>
            </tr>


            <tr>
                <td><input type="submit" value="Save"/></td>
            </tr>

            <tr>
                <td><a href="/login">AdminLogin</a></td>
            </tr>
        </table>
        <p style="color: green"> ${commentSaved}</p>

    </spring:form>
</div>

</body>
</html>
