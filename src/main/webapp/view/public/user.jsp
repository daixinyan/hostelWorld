<%@ page import="personal.darxan.hostel.tool.DateFormatter" %>
<%@ page import="java.util.Date" %><%--
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
    <title>${user.contact}</title>
    <jsp:include page="../common/header.jsp"/>
    <script type="text/javascript" src="../../js/numberchooser.js"></script>
    <link type="text/css" rel="stylesheet" href="../../css/numberchooser.css">
</head>

<body>
<div class="header">
    <a href="#menu"><span></span></a>
    ${user.name}
</div>
<jsp:include page="../common/nav.jsp"/>

<div class="myContent">
    <br/>
    <br/>
    <div class="col-md-2"></div>
    <div class="col-md-4">
        <img src="../../image/default.jpg" class="img-responsive">
    </div>
    <div class="col-md-4">
        <a href=""><div><strong>${user.name}</strong></div> </a>
        <a href=""><div>${room.hostel}</div> </a>


        <div class="">
            <span>级别</span>
            <span class="price tab-h2">
                    <b>${user.level}</b>
            </span>
        </div>




        <div class="">
            <span>电话</span>
            <span class="price tab-h2">
                    <dfn></dfn>
                    <b>${user.phone}</b>
            </span>
        </div>


    </div>

    <div class="col-md-2"></div>

</div>

</body>

</html>
