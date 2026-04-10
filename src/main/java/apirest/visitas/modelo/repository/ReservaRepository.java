package apirest.visitas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import apirest.visitas.modelo.entities.Reserva;
import apirest.visitas.modelo.entities.Usuario;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // Reservas de un usuario concreto
    List<Reserva> findByUsuario(Usuario usuario);

    // Para validar cuántas entradas tiene ya este usuario en esta visita
    List<Reserva> findByUsuarioAndVisita_IdVisita(Usuario usuario, Integer idVisita);

}