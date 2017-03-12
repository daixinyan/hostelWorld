<%@ page import="personal.darxan.hostel.tool.DateFormatter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/21
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="../../css/table.css">

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
    <jsp:include page="../common/header.jsp"/>
</head>

<body>

<jsp:include page="../common/nav.jsp"/>


<div class="myContent">
    <br/>
    <br/>
    <div class="col-md-1"></div>
    <table class="bordered col-md-8">
        <thead>
        <tr>
            <th>描述</th>
            <th>起效日期</th>
            <th>失效日期</th>
            <th>床数</th>
            <th>容量</th>
            <th>空调</th>
            <th>PC</th>
            <th>房价</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="list">
        <c:forEach items="${rooms}" var="room">
            <form action="/hostel/update/schedule">
                <tr class="table-input">

                    <input type="hidden" name="roomId" value="${room.roomId}"></span>
                    <td title="${hostel.name}">
                        <span><img src="${room.image}" style="width: 3em;height: 3em"></span>
                        <span>${room.description}</span>
                    </td>
                    <td><span><input type="date" name="startDate" value="${room.startDate}"></span></td>
                    <td><span><input type="date" name="endDate" value="${room.endDate}"></span></td>
                    <td><span><input name="numOfBed" value="${room.numOfBed}"></span></td>
                    <td><span><input name="capacity" value="${room.capacity}"></span></td>

                    <td>
                        <span><input type="checkbox" name="airCondition"
                                     <c:if test="${room.airCondition}"> checked</c:if>
                              ></span>
                    </td>

                    <td><span><input type="checkbox" name="computer"
                                    <c:if test="${room.computer}"> checked</c:if>
                        ></span>
                    </td>


                    <td>
                        <span class="base_price"><dfn>¥</dfn>
                            <input name="price" value="${room.price}"></span>
                    </td>
                    <td>
                        <a href=""><input type="submit"></a>
                    </td>
                </tr>
            </form>
        </c:forEach>

        </tbody>

        <div class="myPager">
            <ul id="myPagination" class="pagination" ></ul >
        </div>

    </table>
    
    <div class="col-md-3">
        <form id="scheduleSubmitForm" action="../../hostel/action/schedule" method="post" >
            <legend>房间类型增加</legend>

            <img class="img-responsive" src="${hostel.image}">
            <input type="file" class="image" name="image"/>
            <span class="help-block"></span>

            <label>电脑</label>
            <input type="checkbox" class="computer" name="computer"/>
            <span class="help-block"></span>

            <label>空调</label>
            <input type="checkbox" class="airCondition" name="airCondition"/>
            <span class="help-block"></span>

            <label>床数</label>
            <input type="number" class="numOfBed" name="numOfBed"/>
            <span class="help-block"></span>

            <label>总数</label>
            <input type="number" class="count" name="count"/>
            <span class="help-block"></span>

            <label>容量</label>
            <input type="number" class="capacity" name="capacity"/>
            <span class="help-block"></span>


            <label>单价</label>
            <input type="number" class="price" name="price"/>
            <span class="help-block"></span>


            <c:set var="currentTime" value="<%=DateFormatter.dateFormat.format(new Date()) %>" />
            <label>计划开始日期</label>
            <input type="date" class="startDate" name="dateLower" value="${currentTime}"/>
            <span class="help-block"></span>

            <label>计划截至日期</label>
            <input type="date" class="endDate" name="dateUpper" value="${currentTime}"/>
            <span class="help-block"></span>


            <label>简单描述</label>
            <input type="text" class="description" name="description"/>
            <span class="help-block"></span>

            <input type="submit">
        </form>
    </div>
</div>



<script>
    $(function(){
        $("table").resizableColumns({
            store: window.store
        });
    });
</script>

</body>

</html>
