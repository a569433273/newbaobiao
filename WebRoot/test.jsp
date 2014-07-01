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
    $(function(){
        $.post('book.xml',function(data){
            //查找所有的book节点
            var s="";
            $(data).find('Item').each(function(i){
                var id=$(this).children('ID').text;
                var name=$(this).children('Carrier').text();
                var author=$(this).children('FlightNo').text();
                var price=$(this).children('DepartureDate').text();
                s+=id+"&nbsp;&nbsp;&nbsp;&nbsp;"+name+"&nbsp;&nbsp;&nbsp;&nbsp;"+author+"&nbsp;&nbsp;&nbsp;&nbsp;"+price+"<br>";
            });
            $('#mydiv').html(s);
        });
    });
</script>
</head>
<body>
    <div id='mydiv'></div>
</body>
	