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

import apirest.visitas.modelo.entities.Visita;
import apirest.visitas.modelo.services.VisitaService;

@RestController
@RequestMapping("/api/visitas")
public class VisitaRestController {

	@Autowired
	private VisitaService visitaService;

	@GetMapping
	public List<Visita> findAll() {
		return visitaService.findAll();
	}

	@GetMapping("/{idVisita}")
	public Visita findById(@PathVariable Integer idVisita) {
		return visitaService.findById(idVisita);
	}

	@PostMapping
	public Visita save(@RequestBody Visita visita) {
		return visitaService.save(visita);
	}

	@PutMapping("/{idVisita}")
	public Visita update(@PathVariable Integer idVisita, @RequestBody Visita visita) {
		visita.setIdVisita(idVisita);
		return visitaService.save(visita);
	}

	@DeleteMapping("/{idVisita}")
	public void deleteById(@PathVariable Integer idVisita) {
		visitaService.deleteById(idVisita);
	}
}
