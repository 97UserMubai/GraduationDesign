<%--
  Created by IntelliJ IDEA.
  User: 木白
  Date: 2018/10/23
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>签到/签退</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/css/dataTables.bootstrap.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libcss/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libcss/themes/flat-blue.css">
</head>
<body>
<jsp:include page="/WEB-INF/employee/employeeHeader.jsp" />
    <div>
        <a href="${pageContext.request.contextPath}/selectAttendanceClockStatus.do">
            <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2" alert(${msg})>签到</button>
        </a>
        <br><br><br>
        <a href="${pageContext.request.contextPath}/selectAttendanceKnockStatus.do">
        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">签退</button>
        </a>
        <br><br><br>

        <a href="${pageContext.request.contextPath}/selectEmployeeAttendanceAllLog.do">
        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">查看本月签到签退记录</button>
        </a>
            <br><br><br>
        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">补签申请</button>
    </div>
<button type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary">
    补签申请
</button>
<!-- Modal -->
<div class="modal fade modal-primary" id="modalPrimary" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">请填写申请详情</h4>
            </div>
            <div class="modal-body">
                <div>
                    <span>
                    <select onchange="A()" id = "value1">
                        <option value="1">上午：6:00-8:30</option>
                        <option value="2">下午：17:30-22:00</option>
                    </select>
                        </span>
                </div>

                <form>
                    <label >缺签时间:</label>
                    <input type="date" name="supplementDay" placeholder="缺签时间">
                    <br>
                    <label >缺签时间段:</label>
                    <input id = "supplement" name="supplementTime" placeholder="缺签时间段">
                    <br>
                    <label >缺签理由:</label>
                    <input type="text" name="supplementReason" placeholder="缺签理由">
                    <br>
                    <label >缺签细节:</label>
                    <input type="text" name="supplementDetail" placeholder="缺签细节">
                </form>

            </div>
            <div style="text-align:center" class="modal-footer">
                <a href="${pageContext.request.contextPath}/applySupplement.do">
                    <button type="button" class="btn btn-info" data-dismiss="modal" >提交申请</button>
                </a>
            </div>
        </div>

    </div>
</div>
</body>
<script language="javascript">
    function A(){
        document.getElementById('supplement').value=
            document.getElementById('value1').options[document.getElementById('value1').selectedIndex].value;
    }
</script>
<!-- Javascript Libs -->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery.matchHeight-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/select2.full.min.js"></script>
<!-- Javascript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libjs/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libjs/index.js"></script>
</html>
