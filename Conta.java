public class Conta {
    private int agencia;
    private int numeroDaConta;
    private double saldo;

    public Conta(){}

    public Conta(int agencia, int numeroDaConta, double saldo){
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }public int getAgencia() {
        return this.agencia;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }public int getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }public double getSaldo() {
        return this.saldo;
    }

}
