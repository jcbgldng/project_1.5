<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Manager page</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="../css/index.css">
	</head>
	<body>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="/com.revature.project_1/html/manager.jsp">Manager Page</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <button id="viewEmployees">View Employees</button>
		      </li>
		      <li class="nav-item">
		        <button id="AllPendingRIMR"> View all Pending Request</button>
		      </li>
		      <li class="nav-item">
		        <button id="AllResolvedRIMR"> View all Resolved Request</button>
		      </li>
		    </ul>
		    <form id="EmployeeLogout" action="logOut.do" method="post">
      			<button type="submit">Log Out</button>
    		</form>
		  </div>
		</nav>
		
		<div class="d-flex justify-content-center" id="spot">
			<p> Welcome Manager Please select a action you with to complete</p>
		</div>

		<script type="text/javascript" src="../js/managerAjax.js"></script>
	</body>
</html>
