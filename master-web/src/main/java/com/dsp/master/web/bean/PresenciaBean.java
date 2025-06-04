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
	
	
	@PostConstruct
	public void init() {
		this.presenciaBool = false;
		login = loginBean.getUsername();
		
	}
	
	public void checkPresencia() {
		
		Usuario usuario = userService.findByUserName(login);
		System.out.println(usuario.getId());
		Presencia ultimaPresencia = presenciaService.encontrarUltimaPresenciaUsuario(3);
		
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
 
	            
	            presenciaService.registrarEntrada(usuario.getId(),1, estadoRegistro, 
	            		(latitudEntrada.length()<=10 ? latitudEntrada : latitudEntrada.substring(0, 10) ), 
	            		longitudEntrada.length()<=10 ? longitudEntrada : longitudEntrada.substring(0, 10)
	            		);
	            
	        	this.presenciaBool = false;
	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            ec.redirect(ec.getRequestContextPath() + "/presenciaRegistrada.xhtml");
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

		    	presenciaService.registrarSalida(usuario.getId(), null,(
		    			latitudEntrada.length()<=10 ? latitudEntrada : latitudEntrada.substring(0, 10) ), 
	            		longitudEntrada.length()<=10 ? longitudEntrada : longitudEntrada.substring(0, 10)
	            		);
				this.estadoRegistro = "Registrar  presencia (ENTRADA)";

	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            ec.redirect(ec.getRequestContextPath() + "/presenciaRegistrada.xhtml");
	        } else {
	            FacesContext.getCurrentInstance().addMessage(null, 
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no encontrado"));
	        }
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	
	
	
}
