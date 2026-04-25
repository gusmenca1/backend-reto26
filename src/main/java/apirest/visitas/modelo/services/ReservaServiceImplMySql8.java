package apirest.visitas.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.visitas.modelo.entities.Reserva;
import apirest.visitas.modelo.entities.Usuario;
import apirest.visitas.modelo.entities.Visita;
import apirest.visitas.modelo.repository.ReservaRepository;
import apirest.visitas.modelo.repository.VisitaRepository;

@Service
public class ReservaServiceImplMySql8 implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private VisitaRepository visitaRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva findById(Integer idReserva) {
        return reservaRepository.findById(idReserva).orElse(null);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void deleteById(Integer idReserva) {
        reservaRepository.deleteById(idReserva);
    }

    @Override
    public List<Reserva> findByUsuario(Usuario usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    // Validación: cantidad máxima 10 por reserva
    public boolean cantidadValida(Integer cantidad) {
        return cantidad != null && cantidad >= 1 && cantidad <= 10;
    }

    // Validación: el usuario ya tiene una reserva en esta visita con 10 entradas
    public boolean usuarioYaTieneMaximo(Usuario usuario, Integer idVisita) {
        List<Reserva> reservas = reservaRepository.findByUsuarioAndVisita_IdVisita(usuario, idVisita);
        return reservas.stream()
                .anyMatch(r -> r.getCantidad() >= 10);
    }

    // Validación: aforo disponible suficiente
    public boolean aforoSuficiente(Reserva reserva) {
        Integer idVisita = reserva.getVisita().getIdVisita();

        // Cargamos la visita completa desde la BD
        Visita visitaCompleta = visitaRepository.findById(idVisita).orElse(null);
        if (visitaCompleta == null) return false;

        Integer aforoMaximo = visitaCompleta.getAforoMaximo();

        List<Reserva> reservasVisita = reservaRepository
                .findByUsuarioAndVisita_IdVisita(reserva.getUsuario(), idVisita);
        Integer totalReservado = reservasVisita.stream()
                .mapToInt(Reserva::getCantidad)
                .sum();

        return (totalReservado + reserva.getCantidad()) <= aforoMaximo;
    }
}