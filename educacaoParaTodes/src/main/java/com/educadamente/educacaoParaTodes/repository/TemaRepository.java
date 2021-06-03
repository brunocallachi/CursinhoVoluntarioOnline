package com.educadamente.educacaoParaTodes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educadamente.educacaoParaTodes.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer>{
	public List<Tema> findAllByDescricaoContainingIgnoreCase (String descricao);
	
}

