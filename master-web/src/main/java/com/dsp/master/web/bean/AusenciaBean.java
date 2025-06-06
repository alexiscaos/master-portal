package com.dsp.master.web.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dsp.master.core.service.AusenciaService;
import com.dsp.master.core.service.MotausService;
import com.dsp.master.core.service.UserService;
import com.dsp.master.data.model.Ausencia;
import com.dsp.master.data.model.Usuario;
import com.dsp.master.data.model.Motaus;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named ("ausenciaBean")
@SessionScoped
public class AusenciaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Inject
    @Named("userService") 
    private UserService userService;
    
    @Inject
    @Named("ausenciaService") 
    private AusenciaService ausenciaService;
    
    @Inject
    @Named("loginBean")
    private LoginBean loginBean; 
    
    @Inject
    @Named("motausService")
    private MotausService motausService;
    
	private Ausencia ausencia = new Ausencia();
    private  Map<String, Object> motivosAusencias;

	
	private String login;
	private Integer motaus;
	private String Observaciones;
	private BigDecimal horas;
	private BigDecimal minutos;
	private BigDecimal tiempoAus;
	private Integer motivoSeleccionado;

	@PostConstruct
	public void init() {
		login = loginBean.getUsername();
		
	}
    public void registrarAusencia() {

	    try {
	        Usuario usuario = userService.findByUserName(loginBean.getUsername());
	        
	        if (usuario != null) {
		        BigDecimal sixty = new BigDecimal(60);
		         minutos = minutos.divide(sixty, 2, RoundingMode.CEILING);
			        setTiempoAus(horas.add(minutos));
		         System.out.println(tiempoAus+"");
		         
				ausenciaService.registrarAusencia(usuario.getIdUsuario(), usuario.getEmpresaId(),tiempoAus, motivoSeleccionado, Observaciones);
	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	            
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
    
    
	public Map<String, Object> getMotivosAusencias() {
		
		motivosAusencias = new LinkedHashMap<String,Object>();

		Usuario usuario = userService.findByUserName(loginBean.getUsername());

    	if(usuario != null) {
    		List<Motaus> listaMotivosAusencias = motausService.findByIdEmpresa(usuario.getEmpresaId());

    		
    		for(Motaus m : listaMotivosAusencias) {
    			
    			motivosAusencias.put(m.getDescripcion(), m.getId());
    		}
    	}
    	
		return motivosAusencias;
	}
    
    
	public Ausencia getAusencia() {
		return ausencia;
	}
	public void setAusencia(Ausencia ausencia) {
		this.ausencia = ausencia;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getMotaus() {
		return motaus;
	}
	public void setMotaus(Integer motaus) {
		this.motaus = motaus;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public BigDecimal getHoras() {
		return horas;
	}
	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}
	public BigDecimal getMinutos() {
		return minutos;
	}
	public void setMinutos(BigDecimal minutos) {
		this.minutos = minutos;
	}
	public void setMotivosAusencias(Map<String, Object> motivosAusencias) {
		this.motivosAusencias = motivosAusencias;
	}
	public Integer getMotivoSeleccionado() {
		return motivoSeleccionado;
	}
	public void setMotivoSeleccionado(Integer motivoSeleccionado) {
		this.motivoSeleccionado = motivoSeleccionado;
	}
	public BigDecimal getTiempoAus() {
		return tiempoAus;
	}
	public void setTiempoAus(BigDecimal tiempoAus) {
		this.tiempoAus = tiempoAus;
	}
}
