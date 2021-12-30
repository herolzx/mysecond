<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 上下文 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>

<head>
<base href="${ctx }/">
<meta charset="UTF-8">
<title>修改员工</title>
<link rel="stylesheet" type="text/css" href="assets/employee/add.css">

<script type="text/javascript" language="javascript"
	src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>

<!-- 引入layer弹出 -->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/layer/layer.js"></script>
<!--引入选择日期  -->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/laydate/laydate.js"></script>

<!-- 接收后端传过来的数据 -->
<script type="text/javascript">
	var error = "${error}";
	var yy = "${emp.sex}";//是否预约是选择按钮，需要通过js来设置用户已经选择的值，
	//避免用户出错时再次选择
</script>
<!-- 引入自己的js -->
<script type="text/javascript" language="javascript"
	src="assets/employee/edit.js"></script>
</head>
<!-- 身体部分 -->
<body>
	<div class="container">
		<fieldset>
			<legend align="center">修改员工</legend>
			<form class="ware-return" action="employee/list" method="post">
				<div>
					<label></label>
					<button type="submit">返回列表</button>
				</div>
			</form>
			<form class="employee-form" action="employee/edit" method="post" enctype="multipart/form-data">
				<div>
					<label for="id">编号:</label> <input type="text"
						name="id" id="id" placeholder="编号"
						value="${emp.id}">
				</div>
				<div>
					<label for="employeeId">员工编号:</label> <input type="text"
						name="employeeId" id="employeeId" placeholder="请输入员工编号"
						value="${emp.employeeId}">
				</div>
				<div>
					<label for="name">员工姓名:</label> <input type="text" name="name"
						id="name" placeholder="请输入员工姓名" value="${emp.name}">
				</div>
				<div>
					<label for="departmentId">部门编号:</label> <input type="text" name="departmentId"
						id="departmentId" placeholder="请输入员工部门"
						value="${emp.departmentId}">
				</div>
				<div>
					<label for="birthday">出生日期:</label> <input type="text"
						name="birthday" id="birthday" placeholder="请选择出生日期"
						value="${emp.localBirthday}" autocomplete="off">
				</div>

				<div>
					<label for="phone">联系电话:</label> <input type="text" name="phone"
						id="phone" placeholder="请输入联系电话" value="${emp.phone}">
				</div>
				<div>
					<label for="salary">工资:</label> <input type="text" name="salary"
						id="salary" placeholder="请输入工资" value="${emp.salary}">
				</div>
				
				<div class="div-wrapper">
					<label>性别：</label>
					<div>
						<input type="radio" id="male" name="sex" value="男" checked="checked"> <label for="male">男</label>
					</div>

					<div>
						<input type="radio" id="female" name="sex" value="女"> <label for="female">女</label>
					</div>
				</div>
				
				
				<div>
					<label for="portrait-pic">上传头像:</label> <input type="file" name="portrait-pic"
						id="portrait-pic" placeholder="请输入工资" >
				</div>
				
				
				
				<div>
					<label></label>
					<button type="submit">提交</button>
					<button type="reset">重置</button>
				</div>
			</form>
		</fieldset>
	</div>
</body>
</html>