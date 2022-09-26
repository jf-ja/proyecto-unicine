package co.edu.uniquindio.unicine.entidades;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigoPostal;
    @Column(nullable = false)
    private String nombre;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;

    public Ciudad(String codigoPostal, String nombre) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
    }
}
