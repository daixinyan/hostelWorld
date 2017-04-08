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
    <title>客栈计划</title>

    <link type="text/css" rel="stylesheet" href="../../css/table.css">


    <jsp:include page="../common/header.jsp"/>
</head>

<body>

<div class="header">
    <a href="#menu"><span></span></a>
    客栈计划
</div>
<jsp:include page="../common/nav.jsp"/>

<div class="myContent">
    <br/>
    <br/>
    <div class="col-md-1"></div>
    <table class="bordered col-md-7">
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
            <form action="/hostel/update/schedule" method="get">
                <tr class="table-input">

                    <input type="hidden" name="roomId" value="${room.roomId}"></span>
                    <td width="5em" title="${hostel.name}">
                        <span><img src="${room.image}" style="width: 3em;height: 3em"></span>
                        <span>${room.description}</span>
                    </td>
                    <td width="10em" ><span><input class="date-input" type="date" name="startDate" value="${room.startDate}"></span></td>
                    <td width="10em" ><span><input class="date-input" type="date" name="endDate" value="${room.endDate}"></span></td>
                    <td width="5em" ><span><input  class="narrow-input" name="numOfBed" value="${room.numOfBed}"></span></td>
                    <td width="5em" ><span><input  class="narrow-input"  name="capacity" value="${room.capacity}"></span></td>

                    <td width="5em">
                        <span>
                            <input  type="checkbox" name="airCondition"
                                     <c:if test="${room.airCondition}"> checked</c:if>
                            >
                        </span>
                    </td>

                    <td width="5em">
                        <span>
                            <input type="checkbox" name="computer"
                            <c:if test="${room.computer}"> checked</c:if>
                            >
                        </span>
                    </td>


                    <td width="5em">
                        <span class="base_price">
                            <input class="narrow-input" name="price" value="${room.price}"></span>
                    </td>
                    <td width="5em">
                        <a href=""><input type="submit"></a>
                    </td>
                </tr>
            </form>
        </c:forEach>

        </tbody>


    </table>
    
    <div class="col-md-3">
        <form id="scheduleSubmitForm" action="../../hostel/action/schedule" method="post" >
            <legend>房间类型增加</legend>

            <img class="img-responsive" src="${hostel.image}">
            <input type="file" class="image-default" name="image-default"/>
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
            <input type="hidden" class="startDate" name="createTime" value="${currentTime}"/>

            <label>计划开始日期</label>
            <input type="date" class="startDate" name="startDate" value="${currentTime}"/>
            <span class="help-block"></span>

            <label>计划截至日期</label>
            <input type="date" class="endDate" name="endDate" value="${currentTime}"/>
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
