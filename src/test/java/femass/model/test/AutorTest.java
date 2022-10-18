package femass.model.test;

import femass.model.Autor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    void testAutor() {
        Autor.setProximoId(1L);
        Autor autor = new Autor("Lucas", "Siqueira", "Brasileira");
        String esperado = "ID: 1 | Nome: LUCAS | Sobrenome: SIQUEIRA | Nacionalidade: BRASILEIRA";

        Assertions.assertEquals(esperado, autor.toString());
    }

    @Test
    void testEqualsDiferente() {
        Autor.setProximoId(1L);
        Autor autor1 = new Autor("Lucas", "Siqueira", "Brasileira");
        Autor autor2 = new Autor("Lucas", "Siqueira", "Brasileira");

        Assertions.assertFalse(autor2.equals(autor1));
    }

    @Test
    void testEqualsIgual() {
        Autor.setProximoId(1L);
        Autor autor1 = new Autor("Lucas", "Siqueira", "Brasileira");
        Autor autor2 = autor1;

        Assertions.assertTrue(autor2.equals(autor1));
    }

    @Test
    void testEqualsNulo() {
        Autor.setProximoId(1L);
        Autor autor1 = new Autor("Lucas", "Siqueira", "Brasileira");
        Autor autor2 = null;

        Assertions.assertFalse(autor1.equals(autor2));
    }

    @Test
    void testAtualizarProximoId() {
        Autor.setProximoId(1L);
        Autor autor1 = new Autor("Lucas", "Siqueira", "Brasileira");
        Autor autor2 = new Autor("Lucas", "Siqueira", "Brasileira");
        Autor autor3 = new Autor("Lucas", "Siqueira", "Brasileira");

        List<Autor> autores = new ArrayList<Autor>();

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);

        Autor autor = new Autor("Lucas", "Siqueira", "Brasileira");

        Autor.atualizarProximoId(autores);

        Autor autor4 = new Autor("Lucas", "Siqueira", "Brasileira");
        Long codigo = 4L;

        Assertions.assertEquals(codigo, autor4.getId());

    }
}