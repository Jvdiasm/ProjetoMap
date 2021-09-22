import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList <Cliente> listaDeCliente = new ArrayList <Cliente>();  
    public Banco(){}
    public Banco(ArrayList <Cliente> listaDeCliente){
        this.listaDeCliente = listaDeCliente;
    }
    public void setListaDeCliente(ArrayList<Cliente> listaDeCliente) {
        this.listaDeCliente = listaDeCliente;
    }public ArrayList<Cliente> getListaDeCliente() {
        return this.listaDeCliente;
    }
    int numeroDaConta = 1;
    Scanner Entrada = new Scanner (System.in);
    Scanner EntradaNum = new Scanner (System.in);
    public void cadastrarCliente (ArrayList <Cliente> listaDeCliente){
        Cliente cliente = new Cliente();
        System.out.println("\nDados Pessoais do cliente : ");
        System.out.print("\nDigite o nome do cliente : ");
        cliente.setNome(Entrada.nextLine());
        System.out.print("\nDigite a idade do(a) " + cliente.getNome() + " : ");
        cliente.setIdade(Entrada.nextLine());
        System.out.print("\nDigite o sexo do(a) " + cliente.getNome() + " : ");
        cliente.setSexo(Entrada.nextLine());
        System.out.print("\nDigite o cpf do(a) " + cliente.getNome() + " : ");
        cliente.setCpf(Entrada.nextLine());

        System.out.println("\nInformacoes da conta do cliente : ");
        Conta conta = new Conta();
        System.out.print("\nDigite a agencia do(a) " + cliente.getNome() + " : ");
        conta.setAgencia(EntradaNum.nextInt());
        conta.setNumeroDaConta(numeroDaConta);
        System.out.print("\nSeu cliente " + cliente.getNome() + " ficou com a conta de numero = " + numeroDaConta);
        numeroDaConta ++;
        conta.setSaldo(0); 
        cliente.setConta(conta);

        System.out.println("\n\nInformacoes do endereco do cliente : ");
        Endereco endereco = new Endereco();
        System.out.print("\nDigite o pais do(a) " + cliente.getNome() + " : ");  
        endereco.setPais(Entrada.nextLine());
        System.out.print("\nDigite o estado do(a) " + cliente.getNome() + " : ");
        endereco.setEstado(Entrada.nextLine());
        System.out.print("\nDigite a cidade do(a) " + cliente.getNome() + " : ");
        endereco.setCidade(Entrada.nextLine());
        System.out.print("\nDigite o bairro do(a) " + cliente.getNome() + " : ");
        endereco.setBairro(Entrada.nextLine());
        System.out.print("\nDigite a rua do(a) " + cliente.getNome() + " : ");
        endereco.setRua(Entrada.nextLine());
        System.out.print("\nDigite o numero do(a) " + cliente.getNome() + " : ");
        endereco.setNumero(Entrada.nextLine());
        cliente.setEndereco(endereco);

        System.out.println("\nInformacoes do contato do cliente : ");
        Contato contato = new Contato();
        System.out.print("\nDigite o email do(a) " + cliente.getNome() + " : ");
        contato.setEmail(Entrada.nextLine());
        System.out.print("\nDigite o telefone do(a) " + cliente.getNome() + " : ");
        contato.setTelefone(Entrada.nextLine());
        System.out.print("\nDigite o celular do(a) " + cliente.getNome() + " : ");
        contato.setCelular(Entrada.nextLine());
        cliente.setContato(contato);
        System.out.println("\nCadastro realizado com sucesso ! ");
        listaDeCliente.add(cliente);       
    }

    public void mostrarCliente(ArrayList <Cliente> listaDeCliente){
        boolean achou = false; 
        int numeroDaContaAProcurar;
        System.out.print("\nDigite o numero da conta do cliente que voce quer mostrar os dados : ");
        numeroDaContaAProcurar = EntradaNum.nextInt();
        for (Cliente cliente : listaDeCliente) {
            if(cliente.getConta().getNumeroDaConta() == numeroDaContaAProcurar){
                achou = true;
                System.out.println("\nDados Pessoais do cliente : ");

                System.out.println("\nNome do cliente = " + cliente.getNome());
                System.out.println("\nIdade do cliente = " + cliente.getIdade());
                System.out.println("\nSexo do cliente = " + cliente.getSexo());
                System.out.println("\nCPF do cliente = " + cliente.getCpf());

                System.out.println("\nInformacoes da conta do cliente : ");

                System.out.println("\nAgencia do cliente = " + cliente.getConta().getAgencia());
                System.out.println("\nNumero da conta do cliente = " + cliente.getConta().getNumeroDaConta());
                System.out.println("\nSaldo do cliente = " + cliente.getConta().getSaldo() + " R$ ");

                System.out.println("\nInformacoes do endereco do cliente : ");

                System.out.println("\nPais do cliente = " + cliente.getEndereco().getPais());
                System.out.println("\nEstado do cliente = " + cliente.getEndereco().getEstado());
                System.out.println("\nCidade do cliente = " + cliente.getEndereco().getCidade());
                System.out.println("\nBairro do cliente = " + cliente.getEndereco().getBairro());
                System.out.println("\nRua do cliente = " + cliente.getEndereco().getRua());
                System.out.println("\nNumero do cliente = " + cliente.getEndereco().getNumero());

                System.out.println("\nInformacoes do contato do cliente : ");

                System.out.println("\nEmail do cliente = " + cliente.getContato().getEmail());
                System.out.println("\nTelefone do cliente = " + cliente.getContato().getTelefone());
                System.out.println("\nCelular do cliente = " + cliente.getContato().getCelular());
                break;
            }
        }
        if (! achou){
            System.out.println("\nNao existe cliente com esse numero de conta");
        }
        
    }

    public void sacarDinheiro (ArrayList <Cliente> listaDeCliente){
        Conta conta = new Conta();
        Boolean achou = false;
        int numeroDaContaAProcurar;
        double valorDoSaque, saldoAtual;
        System.out.print("\nDigite o numero da conta do cliente para SACAR o dinheiro : ");
        numeroDaContaAProcurar = EntradaNum.nextInt();
        for(int i = 0; i < listaDeCliente.size(); i++){
            if(listaDeCliente.get(i).getConta().getNumeroDaConta() == numeroDaContaAProcurar){
                achou = true;
                int agencia, numeroDaConta;
                agencia = listaDeCliente.get(i).getConta().getAgencia();
                numeroDaConta = listaDeCliente.get(i).getConta().getNumeroDaConta();
                System.out.print("\nDigite o valor do SAQUE : ");
                valorDoSaque = EntradaNum.nextDouble();
                if(valorDoSaque > listaDeCliente.get(i).getConta().getSaldo()){
                    System.out.println("\nImpossivel sacar um valor maior que seu saldo atual ");
                    break;
                }else{
                    saldoAtual = listaDeCliente.get(i).getConta().getSaldo();
                    saldoAtual -= valorDoSaque;
                    conta.setSaldo(saldoAtual);
                    conta.setAgencia(agencia);
                    conta.setNumeroDaConta(numeroDaConta);
                    listaDeCliente.get(i).setConta(conta);
                    System.out.println("\nSaque realizado com sucesso ! ");
                    break;
                } 
            }
        }
        if(! achou){
            System.out.print("\nNao existe cliente com esse numero de conta ");
        }
    }

    public void depositarDinheiro (ArrayList <Cliente> listaDeCliente){
        boolean achou = false;
        Conta conta = new Conta();
        int numeroDaContaAProcurar;
        double valorDoDeposito, saldoAtual;
        System.out.print("\nDigite o numero da conta do cliente para DEPOSITAR o dinheiro : ");
        numeroDaContaAProcurar = EntradaNum.nextInt();
        for(int i = 0; i < listaDeCliente.size(); i++){
            if(listaDeCliente.get(i).getConta().getNumeroDaConta() == numeroDaContaAProcurar){
                achou = true;
                int agencia, numeroDaConta;
                agencia = listaDeCliente.get(i).getConta().getAgencia();
                numeroDaConta = listaDeCliente.get(i).getConta().getNumeroDaConta();
                System.out.print("\nDigite o valor do DEPOSITO : ");
                valorDoDeposito = EntradaNum.nextDouble();
                saldoAtual = listaDeCliente.get(i).getConta().getSaldo();
                saldoAtual += valorDoDeposito;
                conta.setSaldo(saldoAtual);
                conta.setAgencia(agencia);
                conta.setNumeroDaConta(numeroDaConta);
                listaDeCliente.get(i).setConta(conta); 
                System.out.println("\nDeposito realizado com sucesso ! ");
                break;
            }
        }
        if (! achou){
            System.out.print("\nNao existe cliente com esse numero de conta ");
        }
    }

    public void trasnferirDinheiro(ArrayList <Cliente> listaDeCliente){
        boolean achouTransferidor = false;
        boolean achouReceptor = false;
        Conta contaTransferidor = new Conta();
        Conta contaReceptor = new Conta();
        double valorDaTransferencia;
        int numeroDaContaAProcurarTransferidor, numeroDaContaAProcurarReceptor;
        double saldoAtualTransferidor, saldoAtualReceptor;
        System.out.print("\nDigite o numero da conta do cliente que vai TRASNFERIR o dinheiro : ");
        numeroDaContaAProcurarTransferidor = EntradaNum.nextInt();
        for(int i = 0; i < listaDeCliente.size(); i++){
            if(listaDeCliente.get(i).getConta().getNumeroDaConta() == numeroDaContaAProcurarTransferidor){
                achouTransferidor = true;
                System.out.print("\nDigite o valor que voce quer trasnferir : ");
                valorDaTransferencia = EntradaNum.nextDouble();
                if(valorDaTransferencia > listaDeCliente.get(i).getConta().getSaldo()){
                    System.out.print("\nImpossivel transferir valor maior do que o cliente tem em caixa : ");
                }else{
                    int agenciaDoTransferidor, numeroDaContaDoTransferidor;
                    int agenciaDoReceptor, numeroDaContaDoReceptor;
                    agenciaDoTransferidor = listaDeCliente.get(i).getConta().getAgencia();
                    numeroDaContaDoTransferidor = listaDeCliente.get(i).getConta().getNumeroDaConta();
                    saldoAtualTransferidor = listaDeCliente.get(i).getConta().getSaldo();
                    System.out.print("\nDigite o numero da conta do cliente que vai RECEBER o dinheiro : ");
                    numeroDaContaAProcurarReceptor = EntradaNum.nextInt();
                    for(int j = 0; j < listaDeCliente.size(); j++){
                        if (listaDeCliente.get(j).getConta().getNumeroDaConta() == numeroDaContaAProcurarReceptor){
                            achouReceptor = true;
                            agenciaDoReceptor = listaDeCliente.get(j).getConta().getAgencia();
                            numeroDaContaDoReceptor = listaDeCliente.get(j).getConta().getNumeroDaConta();
                            saldoAtualReceptor = listaDeCliente.get(j).getConta().getSaldo();
                            saldoAtualReceptor += valorDaTransferencia;
                            contaReceptor.setAgencia(agenciaDoReceptor);
                            contaReceptor.setNumeroDaConta(numeroDaContaDoReceptor);
                            contaReceptor.setSaldo(saldoAtualReceptor);
                            listaDeCliente.get(j).setConta(contaReceptor);

                            saldoAtualTransferidor -= valorDaTransferencia;
                            contaTransferidor.setAgencia(agenciaDoTransferidor);
                            contaTransferidor.setNumeroDaConta(numeroDaContaDoTransferidor);
                            contaTransferidor.setSaldo(saldoAtualTransferidor);
                            listaDeCliente.get(i).setConta(contaTransferidor);
                            
                            j = listaDeCliente.size() + 1;
                            i = listaDeCliente.size() + 1;
                            System.out.println("\nTrasnferencia realizada com sucesso ! ");
                        
                        }
                    }
                    if(! achouReceptor){
                        System.out.print("\nNao existe cliente com esse numero de conta para recber o dinheiro ");
                    }
                }
            }
        }
        if(! achouTransferidor){
            System.out.print("\nNao existe cliente com esse numero para transferencia ");
        }
    }
    
} 