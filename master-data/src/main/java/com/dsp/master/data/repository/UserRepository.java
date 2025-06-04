package com.dsp.master.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsp.master.data.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.userName = :username")
     Usuario findByUserName(@Param("username") String username);
    
}