<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela! |</title>

<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Animate.css -->
<link href="../vendors/animate.css/animate.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../css/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form id="loginForm" action="login" method="post">
						<h1>Login Form</h1>
						<div>
							<input name="username" type="text" class="form-control" placeholder="Username"
								required="" />
						</div>
						<div>
							<input name="password" type="password" class="form-control"
								placeholder="Password" required="" />
						</div>
						<div>
							<input class="btn btn-default submit" name="submit" type="submit" value="Log in"></input>
							<a class="reset_pass" href="#">Lost your password?</a>
						</div>

						<div class="clearfix"></div>

						<div class="separator">
							<!--                 <p class="change_link">New to site?
                  <a href="#signup" class="to_register"> Create Account </a>
                </p> -->

							<div class="clearfix"></div>
							<br />

							<div>
								<!-- <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1> -->
								<p>©2016 All Rights Reserved. Gentelella Alela! is a
									Bootstrap 3 template. Privacy and Terms</p>
							</div>
						</div>
					</form>
				</section>
			</div>

			<div id="register" class="animate form registration_form">
				<section class="login_content">
					<form>
						<h1>Create Account</h1>
						<div>
							<input type="text" class="form-control" placeholder="Username"
								required="" />
						</div>
						<div>
							<input type="email" class="form-control" placeholder="Email"
								required="" />
						</div>
						<div>
							<input type="password" class="form-control"
								placeholder="Password" required="" />
						</div>
						<div>
							<a class="btn btn-default submit" href="index.html">Submit</a>
						</div>

						<div class="clearfix"></div>

						<div class="separator">
							<p class="change_link">
								Already a member ? <a href="#signin" class="to_register">
									Log in </a>
							</p>

							<div class="clearfix"></div>
							<br />

							<div>
								<h1>
									<i class="fa fa-paw"></i> Gentelella Alela!
								</h1>
								<p>Â©2016 All Rights Reserved. Gentelella Alela! is a
									Bootstrap 3 template. Privacy and Terms</p>
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../vendors/jquery/dist/jquery.min.js"></script>
<script type="text/javascript">
/* 	function login() {
		var user_name = $("user_name").val();
		var pass_word = $("pass_word").val;
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/login/check",
			dataType : 'text',
			success : function(data) {
				if ("0" != data) {
					alert(data);
					window.location.href = "${pageContext.request.contextPath}/index";
				} else {
					loginError();
				}
			},
			error : function() {
				alert("异常");
			}
		});
	} */
</script>
</html>
