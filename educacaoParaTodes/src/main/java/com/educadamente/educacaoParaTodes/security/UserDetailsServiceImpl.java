package com.educadamente.educacaoParaTodes.security;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.educadamente.educacaoParaTodes.model.Usuario;
import com.educadamente.educacaoParaTodes.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario>user = userRepository.findByEmail(username);
		user.orElseThrow(()-> new UsernameNotFoundException(username + "Usuário não encontrado"));
		//return null;
	    return user.map(UserDetailsImpl::new).get(); 
	}

}
