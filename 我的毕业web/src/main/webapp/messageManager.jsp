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
    <meta charset="utf-8">
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
                                    <c:if test = "${leaveRequests.status eq '0'}"><td>待审批</td></c:if>
                                    <c:if test = "${leaveRequests.status eq '1'}"><td>审批中</td></c:if>
                                    <c:if test = "${leaveRequests.status eq '2'}"><td>已审批</td></c:if>
                                    <c:if test = "${leaveRequests.status eq '3'}"><td>被驳回</td></c:if>
                                    <td>
                                        <%--<a href="${pageContext.request.contextPath}/selectMessageByMessageId.do?messageId=${leaveRequests.messageId}">--%>
                                        <%--<button type="button" class="btn btn-primary btn-primary" onclick="openMessage()">详情</button>--%>
                                            <%--alert(this.value)可以获取当前button行的值--%>
                                            <button id="test" type="button" class="btn btn-primary btn-primary" value="${leaveRequests.messageId}" onclick="showMessage(this.value)">详情</button>
                                        <%--</a>--%>
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
<script src="layer-v3.1.1/layer/layer.js"> </script>

<%--使用AJAX来进行数据库数据获取和异步刷新--%>
<script>
    function showMessage(str){
        // alert(str);
        var messageId = str;
        var myjson;
        //测试输出了对应的messageId
        $.ajax({
            // 路径问题暂未解决
            url:"message/getMessage.do",
            type:"POST",
            // contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data:{'messageId':messageId},
            dataType:"json",
            success:function(data){


                // var ceshi = {one:"我是第一",two:"会乱码吗"};
                // alert(ceshi.two);
                // ①测试结果：不会乱码
                //问题：如何将json类型的data数据转换成js对象
                //在action中对gson的处理数据更改为map+eval方法进行处理
                // var myjson = eval("(" + data + ")");
                // alert(myjson.personName);
                //②测试结果：系统报错,var变量接受的eval结果为uncaught

                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['730px', '460px'], //宽高
                    content: '<div class="modal-body">\n' +
                        '\n' +
                        '                                                            <table class="table table-bordered">\n' +
                        '                                                                <thead>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <th>申请Id</th>\n' +
                        '                                                                    <th>申请类型</th>\n' +
                        '\n' +
                        '                                                                </tr>\n' +
                        '                                                                </thead>\n' +
                        '                                                                <tbody>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <td>'+ data.messageId + '</td>\n' +
                        '                                                                    <td>' + data.style + '</td>\n' +
                        '\n' +
                        '                                                                </tr>\n' +
                        '                                                                </tbody>\n' +
                        '                                                            </table>\n' +
                        '                                                            <table class="table table-bordered">\n' +
                        '                                                                <thead>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <th>申请人Id</th>\n' +
                        '                                                                    <th>申请人</th>\n' +
                        '                                                                    <th>申请人部门</th>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </thead>\n' +
                        '                                                                <tbody>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <td>' + data.employeeId + '</td>\n' +
                        '                                                                    <td>'+ myjson.personName + '</td>\n' +
                        '                                                                    <td>'+ data.department +'</td>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </tbody>\n' +
                        '                                                            </table>\n' +
                        '                                                            <table class="table table-bordered">\n' +
                        '                                                                <thead>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <th>离开时间</th>\n' +
                        '                                                                    <th>返回时间</th>\n' +
                        '                                                                    <th>请假天数</th>\n' +
                        '                                                                    <th>当前状态</th>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </thead>\n' +
                        '                                                                <tbody>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <td>'+ data.leaveTime + '</td>\n' +
                        '                                                                    <td>'+ data.backTime + '</td>\n' +
                        '                                                                    <td>'+ data.applyDays + '</td>\n' +
                        '                                                                    <c:if test = "${data.status eq \'0\'}"><td>待审批</td></c:if>\n' +
                        '                                                                    <c:if test = "${data.status eq \'1\'}"><td>审批中</td></c:if>\n' +
                        '                                                                    <c:if test = "${data.status eq \'2\'}"><td>已审批</td></c:if>\n' +
                        '                                                                    <c:if test = "${data.status eq \'3\'}"><td>被驳回</td></c:if>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </tbody>\n' +
                        '                                                            </table>\n' +
                        '                                                            <table class="table table-bordered">\n' +
                        '                                                                <thead>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <th>申请理由</th>\n' +
                        '                                                                    <th>申请细节</th>\n' +
                        '                                                                    <th>申请时间</th>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </thead>\n' +
                        '                                                                <tbody>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <td>'+ data.leaveReason + '</td>\n' +
                        '                                                                    <td>' + data.leaveDetail + '</td>\n' +
                        '                                                                    <td>' + data.applyTime + '</td>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </tbody>\n' +
                        '                                                            </table>\n' +
                        '                                                            <table class="table table-bordered">\n' +
                        '                                                                <thead>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <th>审批人</th>\n' +
                        '                                                                    <th>审批理由</th>\n' +
                        '                                                                    <th>审批时间</th>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </thead>\n' +
                        '                                                                <tbody>\n' +
                        '                                                                <tr>\n' +
                        '                                                                    <td>' + data.provePerson + '</td>\n' +
                        '                                                                    <td>'+ data.proveReason + '</td>\n' +
                        '                                                                    <td>' + data.proveTime + '</td>\n' +
                        '                                                                </tr>\n' +
                        '                                                                </tbody>\n' +
                        '                                                            </table>\n' +
                        '                                                        </div>'
                });

            },
            error:function (msg) {
                $(".notice").html('Error:'+msg);
            }
        });
    }
</script>
</body>
</html>

