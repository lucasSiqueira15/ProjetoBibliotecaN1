package femass.teste;

import femass.dao.AutorDao;
import femass.model.Autor;

import java.util.ArrayList;
import java.util.List;

public class mainTeste {
    public static void main(String[] args) {
        lerDados();

    }

    private static void gravarDados(){
        AutorDao teste = new AutorDao();
        Autor a1 = new Autor("Lucas", "Silva", "Brasil");
        Autor a2 = new Autor("Cintia", "Barros", "Chile");

        try{
            teste.gravar(a1);
            teste.gravar(a2);
        }
        catch (Exception erro){
            System.out.println(erro.getMessage());;
        }
    }

    private static void lerDados(){
        AutorDao teste = new AutorDao();
        List<Autor> testeAutores = new ArrayList<Autor>();
        try{
            testeAutores = teste.consultar();
            for(Autor a: testeAutores){
                System.out.println(a);
            }
        }
        catch (Exception erro){
            System.out.println(erro.getMessage());;
        }
    }
}
