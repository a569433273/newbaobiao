<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>窠浦内部管理</title>
<link rel="stylesheet" type="text/css" href="style/login.css" />
</head>

<body>
	<div class="box">
		<div class="tp">
			<img src="images/tit.png" width="262" height="31" />
		</div>
		<form action="denglu.action" name="dengluform" id="dengluform"
			method="post">
			<div class="loginp">
				<ul>
					<li>USERNAME : <input type="text" size="30px" name="username" /></li>
					<li>PASSWORD : <input type="password" size="30px"
						name="password" /></li>
				</ul>
			</div>
			<div class="btn">
				<input type="image" src="images/login_bn.png" /> <img
					src="images/cancel_bn.png" name="reset" />
			</div>
		</form>
	</div>
	<div class="bottom">
		<div class="font1">www.nestpu.cn</div>
		<div class="font2">窠浦（北京）商务服务有限公司</div>
	</div>
</body>
</html>
