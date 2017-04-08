<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/3/11
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>statistic</title>
    <script src="../../js/echarts.js"></script>
    <jsp:include page="../common/header.jsp"/>
</head>
<body>


<div class="header">
    <a href="#menu"><span></span></a>
    statistic
</div>
<jsp:include page="../common/nav.jsp"/>
<div class="col-md-2"></div>
<div class="col-md-8">
    <label>订单统计</label>
    <label>开始</label>
    <input type="date" value="${usersRestrict.dateLowerString}">
    <label>结束</label>
    <input type="date" value="${usersRestrict.dateUpperString}">
    <span class="help-block"></span>
    <div id="reservationChart" style="width: 750px;height:450px;"></div>

    <label>用户注册统计</label>
    <label>开始</label>
    <input type="date" value="${usersRestrict.dateLowerString}">
    <label>结束</label>
    <input type="date" value="${usersRestrict.dateUpperString}">
    <span class="help-block"></span>
    <div id="registerUserChart" style="width: 750px;height:450px;"></div>

    <label>酒店注册统计</label>
    <label>开始</label>
    <input type="date" value="${usersRestrict.dateLowerString}">
    <label>结束</label>
    <input type="date" value="${usersRestrict.dateUpperString}">
    <span class="help-block"></span>
    <div id="registerHostelChart" style="width: 750px;height:450px;"></div>
</div>
<div class="col-md-2"></div>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var reservationChart = echarts.init(document.getElementById('reservationChart'));
    var registerUserChart = echarts.init(document.getElementById('registerUserChart'));
    var registerHostelChart = echarts.init(document.getElementById('registerHostelChart'));


    // 指定图表的配置项和数据

    function setRegisterUserChart(userRegister) {
        var option =option = {
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data:['注册数目']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : userRegister.timeArray,
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'注册数目',
                    type:'bar',
                    barWidth: '60%',
                    data: userRegister.values
                }
            ]
        };
        registerUserChart.setOption(option);
    }
    function setReservation(reservation) {
        var option = {
            tooltip: {
                trigger: 'axis'
            },
            toolbox: {
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data:['预订数','入住数','付款数']
            },
            xAxis: [
                {
                    type: 'category',
                    data: reservation.timeArray
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '数量',
                    min: reservation.minValue,
                    max: reservation.maxValue,
                    interval: reservation.interval,
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name:'预订数',
                    type:'line',
                    data:reservation.reservations
                },
                {
                    name:'入住数',
                    type:'bar',
                    data:reservation.checkIns
                },
                {
                    name:'付款数',
                    type:'bar',
                    data:reservation.payment
                }
            ]
        };
        reservationChart.setOption(option);
    }
    function setRegisterHostelChart(hostelsRegister) {
        var option =option = {
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data:['注册数目']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : hostelsRegister.timeArray,
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'注册数目',
                    type:'bar',
                    barWidth: '60%',
                    data: hostelsRegister.values
                }
            ]
        };
        registerHostelChart.setOption(option);
    }
    $.ajax(
        {
            url:'/admin/stat/user',
            type:'GET', //POST
            async:true,    //或false,是否异步
//            data:{
//                dateUpper:'yang',
//                dateLower:25
//            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            success:function(data,textStatus,jqXHR){
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
                setRegisterUserChart(data)
            },
        }
    );

    $.ajax(
        {
            url:'/admin/stat/hostel',
            type:'GET', //POST
            async:true,    //或false,是否异步
//            data:{
//                dateUpper:'yang',
//                dateLower:25
//            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            success:function(data,textStatus,jqXHR){
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
                setRegisterHostelChart(data)
            },
        }
    );

    $.ajax(
        {
            url:'/admin/stat/reservation',
            type:'GET', //POST
            async:true,    //或false,是否异步
//            data:{
//                dateUpper:'yang',
//                dateLower:25
//            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
                setReservation(data)
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
            complete:function(){
                console.log('结束')
            }
        }
    );

</script>

</body>
</html>
