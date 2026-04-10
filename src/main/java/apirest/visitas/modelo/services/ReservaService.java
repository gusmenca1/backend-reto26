package apirest.visitas.modelo.services;

import java.util.List;

import apirest.visitas.modelo.entities.Reserva;
import apirest.visitas.modelo.entities.Usuario;

public interface ReservaService extends ICrudGenerico<Reserva, Integer> {

    List<Reserva> findByUsuario(Usuario usuario);

}