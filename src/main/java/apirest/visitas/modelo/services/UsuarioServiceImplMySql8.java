package apirest.visitas.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.visitas.modelo.entities.Usuario;
import apirest.visitas.modelo.repository.UsuarioRepository;
import apirest.visitas.modelo.repository.VisitaRepository;

@Service
public class UsuarioServiceImplMySql8 implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(String usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(usuario).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(String usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(usuario);
	}
}