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
    <title>hostel's custom check-in</title>
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
            <form action="../../hostel/list/checkIn" method="post">
                <input type="text" class="keyword" name="keyword" value="${reservationRestrict.keyword}"/>
                <input type="text" class="order" name="order"  value="${reservationRestrict.order}"/>


                <input type="number" class="page" id="pageNum" name="page"  value="${reservationRestrict.page}"/>
                <input id="searchButton" type="submit"/>

                <div class="date">
                    <input type="date" class="dateLower" name="dateLower" value="${reservationRestrict.dateLower}">
                    <input type="date" class="dateUpper" name="dateUpper" value="${reservationRestrict.dateUpper}">
                </div>
            </form>
        </div>



        <div class="listItems">
            <c:forEach items="${paginationResult.items}" var="reservation">
                <div class="listItem">

                    <div class="hostelId">${reservation.hostelId}</div>
                    <div class="capacity">${reservation.capacity}</div>
                    <div class="numOfBed">${reservation.numOfBed}</div>
                    <div class="airCondition">${reservation.airCondition}</div>
                    <div class="computer">${reservation.computer}</div>
                    <div class="description">${reservation.description}</div>
                    <div class="image">${reservation.image}</div>

                    <div class="price">${reservation.price}</div>
                    <div class="amount">${reservation.amount}</div>

                    <div class="checkIn">${reservation.checkIn}</div>
                    <div class="checkInTime">${reservation.checkInTime}</div>
                    <div class="people">${reservation.people}</div>

                    <div class="payment">${reservation.payment}</div>
                    <div class="paymentTime">${reservation.paymentTime}</div>
                    <div class="checkOut">${reservation.checkOut}</div>
                    <div class="checkOutTime">${reservation.checkOutTime}</div>


                    <div class="reserveTime">${reservation.reserveTime}</div>
                    <div class="reservationId">${reservation.reservationId}</div>


                </div>
            </c:forEach>
        </div>

        <div class="myPager">
            <ul id="myPagination" class="pagination" ></ul >
        </div>

    </div>
</div>

</body>
</html>
