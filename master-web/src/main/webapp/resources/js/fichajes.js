var typingTimer;
function delayAjax(inputId) {
	
    clearTimeout(typingTimer);
    typingTimer = setTimeout(function () {
        PrimeFaces.ab({source: inputId, update: inputId});
    }, 1000); // Espera 1000ms antes de hacer la petición
}

function setLocation(){

	if (navigator.geolocation) {
		
		navigator.geolocation.getCurrentPosition(setPosition, showError);
	} else { 
		x.innerHTML = "Geolocation is not supported by this browser.";
	}
}


function setPosition(position) {
	
	if(document.getElementById("presenciaForm:latitudEntrada") != null){				
		
		console.log("entrada");
		
		document.getElementById("presenciaForm:latitudEntrada").value = position.coords.latitude;
		document.getElementById("presenciaForm:longitudEntrada").value = position.coords.longitude;
		
		document.getElementById("latitud").textContent = position.coords.latitude;
		document.getElementById("longitud").textContent = position.coords.longitude;
		
		//getAddress(position.coords.latitude, position.coords.longitude);
		
		document.getElementById("loader").style.display = "none";
		document.getElementById("loaderDiv").style.display = "block";
		//alert('entrada');
		
	} else {
		
		console.log("salida");
		
		document.getElementById("presenteForm:latitudSalida").value = position.coords.latitude;
		document.getElementById("presenteForm:longitudSalida").value = position.coords.longitude;
		
		document.getElementById("latitud").textContent = position.coords.latitude;
		document.getElementById("longitud").textContent = position.coords.longitude;
		
		//getAddress(position.coords.latitude, position.coords.longitude);
/*
		if(document.getElementById("cierreAutomatico").value == "ANTERIOR"){
			
			console.log("submit salida");
			
			document.getElementById("presenteForm:cierreAut").value = "S";
			
			console.log(document.getElementById("presenteForm:cierreAut").value);
			
			document.getElementById("presenteForm:btnSalvarTerminarPresencia").click();

		} else {
			console.log("salida 2");
			document.getElementById("presenteForm:cierreAut").value = "N";
		}

		//compruebo si hay que hacer el cierre aotomatico
*/
		document.getElementById("loader").style.display = "none";
		document.getElementById("loaderDiv").style.display = "block";
		
		//alert('salida');
	}

}

function showError(error) {
	switch(error.code) {
    	case error.PERMISSION_DENIED:
    		console.log("User denied the request for Geolocation.");
    		break;
		case error.POSITION_UNAVAILABLE:
			console.log("Location information is unavailable.");
			break;
		case error.TIMEOUT:
			console.log("The request to get user location timed out.");
			break;
		case error.UNKNOWN_ERROR:
			console.log("An unknown error occurred.");
		    break;
	}
	
	document.getElementById("loader").style.display = "none";
	document.getElementById("loaderDiv").style.display = "block";
	document.getElementById("jumbotron").style.display = "none";
}

window.onload = setLocation;
