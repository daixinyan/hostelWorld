<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/3/1
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="../../css/table.css">
    <jsp:include page="../common/header.jsp"/>
</head>
<body>
    <jsp:include page="../common/nav.jsp"/>

<div class="myContent">
    <br/>
    <br/>
    <div class="col-md-2"></div>
    <table class="bordered col-md-8">
        <div>

        </div>
        <thead>
        <tr>
            <th>简单描述</th>
            <th>床数</th>
            <th>可容人数</th>
            <th>空调</th>
            <th>PC</th>
            <th>房价（含服务费）</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="list">
        <c:forEach items="${rooms}" var="room">
            <tr class="list-item">

                <td title="${hostel.name}">
                    <span><img src="${room.image}" style="width: 3em;height: 3em"></span>
                    <span>${room.description}</span>
                </td>
                <td><span>${room.numOfBed}</span></td>
                <td><span>${room.capacity}</span></td>
                <td><span>${room.airCondition}</span></td>
                <td><span>${room.computer}</span></td>
                <td>
                    <span class="base_price"><dfn>¥</dfn>${room.price}</span>
                </td>
                <td>
                    <a href="/public/room/${room.roomId}">预定</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
