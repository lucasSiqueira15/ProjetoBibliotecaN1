package femass.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Persistencia<T> {

    //Criar ObjectMapper.
    protected ObjectMapper getMapper(){
        return JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    //Converter o objeto em Json e gravar em arquivo.
    protected void gravarArquivo(List<T> objeto, String arquivo) throws Exception{
        //1° Converter objeto em Json.
        String json = getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(objeto);

        //2° Gravar em arquivo no disco.
        FileOutputStream out = new FileOutputStream(arquivo);
        out.write(json.getBytes(StandardCharsets.UTF_8));
        out.close();
    }

    //Ler o arquivo e converte o conteúdo em objeto;
    protected String consultarArquivo(String arquivo) throws Exception{
        //1° Ler o Arquivo.
        FileInputStream in = new FileInputStream(arquivo);
        String json = new String(in.readAllBytes());
        //2° Converter o Conteúdo do Arquivo em Objeto.
        return json;
    }
}
