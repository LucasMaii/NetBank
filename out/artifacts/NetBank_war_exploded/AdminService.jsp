<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link type="text/css" rel="stylesheet" href="css/service.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	var height=$(document).height();
	$('.main').css('height',height);
})
</script>
</head>

<body>
<div class="main">
  <div class="main0">
  	<div class= "software_title blue">
  	线上银行系统
  	</div>
  	<hr>

    <div class="userlogin" style="float: right; padding-top: 10px; padding-right: 10px; color: orange;">
      您的身份：管理员${admin}, <a href="index.jsp">退出</a>
    </div>

    <div class="main_rigth">
      <div class="rightgrid">
         <div class="right_apps">   
            <ul id="ctl00_cph_right_myapps">
                  <li class="bg0"><a href="/service?method=findAllOfInfo">个人信息</a></li>
                  <li class="bg1"><a href="/service?method=business">业务办理</a></li>
                  <li class="bg2"><a href="/service?method=findAccount">快速查询余额信息</a></li>
                  <li class="bg3"><a href="/service?method=modify">账户维护</a></li>
                  <li class="bg4"><a href="/service?method=aboutUs">关于我们</a></li>
            </ul>
        </div>
    </div>
  </div>
  </div>
</div>

<div class="footer">
  <div class="footer0">
     <div class="footer_l">使用条款 | 隐私保护</div>
     <div class="footer_r">© 2020 GDPU 银行系统 </div>
  </div> 
</div>
</body>
</html>
