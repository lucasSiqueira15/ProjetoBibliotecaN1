package femass.model.test;

import femass.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    @Test
    void devolverEmprestimo() {
        Emprestimo.setProximoId(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Emprestimo emprestimo = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        emprestimo.devolverEmprestimo();

        Assertions.assertNotNull(emprestimo.getDataDevolucao());
        Assertions.assertTrue(emprestimo.getExemplar().getDisponivel());

    }

    @Test
    void testEmprestimo() {
        Emprestimo.setProximoId(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));
        Emprestimo emprestimo = new Emprestimo(
                                    new Exemplar(
                                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                                    new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));
        String esperado = "ID: 1 | " +
                "Leitor: Codigo: 4 | " +
                "Nome: LUCAS | " +
                "Matricula: 1 | " +
                "Exemplar: Código: 4 | LUA | " +
                "Autores: EDUARDO SILVA | " +
                "Data Emprestimo: 17/10/2022 | " +
                "Data Prevista Devolução: 01/11/2022 | " +
                "Data Devolução: Pendente";

        Assertions.assertEquals(esperado, emprestimo.toString());
    }

    void testEqualsDiferente() {
        Emprestimo.setProximoId(1L);
        List<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Eduardo", "Silva", "Brasileira"));

        Emprestimo emprestimo1 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Emprestimo emprestimo2 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Assertions.assertFalse(emprestimo2.equals(emprestimo1));
    }

    @Test
    void testEqualsIgual() {
        Emprestimo.setProximoId(1L);
        List<Autor> autor = new ArrayList<>();
        Emprestimo emprestimo1 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Emprestimo emprestimo2 = emprestimo1;

        Assertions.assertTrue(emprestimo2.equals(emprestimo1));
    }

    @Test
    void testEqualsNulo() {
        Emprestimo.setProximoId(1L);
        List<Autor> autor = new ArrayList<>();
        Emprestimo emprestimo1 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Emprestimo emprestimo2 = null;

        Assertions.assertFalse(emprestimo1.equals(emprestimo2));
    }

    @Test
    void atualizarProximoIdEmp() {
        Emprestimo.setProximoId(1L);
        List<Autor> autor = new ArrayList<>();
        Emprestimo emprestimo1 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Emprestimo emprestimo2 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Emprestimo emprestimo3 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

        emprestimos.add(emprestimo1);
        emprestimos.add(emprestimo2);
        emprestimos.add(emprestimo3);

        Emprestimo emprestimo = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Emprestimo.atualizarProximoIdEmp(emprestimos);

        Emprestimo emprestimo4 = new Emprestimo(
                new Exemplar(
                        LocalDate.of(2022, 10, 17), new Livro("Lua", "2021", autor)),
                new Aluno("Lucas", "Rua Lucas", "(22)997850021", "1"));

        Long codigo = 4L;

        Assertions.assertEquals(codigo, emprestimo4.getId());
    }
}