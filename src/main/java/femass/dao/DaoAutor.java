package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Autor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoAutor extends Persistencia<Autor> implements DaoGeral<Autor> {
    private static final String NOMEARQUIVO = "Autores.json";
    public void gravar(Autor autor) throws Exception {
        List<Autor> autores = consultar();
        autores.add(autor);
        super.gravarArquivo(autores, NOMEARQUIVO);
    }

    public List<Autor> consultar() throws Exception{
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Autor> autores = getMapper().readValue(listaJson, new TypeReference<List<Autor>>(){});
            Autor.atualizarProximoId(autores);
            return autores;
        }
        catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }

}
