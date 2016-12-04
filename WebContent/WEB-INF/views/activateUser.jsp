<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>User Activation</title>
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
			<h2 id="title">User Activation</h2>			
		</div>
	</div>
	<div class="container-fluid" id="register">
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="span8">
					<form action="/CMPE275FinalProject/activateUser" method="post">
						<div class="form-group" >
							<label for="ucode">Unique code</label> <input type="text"
							class="form-control" id="ucode" name="ucode" placeholder="unique code">
						</div>
						<button type="submit" class="btn btn-default" >Submit Details</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>