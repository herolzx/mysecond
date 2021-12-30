<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${ctx }/">
<meta charset="UTF-8">
<title>员工管理系统</title>

<link rel="stylesheet" type="text/css" href="assets/employee/list.css">
<script type="text/javascript" language="javascript"
	src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>

<!-- 引入layer弹出 -->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/layer/layer.js"></script>
<script type="text/javascript" language="javascript"
	src="assets/public/lib/laydate/laydate.js"></script>

<script type="text/javascript">
	var pageNo = "${pi.pageNum}";//当前页
	var pages = "${pi.pages}";//总页数
	var pageSize = "${pi.pageSize}";//一页显示多少行数据
	var error = "${error}";//页面错误信息
	var ctx = "${ctx}";//应用上下文
	var size = "${employee.size()}";
</script>

<script type="text/javascript" language="javascript"
	src="assets/employee/list.js"></script>


</head>
<body>
	<div class="container">
	<h1 align="center" style="margin: 0">员工管理系统</h1>
	
	
	<!--表单区  -->
	<div class="search-form"  >
		<form action="employee/list" method="post">
			<fieldset>
				<legend align="center">查询区</legend>
				<div>
					<label for="employeeId">员工编号：</label><input type="text" name="employeeId" id="employeeId"
						value="${ssb.employeeId }">
				</div>
				<div>
					<label for="departmentId">部门编号：</label><input type="text" name="departmentId"
						id="departmentId" value="${ssb.departmentId }">  
				</div>
				<div>
					<label for="name">姓名：</label><input type="text" name="name"
						id="name" >
				</div>
				<div>
					<label for="salary">薪水：</label><input type="text" name="salary"
						id="salary" value="${ssb.phone }">
				</div>
				<div>
					<label for="birthdayRange">生日：</label><input type="text"
						name="birthdayRange" id="birthdayRange" autocomplete="off" >
				</div>
			</fieldset>


			<!-- 页码 -->
			<input type="hidden" name="pageNo">
			<!--  每页显示多少条数据-->
			<input type="hidden" name="pageSize" value="${pi.pageSize }">
		</form>
	</div>
		<!--  按钮操作区-->
		<div class="op">
			<ul>
				<li><a class="" href="employee/list">首页</a></li>
				<li><a class="add-btn" href="javascript:void(0)">添加</a></li>
				<li><a class="edit-btn" href="javascript:void(0)">修改</a></li>
				<li><a class="search-btn" href="javascript:void(0)">查询</a></li>
				<!-- <li><a href="javascript:void(0)">重置</a></li> -->
				<!-- <li><a id="del-btn" href="javascript:void(0)">删除</a></li> -->
				<li><a class="ajax-del-btn" href="javascript:void(0)"
					style="background-color: #FF6600;">删除</a></li>
			</ul>
		</div>


<!-- 删除表单 -->
		<div class="delete-form">
			<form action="employee/delete" method="post">
				<input type="hidden" name="deleteIds" />
			</form>
		</div>


		<!--数据显示区  -->
		<div class="data">
			<table id="tbl" align="center">
				<thead>
					<tr style="height: 20px">
						<th><input id="checkall" type="checkbox"></th>
						<th>编号</th>
						<th>员工编号</th>
						<th>姓名</th>
						<th>部门编号</th>
						<th>性别</th>
						<th>生日</th>
						<th>薪水</th>
						<th>电话</th>
						<th>部门名称</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employee }" var="ely">
						<tr>
							<td><input type="checkbox"></td>
							<td data-portrait="${ely.portrait}">${ely.id }</td>
							<td>${ely.employeeId}</td>
							<td>${ely.name }</td>
							<td>${ely.departmentId }</td>
							<td>${ely.sex }</td>
							<td>${ely.localBirthday }</td>
							<td>${ely.salary}</td>
							<td>${ely.phone}</td>
							<td>${ely.department.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 页码区 -->
		<div class="paginate">
			<span class="first"> <a href="javascript:void(0)">首页</a></span> <span
				class="prev"><a href="javascript:void(0)">上一页</a></span>
			<!-- 1 2 3 4 5 区 -->
			<ul>
				<c:forEach begin="${pi.navigateFirstPage }" end="${pi.navigateLastPage }"
					var="pi">

					<c:choose>
						<c:when test="${p==pageNum }">
							<li class="current"><a href="javascript:void(0)">${pi }</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:void(0)">${pi }</a></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>
			</ul>
			<span class="next"><a href="javascript:void(0)">下一页</a></span> <span
				class="last"><a href="javascript:void(0)">尾页</a></span>
			<!-- 页面大小下拉框 -->
			<select>
				<option selected="selected" value="3">3</option>
				<option value="2">2</option>
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="40">40</option>
			</select>
		</div>
	</div>
	
</body>
</html>