package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCompra;

    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    private LocalDateTime fecha;
    @OneToOne
    private Cupon cupon;

    @ManyToOne
    private HorarioPelicula horarioPelicula;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "compra_entrada",
            joinColumns = @JoinColumn(name = "compra_codigo"),
            inverseJoinColumns = @JoinColumn(name = "silla_sala_codigo")
    )
    private List<SillaSala> sillaSalas;

    @Builder
    public Compra(MedioPago medioPago, Cupon cupon, Cliente cliente, List<SillaSala> sillaSalas) {
        this.medioPago = medioPago;
        this.fecha = LocalDateTime.now();
        this.cupon = cupon;
        this.cliente = cliente;
        this.sillaSalas = sillaSalas;
    }
}
