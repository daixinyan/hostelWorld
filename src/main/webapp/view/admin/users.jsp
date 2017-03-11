<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/20
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>manager users</title>
    <link type="text/css" rel="stylesheet" href="../../css/table.css">
    <jsp:include page="../common/header.jsp"/>
    <script>
        $(document).ready(function () {

            var visiblePages = 10;

            <c:choose>
                <c:when test="${not empty paginationResult.totalPages} ">
                        var totalPage = ${paginationResult.totalPages};
                </c:when>
                <c:otherwise>
                    var totalPage = 1;
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${not empty restrict.page} ">
                    var currentPage = ${restrict.page};
                </c:when>
                <c:otherwise>
                    var currentPage = 1;
                </c:otherwise>
            </c:choose>


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
    <br/>
    <br/>
    <div class="col-md-1"></div>
    <div class="col-md-8">
        <table class="bordered ">
            <thead>
            <tr>
                <th>会员编号</th>
                <th>会员状态</th>
                <th>余额</th>
                <th>银行账号</th>
                <th>积分</th>
                <th>级别</th>
                <th>联系人</th>
                <th>联系方式</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="list">
            <c:forEach items="${paginationResult.items}" var="user">
                <form action="../../admin/update/user">
                    <tr class="table-input">
                        <input type="hidden" name="memberId" value="${user.memberId}">

                        <td title="${user.name}">
                            <a href="../../admin/hostel/reserved?reservationOwner=${user.memberId}">
                                <span><img src="${user.avatar}" style="width: 3em;height: 3em"></span>
                                <span>${user.memberId}</span>
                            </a>

                        </td>
                        <td><span><input name="state" value="${user.state}"></span></td>
                        <td><span><input name="balance" value="${user.balance}"></span></td>
                        <td><span><input name="bankCard" value="${user.bankCard}"></span></td>
                        <td><span><input name="bonusPoint" value="${user.bonusPoint}"></span></td>
                        <td><span><input name="level" value="${user.level}"></span></td>
                        <td><span><input name="contact" value="${user.contact}"></span></td>
                        <td><span><input name="phone" value="${user.phone}"></span></td>
                        <td><button type="submit">更新</button></td>
                    </tr>
                </form>
            </c:forEach>

            </tbody>
        </table>
        <div class="myPager">
            <ul id="myPagination" class="pagination" ></ul>
        </div>
    </div>

    <div class="col-md-3">
        <br/>
        <form action="/admin/list/user" method="post">
            <fieldset>
                <legend>user搜索</legend>


                <input type="hidden" class="page" id="pageNum" name="page"  value="${searchRestrict.page}"/>

                <label>搜索关键字</label>
                <input type="text" class="keyword" name="keyword" value="${searchRestrict.keyword}"/>
                <span class="help-block"></span>

                <label>从旧到新</label>
                <input type="checkbox" class="order" name="asc"  value="${searchRestrict.asc}"/>
                <span class="help-block"></span>

                <label>开始日期</label>
                <input type="date" class="dateLower" name="dateLower" value="${searchRestrict.dateLowerString}">
                <span class="help-block"></span>

                <label>截至日期</label>
                <input type="date" class="dateUpper" name="dateUpper" value="${searchRestrict.dateUpperString}">
                <span class="help-block"></span>

                <label>地址</label>
                <input type="text" class="address" name="address" value="${searchRestrict.address}"/>
                <span class="help-block"></span>

                <button id="searchButton" type="submit" class="btn">提交</button>

            </fieldset>

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
