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
public class Confiteria implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private int unidades;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Confiteria(String nombre, double precio, int unidades, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.categoria = categoria;
    }
}
