package com.dsp.master.data.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name="PRESENCIAS")
public class Presencia implements Serializable {

	private static final long serialVersionUID =1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPresencia", nullable=false)
    private Integer idPresencia;
    
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
    
	@Column (name="coordEntPre", length = 23, nullable=false)
    private String coordEnt;
    
    @Column (name="coordSalPre", length = 23)
    private String coordSal;
    
    
    public String getCoordEnt() {
		return coordEnt;
	}

	public void setCoordEnt(String coordEnt) {
		this.coordEnt = coordEnt;
	}

	public String getCoordSal() {
		return coordSal;
	}

	public void setCoordSal(String coordSal) {
		this.coordSal = coordSal;
	}
    
    public Integer getId() {
		return idPresencia;
	}

	public void setId(Integer id) {
		this.idPresencia = id;
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

	public Integer getIdPresencia() {
		return idPresencia;
	}

	public void setIdPresencia(Integer idPresencia) {
		this.idPresencia = idPresencia;
	}


	
}
