package femass.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import femass.model.Emprestimo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DaoEmprestimo extends Persistencia<Emprestimo> implements DaoGeral<Emprestimo> {
    private static final String NOMEARQUIVO = "Emprestimos.json";
    @Override
    public void gravar(Emprestimo emprestimo) throws Exception {
        List<Emprestimo> emprestimos = consultar();
        emprestimos.add(emprestimo);
        super.gravarArquivo(emprestimos, NOMEARQUIVO);
    }
    @Override
    public List<Emprestimo> consultar() throws Exception {
        try{
            String listaJson = super.consultarArquivo(NOMEARQUIVO);
            List<Emprestimo> emprestimos = getMapper().readValue(listaJson, new TypeReference<List<Emprestimo>>(){});
            return emprestimos;
        }
        catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }

    public void atualizarId() throws Exception{
        Emprestimo.atualizarProximoIdEmp(consultar());
    }
}
