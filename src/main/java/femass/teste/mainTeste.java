package femass.teste;

import femass.dao.AutorDao;
import femass.model.Autor;

import java.util.ArrayList;
import java.util.List;

public class mainTeste {
    public static void main(String[] args) {

        gravarDados();
        lerDados();
        excluirDados();
        alterarDados();

    }

    private static void gravarDados(){
        AutorDao teste = new AutorDao();
        Autor a1 = new Autor("Lucas", "Silva", "Brasil");
        Autor a2 = new Autor("Cintia", "Barros", "Chile");
        Autor a3 = new Autor("Heitor", "Siqueira", "Uruguai");

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
        List<Autor> testeAutores;
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

    private static void excluirDados(){
        AutorDao teste = new AutorDao();
        List<Autor> testeAutores;
        Autor a2 = new Autor("Cintia", "Barros", "Chile");

        try{
            testeAutores = teste.consultar();
            for(Autor a: testeAutores){
                System.out.println(a);
            }

            System.out.println("---------------------------------");
            teste.excluir(a2);
            testeAutores = teste.consultar();

            for(Autor a: testeAutores){
                System.out.println(a);
            }
        }
        catch (Exception erro){
            System.out.println(erro.getMessage());;
        }
    }

    private static void alterarDados(){
        AutorDao teste = new AutorDao();
        List<Autor> testeAutores;
        Autor a3 = new Autor("Heitor", "Siqueira", "Uruguai");

        try{
            testeAutores = teste.consultar();
            for(Autor a: testeAutores){
                System.out.println(a);
            }

            System.out.println("---------------------------------");
            teste.alterar(a3, "SOBRENOME", "Silva");
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
