<%--
  Created by IntelliJ IDEA.
  User: 木白
  Date: 2018/10/11
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 7]><html class="ie ie7"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="apple-touch-icon.png" rel="apple-touch-icon">
    <link href="favicon.png" rel="icon">
    <meta name="author" content="Nghia Minh Luong">
    <meta name="keywords" content="Default Description">
    <meta name="description" content="Default keyword">
    <title>毕业设计Index</title>
    <!-- Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="../../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../plugins/ps-icon/style.css">
    <!-- CSS Library-->
    <link rel="stylesheet" href="../../plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../plugins/owl-carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="../../plugins/jquery-bar-rating/dist/themes/fontawesome-stars.css">
    <link rel="stylesheet" href="../../plugins/slick/slick/slick.css">
    <link rel="stylesheet" href="../../plugins/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="../../plugins/Magnific-Popup/dist/magnific-popup.css">
    <link rel="stylesheet" href="../../plugins/jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="../../plugins/revolution/css/settings.css">
    <link rel="stylesheet" href="../../plugins/revolution/css/layers.css">
    <link rel="stylesheet" href="../../plugins/revolution/css/navigation.css">
    <!-- Custom-->
    <link rel="stylesheet" href="../../css/main/style.css">
    <!--HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries-->
    <!--WARNING: Respond.js doesn't work if you view the page via file://-->
    <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!--[if IE 7]><body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 8]><body class="ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 9]><body class="ie9 lt-ie10"><![endif]-->
<body>
<div class="header--sidebar"></div>
<header class="header">
    <div class="header__top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-8 col-sm-6 col-xs-12 ">
                    <p>公司地点：中巴软件园天台，联系电话：130-0000-0000，负责人：王生</p>
                </div>
                <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="header__actions"><a href="#">${employee.name}</a>
                        <div class="btn-group ps-dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${employee.identity}</a>
                        </div>
                        <div class="btn-group ps-dropdown">
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <p id="mydate" onload="testDate()"></p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <nav class="navigation">
        <div class="container-fluid">
            <div class="navigation__column left">
                <!--<div class="header__logo"><a class="ps-logo" href="index.html"><img src="images/logo.png" alt=""></a></div>-->
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
            </div>
            <div class="navigation__column center">
                <ul class="main-menu menu">
                    <li class="menu-item menu-item-has-children dropdown"><a href="index.html">日程管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="index.html">部门日程</a></li>
                            <li class="menu-item"><a href="#">我的日程</a></li>
                            <li class="menu-item"><a href="#">我的便签</a></li>
                        </ul>
                    </li>
                    <li class="menu-item menu-item-has-children dropdown"><a href="#">文件管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/selectAllFileLog.do">文件上传/下载</a></li>
                            <li class="menu-item"><a href="#">历史文件</a></li>
                        </ul>
                    </li>
                    <li class="menu-item menu-item-has-children dropdown"><a href="">考勤管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/jumpAttendanceIndex.do">签到/签退</a></li>
                            <li class="menu-item"><a href="#">请假</a></li>
                            <li class="menu-item"><a href="#">查看考勤历史</a></li>
                        </ul>
                    </li>
                    <li class="menu-item menu-item-has-children dropdown"><a href="#">消息管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="index.html">消息传递</a></li>
                            <li class="menu-item"><a href="#">查看历史消息</a></li>
                        </ul>
                    </li>
                    <li class="menu-item menu-item-has-children dropdown"><a href="#">人事管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/selectAllEmployees.do">员工管理</a></li>
                        </ul>
                    </li>
                    <li class="menu-item menu-item-has-children dropdown"><a href="#">部门管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="">业务进度</a></li>
                            <li class="menu-item"><a href="">报表登记</a></li>
                            <li class="menu-item"><a href="">工资表</a></li>
                            <li class="menu-item"><a href="">考勤表</a></li>
                        </ul>
                    </li>
                    <li class="menu-item menu-item-has-children dropdown"><a href="#">系统管理</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="index.html">员工信息</a></li>
                            <li class="menu-item"><a href="#">增加员工</a></li>
                            <li class="menu-item"><a href="#">登录日志</a></li>
                            <li class="menu-item">
                                <a href="${pageContext.request.contextPath}/selectAllLogs.do">
                                    操作日志
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="header-services">
    <div class="ps-services owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="7000" data-owl-gap="0" data-owl-nav="true" data-owl-dots="false" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1" data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000" data-owl-mousedrag="on">
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>部门通知</strong>: 今天放假</p>
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>部门通知</strong>:明天放假</p>
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>公司通知</strong>: 最近带薪放假</p>
    </div>
</div>
<!-- JS Library-->
<script>
    function testDate(){
        var date=new Date();
        var result=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
        document.getElementById("mydate").innerHTML=result;
    }
    setInterval("testDate()", 1000);
</script>
<script type="text/javascript" src="../../plugins/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="../../plugins/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../plugins/jquery-bar-rating/dist/jquery.barrating.min.js"></script>
<script type="text/javascript" src="../../plugins/owl-carousel/owl.carousel.min.js"></script>
<script type="text/javascript" src="../../plugins/gmap3.min.js"></script>
<script type="text/javascript" src="../../plugins/imagesloaded.pkgd.js"></script>
<script type="text/javascript" src="../../plugins/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="../../plugins/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="../../plugins/jquery.matchHeight-min.js"></script>
<script type="text/javascript" src="../../plugins/slick/slick/slick.min.js"></script>
<script type="text/javascript" src="../../plugins/elevatezoom/jquery.elevatezoom.js"></script>
<script type="text/javascript" src="../../plugins/Magnific-Popup/dist/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="../../plugins/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://ditu.google.cn/maps/api/js?key=AIzaSyAx39JFH5nhxze1ZydH-Kl8xXM3OK4fvcg&amp;region=GB"></script>
<script type="text/javascript" src="../../plugins/revolution/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
<script type="text/javascript" src="../../plugins/revolution/js/extensions/revolution.extension.migration.min.js"></script>
<!-- Custom scripts-->
<script type="text/javascript" src="../../js/main/main.js"></script>
</body>
</html>
