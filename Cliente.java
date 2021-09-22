public class Cliente {
    private String nome;
    private String idade;
    private String sexo;
    private String cpf;
    private Conta conta;
    private Endereco endereco;
    private Contato contato;

    public Cliente(){}

    public Cliente(String nome, String idade, String sexo, String cpf, Conta conta, Endereco endereco, Contato contato){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.conta = conta;
        this.endereco = endereco;
        this.contato = contato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }public String getNome() {
        return this.nome;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }public String getIdade() {
        return this.idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }public String getSexo() {
        return this.sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }public String getCpf() {
        return this.cpf;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }public Conta getConta() {
        return this.conta;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }public Endereco getEndereco() {
        return this.endereco;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }public Contato getContato() {
        return this.contato;
    }
    
}
