package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Leitor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoLeitor extends Persistencia<Leitor> implements DaoGeral<Leitor> {
    private static final String NOMEARQUIVO = "Leitores.json";
    @Override
    public void gravar(Leitor leitor) throws Exception {
        List<Leitor> leitores = consultar();
        leitores.add(leitor);
        super.gravarArquivo(leitores, NOMEARQUIVO);
    }

    @Override
    public List<Leitor> consultar() throws Exception {
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Leitor> leitores = getMapper().readValue(listaJson, new TypeReference<List<Leitor>>(){});
            Leitor.atualizarProximoCodigo(leitores);
            return leitores;
        }
        catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
