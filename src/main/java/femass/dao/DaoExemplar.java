package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Exemplar;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoExemplar extends Persistencia<Exemplar> implements DaoGeral<Exemplar>{

    private static final String NOMEARQUIVO = "Exemplares.json";
    @Override
    public void gravar(Exemplar exemplar) throws Exception {
        List<Exemplar> exemplares = consultar();
        exemplares.add(exemplar);
        super.gravarArquivo(exemplares, NOMEARQUIVO);
    }
    @Override
    public List<Exemplar> consultar() throws Exception {
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Exemplar> exemplares = getMapper().readValue(listaJson, new TypeReference<List<Exemplar>>(){});
            Exemplar.atualizarProximoCodigoExemplar(exemplares);
            return exemplares;
        }
        catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
