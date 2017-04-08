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
    <title>${room.description}</title>
    <jsp:include page="../common/header.jsp"/>
    <script type="text/javascript" src="../../js/numberchooser.js"></script>
    <link type="text/css" rel="stylesheet" href="../../css/numberchooser.css">
</head>

<body>
<div class="header">
    <a href="#menu"><span></span></a>
    ${room.hostel}
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
        <a href=""><div><strong>${room.description}</strong></div> </a>
        <a href=""><div>${room.hostel}</div> </a>
        <div class="">
            <span>价&nbsp;&nbsp;&nbsp;&nbsp;格&nbsp;&nbsp;</span>
            <span class="price tab-h2">
                    <dfn>¥</dfn>
                    <b>6.5</b>
            </span>
        </div>

        <div class="">
            <span>床&nbsp;&nbsp;&nbsp;&nbsp;数&nbsp;&nbsp;</span>
            <span class="price tab-h2">
                    <dfn>¥</dfn>
                    <b>${room.price}</b>
            </span>
        </div>

        <div class="">
            <span>最大容量</span>
            <span class="price tab-h2">
                    <dfn>成人</dfn>
                    <b>${room.capacity}</b>
            </span>
        </div>

        <div class="">
            <span>地&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;</span>
            <span class="price tab-h2">
                    <dfn></dfn>
                    <b>
                    ${room.add_1}
                    ${room.add_2}
                    ${room.add_3}
                    ${room.add_4}
                    </b>
            </span>
        </div>

        <div class="">
            <span>空&nbsp;&nbsp;&nbsp;&nbsp;调&nbsp;&nbsp;</span>
            <span class="price tab-h2">
                    <dfn></dfn>
                    <b>
                        <c:choose>
                            <c:when test="${room.airCondition}">
                                有
                            </c:when>
                            <c:otherwise>
                                无
                            </c:otherwise>
                        </c:choose>
                    </b>
            </span>
        </div>

        <div class="">
            <span>电&nbsp;&nbsp;&nbsp;&nbsp;脑&nbsp;&nbsp;</span>
            <span class="price tab-h2">
                    <dfn></dfn>
                    <b>
                        <c:choose>
                            <c:when test="${room.computer}">
                                有
                            </c:when>
                            <c:otherwise>
                                无
                            </c:otherwise>
                        </c:choose>
                    </b>
            </span>
        </div>

        <div class="">
            <span>详细地址</span>
            <span class="price tab-h2">
                    <dfn></dfn>
                    <b>${room.address}</b>
            </span>
        </div>

        <br/>

        <div class="">
            <span>数&nbsp;&nbsp;&nbsp;&nbsp;量&nbsp;&nbsp;</span>
            <span>
                <form action="../../user/reserve/default" method="get">
                    <input class="sdddq bgColor" id="numberChooser" name="amount" value="1"> </input>
                    <label>在线付款&nbsp;</label>
                    <input type="checkbox">
                    <span class="help-block"></span>

                    <input type="hidden" name="roomId" value="${room.roomId}"> </input>
                    <span class="help-block"></span>


                    <c:set var="currentTime" value="<%=DateFormatter.dateFormat.format(new Date()) %>" />
                    <label>入住日期</label>
                    <input type="date" name="checkInDate" value="${currentTime}">
                    <span class="help-block"></span>

                    <br/>
                    <c:choose>
                        <c:when test="${ sessionScope.LOGIN_TYPE=='personal.darxan.hostel.vo.MemberVO'}">
                            <input type="submit">
                        </c:when>
                        <c:otherwise>
                            请先
                            <a target="_blank" href="/public/login/default">
                                <span class="underline_link">登录</span>
                            </a>
                            或者
                            <a href="">
                                <span class="underline_link">刷新</span>
                            </a>
                            当前页面
                        </c:otherwise>
                    </c:choose>
                </form>
            </span>
        </div>

    </div>

    <div class="col-md-2"></div>

</div>

</body>

</html>
