package co.edu.uniquindio.unicine.entidades;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ToString(callSuper = true)
public class Administrador extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "administrador")
    private List<Teatro> teatros;

    public Administrador(String nombre, String correo, String password) {
        super(nombre, correo, password);
    }
}
