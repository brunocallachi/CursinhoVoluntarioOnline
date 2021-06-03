package com.educadamente.educacaoParaTodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educadamente.educacaoParaTodes.model.Tema;
import com.educadamente.educacaoParaTodes.repository.TemaRepository;

@RestController
@RequestMapping ("/temas")
@CrossOrigin ("*")

public class TemaController {
	@Autowired 
	private TemaRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<Tema>> GetAll(){
		return ResponseEntity.ok(repository.findAll());		
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable Integer id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
		
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}
