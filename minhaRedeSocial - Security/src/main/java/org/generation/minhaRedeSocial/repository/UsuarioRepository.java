package org.generation.minhaRedeSocial.repository;

import java.util.Optional;

import org.generation.minhaRedeSocial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByUsuario (String usuario);

}
