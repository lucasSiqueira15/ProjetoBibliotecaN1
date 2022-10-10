package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import femass.model.Autor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
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
        FileOutputStream out = new FileOutputStream("Autores.json");
        out.write(json.getBytes(StandardCharsets.UTF_8));
        out.close();

    }

    public List<Autor> consultar() throws Exception{

        //1° Ler o Arquivo.
        FileInputStream in = new FileInputStream("Autores.json");
        String json = new String(in.readAllBytes());

        //2° Converter o Conteúdo do Arquivo em Objeto.
        ObjectMapper objectMapper = new ObjectMapper();
        this.autores = objectMapper.readValue(json, new TypeReference<List<Autor>>(){});

        //3° Retornar a Lista de Objeto.
        return this.autores;

    }

    public void excluir(Autor autor) throws Exception{
        //1° Ler o Arquivo.
        FileInputStream in = new FileInputStream("Autores.json");
        String json = new String(in.readAllBytes());

        //2° Converter o Conteúdo do Arquivo em Objeto.
        ObjectMapper objectMapper = new ObjectMapper();
        this.autores = objectMapper.readValue(json, new TypeReference<List<Autor>>(){});

        //3° Excluir o autor da Lista de autores.
        this.autores.remove(autor);

        //4° Converter o objeto Autor em Json.
        json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(autores);
        System.out.println(json);

        //5° Gravar Json em arquivo no disco.
        FileOutputStream out = new FileOutputStream("Autores.json");
        out.write(json.getBytes(StandardCharsets.UTF_8));
        out.close();

    }

}
