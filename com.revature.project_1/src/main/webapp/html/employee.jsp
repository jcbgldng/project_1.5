<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Page</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="../css/index.css">
	</head>
	<body>
		
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="/com.revature.project_1/html/employee.jsp">Employee Page</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <button id="ViewInformation">View Information</button>
		      </li>
		      <li class="nav-item">
		        <button id="GetChangeInformationForm">Change Information</button>
		      </li>
		      <li class="nav-item">
		        <button id="GetRimForm">Create RIMR</button>
		      </li>
		      <li class="nav-item">
		        <button id="PendingRIMR">Pending Requests</button>
		      </li>
		      <li class="nav-item">
		        <button id="ResolvedRIMR">Resolved Requests</button>
		      </li>
		    </ul>
		    <form id="EmployeeLogout" class="form-inline my-2 my-lg-0" action="logOut.do" method="post">
	      		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log Out</button>
	    	</form>
		  </div>
		</nav>

		<div class="d-flex justify-content-center" id="EmployeePage">
      		<p>Click on of the Buttons to Display Different Information</p>
    	</div>

    	<script type="text/javascript" src="../js/employeeAjax.js"></script>
	</body>
</html>
