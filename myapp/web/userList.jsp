<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
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


        <sql:query var="users" dataSource="jdbc/lab2">
            select id, name, email from users
        </sql:query>

        <c:forEach  items="${users.rows}" var="row">

            <tr>
                <td><c:out value="${row.id}"></c:out></td>
                <td><c:out value="${row.name}"></c:out></td>
                <td><c:out value="${row.email}"></c:out></td>
                <td>
                    <a href="update/${row.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete/${row.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
