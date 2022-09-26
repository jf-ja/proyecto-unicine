package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sala implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    private Pelicula pelicula;

    @ManyToOne
    private Teatro teatro;

    @ToString.Exclude
    @OneToMany(mappedBy = "sala")
    private List<SillaSala> sillasSalas;


    public Sala(String codigo, String nombre, Teatro teatro, Pelicula pelicula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.teatro = teatro;
        this.pelicula = pelicula;
    }
}
