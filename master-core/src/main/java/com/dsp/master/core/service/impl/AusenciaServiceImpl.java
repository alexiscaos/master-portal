package com.dsp.master.core.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.dsp.master.core.service.AusenciaService;
import com.dsp.master.data.model.Ausencia;
import com.dsp.master.data.repository.AusenciaRepository;
import com.dsp.master.data.repository.PresenciaRepository;

public class AusenciaServiceImpl implements AusenciaService {
	
	@Autowired
	private AusenciaRepository ausenciaRepository;
	@Override
	public Ausencia guardar(Ausencia ausencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ausencia registrarAusencia(Integer id, Integer idEmpresa, BigDecimal tiempoAus,
			Integer motivoAus, String observacionesAus, Boolean traspasado) {
		Ausencia ausencia = new Ausencia();
		ausencia.setIdUsuario(id);
		ausencia.setIdEmpresa(idEmpresa);
    	java.util.Date ahora = new java.util.Date();
    	ausencia.setFecha(new Date((ahora.getTime())));
    	ausencia.setMinutos(tiempoAus);
    	ausencia.setMotivoAusencia(motivoAus);
    	ausencia.setObservaciones(observacionesAus);
    	ausencia.setTraspasado(traspasado);

    	return ausenciaRepository.save(ausencia);
	}
}
