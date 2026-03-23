package apirest.visitas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apirest.visitas.modelo.entities.Usuario;
import apirest.visitas.modelo.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> findAll(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/{usuario}")
	public Usuario findById(@PathVariable String usuario) {
		return usuarioService.findById(usuario);
	}
	
	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	@PutMapping ("/{usuario}")
	public Usuario update(@PathVariable String usuario, @RequestBody Usuario usuarioBody) {
		usuarioBody.setUsuario(usuario);
		return usuarioService.save(usuarioBody);
	}
	
	@DeleteMapping("/{usuario}")
	public void deleteById(@PathVariable String usuario) {
		usuarioService.deleteById(usuario);
	}
}
