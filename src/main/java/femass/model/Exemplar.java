package femass.model;

import java.time.LocalDate;
import java.util.List;

public class Exemplar {
    private Long codigo;
    private LocalDate dataAquisicao;
    private Livro livro;
    private static boolean disponivel;
    private static Long proximoCodigo = 1L;

    public Exemplar(LocalDate dataAquisicao, Livro livro) {
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.dataAquisicao = dataAquisicao;
        this.livro = livro;
        disponivel = true;
    }

    public Exemplar() {
    }

    public static void setDisponivel(boolean disponivel) {
        Exemplar.disponivel = disponivel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public static Long getProximoCodigo() {
        return proximoCodigo;
    }

    @Override
    public String toString() {
        StringBuilder autores = new StringBuilder();
        for(int i = 0; i < this.livro.getAutores().size(); i++){
            if(autores.toString().equals("")){
                autores = new StringBuilder(this.livro.getAutores().get(i).getNome() + " " + this.livro.getAutores().get(i).getSobrenome());
            }
            else{
                autores.append(", ").append(this.livro.getAutores().get(i).getNome()).append(" ").append(this.livro.getAutores().get(i).getSobrenome());
            }
        }

        return "Código: " + this.codigo + " | " + this.livro.getTitulo().toUpperCase() + " | Autores: " + autores.toString().toUpperCase();
    }
    @Override
    public boolean equals(Object obj) {
        Exemplar exemplar = (Exemplar) obj;
        if(exemplar.getCodigo().equals(this.codigo)) return true;
        return false;

    }

    public static void atualizarProximoCodigoExemplar(List<Exemplar> exemplares){
        proximoCodigo = exemplares.get(exemplares.size() - 1).getCodigo() + 1;
    }
}
