package org.generation.minhaRedeSocial.controller;

import java.util.List;
import org.generation.minhaRedeSocial.model.Tema;
import org.generation.minhaRedeSocial.repository.TemaRepository;
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

@RestController /*Todo método do controller (controlador) serializa automaticamente objetos de retorno do HttpResponse*/
@RequestMapping("/tema") /*Solicitando o mapeamento do CRUD que virá a seguir e o nome dentro é como será chamado no Postman*/
@CrossOrigin("*") /*Quando essa API chega no FrontEnd, tem vários formatos que vem: react, angular, etc. E o CrossOrigin é: independente da origem que vier vai puxar a API. O sinal de "*" é pq pode vir de qlq origem que será aceita*/
public class TemaController {
	
	@Autowired /*Autowired = Garante que todos os serviços da interface tipo temaRepository seja acessado a partir do controller!!!*/
	private TemaRepository repository; /*Chama o repositório do tema*/
	
	/*Agora vamos começar o CRUD*/
	
	@GetMapping /*Acionando mapeamento do tipo GET*/
	public ResponseEntity<List<Tema>> GetAll(){
		return ResponseEntity.ok(repository.findAll());  /*O respondeEntity é para acionar o Http response: código de status, podemos usar vários tipos de corpo de resposta, no caso aqui é o GET*/
	}
	
	@GetMapping("/{id}") /*Informa que vai puxar por ID*/
	public ResponseEntity<Tema> GetById(@PathVariable long id){  /*PathVarible capta qual é a variável que vai ser utilizada, no caso o ID*/
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)) /*Pode ser devolvido tanto uma postagem de OK, quanto um NotFound caso não exista, ou tenha algum erro na requisição*/
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}") /*Vamos puxar as info agora por tema*/
	public ResponseEntity<List<Tema>> GetByTema(@PathVariable String descricao){ /*PathVarible capta qual é a variável que vai ser utilizada, no caso a descricao*/
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao)); /*Aqui ele puxa tudo pelo Tema, independente de letras maiuculas, minusculas, palavras a mais ou a menos através do IgnoreCase*/
	}
	
	@PostMapping
	public ResponseEntity<Tema> post(@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> put(@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping
	public void delete (@PathVariable long id) {
		repository.deleteById (id);
	}
	

}
