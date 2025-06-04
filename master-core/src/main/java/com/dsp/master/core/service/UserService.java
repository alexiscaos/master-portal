package com.dsp.master.core.service;


import com.dsp.master.data.model.Usuario;

public interface UserService {

	public Usuario findByUserName(String userName);
}
