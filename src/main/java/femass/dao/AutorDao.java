package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import femass.model.Autor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AutorDao {

    private List<Autor> autores = new ArrayList<Autor>();

    public void gravar(Autor autor) throws Exception {
        //1° Adicionar autor na lista.
        this.autores.add(autor);

        //2° Converter o objeto Autor em Json.
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(autores);

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

        //5° Gravar Json em arquivo no disco.
        FileOutputStream out = new FileOutputStream("Autores.json");
        out.write(json.getBytes(StandardCharsets.UTF_8));
        out.close();

    }

    public void alterar(Autor autor, String nomeAtributo, String novoValor) throws Exception{
        //1° Ler o Arquivo.
        FileInputStream in = new FileInputStream("Autores.json");
        String json = new String(in.readAllBytes());

        //2° Converter o Conteúdo do Arquivo em Objeto.
        ObjectMapper objectMapper = new ObjectMapper();
        this.autores = objectMapper.readValue(json, new TypeReference<List<Autor>>(){});

        //3° Buscar o autor na lista de autores e depois alterar o valor desejado.
        if(this.autores.contains(autor)){
            int index = this.autores.indexOf(autor);
            if (nomeAtributo.toLowerCase() == "nome") {
                this.autores.get(index).setNome(novoValor);
            } else {
                if (nomeAtributo.toLowerCase() == "sobrenome") {
                    this.autores.get(index).setSobrenome(novoValor);
                } else {
                    if (nomeAtributo.toLowerCase() == "nacionalidade") {
                        this.autores.get(index).setNacionalidade(novoValor);
                    } else {
                        throw new IllegalArgumentException("Nome da coluna não encontrado. Por favor, use uma das opções: Nome, Sobrenome ou Nacionalidade.");
                    }
                }
            }
        }
        else {
            throw new IllegalArgumentException("O autor informado não existe na lista de autores.");
        }

        //4° Converter o objeto Autor em Json.
        json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(autores);

        //5° Gravar Json em arquivo no disco.
        FileOutputStream out = new FileOutputStream("Autores.json");
        out.write(json.getBytes(StandardCharsets.UTF_8));
        out.close();

    }

}
