package co.edu.uniquindio.unicine.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private double descuento;
    @Column(nullable = false)
    private Boolean estado;

    private LocalDateTime vencimiento;
    @ManyToOne
    private Cliente cliente;

    @OneToOne(mappedBy = "cupon")
    private Compra compra;

    public Cupon(double descuento, Boolean estado, LocalDateTime vencimiento, Cliente cliente, Compra compra) {
        this.descuento = descuento;
        this.estado = estado;
        this.vencimiento = vencimiento;
        this.cliente = cliente;
        this.compra = compra;
    }
}
