package org.generation.minhaEscola.controller;
import org.generation.minhaEscola.repository.TurmaRepository;
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

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Postagem;
import org.generation.minhaEscola.model.Turma;


@RestController
@RequestMapping("/turmas")
@CrossOrigin("*")
public class TurmaController {
	
	@Autowired
	private TurmaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Turma>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/turma/{turma}")
	public ResponseEntity<List<Turma>> GetByTurma(@PathVariable String turma){
		return ResponseEntity.ok(repository.findAllByTurmaContainingIgnoreCase(turma));
	}
	
	@PostMapping
	public ResponseEntity<Turma> post(@RequestBody Turma turmas){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turmas));
	}
	
	@PutMapping
	public ResponseEntity<Turma> put(@RequestBody Turma turmas){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turmas));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		repository.deleteById(id);
	}
	
}
