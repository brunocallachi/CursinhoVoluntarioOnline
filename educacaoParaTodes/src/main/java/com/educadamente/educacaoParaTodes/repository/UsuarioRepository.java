package com.educadamente.educacaoParaTodes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educadamente.educacaoParaTodes.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
