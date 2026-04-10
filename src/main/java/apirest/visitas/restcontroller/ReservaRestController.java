package apirest.visitas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apirest.visitas.modelo.entities.Reserva;
import apirest.visitas.modelo.entities.Usuario;
import apirest.visitas.modelo.services.ReservaService;
import apirest.visitas.modelo.services.ReservaServiceImplMySql8;

@RestController
@RequestMapping("/api/reservas")
public class ReservaRestController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ReservaServiceImplMySql8 reservaServiceImpl;

    // ADMIN: listar todas las reservas
    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    // ADMIN: buscar reserva por id
    @GetMapping("/{idReserva}")
    public Reserva findById(@PathVariable Integer idReserva) {
        return reservaService.findById(idReserva);
    }

    // CLIENTE: mis reservas
    @GetMapping("/usuario/{username}")
    public List<Reserva> findByUsuario(@PathVariable String username) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        return reservaService.findByUsuario(usuario);
    }

    // CLIENTE: crear reserva con validaciones
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Reserva reserva) {

        if (!reservaServiceImpl.cantidadValida(reserva.getCantidad())) {
            return ResponseEntity.badRequest()
                    .body("La cantidad debe estar entre 1 y 10 entradas por reserva.");
        }

        if (reservaServiceImpl.usuarioYaTieneMaximo(reserva.getUsuario(), reserva.getVisita().getIdVisita())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya tienes una reserva con 10 entradas para este evento.");
        }

        if (!reservaServiceImpl.aforoSuficiente(reserva)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No hay suficiente aforo disponible para esta reserva.");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservaService.save(reserva));
    }

    // ADMIN: editar reserva
    @PutMapping("/{idReserva}")
    public Reserva update(@PathVariable Integer idReserva, @RequestBody Reserva reserva) {
        reserva.setIdReserva(idReserva);
        return reservaService.save(reserva);
    }

    // CLIENTE: cancelar/eliminar reserva
    @DeleteMapping("/{idReserva}")
    public void deleteById(@PathVariable Integer idReserva) {
        reservaService.deleteById(idReserva);
    }
}