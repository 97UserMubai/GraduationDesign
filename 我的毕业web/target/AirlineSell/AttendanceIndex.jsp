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
</head>
<body>
<jsp:include page="/WEB-INF/employee/employeeHeader.jsp" />
    <div>
        <a href="${pageContext.request.contextPath}/selectAttendanceClockStatus.do"><button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">签到</button></a>
        <p style="font-size:16px;">${msg}</p>
        <br><br><br>
        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">签退</button>
        <p style="font-size:16px;">${msg}</p>
        <br><br><br>
        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">查看本月签到签退记录</button>
        <br><br><br>
        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">补签申请</button>
    </div>
</body>
</html>
