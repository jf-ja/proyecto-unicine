package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@MappedSuperclass
@ToString
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false)
    private String nombre;

    @Email
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String password;

    public Persona(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
}
