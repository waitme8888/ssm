<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user</title>

<script type="text/javascript"
	src="${contextPath}/resources/plugins/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/plugins/jquery/jquery.form.js"></script>
</head>
<body>
	<form action="${contextPath}/user/save" method="post" >
		<table>
			<tr>
				<td>id</td>
				<td>${user.id}</td>
				<input type="hidden" name="id" value="${user.id }">
			</tr>
			<tr>
				<td>姓名</td>
				<td><input name="name" value="${user.name}"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input name="age" value="${user.age}"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input name="gender" value="${user.gender}"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交">
					<input type="button" onclick="cancel()" value="取消">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	   function cancel() {
		   location.href = "${contextPath}/user/list"
	   }
	</script>
</body>