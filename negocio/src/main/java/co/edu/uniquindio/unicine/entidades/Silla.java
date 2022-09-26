package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String numero;
    @Column(nullable = false)
    private String fila;
    @Column(nullable = false)
    private String columna;

    @ToString.Exclude
    @OneToMany(mappedBy = "silla")
    private List<SillaSala> sillasSalas;

    public Silla(String numero, String fila, String columna) {
        this.numero = numero;
        this.fila = fila;
        this.columna = columna;
    }
}
