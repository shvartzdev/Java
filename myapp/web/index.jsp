<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvartz
  Date: 2018-11-23
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>
  <a href="/hello">Please <s>kill</s> click me!!!</a>
  </h1>

  <sql:query var="users" dataSource="jdbc/lab2">
  select id, name, email from users
  </sql:query>

  <h2>Results</h2>

  <c:forEach var="row" items="${users.rows}">
    id ${row.id}<br/>
    name ${row.name}<br/>
    email ${row.email}<br/>
  </c:forEach>

  </body>
</html>
