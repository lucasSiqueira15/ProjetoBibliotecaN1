package femass.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Emprestimo {
    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private static Long proximoId = 1L;
    private Exemplar exemplar;
    private Leitor leitor;

    public Emprestimo(Exemplar exemplar, Leitor leitor) {
        this.id = proximoId;
        proximoId++;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(leitor.getPrazoMaximoDevolucao());
        this.dataDevolucao = null;
        this.exemplar = exemplar;
        this.exemplar.setDisponivel(false);
        this.leitor = leitor;
    }

    public Emprestimo() {
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public static Long getProximoId() {
        return proximoId;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void devolverEmprestimo(){
        this.exemplar.setDisponivel(true);
        this.dataDevolucao = LocalDate.now();
    }

    @Override
    public String toString() {
        if(this.dataDevolucao == null){
            return "ID: " + this.id
                    + " | Leitor: " + this.leitor.toString()
                    + " | Exemplar: " + this.exemplar.toString()
                    + " | Data Emprestimo: " + this.dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    + " | Data Prevista Devolução: " + this.dataPrevistaDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    + " | Data Devolução: Pendente";
        }
        return "ID: " + this.id
                + " | Leitor: " + this.leitor.toString()
                + " | Exemplar: " + this.exemplar.toString()
                + " | Data Emprestimo: " + this.dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " | Data Prevista Devolução: " + this.dataPrevistaDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " | Data Devolução: " + this.dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        Emprestimo emprestimo = (Emprestimo) obj;
        if(emprestimo.getId().equals(this.id)) return true;
        return false;
    }

    public static void atualizarProximoIdEmp(List<Emprestimo> emprestimos){
        if(emprestimos.size() == 0){
            proximoId = 1L;
        }
        else{
            proximoId = emprestimos.get(emprestimos.size() - 1).getId() + 1;
        }
    }
}
