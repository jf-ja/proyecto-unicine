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
public class SillaSala implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigoSillaSala;
    @Column(nullable = false)
    private double precio;

    @ManyToOne
    private Silla silla;

    @ManyToOne
    private Sala sala;

    @ManyToMany(mappedBy = "sillaSalas")
    private List<Compra> compras;

    public SillaSala(String codigoSillaSala, double precio, Silla silla, Sala sala) {
        this.codigoSillaSala = codigoSillaSala;
        this.precio = precio;
        this.silla = silla;
        this.sala = sala;
    }
}
