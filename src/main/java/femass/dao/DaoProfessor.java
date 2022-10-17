package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Professor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoProfessor extends Persistencia<Professor> implements DaoGeral<Professor> {

    private static final String NOMEARQUIVO = "Professores.json";
    @Override
    public void gravar(Professor professor) throws Exception {
        List<Professor> professores = consultar();
        professores.add(professor);
        super.gravarArquivo(professores, NOMEARQUIVO);
    }

    @Override
    public List<Professor> consultar() throws Exception {
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Professor> professores = getMapper().readValue(listaJson, new TypeReference<List<Professor>>(){});
            Professor.atualizarProximoCodigoProf(professores);
            return professores;
        }
        catch (FileNotFoundException f){
            Professor.setProximoCodigo(1L);
            return new ArrayList<>();
        }
    }
}
