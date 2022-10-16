package femass.model;

import java.util.List;

public class Livro {
    private Long codigo;
    private String titulo;
    private String ano;
    private List<Autor> autores;
    private static Long proximoCodigo = 1L;


    public Livro(String titulo, String ano, List<Autor> autores) {
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
        this.autores = autores;
        this.ano = ano;
    }

    public Livro() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAno() {
        return ano;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " | Título: " + this.titulo.toUpperCase() + " | Ano: " + this.ano.toUpperCase();
    }
    @Override
    public boolean equals(Object obj) {
        Livro livro = (Livro) obj;

        if(livro.getCodigo().equals(this.codigo)) return true;
        return false;
    }

    public static void atualizarProximoCodigoLivro(List<Livro> livros){
        proximoCodigo = livros.get(livros.size() - 1).getCodigo() + 1;
    }
}
