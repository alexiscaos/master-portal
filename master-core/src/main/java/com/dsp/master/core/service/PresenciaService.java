package com.dsp.master.core.service;


import com.dsp.master.data.model.Presencia;

public interface PresenciaService {
	
	public Presencia encontrarUltimaPresenciaUsuario(Integer id);
	
	public Presencia registrarEntrada(Integer id, Integer idEmpresa, String observaciones, String coordEnt);
	
	public Presencia registrarSalida(Integer id, String observaciones, String coordSal);
	
	public Presencia guardar(Presencia presencia);
	
}
