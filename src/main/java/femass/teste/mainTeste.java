package femass.teste;

import femass.dao.AutorDao;
import femass.model.Autor;

import java.util.ArrayList;
import java.util.List;

public class mainTeste {

    private static Autor a1 = new Autor("Lucas", "Silva", "Brasil");
    private static Autor a2 = new Autor("Cintia", "Barros", "Chile");
    private static Autor a3 = new Autor("Heitor", "Siqueira", "Uruguai");
    public static void main(String[] args) {

        gravarDados();
        lerDados();
        excluirDados();
        alterarDados();

    }

    private static void gravarDados(){
        AutorDao teste = new AutorDao();

        try{
            teste.gravar(a1);
            teste.gravar(a2);
            teste.gravar(a3);
        }
        catch (Exception erro){
            System.out.println(erro.getMessage());;
        }
    }

    private static void lerDados(){
        AutorDao teste = new AutorDao();
        List<Autor> testeAutores;
        try{
            System.out.println("-----------------LENDO----------------");
            testeAutores = teste.consultar();
            for(Autor a: testeAutores){
                System.out.println(a);
            }
            System.out.println("---------------------------------");
        }
        catch (Exception erro){
            System.out.println(erro.getMessage());;
        }
    }

    private static void excluirDados(){
        AutorDao teste = new AutorDao();
        List<Autor> testeAutores;

        try{
            System.out.println("-----------------EXCLUINDO----------------");
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

        try{
            System.out.println("-----------------ALTERANDO----------------");
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
