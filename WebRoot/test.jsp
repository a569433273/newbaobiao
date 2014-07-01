<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@taglib prefix="s" uri="/struts-tags"%>
<title>这个报表你做出问题了</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>jquery解析xml</title>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$.post('book.xml', function(data) {
			//查找所有的book节点
			var s = "";
			var t="";
			$(data).find('Item')
					.each(
							function() {
								var id = $(this).children('ID').text();
								var hangkonggongsi = $(this)
										.children('Carrier').text();
								var hangbanhao = $(this).children('FlightNo')
										.text();
								$(this).children('Classes').children('Class').each(function(){
									var cangwei = $(this).attr("Code");
									var price = $(this).attr("Price");
									var zuowei = $(this).attr("Seat");
									var zuoweishu = 0;
									if (zuowei == "A"&&price != 0) {
										zuoweishu = 9;
										t += "<tr><td>" + cangwei + "</td><td>" + zuoweishu + "</td></tr>";
									} else if (zuowei == "S"|| zuowei == "Q") {
										zuoweishu = 0;
									} else if (price != 0){
										zuoweishu = zuowei;
										t += "<tr><td>" + cangwei + "</td><td>" + zuoweishu + "</td></tr>";
									}
									
								});
								s += "<table><tr><td>" + id + "</td><td>" + hangkonggongsi + "</td></tr>" + t + "</table>";
							});
			$('#mydiv').html(s);
		});
	});
</script>
</head>
<body>
	<div id='mydiv'></div>
</body>