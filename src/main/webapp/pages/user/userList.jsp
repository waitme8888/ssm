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
<script type="text/javascript"
	src="${contextPath}/resources/js/jquery.page.js"></script>
<style type="text/css">
.tcdPageCode{padding: 15px 20px;text-align: left;color: #ccc;}
.tcdPageCode a{display: inline-block;color: #428bca;display: inline-block;height: 25px; line-height: 25px;  padding: 0 10px;border: 1px solid #ddd; margin: 0 2px;border-radius: 4px;vertical-align: middle;}
.tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
.tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca; border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
.tcdPageCode span.disabled{ display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px; color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
</style>
</head>
<body>


	  <form name="searchForm" id="searchForm" method="post">
	    <input type="hidden" id="pageNo" name="pageNo" />
	    <input type="hidden" id="pageSize" name="pageSize" value="10" />
		<table style="margin-top:30px;">
			<tr>
				<td>姓名</td><td><input type="text" id="searchName" name="searchName" value="${searchName}"></td>
				<td><input type="button" value="查询" onclick="searchUser()"></td>
			</tr>
		</table>
	</form>
	<table id="userTable"  border=1>
		<tr>
			<td width="50px" style="text-align: center;">id</td>
			<td width="80px" style="text-align: center;">姓名</td>
			<td width="50px" style="text-align: center;">年龄</td>
			<td width="50px" style="text-align: center;">性别</td>
			<td width="100px" style="text-align: center;">操作</td>
		</tr>
		<c:if test="${not empty page.list}">
			<c:forEach items="${page.list}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
					<td>${user.gender }</td>
					<td><a href="javascript:updateUser('${user.id }')">修改</a>&nbsp;&nbsp;<a
						href="javascript:deleteUser('${user.id }')">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

    <!-- 分页-->
    <div class="tcdPageCode" ></div>
 
    <p><input type="button" value="添加" onclick="addUser()"></p>
	<script type="text/javascript">
	    $(".tcdPageCode").createPage({
	        pageCount:"${page.pages}", //总页数
	        current:"${page.pageNum}", //当前页
	        backFn:function(p){
	            $("#pageNo").val(p);
	            searchUser();
	        }
	    });
		
		function updateUser(id) {
			window.location.href = "${contextPath}/user/" + id;
		}

		function deleteUser(id) {
			var url = "${contextPath}/user/delete";
			$.post(url, {
				id : id
			}, function(data) {
				if (data.success) {
					window.location.reload();
				} else {
					alert("删除数据失败");
				}
			});
		}
		function addUser() {
			window.location.href = "${contextPath}/user/-1";
		}
		function searchUser() {
			$("#searchForm").attr("action", "${contextPath}/user/list");
			$("#searchForm").submit();
		}
	</script>
</body>