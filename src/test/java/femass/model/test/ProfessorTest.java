package femass.model.test;

import femass.model.Aluno;
import femass.model.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void testProfessor() {
        Professor.setProximoCodigo(1L);
        Professor professor = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        String esperado = "Codigo: 1 | Nome: LUCAS | Disciplina: MATEMÁTICA";

        Assertions.assertEquals(esperado, professor.toString());
    }

    @Test
    void testEqualsDiferente() {
        Professor.setProximoCodigo(1L);
        Professor professor1 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        Professor professor2 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");

        Assertions.assertFalse(professor2.equals(professor1));
    }

    @Test
    void testEqualsIgual() {
        Professor.setProximoCodigo(1L);
        Professor professor1 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        Professor professor2 = professor1;

        Assertions.assertTrue(professor2.equals(professor1));
    }

    @Test
    void testEqualsNulo() {
        Professor.setProximoCodigo(1L);
        Professor professor1 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        Professor professor2 = null;

        Assertions.assertFalse(professor1.equals(professor2));
    }

    @Test
    void atualizarProximoCodigoProf() {
        Professor.setProximoCodigo(1L);
        Professor professor1 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        Professor professor2 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        Professor professor3 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");

        List<Professor> professores = new ArrayList<Professor>();

        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);

        Aluno.proximoCodigo = 10L;

        Professor.atualizarProximoCodigoProf(professores);

        Professor professor4 = new Professor("Lucas", "Rua Lucas", "(22)997430096", "Matemática");
        Long codigo = 4L;

        Assertions.assertEquals(codigo, professor4.getCodigo());
    }
}