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
<link href="style/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="top_img" align="right"></div>
	<div class="mid">
		<div class="left">
			<div class="left1">
				<div class="left_te1">
					<img src="images/left1_03.png" />
				</div>
				<div class="left_te2" align="center">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						style="margin-top:12px;">
						<tr>
							<td><img src="images/tel_031.png" width="168" height="26" />
							</td>
						</tr>
						<tr>
							<td><%=(String) session.getAttribute("yuangong")%> ，您好</td>
						</tr>
					</table>
				</div>
				<div class="left_te3">
					<img src="images/left1_07.png" />
				</div>
			</div>
			<div class="left2">
				<div class="left2_1">
					<img src="images/left2_01.png" />
				</div>
				<div class="left2_2">
					<ul>
						<li><span>业务报表</span>
						</li>
						<li><a href="dakehu.jsp" target="right2_tt">大客户</a>
						</li>
						<li><a href="sanke.html" target="right2_tt">散客</a>
						</li>
						<li><a href="#">淘宝/去哪儿店</a>
						</li>
						<li><a href="#">集团客户</a>
						</li>
						<li><a href="sszhanzuo.jsp" target="right2_tt">快速生成SS</a>
						</li>
					</ul>
					<ul>
						<li><span>信息发布</span>
						</li>
						<li><a href="#">通讯录</a>
						</li>
						<li><a href="#">人力行政管理</a>
						</li>
						<li><a href="#">资源共享</a>
						</li>
						<li><a href="#">讨论区</a>
						</li>
					</ul>
				</div>
				<div class="left2_1">
					<img src="images/left2_02.png" />
				</div>
			</div>
		</div>

		<div class="right">
			<div class="right1">
				现在的位置：<a href="#">首页</a>
			</div>
			<div class="right2" align="center">
				<div class="right2_tt">
					<iframe name="right2_tt" frameborder="0" width="700" height="290"
						scrolling="no"></iframe>
				</div>
			</div>
			<div class="right3">
				<img src="images/right_b_03.png" />
			</div>

			<div class="right4">查询订单</div>
			<div class="right5">
				<table>
					<tr>
						<td>
							<form action="chaxun.action" name="chaxunform" id="chaxunform"
								method="post" target="right2_tt">
								PNR：<input type="text" name="pnrchaxun" id="pnrchaxun" /> 
								订单号：<input type="text" name="ordidchaxun" id="ordidchaxun" /><input
									type="submit" value="查询" />
							</form></td>
						<td>
							<form action="writeexcel.action" name="writeexcelform"
								id="writeexcelform" method="post" target="right2_tt">
								<input type="text" name="chupiaoriqi" id="chupiaoriqi" /> <input
									type="submit" value="生成报表" />
							</form></td>
					</tr>
				</table>
			</div>
			<div class="right3">
				<img src="images/right_b_03.png" />
			</div>
		</div>
	</div>

	<div style=" clear:both;"></div>
	<div class="btt" align="center">
		<table width="98%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="18%"><div id="timetable"></div>
				</td>
				<td width="82%" align="right">版权所有</td>
			</tr>
		</table>
	</div>

	<script language="javascript">
		function get_time() {
			var date = new Date();
			var year = "", month = "", day = "";
			year = date.getFullYear();
			month = add_zero(date.getMonth() + 1);
			day = add_zero(date.getDate());
			week = date.getDay();
			switch (date.getDay()) {
			case 0:
				val = "星期天";
				break;
			case 1:
				val = "星期一";
				break;
			case 2:
				val = "星期二";
				break;
			case 3:
				val = "星期三";
				break;
			case 4:
				val = "星期四";
				break;
			case 5:
				val = "星期五";
				break;
			case 6:
				val = "星期六";
				break;
			}
			timetable.innerText = "日期：" + year + "年" + month + "月" + day
					+ "日  " + val;
		}
		function add_zero(temp) {
			if (temp < 10)
				return "0" + temp;
			else
				return temp;
		}
		setInterval("get_time()", 1000);
	</script>
</body>
</html>