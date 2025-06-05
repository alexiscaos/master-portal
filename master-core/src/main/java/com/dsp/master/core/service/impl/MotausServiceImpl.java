package com.dsp.master.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsp.master.core.service.MotausService;
import com.dsp.master.data.model.Motaus;
import com.dsp.master.data.repository.MotausRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MotausServiceImpl implements MotausService {
	@Autowired
	private MotausRepository motausRepository;
	
	@Override
	public List<Motaus> findByIdEmpresa(Integer idEmpresa) {
		return motausRepository.findByIdEmpresa(idEmpresa);
	}

}
