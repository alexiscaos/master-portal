package com.dsp.master.core.service;


import com.dsp.master.data.model.Presencia;

public interface PresenciaService {
	
	public Presencia encontrarUltimaPresenciaUsuario(Integer id);
	
	public Presencia registrarEntrada(Integer id, Integer idEmpresa, String observaciones, String latitudEntrada, String longitudEntrada);
	
	public Presencia registrarSalida(Integer id, String observaciones, String latitudSalida, String longitudSalida);
	
	public Presencia guardar(Presencia presencia);
	
}
