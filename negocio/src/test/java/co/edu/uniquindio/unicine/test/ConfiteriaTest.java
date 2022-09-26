package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Categoria;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.repositorios.ConfiteriaRepo;
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
public class ConfiteriaTest {

    @Autowired
    private ConfiteriaRepo confiteriaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){

        Confiteria confiteria= new Confiteria("Crispetas Medianas",17900 , 12, Categoria.CRISPETAS);
        Confiteria guardado= confiteriaRepo.save(confiteria);

        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

        Confiteria guardado= confiteriaRepo.findById(12).orElse(null);
        confiteriaRepo.delete(guardado);
        Assertions.assertNull(confiteriaRepo.findById(12).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        Confiteria guardado = confiteriaRepo.findById(12).orElse(null);
        guardado.setNombre("Jugo");
        Confiteria nuevo = confiteriaRepo.save(guardado);

        Assertions.assertEquals("Jugo", nuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<Confiteria> buscado = confiteriaRepo.findById(12);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Confiteria> lista = confiteriaRepo.findAll();
        System.out.println(lista);

    }
}
