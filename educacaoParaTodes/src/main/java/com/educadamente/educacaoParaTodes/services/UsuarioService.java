package com.educadamente.educacaoParaTodes.services;

import java.util.Optional;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.educadamente.educacaoParaTodes.model.Usuario;
import com.educadamente.educacaoParaTodes.model.UsuarioLogin;
import com.educadamente.educacaoParaTodes.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		if(userRepository.findByEmail(usuario.getEmail()).isPresent() && usuario.getId() == 0) {
            return null;
        }
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return userRepository.save(usuario);
	}

	public Optional<UsuarioLogin> Login(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = userRepository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getId());
				user.get().setNome(usuario.get().getNome());
				user.get().setFoto(usuario.get().getFoto());
				user.get().setTipo(usuario.get().getTipo());

				return user;
			}
		}

		return Optional.empty();
	}

}
