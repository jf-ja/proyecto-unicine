package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.repositorios.CiudadRepo;
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
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){

        Ciudad ciudad= new Ciudad("7","Barranquilla");
        Ciudad guardado= ciudadRepo.save(ciudad);

        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

       Ciudad guardado= ciudadRepo.findById("2").orElse(null);
        ciudadRepo.delete(guardado);
        Assertions.assertNull(ciudadRepo.findById("2").orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        Ciudad guardado = ciudadRepo.findById("2").orElse(null);
        guardado.setNombre("Buga");
        Ciudad nuevo = ciudadRepo.save(guardado);

        Assertions.assertEquals("Buga", nuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<Ciudad> buscado = ciudadRepo.findById("2");
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Ciudad> lista = ciudadRepo.findAll();
        System.out.println(lista);

    }
}
