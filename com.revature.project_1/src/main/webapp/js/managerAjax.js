window.onload = function(){
	loggedIn();
	document.getElementById("theName").addEventListener("click", printFirstandLast);
	document.getElementById("viewEmployees").addEventListener("click", viewEmployees);
	document.getElementById("AllPendingRIMR").addEventListener("click", getAllPendingRIMR);
	document.getElementById("AllResolvedRIMR").addEventListener("click", getAllResolvedRIMR);
}

function loggedIn(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if( (xhr.status === 404) ){
			window.location.href = "http://localhost:8080/com.revature.project_1/html/index.html";
		}

	}
	xhr.open("post", "/com.revature.project_1/Manager.do", true);
	xhr.send();

}

function printFirstandLast(){
	let spot = document.getElementById("spot");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("get", "/com.revature.project_1/UserFisrtName.ajax");
	xhr.send();

}

function viewEmployees(){
	let spot = document.getElementById("spot");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("get", "/com.revature.project_1/viewEmployees.ajax");
	xhr.send();

}
function getAllPendingRIMR() {
	let spot = document.getElementById("spot");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("get", "/com.revature.project_1/getAllPendingRIMR.ajax");
	xhr.send();
}

function getAllResolvedRIMR() {
	let spot = document.getElementById("spot");
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("get", "/com.revature.project_1/getAllResolvedRIMR.ajax");
	xhr.send();
}
function AppoveRIMR(id) {
	let spot = document.getElementById("spot");
	let data = "";
	data = data.concat("RIMR_id=").concat(id.innerHTML);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("post", "/com.revature.project_1/appoveRIMR.ajax", true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function RejectRIMR(id) {
	let spot = document.getElementById("spot");
	let data = "";
	data = data.concat("RIMR_id=").concat(id.innerHTML);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if( (xhr.readyState === 4) & (xhr.status === 200) ){
			spot.innerHTML = xhr.responseText;
		}

	}
	xhr.open("post", "/com.revature.project_1/rejectRIMR.ajax", true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}
