package com.dsp.master.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsp.master.data.model.Presencia;

@Repository
public interface PresenciaRepository extends JpaRepository <Presencia, Integer> {
    @Query("SELECT p FROM Presencia p WHERE p.id = (SELECT MAX(p2.id) FROM Presencia p2 WHERE p2.idUsuario = :id)")
    public Presencia findUltimaPresenciaUsuario(@Param("id") Integer id);
}
