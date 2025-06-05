package com.dsp.master.data.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name="PRESENCIAS")
public class Presencia implements Serializable {

	private static final long serialVersionUID =1L;
	
    @Id
    @GeneratedValue
    @Column(name="idPresencia", nullable=false)
    private Integer id;
    
    @Column(name="idEmpresaPre", nullable=false)
    private Integer idEmpresa;
    
    @Column(name="idUsuarioPre", nullable=false)
    private Integer idUsuario;
    
	@Temporal(TemporalType.DATE)
    @Column(name="fechaEntradaPre", nullable=false)
    private Date fechaEntrada;
	
    @Temporal(TemporalType.DATE)
    @Column(name="fechaSalidaPre")
    private Date fechaSalida;
    
    @Column (name="latitudEntradaPre", length = 10, nullable=false)
    private String latitudEntrada;
    
    @Column (name="longitudEntradaPre", length = 10, nullable=false)
    private String longitudEntrada;
    
    @Column (name="latitudsalidaPre", length = 10)
    private String latitudSalida;
    
    @Column (name="longitudSalidaPre", length = 10)
    private String longitudSalida;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
