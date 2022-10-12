package femass.dao;

import femass.model.Autor;
import java.util.List;

public class AutorDao extends Persistencia<Autor> implements DaoGeral<Autor> {

    private static final String NOMEARQUIVO = "Autores.json";
    public void gravar(Autor autor) throws Exception {
        List<Autor> autores = consultar();
        autores.add(autor);
        super.gravarArquivo(autores, NOMEARQUIVO);
    }

    public List<Autor> consultar() throws Exception{
        return super.consultarArquivo(NOMEARQUIVO);
    }

    public void excluir(Autor autor) throws Exception{
        super.excluirRegistro(autor, NOMEARQUIVO);
    }

//    public void alterar(Autor autor, String nomeAtributo, String novoValor) throws Exception{
//        //1° Ler o Arquivo.
//        FileInputStream in = new FileInputStream("Autores.json");
//        String json = new String(in.readAllBytes());
//
//        //2° Converter o Conteúdo do Arquivo em Objeto.
//        ObjectMapper objectMapper = new ObjectMapper();
//        this.autores = objectMapper.readValue(json, new TypeReference<List<Autor>>(){});
//
//        //3° Buscar o autor na lista de autores e depois alterar o valor desejado.
//        if(this.autores.contains(autor)){
//            int index = this.autores.indexOf(autor);
//            if (nomeAtributo.toLowerCase().equals("nome")) {
//                this.autores.get(index).setNome(novoValor);
//            } else {
//                if (nomeAtributo.toLowerCase().equals("sobrenome")) {
//                    this.autores.get(index).setSobrenome(novoValor);
//                } else {
//                    if (nomeAtributo.toLowerCase().equals("nacionalidade")) {
//                        this.autores.get(index).setNacionalidade(novoValor);
//                    } else {
//                        throw new IllegalArgumentException("Nome da coluna não encontrado. Por favor, use uma das opções: Nome, Sobrenome ou Nacionalidade.");
//                    }
//                }
//            }
//        }
//        else {
//            throw new IllegalArgumentException("O autor informado não existe na lista de autores.");
//        }
//
//        //4° Converter o objeto Autor em Json.
//        json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(autores);
//
//        //5° Gravar Json em arquivo no disco.
//        FileOutputStream out = new FileOutputStream("Autores.json");
//        out.write(json.getBytes(StandardCharsets.UTF_8));
//        out.close();
//
//    }

}
