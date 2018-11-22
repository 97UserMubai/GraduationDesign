<%--
  Created by IntelliJ IDEA.
  User: 木白
  Date: 2018/11/6
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="test1">这是个测试的按钮，会有layer弹出框</button>
</body>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"> </script>
<script src="layer-v3.1.1/layer/layer.js"> </script>
<script>
    $('#test1').on('click', function(){
        layer.msg('hello');
    });
</script>
</html>
