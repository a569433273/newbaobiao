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
<script type="text/javascript">
	function my_submit() {
		document.dakehuform.submit();
		document.dakehuform.submit1.disabled = true;
	}
</script>
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
				<td>订单号：<input type="text" name="ordid" id="ordid" /></td>
			</tr>
			<tr>
				<td><input type="button" value="OK" name="submit1"
					onClick="javascript:my_submit();" /></td>
			</tr>
		</table>
	</form>
</body>
</html>