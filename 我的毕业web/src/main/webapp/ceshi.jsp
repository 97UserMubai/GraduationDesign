<%--
  Created by IntelliJ IDEA.
  User: 木白
  Date: 2018/11/19
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>部门日程管理</title>
</head>
<body>
<div >
    <jsp:include page="/WEB-INF/employee/employeeHeader.jsp" />
</div>
<div style="width: 1300px">
    <jsp:include page="scheduleBody.jsp" />
</div>
</body>
</html>
