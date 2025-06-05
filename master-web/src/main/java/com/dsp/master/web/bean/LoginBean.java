package com.dsp.master.web.bean;

import java.io.Serializable;


import com.dsp.master.core.service.UserService;
import com.dsp.master.data.model.Usuario;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;


@Named ("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    @Inject
    @Named("userService") 
    private UserService userService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @PostConstruct
    public void init() {
        System.out.println("LoginBean inicializado. UserService: " + (userService != null ? "inyectado" : "NULL"));
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            // Lógica de autenticación usando el servicio
            Usuario user = userService.findByUserName(username);
            System.out.println(username);
            System.out.println(user.getId());

            if (user != null && user.getPassword().equals(password)) {
                // Inicio de sesión exitoso
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "¡Bienvenido!"));
                // Redirigir a la página principal (index.xhtml)
                context.getExternalContext().redirect("main.xhtml");
                return null;
            } else {
                // Inicio de sesión fallido
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrectos."));
                return null;
            }
        } catch (Exception e) {
            // Capturar excepciones para depuración
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al procesar la solicitud: " + e.getMessage()));
            return null;
        }
    }
}