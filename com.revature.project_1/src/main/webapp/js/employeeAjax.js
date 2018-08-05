window.onload = function(){
	loggedIn();
	document.getElementById("ViewInformation").addEventListener("click", viewInformation);
	document.getElementById("GetChangeInformationForm").addEventListener("click", GetChangeInformationForm);
	document.getElementById("GetRimForm").addEventListener("click", getRIMRForm);
}

function loggedIn(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if( (xhr.status === 404) ){
			window.location.href = "http://localhost:8080/com.revature.project_1/html/index.html";
		}else if( (xhr.status === 200) ){

		}

	}
	xhr.open("post", "/com.revature.project_1/Employee.do", true);
	xhr.send();

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

function GetChangeInformationForm(){
	let spot = document.getElementById("EmployeePage");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("get", "/com.revature.project_1/GetChangeForm.ajax");
	xhr.send();
}
function ChangeEmployeeInformation(){
	let spot = document.getElementById("EmployeePage");
	let formData = document.getElementById("UserInformationForm").elements;
	let data = "";
	data = data.concat("FirstName=").concat(formData.FirstName.value);
	data = data.concat("&LastName=").concat(formData.LastName.value);
	data = data.concat("&Address=").concat(formData.Address.value);
	data = data.concat("&Phone=").concat(formData.Phone.value);
	data = data.concat("&Email=").concat(formData.Email.value);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("post", "/com.revature.project_1/UpdateEmployeeInformation.ajax", true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function getRIMRForm() {
	let spot = document.getElementById("EmployeePage");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("get", "/com.revature.project_1/GetRIMRForm.ajax");
	xhr.send();
}

function createRIMRForm() {
	let spot = document.getElementById("EmployeePage");
	let formData = document.getElementById("RIMRForm").elements;
	let data = "";
	data = data.concat("Amount=").concat(formData.Amount.value);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("post", "/com.revature.project_1/CreateRimR.ajax", true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}
