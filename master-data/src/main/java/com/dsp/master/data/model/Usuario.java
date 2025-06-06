package com.dsp.master.data.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column (name="loginUsuario", nullable = false, length = 60 )
    private String loginUsuario;
       
    @Column(nullable = false)
    private String password;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "idEmpresaUser")
    private Integer empresaId;



	public Usuario() {
    }
    
    public Usuario(String userName, String password) {
        this.loginUsuario = userName;
        this.password = password;
    }

    public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	@Override
    public String toString() {
        return "User [id=" + idUsuario + ", userName=" + loginUsuario + "]";
    }
}