/**
 * 
 */
package apirest.visitas.modelo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 */
@Entity
@Table(name = "usuarios")
@Data


public class Usuario {
	
	@Id
	private String usuario;
	
	private String contrasena;
	
	private String email;

    private String nombre;

    private String apellidos;

    private String direccion;
    
    private Integer activado;
    
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
}
