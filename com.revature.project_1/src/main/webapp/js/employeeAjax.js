window.onload = function(){
	document.getElementById("ViewInformation").addEventListener("click", viewInformation);
}

function viewInformation(){
let spot = document.getElementById("EmployeePage");
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}
		
	}
	xhr.open("get", "/com.revature.project_1/ViewEmployeeInformation.ajax");
	xhr.send();
}