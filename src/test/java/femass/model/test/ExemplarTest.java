package femass.model.test;

import femass.model.Autor;
import femass.model.Exemplar;
import femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExemplarTest {

    @Test
    void testExemplar() {
        Exemplar.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Exemplar exemplar = new Exemplar(LocalDate.of(2022, 10, 17),
                            new Livro("Lua", "2021", autor));

        String esperado = "Código: 1 | LUA | Autores: EDUARDO SILVA";

        Assertions.assertEquals(esperado, exemplar.toString());
    }

    @Test
    void testEqualsDiferente() {
        Exemplar.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Exemplar exemplar1 = new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));
        Exemplar exemplar2 = new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));

        Assertions.assertFalse(exemplar2.equals(exemplar1));
    }

    @Test
    void testEqualsIgual() {
        Exemplar.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Exemplar exemplar1 =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));
        Exemplar exemplar2 = exemplar1;

        Assertions.assertTrue(exemplar2.equals(exemplar1));
    }

    @Test
    void testEqualsNulo() {
        Exemplar.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Exemplar exemplar1 =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));
        Exemplar exemplar2 = null;

        Assertions.assertFalse(exemplar1.equals(exemplar2));
    }

    @Test
    void atualizarProximoCodigoExemplar() {
        Exemplar.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Exemplar exemplar1 =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));
        Exemplar exemplar2 =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));
        Exemplar exemplar3 =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));

        List<Exemplar> exemplares = new ArrayList<Exemplar>();

        exemplares.add(exemplar1);
        exemplares.add(exemplar2);
        exemplares.add(exemplar3);

        Exemplar exemplar =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));

        Exemplar.atualizarProximoCodigoExemplar(exemplares);

        Exemplar exemplar4 =  new Exemplar(LocalDate.of(2022, 10, 17),
                                new Livro("Lua", "2021", autor));
        Long codigo = 4L;

        Assertions.assertEquals(codigo, exemplar4.getCodigo());
    }
}