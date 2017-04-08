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
    <title>manager hostel</title>
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

<div class="header">
    <a href="#menu"><span></span></a>
    manager hostel
</div>
<jsp:include page="../common/nav.jsp"/>

<div class="myContent">
    <br/>
    <br/>
    <div class="col-md-1"></div>
    <div class="col-md-8">
        <table class="bordered ">
            <thead>
            <tr>
                <th>酒店编号</th>
                <th>酒店名</th>
                <th>状态</th>
                <th>地址</th>
                <th>详细地址</th>
                <th>银行卡</th>
                <th>联系人</th>
                <th>联系方式</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="list">
            <c:forEach items="${paginationResult.items}" var="hostel">
                <form action="../../admin/update/hostel" id="${hostel.hostelId}">
                    <input type="hidden" name="hostelId" value="${hostel.hostelId}">
                    <tr class="narrow-table">

                        <td title="${hostel.hostel}">
                            <a href="../../admin/hostel/reserved?reservationOwner=${hostel.hostelId}">
                                <span><img src="${hostel.image}" style="width: 3em;height: 3em"></span>
                                <span>${hostel.hostelId}</span>
                            </a>

                        </td>
                        <td><span><input name="hostel" value="${hostel.hostel}"></span></td>
                        <td>
                        <span>
                            <%--<input type="number" name="state" value="${hostel.state}">--%>
                             <select name="state" form="${hostel.hostelId}">
                                 <option  value="0"
                                         <c:if test="${hostel.state==0}">selected="selected"</c:if>
                                 >待审核</option>
                                 <option  value="1"
                                          <c:if test="${hostel.state==1}">selected="selected"</c:if>
                                 >通过</option>
                                 <option  value="-1"
                                          <c:if test="${hostel.state==-1}">selected="selected"</c:if>
                                 >不通过</option>
                            </select>
                        </span>
                        </td>
                        <td>
                        <span>
                            <input name="add_1" value="${hostel.add_1}">
                            <input name="add_2" value="${hostel.add_2}">
                            <input name="add_3" value="${hostel.add_3}">
                            <input name="add_4" value="${hostel.add_4}">
                        </span>
                        </td>

                        <td><span><input name="address" value="${hostel.address}"></span></td>
                        <td><span><input name="bankcard" value="${hostel.bankcard}"></span></td>
                        <td><span><input name="contact" value="${hostel.contact}"></span></td>
                        <td><span><input name="phone" value="${hostel.phone}"></span></td>

                        <td>
                            <a href=""><input type="submit"></a>
                        </td>
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
        <form action="/admin/list/hostel" method="post">
            <fieldset>
                <legend>hostel搜索</legend>


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
