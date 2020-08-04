package org.generation.minhaRedeSocial.repository;

import java.util.List;

import org.generation.minhaRedeSocial.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List<Postagem> findAllByDescricaoContainingIgnoreCase (String tema);

}
