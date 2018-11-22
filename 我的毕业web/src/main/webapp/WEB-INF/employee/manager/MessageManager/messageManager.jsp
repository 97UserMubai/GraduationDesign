<%--
  Created by IntelliJ IDEA.
  User: 木白
  Date: 2018/11/2
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>历史信息查询</title>
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
<%--引入页面--%>
<jsp:include page="/WEB-INF/employee/employeeHeader.jsp" />
<!-- Main Content -->
<div class="container-fluid">
    <div class="side-body">
        <div class="page-title">
            <span class="title">历史信息查询</span>
            <div class="description"></div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="card">
                    <div class="card-header">
                        <div class="card-title">
                            <div class="title">记录列表</div>
                        </div>
                        <div class="pull-right card-action">
                            <div class="btn-group" role="group" aria-label="...">
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="datatable table table-hover" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>信息ID</th>
                                <th>信息类型</th>
                                <th>员工姓名</th>
                                <th>所属部门</th>
                                <th>请假时间</th>
                                <th>当前状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--begin="0" end="${pageInfo.list.size-1}"--%>
                            <c:forEach items="${pageInfo.list}" var="leaveRequests" varStatus="status">
                                <tr>
                                    <td>${leaveRequests.messageId}</td>
                                    <td>${leaveRequests.style}</td>
                                    <td>${leaveRequests.personName}</td>
                                    <td>${leaveRequests.department}</td>
                                    <td>${leaveRequests.applyDays}</td>
                                    <td>${leaveRequests.status}</td>
                                    <td>
                                            <button type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary" value="">
                                                详情
                                            </button>
                                            <!-- Modal -->
                                            <div class="modal fade modal-primary" id="modalPrimary" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" id="myModalLabel">申请详情</h4>
                                                        </div>
                                                        <div class="modal-body">

                                                            <table class="table table-bordered">
                                                                <thead>
                                                                <tr>
                                                                    <th>申请Id</th>
                                                                    <th>申请类型</th>

                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr>
                                                                    <td>${leaveRequests.messageId}</td>
                                                                    <td>${leaveRequests.style}</td>

                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="table table-bordered">
                                                                <thead>
                                                                <tr>
                                                                    <th>申请人Id</th>
                                                                    <th>申请人</th>
                                                                    <th>申请人部门</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr>
                                                                    <td>${leaveRequests.employeeId}</td>
                                                                    <td>${leaveRequests.personName}</td>
                                                                    <td>${leaveRequests.department}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="table table-bordered">
                                                                <thead>
                                                                <tr>
                                                                    <th>离开时间</th>
                                                                    <th>返回时间</th>
                                                                    <th>请假天数</th>
                                                                    <th>当前状态</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr>
                                                                    <td>${leaveRequests.leaveTime}</td>
                                                                    <td>${leaveRequests.backTime}</td>
                                                                    <td>${leaveRequests.applyDays}</td>
                                                                    <td>${leaveRequests.status}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="table table-bordered">
                                                                <thead>
                                                                <tr>
                                                                    <th>申请理由</th>
                                                                    <th>申请细节</th>
                                                                    <th>申请时间</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr>
                                                                    <td>${leaveRequests.leaveReason}</td>
                                                                    <td>${leaveRequests.leaveDetail}</td>
                                                                    <td>${leaveRequests.applyTime}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="table table-bordered">
                                                                <thead>
                                                                <tr>
                                                                    <th>审批人</th>
                                                                    <th>审批理由</th>
                                                                    <th>审批时间</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr>
                                                                    <td>${leaveRequests.provePerson}</td>
                                                                    <td>${leaveRequests.proveReason}</td>
                                                                    <td>${leaveRequests.proveTime}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div style="text-align:center" class="modal-footer">
                                                            <button type="button" class="btn btn-info" data-dismiss="modal" >确定</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
</body>
</html>

