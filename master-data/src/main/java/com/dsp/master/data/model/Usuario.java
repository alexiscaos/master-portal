package com.dsp.master.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "userName", nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String password;
    
    @Column (name="loginUsuario", nullable = false, length = 60 )
    private String loginUsuario;
    
    @Column(name = "idEmpresaUser")
    private Integer idEmpresa;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

	public Usuario() {
    }
    
    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) 	{
		this.loginUsuario = loginUsuario;
	}
    
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + "]";
    }
}