package apirest.visitas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apirest.visitas.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	
}
