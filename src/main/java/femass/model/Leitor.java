package femass.model;

public abstract class Leitor {

    protected Long codigo;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected static Integer prazoMaximoDevolucao;
    protected static Long proximoCodigo = 1L;

    public Leitor(){
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static void setPrazoMaximoDevolucao(Integer prazoMaximoDevolucao) {
        Leitor.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    public static void setProximoCodigo(Long proximoCodigo) {
        Leitor.proximoCodigo = proximoCodigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.codigo + " | Nome: " + this.nome.toUpperCase();
    }

    @Override
    public boolean equals(Object obj) {
        Leitor leitor = (Leitor) obj;

        if(leitor.getCodigo().equals(this.codigo)) return true;
        return false;
    }
}
