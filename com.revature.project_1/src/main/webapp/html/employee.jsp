<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Employee Page</title>
</head>
	<body>
	    <form id="EmployeeLogout" action="logOut.do" method="post">
	      <button type="submit">Log Out</button>
	    </form>
		<p>Place holder</p>

		<button id="ViewInformation">View Information</button>
    	<button id="GetChangeInformationForm">Change Information</button>
    	<button id="GetRimForm">Create RIMR</button>
		<div id="EmployeePage">
      		<p>This should change</p>
    	</div>

    	<script type="text/javascript" src="../js/employeeAjax.js"></script>
	</body>
</html>
