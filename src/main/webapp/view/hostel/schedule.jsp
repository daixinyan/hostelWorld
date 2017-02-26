<%--
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

    <jsp:include page="../common/header.jsp"/>
    <script type="text/javascript">
        function submitSchedule() {
            var options = {
                success: function (data) {
                    alert(data);
                    console.log(data);
                }
            };
            // ajaxForm
            console.log("start submit");
            $("#scheduleSubmitForm").ajaxForm(options);
        }
    </script>
</head>

<body>

<jsp:include page="../common/nav.jsp"/>


<div class="content">


    <div class="mySchedule">
        <c:forEach items="${schedules}" var="scheduleItem">
            <div class="scheduleItem">
                <span class="computer">${scheduleItem.computer}</span>
                <span class="airCondition">${scheduleItem.airCondition}</span>
                <span class="numOfBed">${scheduleItem.numOfBed}</span>
                <span class="capacity">${scheduleItem.capacity}</span>
                <span class="count">${scheduleItem.count}</span>
                <span class="price">${scheduleItem.price}</span>
                <span class="startDate">${scheduleItem.startDate}</span>
                <span class="endDate">${scheduleItem.endDate}</span>
                <span class="description">${scheduleItem.description}</span>
                <span class="image">${scheduleItem.image}</span>
            </div>
        </c:forEach>

    </div>


    <div class="scheduleSubmit">
        <form id="scheduleSubmitForm" action="/hostel/action/schedule" method="post" >
            <input type="radio" class="computer" name="computer"/>
            <input type="radio" class="airCondition" name="airCondition"/>
            <input type="number" class="numOfBed" name="numOfBed"/>
            <input type="number" class="count" name="count"/>
            <input type="number" class="capacity" name="capacity"/>
            <input type="number" class="price" name="price"/>
            <input type="date" class="startDate" name="dateLower"/>
            <input type="date" class="endDate" name="dateUpper"/>
            <input type="text" class="description" name="description"/>
            <%--<input type="image" class="image" name="image"/>--%>
            <input type="submit"/>
        </form>
        <button onclick="submitSchedule()">
            submit
        </button>
    </div>



    <div class="myFooter">
    </div>
</div>



</body>

</html>
