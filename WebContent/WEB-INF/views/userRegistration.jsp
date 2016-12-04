<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>User Registration</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h2 id="title">User Registration</h2>			
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="/CMPE275FinalProject/userRegistration" method="post">
						<div class="form-group" >
							<label for="email">Email</label> <input type="text"
							class="form-control" id="email" name="email" placeholder="Email">
						</div>
						<div class="form-group" >
							<label for="FisrtName">First Name</label> <input type="Text"
							class="form-control" id="firstName" name="firstName" placeholder="First Name">
						</div>
						<div class="form-group" >
							<label for="LastName">Last Name</label> <input type="Text"
							class="form-control" id="lastName" name="lastName" placeholder="Last Name">
						</div>
						<div class="form-group" >
							<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password" placeholder="Password">
						</div>
						<div class="form-group" >
							<label for="univid">University ID</label> <input type="text"
							class="form-control" id="univid" name="univid" placeholder="University ID">
						</div>
						<button type="submit" class="btn btn-default" >Submit Details</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>