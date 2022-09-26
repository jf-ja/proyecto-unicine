package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private String asunto;
    @Column(nullable = false)
    private String descripcion;

    private LocalDateTime fecha;
    @ManyToOne
    private Cliente cliente;

    public Pqrs(String asunto, String descripcion, LocalDateTime fecha, Cliente cliente) {
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.cliente = cliente;
    }
}
