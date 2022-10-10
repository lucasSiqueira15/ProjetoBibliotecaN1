package femass.model;

public class Autor {
    private Long id;
    private String nome;
    private String sobrenome;
    private String nacionalidade;

    private static Long proximoId = 1L;

    public Autor(String nome, String sobrenome, String nacionalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
        this.id = proximoId;
        proximoId++;
    }
    public Autor() {
        this.id = proximoId;
        proximoId++;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " | Nome: " + this.nome.toUpperCase() + " | Sobrenome: " +
                this.sobrenome.toUpperCase() + " | Nacionalidade: " + this.nacionalidade.toUpperCase();
    }

}
