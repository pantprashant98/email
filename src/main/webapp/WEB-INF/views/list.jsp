<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style type="text/css">
        a:link, a:visited {
            background-color: silver;
            color: green;
            padding: 9px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
    </style>

    <title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">


            <li class="active"><a href="${pageContext.request.contextPath}/logout">LogOut<span class="sr-only">(current)</span></a></li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<h1>Comment</h1>


<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("activeUser")==null){
        response.sendRedirect("login.jsp");
    }

%>

<table class="table table-hover">

    <thead>
    <tr>

        <%--<h1> <p style="color:red; size: 70px;">Welcome:${adminName}</p></h1>--%>
        <th scope="col">Username</th>
        <th scope="col">Date</th>
        <th scope="col">Comment</th>



    </tr>
    </thead>
    <c:forEach var="comment" items="${commentList}">
        <tbody>
        <tr class="table-success">
            <th scope="row"><c:out value="${comment.name}"/></th>
            <td><c:out value="${comment.date}"/></td>
            <td><c:out value="${comment.comments}"/></td>
            <%--<td><a href="edit?getId=${user.id}">Edit</a></td>--%>
            <%--<td><a href="delete?getId=${user.id}">Delete</a></td>--%>

        </tr>

        </tbody>
    </c:forEach>
</table>
</body>

</table>
</html>
