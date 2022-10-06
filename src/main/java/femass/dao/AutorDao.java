package femass.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import femass.model.Autor;

import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private List<Autor> autores = new ArrayList<Autor>();

    public void gravar(Autor autor) throws Exception {
        //1° Adicionar autor na lista.
        this.autores.add(autor);

        //2° Converter o objeto Autor em Json.
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(autores);
        System.out.println(json);
        //3° Gravar Json em arquivo no disco.




    }

}
