<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvartz
  Date: 2018-11-25
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATING</title>
</head>
<body>
<div align="center">
    <h1>Users Management</h1>
    <h2>
        <a href="/new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All User</a>

    </h2>
</div>
<div align="center">
    <form action="/update" method="post">
        <table border="2">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Email</td>
            </tr>
            <tr>
                <td><input type="text" name="id" value="${user.id}"/></td>
                <td><input type="text" name="name" value="${user.name}"/></td>
                <td><input type="text" name="email" value="${user.email}"/></td>
            </tr>
            <br><input type="submit" value="UPDATE"></br>
        </table>
    </form>
</div>
</body>
</html>