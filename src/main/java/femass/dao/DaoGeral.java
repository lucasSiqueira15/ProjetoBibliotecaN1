package femass.dao;

import java.util.List;

public interface DaoGeral<T> {

    public void gravar(T objeto) throws Exception;
    public List<T> consultar() throws Exception;
    //public void alterar(T objeto, String atributo, String valor) throws Exception;
    public void excluir(T objeto) throws Exception;

}
