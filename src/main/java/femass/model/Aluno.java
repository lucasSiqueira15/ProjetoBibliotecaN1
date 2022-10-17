package femass.model;

import java.util.List;

public class Aluno extends Leitor{
    private String matricula;

    public Aluno(String nome, String endereco, String telefone, String matricula){
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigo = proximoCodigo;
        proximoCodigo++;
        prazoMaximoDevolucao = 15L;
    }

    public Aluno(){
        super();
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() + " | Nome: " + this.getNome().toUpperCase()+
                " | Matricula: " + this.matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        Aluno aluno = (Aluno) obj;
        if(aluno.getCodigo().equals(this.codigo)) return true;
        return false;
    }

    public static void atualizarProximoCodigoAluno(List<Aluno> alunos){
        proximoCodigo = alunos.get(alunos.size() - 1).getCodigo() + 1;
    }
}
