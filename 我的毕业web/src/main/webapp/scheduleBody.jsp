<%--
  Created by IntelliJ IDEA.
  User: 木白
  Date: 2018/11/19
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>部门日程管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libcss2/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libcss2/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600">
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/libcss2/css/font-awesome.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libcss2/css/style.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libcss2/css/pages/dashboard.css" >
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <!--<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>-->
    <%--<![endif]-->--%>
    <style>
        .div-a{float: left;width: 49%;}
        .div-b{float: left;width: 49%;}
    </style>
</head>
<body>
<br>
<div class="main">
    <div class="main-inner">
        <div class="container">
            <div class="row">
                <!--左边-->
                <div class="div-a">
                <div class="span6">
                    <div class="widget widget-nopad">
                        <div class="widget-header"> <i class="icon-list-alt"></i>
                            <h3> 今日统计</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div class="widget big-stats-container">
                                <div class="widget-content">
                                    <h6 class="bigstats">今日统计数据为当天公司应到人数/签到人数/请假人数/出勤率等信息</h6>
                                    <div id="big_stats" class="cf">
                                        <div class="stat"> <i class="icon-anchor"></i> <span class="value">30</span> </div>
                                        <!-- .stat -->

                                        <div class="stat"> <i class="icon-thumbs-up-alt"></i> <span class="value">28</span> </div>
                                        <!-- .stat -->

                                        <div class="stat"> <i class="icon-twitter-sign"></i> <span class="value">2</span> </div>
                                        <!-- .stat -->

                                        <div class="stat"> <i class="icon-bullhorn"></i> <span class="value">93%</span> </div>
                                        <!-- .stat -->
                                    </div>
                                </div>
                                <!-- /widget-content -->

                            </div>
                        </div>
                    </div>
                    <!-- /widget -->
                    <div class="widget widget-nopad">
                        <div class="widget-header"> <i class="icon-list-alt"></i>
                            <h3>任务标签</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div id='calendar'>
                            </div>
                        </div>
                        <!-- /widget-content -->
                    </div>
                    <!-- /widget -->
                </div>
                </div>
                <!-- /span6 -->
                <div class="div-b">
                <%--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>--%>
                <!--右边-->
                <div class="span6">
                    <!-- /widget -->
                    <!--跟左边的calander相对应-->
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-signal"></i>
                            <h3> 最近七天数据面积图</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <canvas id="area-chart" class="chart-holder" height="250" width="538"> </canvas>
                            <!-- /area-chart -->
                        </div>
                        <!-- /widget-content -->
                    </div>
                    <!-- /widget -->
                    <!--重要信息列表-->
                    <div class="widget widget-nopad">
                        <div class="widget-header"> <i class="icon-list-alt"></i>
                            <h3> 信息列表</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <!--只显示最近的五条数据-->
                            <ul class="news-items">
                                <li>

                                    <div class="news-item-date"> <span class="news-item-day">11</span> <span class="news-item-month">11月</span> </div>
                                    <div class="news-item-detail"> <a href="http://www.by EGrappler/thursday-roundup-40/" class="news-item-title" target="_blank">双十一剁手节</a>
                                        <p class="news-item-preview">麻烦让让，您踩到我的晚餐了</p>
                                    </div>

                                </li>
                                <li>

                                    <div class="news-item-date"> <span class="news-item-day">13</span> <span class="news-item-month">11月</span> </div>
                                    <div class="news-item-detail"> <a href="http://www.by EGrappler/retina-ready-responsive-app-landing-page-website-template-app-landing/" class="news-item-title" target="_blank">物流塞车节</a>
                                        <p class="news-item-preview"> 您的宝贝已发货，目前仍停留在发货地</p>
                                    </div>

                                </li>
                                <li>

                                    <div class="news-item-date"> <span class="news-item-day">14</span> <span class="news-item-month">11月</span> </div>
                                    <div class="news-item-detail"> <a href="http://www.by EGrappler/open-source-jquery-php-ajax-contact-form-templates-with-captcha-formify/" class="news-item-title" target="_blank">您有新的物流消息</a>
                                        <p class="news-item-preview">来自西安的韵达快递已投递到肇庆学院智顺通代领点，请尽快前往领取，订单编号：xxxxxxx</p>
                                    </div>

                                </li>

                                <li>

                                    <div class="news-item-date"> <span class="news-item-day">15</span> <span class="news-item-month">11月</span> </div>
                                    <div class="news-item-detail"> <a href="http://www.by EGrappler/open-source-jquery-php-ajax-contact-form-templates-with-captcha-formify/" class="news-item-title" target="_blank">您有新的物流消息</a>
                                        <p class="news-item-preview">来自上海的中通快递已投递到肇庆学院智顺通代领点，请尽快前往领取，订单编号：xxxxxxx</p>
                                    </div>

                                </li>

                                <li>

                                    <div class="news-item-date"> <span class="news-item-day">15</span> <span class="news-item-month">11月</span> </div>
                                    <div class="news-item-detail"> <a href="http://www.by EGrappler/open-source-jquery-php-ajax-contact-form-templates-with-captcha-formify/" class="news-item-title" target="_blank">您有新的物流消息</a>
                                        <p class="news-item-preview">来自深圳的顺丰快递已投递到肇庆学院智顺通代领点，请尽快前往领取，订单编号：xxxxxxx</p>
                                    </div>

                                </li>

                            </ul>
                        </div>
                        <!-- /widget-content -->
                    </div>
                    <!-- /widget -->
                </div>
                <!-- /span6 -->
                </div>
                <%--div-b--%>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /main-inner -->
</div>
<!-- /main -->
<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libjs2/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libjs2/js/excanvas.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libjs2/js/chart.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libjs2/js/bootstrap.js"></script>
<script type="text/javascript" language="javascript"  src="${pageContext.request.contextPath}/js/libjs2/js/full-calendar/fullcalendar.min.js"></script>

<script type="text/javascript"  src="${pageContext.request.contextPath}/js/libjs2/js/base.js"></script>
<script>

    var lineChartData = {
        labels: ["11.07", "11.08", "11.09", "11.12", "11.13", "11.14", "11.15"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                <!--数据的比例尺，之后的获取将由记录表提供-->
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    };

    var myLine = new Chart(document.getElementById("area-chart").getContext("2d")).Line(lineChartData);


    var barChartData = {
        <!--这里在之后要更改为工作日时间，添加判断，！weekday==星期六||星期日-->
        labels: ["11.07", "11.08", "11.09", "11.12", "11.13", "11.14", "11.15"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    };

    $(document).ready(function() {
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();
        var calendar = $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            selectable: true,
            selectHelper: true,
            select: function(start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            editable: true,
            events: [
                {
                    title: 'All Day Event',
                    start: new Date(y, m, 1)
                },
                {
                    title: 'Long Event',
                    start: new Date(y, m, d+5),
                    end: new Date(y, m, d+7)
                },
                {
                    id: 999,
                    title: 'Repeating Event',
                    start: new Date(y, m, d-3, 16, 0),
                    allDay: false
                },
                {
                    id: 999,
                    title: 'Repeating Event',
                    start: new Date(y, m, d+4, 16, 0),
                    allDay: false
                },
                {
                    title: 'Meeting',
                    start: new Date(y, m, d, 10, 30),
                    allDay: false
                },
                {
                    title: 'Lunch',
                    start: new Date(y, m, d, 12, 0),
                    end: new Date(y, m, d, 14, 0),
                    allDay: false
                },
                {
                    title: 'Birthday Party',
                    start: new Date(y, m, d+1, 19, 0),
                    end: new Date(y, m, d+1, 22, 30),
                    allDay: false
                },
                {
                    title: 'by EGrappler',
                    start: new Date(y, m, 28),
                    end: new Date(y, m, 29),
                    url: 'http://by EGrappler/'
                }
            ]
        });
    });
</script><!-- /Calendar -->
</body>
</html>

