package co.edu.uniquindio.unicine.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class AdministradorTeatro extends Persona implements Serializable {

    @ToString.Exclude
    @OneToOne
    private Teatro teatro;

    public AdministradorTeatro(String nombre, String correo, String password) {
        super(nombre, correo, password);
    }
}
