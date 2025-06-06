package com.dsp.master.web.bean;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import com.dsp.master.core.service.PresenciaService;
import com.dsp.master.core.service.UserService;
import com.dsp.master.data.model.Presencia;
import com.dsp.master.data.model.Usuario;

@Named ("presenciaBean")
@SessionScoped
public class PresenciaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Inject
    @Named("userService") 
    private UserService userService;
    
    @Inject
    @Named("presenciaService") 
    private PresenciaService presenciaService;
	
    
    @Inject
    @Named("loginBean")
    private LoginBean loginBean; 
    
	private Presencia presencia = new Presencia();
	
	private Boolean presenciaBool;
	
	private String infoPresencia;
	
	private String presenciaEstado;
	
	private String estadoRegistro;
	
	private String login;
	

	private String latitudEntrada;
	
	private String longitudEntrada;
	
	private String latitudSalida;
	
	private String longitudSalida;
	private String presenciaObserv;
	
	
	@PostConstruct
	public void init() {
		this.presenciaBool = false;
		login = loginBean.getUsername();
		
	}
	
	public void checkPresencia() {
		
		Usuario usuario = userService.findByUserName(login = loginBean.getUsername()
);
		Presencia ultimaPresencia = presenciaService.encontrarUltimaPresenciaUsuario(usuario.getIdUsuario());
		
		if((ultimaPresencia==null) || (ultimaPresencia!=null && ultimaPresencia.getFechaSalida()!=null)) {
			System.out.println("USUARIO NO PRESENTE");
			this.presenciaBool=true;
			this.presenciaEstado = "Registrar  presencia (ENTRADA)";
		}else {
	      	System.out.println("USUARIO PRESENTE");
        	this.presenciaBool = false;
			this.presenciaEstado = "Terminar presencia (SALIDA)";
        	this.infoPresencia = "Presencia registrada el " + ultimaPresencia.getFechaEntrada() + " a las " + ultimaPresencia.getFechaEntrada();
		}
		
	}
	
	public void registrarPresencia() {
	    try {
	        Usuario usuario = userService.findByUserName(loginBean.getUsername());
	        
	        if (usuario != null) {
 
	            
	            presenciaService.registrarEntrada(usuario.getIdUsuario(),1, estadoRegistro, concatenaCoords(latitudEntrada, longitudEntrada));
	        	this.presenciaBool = false;
	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            ec.redirect(ec.getRequestContextPath() + "/views/presenciaRegistrada.xhtml");

	        } else {
	            FacesContext.getCurrentInstance().addMessage(null, 
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no encontrado"));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, 
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
	    }
	}
	
	public void terminarPresencia() {
		try {
	        Usuario usuario = userService.findByUserName(loginBean.getUsername());

	    	
	    	if (usuario != null) {

		    	presenciaService.registrarSalida(usuario.getIdUsuario(), presenciaObserv, concatenaCoords(latitudSalida, longitudSalida));
				this.estadoRegistro = "Registrar  presencia (ENTRADA)";

	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            ec.redirect(ec.getRequestContextPath() + "/views/presenciaRegistrada.xhtml");


	        } else {
	            FacesContext.getCurrentInstance().addMessage(null, 
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no encontrado"));
	        }
	    	
		} catch (Exception e) {

		}
	}
	
	public String salir() throws IOException {
	    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

	    context.invalidateSession();

	    context.redirect(context.getRequestContextPath() + "/login.xhtml");

	    FacesContext.getCurrentInstance().responseComplete();
	    return null;
	}

	private String concatenaCoords(String latitud, String longitud) {
		
		if(latitud.length()>=10) {
			latitud= latitud.substring(0, 10) ;
		}
		
		if(longitud.length()>=10) {
			longitud= longitud.substring(0, 10) ;
		}
		
		System.out.println(latitud+", "+longitud);
		
		return  latitud+", "+longitud;
	}

	public Presencia getPresencia() {
		return presencia;
	}

	public void setPresencia(Presencia presencia) {
		this.presencia = presencia;
	}

	public Boolean getPresenciaBool() {
		return presenciaBool;
	}

	public void setPresenciaBool(Boolean presenciaBool) {
		this.presenciaBool = presenciaBool;
	}

	public String getInfoPresencia() {
		return infoPresencia;
	}

	public void setInfoPresencia(String infoPresencia) {
		this.infoPresencia = infoPresencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPresenciaEstado() {
		return presenciaEstado;
	}

	public void setPresenciaEstado(String presenciaEstado) {
		this.presenciaEstado = presenciaEstado;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLatitudEntrada() {
		return latitudEntrada;
	}

	public void setLatitudEntrada(String latitudEntrada) {
		this.latitudEntrada = latitudEntrada;
	}

	public String getLongitudEntrada() {
		return longitudEntrada;
	}

	public void setLongitudEntrada(String longitudEntrada) {
		this.longitudEntrada = longitudEntrada;
	}

	public String getLatitudSalida() {
		return latitudSalida;
	}

	public void setLatitudSalida(String latitudSalida) {
		this.latitudSalida = latitudSalida;
	}

	public String getLongitudSalida() {
		return longitudSalida;
	}

	public void setLongitudSalida(String longitudSalida) {
		this.longitudSalida = longitudSalida;
	}

	public String getPresenciaObserv() {
		return presenciaObserv;
	}

	public void setPresenciaObserv(String presenciaObserv) {
		this.presenciaObserv = presenciaObserv;
	}
	
	
	
}
