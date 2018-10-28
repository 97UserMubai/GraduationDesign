<%--
  Created by IntelliJ IDEA.
  User: TIANYANZHI
  Date: 2018/8/6 0006
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>员工管理</title>
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
<jsp:include page="/WEB-INF/admin/adminHeader.jsp" />
<!-- Main Content -->
<div class="container-fluid">
    <div class="side-body">
        <div class="page-title">
            <span class="title">员工管理</span>
            <div class="description"></div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="card">
                    <div class="card-header">
                        <div class="card-title">
                            <div class="title">员工列表</div>
                        </div>
                        <div class="pull-right card-action">
                            <div class="btn-group" role="group" aria-label="...">
                                <button type="button" class="btn btn-primary  btn-primary" data-toggle="modal" data-target="#modalPrimary0">新增员工</button>
                                <!-- Modal -->
                                <div class="modal fade modal-primary" id="modalPrimary0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabe0">添加新员工信息</h4>
                                            </div>
                                            <div class="modal-body">

                                                <form class="form-horizontal" action="addEmployee.do" >
                                                    <div class="form-group">
                                                        <label for="input8" class="col-sm-2 control-label">员工名字</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="name" id="input8" required placeholder="name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="input4" class="col-sm-2 control-label">员工密码</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="password" id="input4" required placeholder="password">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="input5" class="col-sm-2 control-label">联系号码</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="phone" id="input5" required placeholder="phone">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="input6" class="col-sm-2 control-label">员工身份</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="identity" id="input6" required placeholder="identity">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-offset-2 col-sm-10">
                                                            <button type="submit" class="btn btn-primary">添加新员工</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="datatable table table-hover" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>员工姓名</th>
                                <th>员工ID</th>
                                <th>所属部门</th>
                                <th>联系方式</th>
                                <th>员工身份</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="employees" varStatus="status">
                                <tr>
                                    <td>${employees.name}</td>
                                    <td>${employees.id}</td>
                                    <td>${employees.department}</td>
                                    <td>${employees.phone}</td>
                                    <td>${employees.identity}</td>
                                    <td>
                                        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">炒鱿鱼</button>
                                        <!-- Modal -->
                                        <div class="modal fade modal-primary" id="modalPrimary2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title" id="myModalLabe2">炒鱿鱼该员工</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        此操作将不可逆，是否炒鱿鱼？
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                        <a href="${pageContext.request.contextPath}/deleteEmployee.do?id=${pageInfo.list[status.index+1].id}">
                                                            <button type="button" class="btn btn-danger">确认炒他</button>
                                                        </a>
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
