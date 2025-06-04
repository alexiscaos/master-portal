package com.dsp.master.core.service.impl;

import java.sql.Date;
import java.time.LocalDateTime;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsp.master.core.service.PresenciaService;
import com.dsp.master.data.model.Presencia;
import com.dsp.master.data.repository.PresenciaRepository;

@Service
@Transactional
public class PresenciaServiceImpl implements PresenciaService {
	
	@Autowired
	private PresenciaRepository presenciaRepository;
	
    @Override
    public Presencia encontrarUltimaPresenciaUsuario(Integer id){
		return presenciaRepository.findUltimaPresenciaUsuario(id);
	}
    
    @Override
    public Presencia registrarEntrada(Integer id, Integer idEmpresa, String observaciones, String latitudEntrada, String longitudEntrada) {
    	Presencia presencia = new Presencia();
    	presencia.setIdUsuario(id);
    	presencia.setIdEmpresa(idEmpresa);
    	
    	java.util.Date ahora = new java.util.Date();
    	presencia.setFechaEntrada(new Date((ahora.getTime())));
    	presencia.setLatitudEntrada(latitudEntrada);
    	presencia.setLongitudEntrada(longitudEntrada);
    	
    	return presenciaRepository.save(presencia);

    }

	@Override
	public Presencia registrarSalida(Integer id, String observaciones, String latitudSalida, String longitudSalida) {
		Presencia ultimaPresencia = encontrarUltimaPresenciaUsuario(id);
		
		if(ultimaPresencia != null && ultimaPresencia.getFechaSalida() ==null) {
			java.util.Date ahora = new java.util.Date();
			ultimaPresencia.setFechaSalida(new Date(ahora.getTime()));
			
	    	ultimaPresencia.setLatitudSalida(latitudSalida);
	    	ultimaPresencia.setLongitudSalida(longitudSalida);
			return presenciaRepository.save(ultimaPresencia);
		}
		
		return null;
	}

	@Override
	public Presencia guardar(Presencia presencia) {
		return presenciaRepository.save(presencia);
	}
    
    
    
    
}
