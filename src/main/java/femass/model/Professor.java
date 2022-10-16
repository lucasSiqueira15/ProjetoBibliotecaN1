package femass.model;

import java.util.List;

public class Professor extends Leitor{
    private String disciplina;

    public Professor(String nome, String endereco, String telefone, String disciplina){
        super();
        this.disciplina = disciplina;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigo = proximoCodigo;
        proximoCodigo++;
        prazoMaximoDevolucao = 30;
    }

    public Professor(){
        super();
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() + " | Nome: " + this.getNome().toUpperCase()+
                " | Disciplina: " + this.disciplina;
    }

    @Override
    public boolean equals(Object obj) {
        Professor professor = (Professor) obj;

        if(professor.getCodigo().equals(this.codigo)) return true;
        return false;
    }

    public static void atualizarProximoCodigoProf(List<Professor> professores){
        proximoCodigo = professores.get(professores.size() - 1).getCodigo() + 1;
    }
}
