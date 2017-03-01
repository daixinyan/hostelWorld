<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/21
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>hostel's reservations</title>
    <jsp:include page="../common/header.jsp"/>
    <script>
        $(document).ready(function () {
            var currentPage = 1;
            var visiblePages = 10;
            var totalPage = 1;
            totalPage = ${paginationResult.totalPages};
            currentPage = ${reservationRestrict.page};

            $('#myPagination').jqPaginator({
                totalPages: totalPage,
                visiblePages: visiblePages,
                currentPage: currentPage,
                onPageChange: function (num, type) {
                    if (num!=currentPage) {
                        $("#pageNum").attr("value", num);
                        $("#searchButton").click();
                    }
                }
            });
        });
    </script>
</head>
<body>

<jsp:include page="../common/nav.jsp"/>

<div class="myContent">

    <div class="hostelsList">

        <div class="listHeader">
            <form action="../../hostel/list/payment" method="post">
                <input type="text" class="keyword" name="keyword" value="${reservationRestrict.keyword}"/>
                <input type="text" class="order" name="order"  value="${reservationRestrict.order}"/>


                <input type="number" class="page" id="pageNum" name="page"  value="${reservationRestrict.page}"/>
                <input id="searchButton" type="submit"/>

                <div class="date">
                    <input type="date" class="dateLower" name="dateLower" value="${reservationRestrict.dateLowerString}">
                    <input type="date" class="dateUpper" name="dateUpper" value="${reservationRestrict.dateUpperString}">
                </div>
            </form>
        </div>


        <div class="listItems">
            <c:forEach items="${paginationResult.items}" var="reservation2">
                <div class="listItem">

                    <div class="memberId">${reservation.memberId}</div>
                    <div class="name">${reservation.name}</div>
                    <div class="contact">${reservation.contact}</div>
                    <div class="phone">${reservation.phone}</div>
                    <div class="avatar">${reservation.avatar}</div>

                    <div class="price">${reservation.price}</div>
                    <div class="amount">${reservation.amount}</div>

                    <div class="people">${reservation.people}</div>
                    <div class="checkIn">${reservation.checkIn}</div>
                    <div class="checkInTime">${reservation.checkInTime}</div>
                    <div class="payment">${reservation.payment}</div>
                    <div class="paymentTime">${reservation.paymentTime}</div>
                    <div class="checkOut">${reservation.checkOut}</div>
                    <div class="checkOutTime">${reservation.checkOutTime}</div>

                    <div class="reserveTime">${reservation.reserveTime}</div>
                    <div class="reservationId">${reservation.reservationId}</div>

                </div>

                <div class="" style="display:block;">
                    <div class="col-xs-12 col-sm-12 col-md-4 ">
                        <a  class=" "  href="../../public/user/${reservation.memberId}" title="${reservation.name}" >
                            <img alt="${reservation.contact}" src="${reservation.avatar}" style="height:170px;width:150px;border-width:0px;">
                        </a>
                    </div>
                    <diV class="col-xs-12 col-sm-12 col-md-8">
                        <h3 class="">
                            <a class="" title="" href="../../public/user/${reservation.memberId}">${reservation.contact}</a>
                        </h3>
                        <a class="" title="" href="../../public/user/${reservation.memberId}">
                            <div class="">
                                <span class="phone">${reservation.phone}</span>
                            </div>
                        </a>

                        <c:if test="${reservation.checkOut!=true}">
                            <a class="">
                                <div class="">
                                    <span onclick="alert('${reservation.memberId}')" class="checkout">点击checkout</span>
                                </div>
                            </a>
                        </c:if>

                        <a class="">
                            <div class="">
                                        <span class="price">
                                            <dfn>¥</dfn>
                                            <b>${reservation.price}*${reservation.amount}</b>
                                        </span>
                            </div>
                        </a>
                        <a class="">
                            <div class="">
                                <span class="time">${reservation.reserveTime}</span>
                            </div>
                        </a>
                    </diV>

                </div>
                <div class="clearfix"></div>
            </c:forEach>
        </div>

        <div class="myPager">
            <ul id="myPagination" class="pagination" ></ul >
        </div>

    </div>
</div>

</body>
</html>
