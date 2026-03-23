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
import org.springframework.web.bind.annotation.RestController;

import apirest.visitas.modelo.entities.Perfil;
import apirest.visitas.modelo.services.PerfilService;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilRestController {

	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public List<Perfil> findAll(){
		return perfilService.findAll();
	}
	
	@GetMapping("/{idPerfil}")
	public Perfil findById(@PathVariable Integer idPerfil) {
		return perfilService.findById(idPerfil);
	}
	
	@PostMapping
	public Perfil save(@RequestBody Perfil perfil) {
		return perfilService.save(perfil);
	}
	
	@PutMapping("/{idPerfil}")
	public Perfil update(@PathVariable Integer idPerfil, @RequestBody Perfil perfil) {
		perfil.setIdPerfil(idPerfil);
		return perfilService.save(perfil);		
	}
	
	@DeleteMapping("/{idPerfil}")
	public void deleteById (@PathVariable Integer idPerfil) {
		perfilService.deleteById(idPerfil);
	}
}
