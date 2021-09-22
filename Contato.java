public class Contato {
    private String email;
    private String telefone;
    private String celular;

    public Contato(){}

    public Contato(String email, String telefone, String celular){
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }public String getEmail() {
        return this.email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }public String getTelefone() {
        return this.telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }public String getCelular() {
        return this.celular;
    }
}
