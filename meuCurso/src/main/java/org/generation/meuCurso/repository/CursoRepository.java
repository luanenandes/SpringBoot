package org.generation.meuCurso.repository;
import java.util.List;
import org.generation.meuCurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <Curso, Long> {
	
	public List <Curso> findAllByMateriaContainingIgnoreCase (String materia);

}
