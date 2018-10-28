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

    <title>文件管理</title>
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
            <span class="title">文件管理</span>
            <div class="description"></div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="card">
                    <div class="card-header">
                        <div class="card-title">
                            <div class="title">文件列表</div>
                        </div>
                        <div class="pull-right card-action">
                            <%--<div class="btn-group" role="group" aria-label="...">--%>
                                <%--<button type="button" class="btn btn-primary  btn-primary" id="dataform">选择文件</button>--%>
                            <%--</div>--%>
                                <div class="btn-group" role="group" aria-label="...">
                                <form action="${pageContext.request.contextPath}/fileUpload.do" enctype="multipart/form-data" method="post" >
                                    <input type="file"  class="btn btn-primary  btn-primary" name="filename" >
                                    <input type="submit" class="btn btn-primary  btn-primary" value="上传">
                                </form>
                                </div>
                            <%--<div class="btn-group" role="group" aria-label="...">--%>
                                <%--<button type="button" class="btn btn-primary  btn-primary" >确认上传</button>--%>
                            <%--</div>--%>


                        </div>
                    </div>
                    <div class="card-body">
                        <table class="datatable table table-hover" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>文件名</th>
                                <th>上传人</th>
                                <th>所属部门</th>
                                <th>上传时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="fileBeans" varStatus="status">
                                <tr>
                                    <td>${fileBeans.fileName}</td>
                                    <td>${fileBeans.filePerson}</td>
                                    <td>${fileBeans.fileDepartment}</td>
                                    <td>${fileBeans.fileTime}</td>
                                    <td>
                                        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">下载</button>
                                        <button type="button" class="btn btn-danger  btn-sm" data-toggle="modal" data-target="#modalPrimary2">清除</button>
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
