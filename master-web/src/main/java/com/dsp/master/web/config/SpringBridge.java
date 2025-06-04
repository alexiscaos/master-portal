package com.dsp.master.web.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dsp.master.core.service.PresenciaService;
import com.dsp.master.core.service.UserService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;

@ApplicationScoped
public class SpringBridge {

    private WebApplicationContext getSpringContext() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
        return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
    

    @Produces
    @Named("userService")
    @ApplicationScoped
    public UserService getUserService() {
        return getSpringContext().getBean(UserService.class);
    }
    
    
    @Produces
    @Named("presenciaService")
    @ApplicationScoped
    public PresenciaService getPresenciaService() {
        return getSpringContext().getBean(PresenciaService.class);
    }
    
}