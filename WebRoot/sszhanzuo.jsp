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
<title>根据信息自动占座</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<s:set name="ssmessage" value="ssmessage"></s:set>
<body>
	<form action="zhanzuo.action" name="mmform" id="mmform" method="post">
		<textarea name="creatPNRmessage" id="creatPNRmessage" rows="9"
			cols="88"><s:property value="ssmessage" /></textarea>
		<br /> 联系电话：<select name="osinumber" id="osinumber">
			<option value="1">大客户</option>
			<option value="13580305752">新天空</option>
			<option value="13339981503">盛亚辉</option>
			<option value="13911133783">邝雄辉</option>
			<option value="18611603453">王海林</option>
			<option value="13368888848">张禄萍</option>
			<option value="18611343843">王海芹</option>
			<option value="13710970066">新天空2</option>
			<option value="15010077407">王海生</option>
			<option value="13699246811">吴德生</option>
			<option value="18606582037">中体国旅</option>
		</select> <input type="submit" name="submit" class="button" value="占座" />
	</form>
</body>
</html>
