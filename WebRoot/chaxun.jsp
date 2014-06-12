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
<title>查询订单</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<s:set name="cunzai" value="cunzai"></s:set>
<body>
	<s:if test="#cunzai == '1'.toString()">
		<form action="xiugai.action" name="xiugai" id="xiugai" method="post">
			<table width="349" border="0">
				<tr>
					<td width="53" height="20">订单号</td>
					<td width="61" height="20">采购商</td>
					<td width="62" height="20">乘机人</td>
					<td width="70" height="20">票号</td>
					<td width="69" height="20">PNR</td>
				</tr>
				<s:iterator value="dakehus">
					<tr>
						<td height="20"><input type="text" name="xordid" id="xordid"
							 size="15" value="<s:property value="ordid"/>" />
						</td>
						<td height="20"><input type="text" name="xcaigoushang"
							id="xcaigoushang" size="15" value="<s:property value="caigoushang"/>" />
						</td>
						<td height="20"><input type="text" name="xxingming"
							id="xxingming" size="15" value="<s:property value="xingming"/>" />
						</td>
						<td height="20"><input type="text" name="xpiaohao"
							id="xpiaohao" size="15" value="<s:property value="piaohao"/>" />
						</td>
						<td height="20"><input type="text" name="xpnr"
							id="xpnr" size="15" value="<s:property value="pnr"/>" />
						</td>
					</tr>
					</s:iterator>
					<tr>
						<td height="20">票面价</td>
						<td height="20">税费</td>
						<td height="20">支出金额</td>
						<td height="20">实收金额</td>
						<td height="20">利润</td>
					</tr>
					<s:iterator value="dakehus">
					<tr>
						<td height="20"><input type="text" name="xpiaomianjia"
							id="xpiaomianjia" size="15" value="<s:property value="piaomianjia"/>" />
						</td>
						<td height="20"><input type="text" name="xshuifei"
							id="xshuifei" size="15" value="<s:property value="shuifei"/>" />
						</td>
						<td height="20"><input type="text" name="xzhichujine"
							id="xzhichujine" size="15" value="<s:property value="zhichujine"/>" />
						</td>
						<td height="20"><input type="text" name="xshishou"
							id="xshishou" size="15" value="<s:property value="shishou"/>" />
						</td>
						<td height="20"><input type="text" name="xlirun" id="xlirun"
							size="15" value="<s:property value="lirun"/>" />
						</td>
					</tr>
					</s:iterator>
					<tr>
						<td height="20">航程</td>
						<td height="20">航班</td>
						<td height="20">仓位</td>
						<td height="20">乘机日期</td>
						<td height="20">&nbsp;</td>
					</tr>
					<s:iterator value="dakehus">
					<tr>
						<td height="20"><input type="text" name="xhangcheng"
							id="xhangcheng" size="15" value="<s:property value="hangcheng"/>" />
						</td>
						<td height="20"><input type="text" name="xhangban"
							id="xhangban" size="15" value="<s:property value="hangban"/>" />
						</td>
						<td height="20"><input type="text" name="xcangwei"
							id="xcangwei" size="15" value="<s:property value="cangwei"/>" />
						</td>
						<td height="20"><input type="text" name="xchengjiriqi"
							id="xchengjiriqi" size="15" value="<s:property value="chengjiriqi"/>" />
						</td>
						<td height="20">&nbsp;</td>
					</tr>
					</s:iterator>
					<tr>
						<td height="20">出票日期</td>
						<td height="20">备注</td>
						<td height="20">&nbsp;</td>
						<td height="20">&nbsp;</td>
						<td height="20">&nbsp;</td>
					</tr>
					<s:iterator value="dakehus">
					<tr>
						<td height="20"><input type="text" name="xchupiaoriqi"
							id="xchupiaoriqi" size="15" value="<s:property value="chupiaoriqi"/>" />
						</td>
						<td height="20"><input type="text" name="xbeizhu"
							id="xbeizhu" size="15" value="<s:property value="beizhu"/>" />
						</td>
						<td height="20"><input type="hidden" name="xid" id="xid"
							size="15" value="<s:property value="id"/>" /><input type="submit" name="submit" value="保存修改" />
						</td>
						<td height="20">&nbsp;</td>
						<td height="20"></td>
					</tr>
					</s:iterator>
				
			</table>
			
		</form>
		<form action="feipiao.action" name="feipiao" id="feipiao"
			method="post">
			废票:<input type="text" name="feipiaozhangshu" id="feipiaozhangshu">张
			<s:iterator value="dakehus">
				<input type="hidden" name="xid" id="xid"
					value="<s:property value="id"/>" />
			</s:iterator>
			<input type="submit" name="submit" value="废票" />
		</form>
	</s:if>
	<s:else>
		<s:property value="cunzai" />
	</s:else>
</body>
</html>
