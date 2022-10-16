package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Aluno;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoAluno extends Persistencia<Aluno> implements DaoGeral<Aluno> {
    private static final String NOMEARQUIVO = "Alunos.json";
    @Override
    public void gravar(Aluno aluno) throws Exception {
        List<Aluno> alunos = consultar();
        alunos.add(aluno);
        super.gravarArquivo(alunos, NOMEARQUIVO);
    }

    @Override
    public List<Aluno> consultar() throws Exception {
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Aluno> alunos = getMapper().readValue(listaJson, new TypeReference<List<Aluno>>(){});
            Aluno.atualizarProximoCodigoAluno(alunos);
            return alunos;
        }
        catch (FileNotFoundException f){
            Aluno.setProximoCodigo(1L);
            return new ArrayList<>();
        }
    }
}
