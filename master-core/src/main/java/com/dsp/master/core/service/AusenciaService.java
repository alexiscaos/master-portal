package com.dsp.master.core.service;

import java.math.BigDecimal;
import java.util.Date;

import com.dsp.master.data.model.Ausencia;

public interface  AusenciaService {
	
	public Ausencia registrarAusencia(Integer id, Integer idEmpresa, BigDecimal tiempoAus, Integer motivoAus, String observacionesAus, Boolean traspasado);
	
	public Ausencia guardar(Ausencia ausencia);
}
