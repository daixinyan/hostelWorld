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
<div class="container-fluid">
    <div class="row-fluid">

        <div class="col-md-2"></div>
        <div class="col-md-6">


            <div class="listItems">
                <c:forEach items="${paginationResult.items}" var="room">
                    <br/>
                    <div class="" style="display:block;">

                        <div class="col-md-4">
                            <a  class=" "  href="../../public/room/${room.roomId}" title="${room.hostel}" >
                                <img  class="img-responsive" alt="${room.hostel}" src="${room.image}">
                            </a>
                        </div>

                        <div class="col-md-5">
                            <h2 class="">
                                <a class="" title="" href="../../public/hostel/${room.hostelId}">${room.contact}</a>
                            </h2>
                            <a class="" title="" href="../../public/hostel/${room.hostelId}">
                                <div class="">
                                    <span class="phone">${room.phone}</span>
                                </div>
                            </a>
                            <a class="">
                                <div class="">
                                    <span class="">${room.address}</span>
                                </div>
                            </a>
                            <a class="">
                                <div class="">
                                <span class="">
                                    <c:choose>
                                        <c:when test="${room.airCondition==true}">
                                            有空调
                                        </c:when>
                                        <c:otherwise>
                                            无空调
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${room.computer==true}">
                                            有电脑
                                        </c:when>
                                        <c:otherwise>
                                            无电脑
                                        </c:otherwise>
                                    </c:choose>
                                    ${room.numOfBed}人床
                                </span>
                                </div>
                            </a>
                            <a class="">
                                <div class="">
                                    <span class="">${room.description}</span>
                                </div>
                            </a>
                        </div>
                        <diV class="col-md-3">
                            <a class="">
                                <div class="">
                                        <span class="price tab-h2">
                                            <dfn>¥</dfn>
                                            <b>${room.price}</b>
                                        </span>
                                </div>
                            </a>
                        </diV>

                        <br/>
                        <br/>
                        <a class="">
                            <div class="">
                                <span class="">
                                    <c:choose>
                                        <c:when test="${room.canceled}">
                                            已退订
                                        </c:when>
                                        <c:when test="${room.checkIn && !room.canceled}">
                                            已入住
                                        </c:when>
                                        <c:otherwise>
                                            <form action="../../user/cancel/${room.reservationId}">
                                                <input class="borderless underline_link" type="submit" value="退订">
                                            </form>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                        </a>

                        <c:choose>
                            <c:when test="${room.canceled}">
                                <br/>
                            </c:when>
                            <c:when test="${room.payment}">
                                <a class="">
                                    <div class="">
                                        <span class="">
                                            已付款
                                        </span>
                                    </div>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="/user/pay/${room.reservationId}">
                                    <div class="">
                                        <span class="underline_link">
                                            去付款
                                        </span>
                                    </div>
                                </a>
                            </c:otherwise>
                        </c:choose>

                        <br/>

                        <a class="">
                            <div class="">
                                <span class="">${room.reserveTime}</span>
                            </div>
                        </a>

                    </div>
                    <div class="clearfix"></div>
                </c:forEach>
            </div>

            <div class="myPager">
                <ul id="myPagination" class="pagination" ></ul >
            </div>

        </div>
    </div>

    <div class="col-md-3">
        <br/>
        <form action="../../user/list/reservation" method="post">
            <fieldset>
                <legend>房间搜索</legend>


                <input type="hidden" class="page" id="pageNum" name="page"  value="${reservationRestrict.page}"/>

                <label>搜索关键字</label>
                <input type="text" class="keyword" name="keyword" value="${reservationRestrict.keyword}"/>
                <span class="help-block"></span>

                <label>排序方式</label>
                <input type="checkbox" class="order" name="order"  value="${reservationRestrict.order}"/>

                <label>从旧到新</label>
                <input type="checkbox" class="order" name="asc"  value="${reservationRestrict.asc}"/>
                <span class="help-block"></span>

                <label>开始日期</label>
                <input type="date" class="dateLower" name="dateLower" value="${reservationRestrict.dateLowerString}">
                <span class="help-block"></span>

                <label>截至日期</label>
                <input type="date" class="dateUpper" name="dateUpper" value="${reservationRestrict.dateUpperString}">
                <span class="help-block"></span>

                <button id="searchButton" type="submit" class="btn">提交</button>

            </fieldset>

        </form>

    </div>

</div>

</body>
</html>
