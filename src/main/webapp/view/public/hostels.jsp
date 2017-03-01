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
<div class="container-fluid">
<div class="row-fluid">

    <div class="col-md-2"></div>
    <div class="col-md-6">


        <div class="listItems">
            <c:forEach items="${hostels.items}" var="room">
                <br/>
                <div class="" style="display:block;">

                    <div class="col-md-4">
                        <a  class=" "  href="../../public/room/${room.roomId}" title="${room.hostel}" >
                            <img  class="img-responsive" alt="${room.hostel}" src="${room.image}">
                        </a>
                    </div>

                    <div class="col-md-5">
                        <h2 class="">
                            <a class="" title="" href="../../public/hostel/${room.roomId}">${room.contact}</a>
                        </h2>
                        <a class="" title="" href="../../public/hostel/${room.roomId}">
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
                    <diV class="col-md-2">
                        <a class="">
                            <div class="">
                                        <span class="price tab-h2">
                                            <dfn>¥</dfn>
                                            <b>${room.price}</b>
                                        </span>
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

    <div class="col-md-3">
        <br/>
        <form action="../../public/list/hostel" method="post">
            <fieldset>
                <legend>房间搜索</legend>


                <input type="hidden" class="page" id="pageNum" name="page"  value="${searchRestrict.page}"/>

                <label>搜索关键字</label>
                <input type="text" class="keyword" name="keyword" value="${searchRestrict.keyword}"/>
                <span class="help-block"></span>

                <label>排序方式</label>
                <input type="radio" class="order" name="order"  value="${searchRestrict.order}"/>

                <label>从旧到新</label>
                <input type="radio" class="order" name="asc"  value="${searchRestrict.asc}"/>
                <span class="help-block"></span>

                <label>开始日期</label>
                <input type="date" class="dateLower" name="dateLower" value="${searchRestrict.dateLowerString}">
                <span class="help-block"></span>

                <label>截至日期</label>
                <input type="date" class="dateUpper" name="dateUpper" value="${searchRestrict.dateUpperString}">
                <span class="help-block"></span>

                <label>最低价格</label>
                <input type="text" class="priceLower" name="priceLower" value="${searchRestrict.priceLower}">
                <span class="help-block"></span>

                <label>最高价格</label>
                <input type="text" class="priceUpper" name="priceUpper" value="${searchRestrict.priceUpper}">
                <span class="help-block"></span>

                <label>床数</label>
                <input type="number" class="numOfBed" name="numOfBed" value="${searchRestrict.numOfBed}">
                <span class="help-block"></span>

                <label>地址</label>
                <input type="text" class="address" name="address" value="${searchRestrict.address}"/>
                <span class="help-block"></span>

                <label>空调</label>
                <input type="radio" class="airCondition" name="airCondition"  value="${searchRestrict.airCondition}"/>

                <label>电脑</label>
                <input type="radio" class="computer" name="computer"  value="${searchRestrict.computer}"/>

                <button id="searchButton" type="submit" class="btn">提交</button>

            </fieldset>

        </form>

</div>

</div>
</body>

</html>
