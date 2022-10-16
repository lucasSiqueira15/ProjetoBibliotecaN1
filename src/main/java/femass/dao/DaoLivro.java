package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Autor;
import femass.model.Livro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro extends Persistencia<Livro> implements DaoGeral<Livro>{
    private static final String NOMEARQUIVO = "Livros.json";
    @Override
    public void gravar(Livro livro) throws Exception {
        List<Livro> livros = consultar();
        livros.add(livro);
        super.gravarArquivo(livros, NOMEARQUIVO);
    }
    @Override
    public List<Livro> consultar() throws Exception {
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Livro> livros = getMapper().readValue(listaJson, new TypeReference<List<Livro>>(){});
            Livro.atualizarProximoCodigoLivro(livros);
            return livros;
        }
        catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
