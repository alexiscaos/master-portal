package com.dsp.master.web.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class CDIConfig {
	@PersistenceContext(unitName = "maestroPU")
	private EntityManager entityManager;
	
    
    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}