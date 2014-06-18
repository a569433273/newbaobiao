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
<title>大客户报表</title>
</head>
<body>
	<form action="dakehu.action" name="dakehuform" id="dakehuform"
		method="post">
		<table>
			<tr>
				<td colspan="2"><textarea name="PNRmessage" cols="60" rows="14"></textarea>
				</td>
			</tr>
			<tr>
				<td>采购商：<select name="caigoushang" id="caigoushang">
						<option value="1">二连浩特</option>
						<option value="2">中体国旅</option>
				</select></td>
				<td>实收：<input type="text" name="noordidshishou"
					id="noordidshishou" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="OK" /></td>
			</tr>
		</table>
	</form>
</body>
</html>