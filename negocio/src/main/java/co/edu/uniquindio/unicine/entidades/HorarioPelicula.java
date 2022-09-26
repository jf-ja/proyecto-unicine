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
public class HorarioPelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne
    private Pelicula pelicula;

    @ManyToOne
    private Horario horario;

    @ToString.Exclude
    @OneToMany(mappedBy = "horarioPelicula")
    private List<Compra> compra;

    public HorarioPelicula(Integer codigo, Pelicula pelicula, Horario horario) {
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.horario = horario;
    }
}
