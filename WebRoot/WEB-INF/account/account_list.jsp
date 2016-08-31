<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>达内－NetCTOSS</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global_color.css" />

<script type="text/javascript" src="../scripts/base64.js"></script>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/cookie_util.js"></script>
<script type="text/javascript" src="../scripts/DateFormat.js"></script>
<script type="text/javascript" src="../scripts/menu.js"></script>
<script type="text/javascript" src="../scripts/account.js"></script>
</head>
<body>
	<!--Logo区域开始-->
	<div id="header">
		<img src="../images/logo.png" alt="logo" class="left" /> <a href="#">[退出]</a>
	</div>
	<!--Logo区域结束-->
	<!--导航区域开始-->
	<div id="navi">
		<ul id="menu">
			<li><a id="index" href="javascript:;" class="index_off"></a></li>
			<li><a id="role" href="javascript:;" class="role_off"></a></li>
			<li><a id="admin" href="javascript:;" class="admin_off"></a></li>
			<li><a id="cost" href="javascript:;" class="fee_off"></a></li>
			<li><a id="account" href="javascript:;" class="account_on"></a></li>
			<li><a id="service" href="javascript:;" class="service_off"></a></li>
			<li><a id="bill" href="javascript:;" class="bill_off"></a></li>
			<li><a id="report" href="javascript:;" class="report_off"></a></li>
			<li><a id="user" href="javascript:;" class="information_off"></a></li>
			<li><a id="user_mod" href="javascript:;" class="password_off"></a></li>
		</ul>
	</div>
	<!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<form action="" method="">
			<!--查询-->
			<div class="search_add">
				<div>
					身份证：<input type="text" value="不验证" class="text_search" />
				</div>
				<div>
					姓名：<input type="text" class="width70 text_search" value="不验证" />
				</div>
				<div>
					登录名：<input type="text" value="不验证" class="text_search" " />
				</div>
				<div>
					状态： <select class="select_search">
						<option>全部</option>
						<option>开通</option>
						<option>暂停</option>
						<option>删除</option>
					</select>
				</div>
				<div>
					<input type="button" value="搜索" class="btn_search" />
				</div>
				<input type="button" value="增加" class="btn_add"
					onclick="location.href='account_add.html';" />
			</div>
			<!--删除等的操作提示-->
			<div id="operate_result_info" class="operate_success">
				<img src="../images/close.png"
					onclick="this.parentNode.style.display='none';" />
				删除成功，且已删除其下属的业务账号！
			</div>
			<!--数据区域：用表格展示数据-->
			<div id="data">
				<table id="datalist">
					<thead>
						<tr>
							<th>账号ID</th>
							<th>姓名</th>
							<th class="width150">身份证</th>
							<th>登录名</th>
							<th>状态</th>
							<th class="width100">创建日期</th>
							<th class="width150">上次登录时间</th>
							<th class="width200"></th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
					
				</table>
				<p>
					业务说明：<br /> 1、创建则开通，记载创建时间；<br /> 2、暂停后，记载暂停时间；<br />
					3、重新开通后，删除暂停时间；<br /> 4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
					5、暂停账务账号，同时暂停下属的所有业务账号；<br />
					6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
					7、删除账务账号，同时删除下属的所有业务账号。
				</p>
			</div>
			<!--分页-->
			<div id="pages">
				<a href="#">首页</a> <a href="#">上一页</a> <a href="#"
					class="current_page">1</a> <a href="#">2</a> <a href="#">3</a> <a
					href="#">4</a> <a href="#">5</a> <a href="#">下一页</a> <a href="#">末页</a>
			</div>
		</form>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
		<p>版权所有(C)加拿大达内IT培训集团公司</p>
	</div>
</body>
</html>
