package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTeatroTest {

    @Autowired
    private AdministradorTeatroRepo administradorTeatroRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){

        AdministradorTeatro administradorTeatro = new AdministradorTeatro("Jordan" , "adminTeatro4@gmail.com", "jordan123");
        AdministradorTeatro guardado= administradorTeatroRepo.save(administradorTeatro);

        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

        AdministradorTeatro guardado= administradorTeatroRepo.findById(002).orElse(null);
        administradorTeatroRepo.delete(guardado);
        Assertions.assertNull(administradorTeatroRepo.findById(002).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        AdministradorTeatro guardado = administradorTeatroRepo.findById(002).orElse(null);
        guardado.setCorreo("jordan@gmail.com");
        AdministradorTeatro nuevo = administradorTeatroRepo.save(guardado);

        Assertions.assertEquals("jordan@gmail.com", nuevo.getCorreo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<AdministradorTeatro> buscado = administradorTeatroRepo.findById(002);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<AdministradorTeatro> lista = administradorTeatroRepo.findAll();
        System.out.println(lista);

    }
}
