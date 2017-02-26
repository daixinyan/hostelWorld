<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/17
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>hostels</title>

    <jsp:include page="../common/header.jsp"/>
    <script>
        $(document).ready(function () {
            var currentPage = 1;
            var visiblePages = 10;
            var totalPage = 1;
            totalPage = ${hostels.totalPages};
            currentPage = ${searchRestrict.page};

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
            <form action="/public/list/hostel" method="post">
                <input type="text" class="keyInput" name="keyword" value="${searchRestrict.keyword}"/>
                <input type="text" class="order" name="order"  value="${searchRestrict.order}"/>
                <input type="text" class="add1" name="add1" value="${searchRestrict.add1}"/>
                <input type="text" class="add2" name="add2" value="${searchRestrict.add2}"/>
                <input type="text" class="add3" name="add3" value="${searchRestrict.add3}"/>
                <input type="text" class="add4" name="add4" value="${searchRestrict.add4}"/>
                <input type="text" class="address" name="address" value="${searchRestrict.address}"/>
                <input type="radio" class="computer" name="computer" value="${searchRestrict.computer}"/>
                <input type="radio" class="airCondition" name="airCondition" value="${searchRestrict.airCondition}"/>
                <input type="number" class="numOfBed" name="numOfBed" value="${searchRestrict.numOfBed}"/>
                <input type="number" class="capacity" name="capacity" value="${searchRestrict.capacity}"/>
                <input type="number" class="page" id="pageNum" name="page"  value="${searchRestrict.page}"/>
                <input id="searchButton" type="submit"/>
                <div class="priceLimit">
                    <input type="number" class="priceLower" name="priceLower" value="${searchRestrict.priceLower}"/>
                    <input type="number" class="priceUpper" name="priceUpper" value="${searchRestrict.priceUpper}"/>
                </div>

                <div class="date">
                    <input type="date" class="dateLower" name="dateLower" value="${searchRestrict.dateLower}">
                    <input type="date" class="dateUpper" name="dateUpper" value="${searchRestrict.dateUpper}">
                </div>
            </form>
        </div>


        <div class="listItems">
            <c:forEach items="${hostels.items}" var="room">
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
