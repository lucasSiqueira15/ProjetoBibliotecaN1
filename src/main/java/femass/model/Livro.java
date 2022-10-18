package femass.model;

import java.util.List;

public class Livro {
    private Long codigo;
    private String titulo;
    private String ano;
    private List<Autor> autores;
    private static Long proximoCodigo = 1L;


    public Livro(String titulo, String ano, List<Autor> autores) {
        if(autores.isEmpty()){
            throw new IllegalArgumentException("POR FAVOR, INSERIR UM AUTOR PARA PODER CADASTRAR SEU LIVRO.");
        }
        else {
            this.codigo = proximoCodigo;
            proximoCodigo++;
            this.titulo = titulo;
            this.autores = autores;
            this.ano = ano;
        }
    }

    public Livro() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public static void setProximoCodigo(Long proximoCodigo) {
        Livro.proximoCodigo = proximoCodigo;
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
        StringBuilder autores = new StringBuilder();
        for(int i = 0; i < this.autores.size(); i++){
            if(autores.toString().equals("")){
                autores = new StringBuilder(this.autores.get(i).getNome() + " " + this.autores.get(i).getSobrenome());
            }
            else{
                autores.append(", ").append(this.autores.get(i).getNome()).append(" ").append(this.autores.get(i).getSobrenome());
            }
        }

        return "Código: " + this.codigo + " | Título: " + this.titulo.toUpperCase() + " | Ano: " + this.ano.toUpperCase() + " | Autores: " + autores.toString().toUpperCase();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        Livro livro = (Livro) obj;
        if(livro.getCodigo().equals(this.codigo)) return true;
        return false;
    }

    public static void atualizarProximoCodigoLivro(List<Livro> livros){
        if(livros.isEmpty()){
            proximoCodigo = 1L;
        }
        else{
            proximoCodigo = livros.get(livros.size() - 1).getCodigo() + 1;
        }
    }
}
