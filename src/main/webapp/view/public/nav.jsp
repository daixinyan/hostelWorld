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
<%--${sessionScope.sessionid}；--%>
<c:if test="${sessionScope.LOGIN==null||sessionScope.LOGIN==''}">
    <nav id="menu">
        <ul>
            <li><a href="../../public/list/hostel">hostels Search</a></li>
            <li><a href="../../public/register/hostel">注册</a> </li>
            <li><a href="../../public/register/user">注册</a> </li>
            <li><a href="../../public/login/default">登陆</a> </li>
            <li><a href="../../public/login/hostel">hostel登陆</a> </li>
            <li><a href="../../public/login/user">会员登陆</a> </li>
            <li><a href="../../public/login/admin">管理员登陆</a> </li>

        </ul>
    </nav>
</c:if>

<c:if test="${sessionScope.LOGIN=='personal.darxan.hostel.vo.MemberVO'}">
    <nav id="menu">

    </nav>
</c:if>

<c:if test="${sessionScope.LOGIN=='personal.darxan.hostel.vo.HostelVO'}}">
    <nav id="menu">
        <li><a href="/public/list/hostel">hostels Search</a></li>
        <li><a href="/hostel/hostel/info">客栈信息</a> </li>
        <li><a href="/hostel/list/schedule">客栈计划</a> </li>
        <li><a href="/hostel/list/checkIn">入住信息</a> </li>
        <li><a href="/hostel/list/reservation">预定信息</a> </li>
        <li><a href="/hostel/list/userPay">用户付款</a> </li>
        <li><a href="/hostel/list/payment">平台结账</a> </li>
    </nav>
</c:if>