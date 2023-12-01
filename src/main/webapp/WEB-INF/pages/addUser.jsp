<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>New user</title>
</head>
<body>
<h2>Adding new user</h2>
<form action="${pageContext.request.contextPath}/controller?command=do_add_user" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" required><br><br>

    <label for="phoneNumber">Phone number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>

    <input type="submit" value="Submit">
    <a href="${requestScope.prevQuery}">Cancel</a>
</form>
</body>
</html>
