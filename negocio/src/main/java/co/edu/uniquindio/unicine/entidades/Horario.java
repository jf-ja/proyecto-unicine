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
public class Horario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private String dia;
    @Column(nullable = false)
    private String mes;
    @Column(nullable = false)
    private String anio;
    @Column(nullable = false)
    private String hora;

    @ToString.Exclude
    @OneToMany(mappedBy = "horario")
    private List<HorarioPelicula> horarioPeliculas;

    public Horario(String dia, String mes, String anio, String hora) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
    }
}
