package com.dsp.master.data.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPRESAS")
public class Empresa implements Serializable {
	private static final long serialVersionUID =  1L;
	
	@Id
    @Column(name="idEmp", nullable=false)
    private Integer idEmpresa;
    
    @Column (name="nombrEmp", length = 80 )
    private String nombre;
    
    @Column (name="ausenciasEmp", length = 1 )
    private String ausencias;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAusencias() {
		return ausencias;
	}

	public void setAusencias(String ausencias) {
		this.ausencias = ausencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
