package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teatro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;


    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private Administrador administrador;

    @OneToOne(mappedBy = "teatro")
    private AdministradorTeatro administradorTeatro;

    @ToString.Exclude
    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;

    public Teatro(String codigo, String nombre, String direccion, Ciudad ciudad, Administrador administrador) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.administrador = administrador;
    }
}
