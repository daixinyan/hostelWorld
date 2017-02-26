<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/19
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <title>Title</title>

    <jsp:include page="../common/header.jsp"/>
</head>

<body>



<jsp:include page="../common/nav.jsp"/>

<div class="content">

    <div class="hostelInfo">
        <form action="/hostel/update" method="post">
            <input type="text" class="name" name="name" value="${hostel.name}"/>
            <input type="password" class="password" name="password" value="${hostel.password}"/>
            <input type="password" class="re_password" name="re_password" value="${hostel.password}"/>
            <input type="text" class="contact" name="contact" value="${hostel.contact}"/>
            <input type="number" class="phone" name="phone" value="${hostel.phone}"/>
            <input type="number" class="bankcard" name="bankcard" value="${hostel.bankcard}"/>
            <input type="text" class="hostel" name="hostel" value="${hostel.hostel}"/>
            <input type="submit">
        </form>
    </div>

    <div class="myFooter">
    </div>
</div>



</body>

</html>