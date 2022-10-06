package femass.teste;

import femass.dao.AutorDao;
import femass.model.Autor;

public class mainTeste {
    public static void main(String[] args) {
        AutorDao teste = new AutorDao();
        Autor a1 = new Autor("Lucas", "Silva", "Brasil");
        Autor a2 = new Autor("Cintia", "Barros", "Chile");

        try{
            teste.gravar(a1);
            teste.gravar(a2);
        }
        catch (Exception erro){
            erro.getMessage();
        }

    }
}
