<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvartz
  Date: 2018-11-30
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
</head>
<body>

<div align="center">
    <h1>Users Management</h1>
    <h2>
        <a href="/insert">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Users</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>email</th>
        </tr>

        <c:forEach  items="${users}" var="user">

            <tr>
                <td><c:out value="${user.getId()}"></c:out></td>
                <td><c:out value="${user.getName()}"></c:out></td>
                <td><c:out value="${user.getEmail()}"></c:out></td>
                <td>
                    <a href="update/${user.getId()}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete/${user.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
