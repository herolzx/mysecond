<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${ctx }/">
<meta charset="UTF-8">
<c:choose>
	<c:when test="${title != null }">
		<title>${title }</title>
	</c:when>
	 <c:otherwise>
	 	<title>异常或错误信息</title>
	 </c:otherwise>
</c:choose>
<!-- 引入弹框 -->
<link rel="stylesheet" type="text/css" href="assets/public/lib/layui/css/layui.css" />
<script type="text/javascript" src="assets/public/lib/layui/layui.js"></script>
<style type="text/css">
.title {
	margin: 15px;
}
</style>
<!-- 接收数据 -->
<script type="text/javascript">
	var error = "${error}";
</script>
</head>
<body>
<!-- 显示错误信息 -->
	<c:choose>
		<c:when test="${error != null}">
			<h3 class="title">${error }</h3>
		</c:when>
		<c:otherwise>
			<h3>请求的操作异常，请联系管理员</h3>
		</c:otherwise>
	</c:choose>
	
	<!-- 隐藏异常信息 -->
	<c:if test="${exception != null}">
		<div style="display: none;">${exception }</div>
	</c:if>
	<!-- 弹出框提示 popup是布尔值 -->
	<script type="text/javascript">
		var ctx = "${ctx}";
		//是否弹出
		var popup = "${popup}";
		var fallbackUrl = "${fallbackUrl}";

		layui.use([ "layer", "jquery" ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;

			if (popup) {
				//错误信息
				var msg = $("h3.title").text();

				layer.alert(msg, function(idx) {
					//关闭弹出框
					layer.close(idx);
					//如果有跳转url，则跳转
					if (fallbackUrl) {
						location.href = ctx + "/" + fallbackUrl;
					}
				});
			}
		});
	</script>
	
</body>
</html>