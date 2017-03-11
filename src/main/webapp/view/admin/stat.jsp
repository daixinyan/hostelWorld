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
    <title>Title</title>
    <script src="../../js/echarts.js"></script>
</head>
<body>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据

    function setChart(reservation) {
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
                data:['预定数','入住数','付款数']
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
        myChart.setOption(option);
    }
    $.ajax(
        {
            url:'/admin/stat/reservation',
            type:'GET', //POST
            async:true,    //或false,是否异步
            data:{
                dateUpper:'yang',
                dateLower:25
            },
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
                setChart(data)
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
