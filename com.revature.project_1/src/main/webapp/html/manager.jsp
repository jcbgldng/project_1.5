<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<nav>
			<div>
				<div>
					future logo
				</div>
				<div>
					<ul>
						<li>Future navbar</li>
					</ul>
				</div>
			</div>
		</nav>
		<button id="theName">boop</button>
		<button id="viewEmployees">View Employees</button>
    <button id="AllPendingRIMR"> View all Pending Request</button>
		<form id="EmployeeLogout" action="logOut.do" method="post">
      		<button type="submit">Log Out</button>
    	</form>
		<div id="spot">Hello</div>

		<script type="text/javascript" src="../js/managerAjax.js"></script>
	</body>
</html>
