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
<title>根据票号或PNR生成短信模板</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<s:set name="duanxin" value="duanxin"></s:set>
<script type="text/javascript">
   function duanxinpnr(){
     document.duanxin.action="duanxinpnr";
  		document.duanxin.submit();
	}
   function duanxinpiaohao() {
		document.duanxin.action = "duanxinpiaohao";
		document.duanxin.submit();
	}
   function faduanxin() {
		document.duanxin.action = "faduanxin";
		document.duanxin.submit();
	}
</script>
<body>
	<form action="" name="duanxin" id="duanxin" method="post">
		<textarea name="duanxinmessage" id="duanxinmessage" rows="9"
			cols="88"><s:property value="duanxin" /></textarea>
			<br/>
		<input type="submit" name="submit" class="button" value="PNR" onclick="duanxinpnr()"/>
		<input type="submit" name="submit" class="button" value="票号" onclick="duanxinpiaohao()"/>
		<br/>
		手机号：<input type="text" name="shoujihao" id="shoujihao"/>
		<input type="submit" name="submit" class="button" value="发短信" onclick="faduanxin()"/>
	</form>
</body>
</html>
