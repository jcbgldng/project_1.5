window.onload = function(){
	document.getElementById("theName").addEventListener("click", printFirstandLast);
	document.getElementById("viewEmployees").addEventListener("click", viewEmployees);
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