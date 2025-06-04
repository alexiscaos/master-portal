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
    @Column(name="id_aus", nullable=false)
    private Integer id;
    
    @Column(name="id_empresa_aus", nullable=false)
    private Integer idEmpresa;
    
    @Column(name="id_usuario_aus", nullable=false)
    private Integer idUsuario;
    
    @Column(name="fecha_aus", nullable=false)
    private Date fecha;
    
    @Column(name="tiempo_aus", nullable=false)
    private BigDecimal tiempo;
    
    @Column(name="motivo_ausencia_aus", nullable=false)
    private Integer motivoAusencia;
    
    @Column (name="observaciones_aus", length = 80)
    private String observaciones;
    
    @Column (name="traspasado_aus", length = 1)
    private String traspasado;
    
    @Transient
    private String latitud;
    
    @Transient
    private String longitud;
    
    @Transient
    private BigDecimal horas;
    
    @Transient
    private BigDecimal minutos;
    
	public Ausencia() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
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

	public String getTraspasado() {
		return traspasado;
	}

	public void setTraspasado(String traspasado) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((horas == null) ? 0 : horas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		result = prime * result + ((minutos == null) ? 0 : minutos.hashCode());
		result = prime * result + ((motivoAusencia == null) ? 0 : motivoAusencia.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
		result = prime * result + ((traspasado == null) ? 0 : traspasado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ausencia other = (Ausencia) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (horas == null) {
			if (other.horas != null)
				return false;
		} else if (!horas.equals(other.horas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		if (minutos == null) {
			if (other.minutos != null)
				return false;
		} else if (!minutos.equals(other.minutos))
			return false;
		if (motivoAusencia == null) {
			if (other.motivoAusencia != null)
				return false;
		} else if (!motivoAusencia.equals(other.motivoAusencia))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		if (traspasado == null) {
			if (other.traspasado != null)
				return false;
		} else if (!traspasado.equals(other.traspasado))
			return false;
		return true;
	}

}
