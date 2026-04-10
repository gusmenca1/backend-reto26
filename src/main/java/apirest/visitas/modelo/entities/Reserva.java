package apirest.visitas.modelo.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visita visita;

    @ManyToOne
    @JoinColumn(name = "user_reserva")
    private Usuario usuario;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    private String observaciones;

    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    public enum Estado {
        CONFIRMADA, CANCELADA, COMPLETADA
    }
}