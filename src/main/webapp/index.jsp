<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<h1>Список пользователей</h1>
<c:out value="${text}"/>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone number</th>
    </tr>
    <c:forEach var="user" items="${requestScope.usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>