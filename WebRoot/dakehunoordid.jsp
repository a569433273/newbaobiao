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
		<input type="hidden" id="nameofcaigoushang" name="nameofcaigoushang"
			value="二连浩特">
		<table>
			<tr>
				<td colspan="2"><textarea name="PNRmessage" cols="60" rows="14"></textarea>
				</td>
			</tr>
			<tr>
				<td>采购商：<select name="caigoushang" id="caigoushang"
					onchange="getcaigoushang(this.options[this.options.selectedIndex].text)"></select>
					<script type="text/javascript" src="js/caigoushang.js" charset="gbk"></script>
					<script type="text/javascript">
						initcaigoushangsdakehu(document
								.getElementById("caigoushang"));
						function getcaigoushang(s) {
							document.getElementById("nameofcaigoushang").value = s;
						}
					</script>
				</td>
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