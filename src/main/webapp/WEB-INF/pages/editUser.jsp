<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h2>Edit user [${userInfo.id}] ${userInfo.name} ${userInfo.surname}</h2>


<form method="post" action="${pageContext.request.contextPath}/controller?command=do_edit_user">
    <input type="hidden" name="command" value="do_edit_user"/>
    <input type="hidden" name="id" value="${userInfo.id}"/>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${userInfo.name}"><br><br>

    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" value="${userInfo.surname}"><br><br>

    <label for="phoneNumber">Phone number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="${userInfo.phoneNumber}"><br><br>

    <input type="submit" value="Submit">
    <a href="${requestScope.prevQuery}">Cancel</a>
</form>

</body>
</html>
