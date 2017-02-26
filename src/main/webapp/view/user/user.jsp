<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/19
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <title>user info</title>

    <jsp:include page="../common/header.jsp"/>
</head>

<body>

<jsp:include page="../common/nav.jsp"/>

<div class="myContent">

    <div class="personalInfo">
        <form action="/user/update" method="post">

            <input type="text" class="name" name="name" value="${user.name}">

            <input type="password" class="password" name="password" value="${user.password}">
            <input type="password" class="re_password" name="re_password" value="${user.password}">

            <input type="text" class="contact" name="contact" value="${user.contact}">
            <input type="number" class="phone" name="phone" value="${user.phone}">
            <input type="number" class="bankcard" name="bankcard" value="${user.bankCard}">

            <img src="${user.avatar}">
            <input type="file" class="avatar" name="avatar" value="${user.avatar}">

            <input type="submit">
        </form>
    </div>

</div>
<div class="myFooter"></div>

</body>

</html>