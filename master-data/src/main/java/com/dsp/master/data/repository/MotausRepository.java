package com.dsp.master.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsp.master.data.model.Motaus;

@Repository
public interface MotausRepository extends JpaRepository<Motaus, Integer> {

    @Query("SELECT ma FROM Motaus ma WHERE ma.empresa.idEmpresa = :idEmpresa")
    public List<Motaus> findByIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
}
