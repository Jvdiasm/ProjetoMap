public class Endereco{
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public Endereco(){}

    public Endereco(String pais, String estado, String cidade, String bairro, String rua, String numero){
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;      
    }

    public void setPais(String pais) {
        this.pais = pais;
    }public String getPais() {
        return this.pais;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }public String getEstado() {
        return this.estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }public String getCidade() {
        return this.cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }public String getBairro() {
        return this.bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }public String getRua() {
        return this.rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getNumero() {
        return this.numero;
    }
    
}