<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/19
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>

<body>

<jsp:include page="nav.jsp"/>

<div class="myContent">
    <div class="listItem">

        <div class="roomId">${room.roomId}</div>
        <div class="add_1">${room.add_1}</div>
        <div class="add_2">${room.add_2}</div>
        <div class="add_3">${room.add_3}</div>
        <div class="add_4">${room.add_4}</div>
        <div class="address">${room.address}</div>
        <div class="airCondition">${room.airCondition}</div>
        <div class="bankcard">${room.bankcard}</div>
        <div class="capacity">${room.capacity}</div>
        <div class="computer">${room.computer}</div>
        <div class="contact">${room.contact}</div>
        <div class="count">${room.count}</div>
        <div class="createTime">${room.createTime}</div>
        <div class="description">${room.description}</div>
        <div class="endDate">${room.endDate}</div>
        <div class="hostel">${room.hostel}</div>
        <div class="hostelId">${room.hostelId}</div>
        <div class="image">${room.image}</div>
        <div class="numOfBed">${room.numOfBed}</div>
        <div class="phone">${room.phone}</div>
        <div class="price">${room.price}</div>
        <div class="startDate">${room.startDate}</div>
        <div class="state">${room.state}</div>

        <a href="/public/hostel/${room.roomId}">${room.roomId}</a>
        <form action="../../user/reserve">
            <input type="number" value="${room.roomId}" name="roomId">
            <input type="number" value="1" name="amount">
            <input type="submit">
        </form>

    </div>
</div>
<div class="myFooter"></div>

</body>

</html>
