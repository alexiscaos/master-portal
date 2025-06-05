package com.dsp.master.data.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="MOTAUS")
public class Motaus implements Serializable{
	
	private static final long serialVersionUID =  1L;
	
    @Id
    @Column(name="idMau", nullable=false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="idEmp", referencedColumnName="idEmp", nullable=false)
    private Empresa empresa;
    
    @Column (name="descripcionMau", length = 25)
    private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
