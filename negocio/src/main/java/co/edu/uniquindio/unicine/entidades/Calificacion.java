package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Calificacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private double puntuacion;

    @ManyToOne
    private Pelicula pelicula;

    @ManyToOne
    private Cliente cliente;

    public Calificacion(double puntuacion, Pelicula pelicula, Cliente cliente) {
        this.puntuacion = puntuacion;
        this.pelicula = pelicula;
        this.cliente = cliente;
    }
}
