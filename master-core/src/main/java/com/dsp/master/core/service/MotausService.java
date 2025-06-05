package com.dsp.master.core.service;

import java.util.List;

import com.dsp.master.data.model.Motaus;
public interface MotausService {
	public List<Motaus> findByIdEmpresa(Integer idEmpresa); 
}
