package com.dsp.master.core.service.impl;

import com.dsp.master.core.service.UserService;
import com.dsp.master.data.model.Usuario;
import com.dsp.master.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Usuario findByUserName(String userName) {
        System.out.println("Buscando usuario con nombre: [" + userName + "]");
        Usuario usuario = userRepository.findByLoginUsuario(userName);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
        } else {
            System.out.println("Usuario encontrado: " + usuario);
        }
        return usuario;    
    }
}