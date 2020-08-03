package org.generation.farmacia10.repository;

import java.util.List;

import org.generation.farmacia10.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos, Long> {
	
		public List<Produtos> findAllByDescricaoContainingIgnoreCase (String descricao);

}
