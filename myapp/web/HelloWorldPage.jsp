<%--
  Created by IntelliJ IDEA.
  User: shvartz
  Date: 2018-11-26
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring</title>
</head>
<body>

<h1>${message}</h1>

<h2 id="txt"></h2>

<script type="text/javascript">
    var check = function(txt){
            document.getElementById("txt").innerHTML = document.getElementById("txt").innerHTML + txt;
            setTimeout(function(){check(txt)}, 250);
    };

    check("I hate spring MVC! ");
</script>
</body>
</html>
