package femass.model.test;

import femass.model.Autor;
import femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void testLivro() {
        Livro.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Livro livro = new Livro("Lua", "2021", autor);

        String esperado = "Código: 1 | Título: LUA | Ano: 2021";

        Assertions.assertEquals(esperado, livro.toString());
    }

    @Test
    void testEqualsDiferente() {
        Livro.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Livro livro1 = new Livro("Lua", "2021", autor);
        Livro livro2 = new Livro("Lua", "2021", autor);

        Assertions.assertFalse(livro2.equals(livro1));
    }

    @Test
    void testEqualsIgual() {
        Livro.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Livro livro1 = new Livro("Lua", "2021", autor);
        Livro livro2 = livro1;

        Assertions.assertTrue(livro2.equals(livro1));
    }

    @Test
    void testEqualsNulo() {
        Livro.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Livro livro1 =  new Livro("Lua", "2021", autor);
        Livro livro2 = null;

        Assertions.assertFalse(livro1.equals(livro2));
    }

    @Test
    void atualizarProximoCodigoLivro() {
        Livro.setProximoCodigo(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Livro livro1 = new Livro("Lua", "2021", autor);
        Livro livro2 = new Livro("Lua", "2021", autor);
        Livro livro3 = new Livro("Lua", "2021", autor);

        List<Livro> livros = new ArrayList<Livro>();

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);

        Livro livro = new Livro("Lua", "2021", autor);

        Livro.atualizarProximoCodigoLivro(livros);

        Livro livro4 = new Livro("Lua", "2021", autor);
        Long codigo = 4L;

        Assertions.assertEquals(codigo, livro4.getCodigo());
    }
}