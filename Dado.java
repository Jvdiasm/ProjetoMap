package sep;

public class Dado {
    private int tipo;
    private String cpf;

    public Dado(){}

    public Dado(int tipo, String cpf){
        this.tipo = tipo;
        this.cpf = cpf;
    }

    public void setTipo(int tipo){
        this.tipo =  tipo;
    }

    public int getTipo(){
        return this.tipo;
    }

    public void setCpf(String cpf){
        this.cpf =  cpf;
    }

    public String getCpf(){
        return this.cpf;
    }


}
