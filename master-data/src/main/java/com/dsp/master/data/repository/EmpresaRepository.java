package com.dsp.master.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsp.master.data.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Integer>{

}
