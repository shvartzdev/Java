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
    <title>UserStore</title>
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
    <c:if test="${user != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit Book
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if>
                <tr>
                    <th>Title: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${user.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Author: </th>
                    <td>
                        <input type="text" name="author" size="45"
                               value="<c:out value='${user.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
