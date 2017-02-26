<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/15
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    ${message}
    ${requestScope.message}
    <c:forEach items="${users}" var="user">

        ${user}

        <br/>

    </c:forEach>


</head>
<body>

</body>
</html>
