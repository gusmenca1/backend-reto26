package apirest.visitas.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.visitas.modelo.repository.VisitaRepository;
import apirest.visitas.modelo.entities.Visita;

@Service
public class VisitaServiceImplMySql8 implements VisitaService {

	@Autowired
	private VisitaRepository visitaRepository;

	@Override
	public List<Visita> findAll() {
		return visitaRepository.findAll();
	}

	@Override
	public Visita findById(Integer idVisita) {
		return visitaRepository.findById(idVisita).orElse(null);
	}

	@Override
	public Visita save(Visita visita) {
		return visitaRepository.save(visita);
	}

	@Override
	public void deleteById(Integer idVisita) {
		visitaRepository.deleteById(idVisita);
	}
}
