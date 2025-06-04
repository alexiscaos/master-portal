var typingTimer;
function delayAjax(inputId) {
	
    clearTimeout(typingTimer);
    typingTimer = setTimeout(function () {
        PrimeFaces.ab({source: inputId, update: inputId});
    }, 1000); // Espera 1000ms antes de hacer la petición
}

function setLocation(){
	document.getElementById("loader").innerHTML = "Obteniendo su ubicación...";
	
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(setPosition, showError);
	} else { 
		document.getElementById("loader").innerHTML = "La geolocalización no está soportada en este navegador.";
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
		
		//compruebo si hay que hacer el cierre aotomatico
		if(document.getElementById("cierreAutomatico").value == "ANTERIOR"){
			
			console.log("submit salida");
			
			document.getElementById("presenteForm:cierreAut").value = "S";
			
			console.log(document.getElementById("presenteForm:cierreAut").value);
			
			document.getElementById("presenteForm:btnSalvarTerminarPresencia").click();

		} else {
			console.log("salida 2");
			document.getElementById("presenteForm:cierreAut").value = "N";
		}
		
		document.getElementById("loader").style.display = "none";
		document.getElementById("loaderDiv").style.display = "block";
		
		//alert('salida');
	}

}

function showError(error) {
	switch(error.code) {
    	case error.PERMISSION_DENIED:
    		document.getElementById("loader").innerHTML = "Usuario ha denegado el permiso de geolocalización.";
    		break;
		case error.POSITION_UNAVAILABLE:
			document.getElementById("loader").innerHTML = "La información de ubicación no está disponible.";
			break;
		case error.TIMEOUT:
			document.getElementById("loader").innerHTML = "La solicitud de geolocalización ha expirado.";
			break;
		case error.UNKNOWN_ERROR:
			document.getElementById("loader").innerHTML = "Ha ocurrido un error desconocido.";
		    break;
	}
	
	setTimeout(function() {
		document.getElementById("loader").style.display = "none";
		document.getElementById("loaderDiv").style.display = "block";
	}, 3000);
}

window.onload = setLocation;
