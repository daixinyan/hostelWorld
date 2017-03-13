<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/25
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header">
    <a href="#menu"><span></span></a>
    Demo
</div>

<c:choose>
    <c:when test="${empty sessionScope.LOGIN_TYPE}">

        <nav id="menu">
            <ul>
                <li><a href="/public/list/hostel">hostels Search</a></li>
                <li><a href="/public/register/hostel">hostel注册</a> </li>
                <li><a href="/public/register/user">用户注册</a> </li>

                <li><a href="/public/login/hostel">hostel登陆</a> </li>
                <li><a href="/public/login/user">会员登陆</a> </li>
                <li><a href="/public/login/admin">管理员登陆</a> </li>

            </ul>
        </nav>
    </c:when>

    <c:otherwise>
        <c:if test="${sessionScope.LOGIN_TYPE=='personal.darxan.hostel.vo.MemberVO'}">
            <nav id="menu">
                <ul>
                    <li><a href="/public/list/hostel">hostels Search</a></li>

                    <li><a href="/user/user/info">用户信息</a> </li>
                    <li><a href="/user/list/checkIn">入住信息</a> </li>
                    <li><a href="/user/list/reservation">预定信息</a> </li>
                    <li><a href="/user/list/payment">用户付款</a> </li>
                </ul>
            </nav>
        </c:if>

        <c:if test="${ sessionScope.LOGIN_TYPE=='personal.darxan.hostel.vo.HostelVO'}">
            <nav id="menu">
                <ul>
                    <li><a href="/public/list/hostel">hostels Search</a></li>
                    <li><a href="/hostel/hostel/info">客栈信息</a> </li>
                    <li><a href="/hostel/list/schedule">客栈计划</a> </li>
                    <li><a href="/hostel/list/checkIn">入住信息</a> </li>
                    <li><a href="/hostel/list/reservation">预定信息</a> </li>
                    <li><a href="/hostel/list/payment">账单信息</a> </li>
                </ul>
            </nav>
        </c:if>

        <c:if test="${ sessionScope.LOGIN_TYPE=='personal.darxan.hostel.vo.AdministerVO'}">
            <nav id="menu">
                <ul>
                    <li><a href="/public/list/hostel">hostels Search</a></li>
                    <li><a href="/admin/list/reservation">订单信息</a> </li>
                    <li><a href="/admin/list/hostels">客栈信息</a> </li>
                    <li><a href="/admin/list/users">会员信息</a> </li>
                    <li><a href="/admin/list/payment">支付信息</a> </li>
                    <li><a href="/admin/stat/page">统计信息</a> </li>
                </ul>
            </nav>
        </c:if>
    </c:otherwise>


</c:choose>
