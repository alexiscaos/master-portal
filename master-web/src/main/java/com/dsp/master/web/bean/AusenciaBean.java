package com.dsp.master.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dsp.master.core.service.AusenciaService;
import com.dsp.master.core.service.PresenciaService;
import com.dsp.master.core.service.UserService;
import com.dsp.master.data.model.Ausencia;
import com.dsp.master.data.model.Presencia;
import com.dsp.master.data.model.Usuario;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
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
    
	private Ausencia ausencia = new Ausencia();
	
	private String login;
	private Integer motaus;
	private String Observaciones;
	private BigDecimal horas;
	private BigDecimal minutos;

	@PostConstruct
	public void init() {
		login = loginBean.getUsername();
		
	}
    public void registrarAusencia() {
		Usuario usuario = userService.findByUserName(login);
		ausenciaService.registrarAusencia();
    	
    }
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
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
    
}
