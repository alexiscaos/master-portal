package com.dsp.master.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



@Entity
@Table (name="AUSENCIAS")
public class Ausencia implements Serializable{

	private static final long serialVersionUID =  1L;
	
    @Id
    @GeneratedValue
    @Column(name="idAus", nullable=false)
    private Integer id;
    
    @Column(name="idEmpresaAus", nullable=false)
    private Integer empresaId;
    
    @Column(name="idUsuarioAus", nullable=false)
    private Integer usuarioId;
    
    @Column(name="fechaAus", nullable=false)
    private Date fecha;
    
    @Column(name="tiempoAus", nullable=false)
    private BigDecimal tiempo;
    
    @Column(name="motivo_ausenciaAus", nullable=false)
    private Integer motivoAusencia;
    
    @Column (name="observacionesAus", length = 80)
    private String observaciones;
    
    @Column (name="traspasadoAus", length = 1)
    private Boolean traspasado;
    
    @Transient
    private String latitud;
    
    @Transient
    private String longitud;
    
    @Transient
    private BigDecimal horas;
    
    @Transient
    private BigDecimal minutos;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEmpresa() {
		return empresaId;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.empresaId = idEmpresa;
	}

	public Integer getIdUsuario() {
		return usuarioId;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.usuarioId = idUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTiempo() {
		return tiempo;
	}

	public void setTiempo(BigDecimal tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getMotivoAusencia() {
		return motivoAusencia;
	}

	public void setMotivoAusencia(Integer motivoAusencia) {
		this.motivoAusencia = motivoAusencia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Boolean getTraspasado() {
		return traspasado;
	}

	public void setTraspasado(Boolean traspasado) {
		this.traspasado = traspasado;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
