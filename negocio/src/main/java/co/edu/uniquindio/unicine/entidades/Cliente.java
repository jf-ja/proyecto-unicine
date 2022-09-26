package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Cliente extends Persona implements Serializable {
    @Column(nullable = false)
    private String urlFoto;
    @Column(nullable = false)
    private boolean estado;
    @ElementCollection
    private List<String> telefonos ;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Cupon> cupones;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Pqrs> pqrses;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Calificacion> calificaciones;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    public Cliente(String nombre, String correo, String password, String urlFoto, Boolean estado, List<String> telefonos) {
        super(nombre, correo, password);
        this.urlFoto = urlFoto;
        this.estado = estado;
        this.telefonos = telefonos;
    }
}
