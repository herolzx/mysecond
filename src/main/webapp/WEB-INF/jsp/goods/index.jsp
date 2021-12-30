<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${ctx }/">
<meta charset="UTF-8">
<title>登录页</title>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.0-dist/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<!--[if it IE 9]>
	<script src="html5shiv/html5shiv.js"></script>
    <script src="respond/respond.js"></script>
<![end if]-->
<!--<script src="jq/jquery.min.1.11.js"></script>-->
<script src="jq/jquery-3.1.1.min.js"></script>
<script src="jq/jquery.flexslider-min.js"></script>
<script src="bootstrap-3.3.0-dist/dist/js/bootstrap.min.js"></script>
	
</head>
<body>
	<!--  url(assets/images/bg.jpg)   -->
	<div class="bg" style="background:"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				
				<form action="login" method="post">
					<div class="panel loginbox"
						style="background: url(assets/images/tmbg-white.png)">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="username"
										placeholder="登录账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							
								<div class="form-group">
									<div class="field">
										<input type="text" class="input input-big" name="captchas" 
											placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
										<img id="captcha" src="captcha" alt="" width="100"
										height="32" class="passcode"
										style="height: 43px; cursor: pointer;"
										onclick="this.src=this.src+'?'">
									</div>
								</div>
							
						</div>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>