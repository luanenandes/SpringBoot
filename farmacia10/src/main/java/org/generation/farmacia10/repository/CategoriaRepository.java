package org.generation.farmacia10.repository;

import java.util.List;

import org.generation.farmacia10.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String produtos);
}
