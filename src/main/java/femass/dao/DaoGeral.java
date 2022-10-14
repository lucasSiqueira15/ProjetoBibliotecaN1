package femass.dao;

import java.util.List;

public interface DaoGeral<T> {

    void gravar(T objeto) throws Exception;
    List<T> consultar() throws Exception;

}
