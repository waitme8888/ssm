<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = "https://" + request.getServerName() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>limit</title>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen" />
<meta charset="UTF-8">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background: url(resources/images/backimg.png) repeat;
	font-size: 14px;
	font-family: Microsoft Yahei;
	border-top: 2px solid #39b562;
}

.not-found {
	width: 440px;
	height: 320px;
	background: url(resources/images/limited.png) top center no-repeat;
	position: absolute;
	left: 50%;
	margin-left: -220px;
	top: 50%;
	margin-top: -240px;
}

.not-found p {
	position: absolute;
	bottom: 0;
	width: 100%;
	text-indent: 24px;
	top: 70px;
	color: #666;
}

.not-found a {
	color: #428bca;
	text-decoration: none;
}

.not-found a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="not-found">
		<p>
			您可以 <a href="homePage">返回首页</a>或 联系管理员
		</p>
	</div>
</body>
</html>