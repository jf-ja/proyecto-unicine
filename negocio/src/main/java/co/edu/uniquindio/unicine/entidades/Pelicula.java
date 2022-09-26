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
public class Pelicula implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String sipnosis;
    @Column(nullable = false)
    private String urlTrailer;
    @Column(nullable = false)
    private String urlImagen;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;
    @Column(nullable = false)
    private Boolean estado;
    @Column(nullable = false)
    private String reparto;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Sala> sala;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Calificacion> calificaciones;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<HorarioPelicula> horarioPeliculas;


    public Pelicula(String nombre, String sipnosis, String urlTrailer, String urlImagen, Genero genero, Boolean estado, String reparto) {
        this.nombre = nombre;
        this.sipnosis = sipnosis;
        this.urlTrailer = urlTrailer;
        this.urlImagen = urlImagen;
        this.genero = genero;
        this.estado = estado;
        this.reparto = reparto;
    }
}
