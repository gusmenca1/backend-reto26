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
@Table(name = "visitas")
@Data
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visita")
	private Integer idVisita;

	private String nombre;

	private String descripcion;

	@Column(name = "fecha_inicio")
	private LocalDateTime fechaInicio;

	private Integer duracion;

	private String direccion;

	@Enumerated(EnumType.STRING)
	private Estado estado;

	@Column(name = "aforo_maximo")
	private Integer aforoMaximo;

	@Column(name = "minimo_asistencia")
	private Integer minimoAsistencia;

	private BigDecimal precio;

	// TODO: Falta crear la entidad TipoVisita y descomentar esto
	/*@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoVisita tipoVisita;*/

	public enum Estado {
		ACTIVO, CANCELADO, TERMINADO
	}
}
