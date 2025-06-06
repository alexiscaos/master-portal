package com.dsp.master.core.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsp.master.core.service.AusenciaService;
import com.dsp.master.data.model.Ausencia;
import com.dsp.master.data.repository.AusenciaRepository;

@Service
@Transactional
public class AusenciaServiceImpl implements AusenciaService {
	
	@Autowired
	private AusenciaRepository ausenciaRepository;
	
	@Override
	public Ausencia guardar(Ausencia ausencia) {
    	return ausenciaRepository.save(ausencia);
	}

	@Override
	public Ausencia registrarAusencia(Integer id, Integer idEmpresa, BigDecimal tiempoAus,
			Integer motivoAus, String observacionesAus) {
		Ausencia ausencia = new Ausencia();
		ausencia.setIdUsuario(id);
		ausencia.setIdEmpresa(idEmpresa);
    	java.util.Date ahora = new java.util.Date();
    	ausencia.setFecha(new Date((ahora.getTime())));
    	ausencia.setTiempo(tiempoAus);
    	ausencia.setMotivoAusencia(motivoAus);
    	ausencia.setObservaciones(observacionesAus);
    	ausencia.setTraspasado(false);

    	return ausenciaRepository.save(ausencia);
	}
}
