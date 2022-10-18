package femass.model.test;

import femass.model.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void testAluno() {
        Aluno.setProximoCodigo(1L);
        Aluno aluno = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        String esperado = "Codigo: 1 | Nome: LUCAS | Matricula: 1";

        Assertions.assertEquals(esperado, aluno.toString());
    }

    @Test
    void testEqualsDiferente() {
        Aluno.setProximoCodigo(1L);
        Aluno aluno1 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        Aluno aluno2 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");

        Assertions.assertFalse(aluno2.equals(aluno1));
    }

    @Test
    void testEqualsIgual() {
        Aluno.setProximoCodigo(1L);
        Aluno aluno1 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        Aluno aluno2 = aluno1;

        Assertions.assertTrue(aluno2.equals(aluno1));
    }

    @Test
    void testEqualsNulo() {
        Aluno.setProximoCodigo(1L);
        Aluno aluno1 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        Aluno aluno2 = null;

        Assertions.assertFalse(aluno1.equals(aluno2));
    }

    @Test
    void testAtualizarProximoCodigoAluno() {
        Aluno.setProximoCodigo(1L);
        Aluno aluno1 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        Aluno aluno2 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        Aluno aluno3 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");

        List<Aluno> alunos = new ArrayList<Aluno>();

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);

        Aluno.proximoCodigo = 10L;

        Aluno.atualizarProximoCodigoAluno(alunos);

        Aluno aluno4 = new Aluno("Lucas", "Rua Lucas", "(22)997430096", "1");
        Long codigo = 4L;

        Assertions.assertEquals(codigo, aluno4.getCodigo());

    }
}