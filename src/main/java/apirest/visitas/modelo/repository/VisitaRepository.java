package apirest.visitas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apirest.visitas.modelo.entities.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer> {
}
