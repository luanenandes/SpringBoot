
package org.generation.meuCurso.controller;
import org.generation.meuCurso.model.Curso;
import org.generation.meuCurso.repository.CursoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


@RestController
@RequestMapping("/curso")
@CrossOrigin("*")
public class CursoController {
	
	@Autowired
	private CursoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> GetAll(@PathVariable long id){
	return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/curso/{curso}")
	public ResponseEntity<Curso> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	

}