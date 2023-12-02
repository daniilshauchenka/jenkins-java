<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Users list</title>

    <style>
        .bordered-table {
            border-collapse: collapse;
        }
        .bordered-table td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Users list</h1>
<a href="${pageContext.request.contextPath}/controller?command=go_to_add_user">Add user</a>
<table class="bordered-table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone number</th>
        <th></th>
    </tr>
    <c:forEach var="user" items="${requestScope.usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.phoneNumber}</td>
            <td><a href="${pageContext.request.contextPath}/controller?command=go_to_edit_user&id=${user.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
