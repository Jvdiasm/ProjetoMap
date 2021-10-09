package sep;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    static Scanner  input = new Scanner(System.in);
    static Menu menu =  new Menu();
    public static void main(String[] args) {
        Conexao con = new Conexao();
        con.conexao();
        Dado dado = new Dado();
        int escolha, escolhaf;
        boolean programa = true;
        while(programa){
            menu.menuWhile();
            escolha = input.nextInt();
            if(escolha == 1){
                dado = login();
                if(dado == null) continue;
                switch(dado.getTipo()){
                    case 1:
                        while(true){
                            menu.menuG();
                            escolhaf = input.nextInt();
                            funcoesG(escolhaf);
                            if(check()!=0){
                                break;
                            }
                        }break;
                    case 2:
                        while(true){
                            menu.menuP();
                            escolhaf = input.nextInt();
                            funcoesP(escolhaf);
                            if(check()!=0){
                                break;
                            }
                        }break;
                    case 3:
                        while(true){
                            verificarAluno(dado.getCpf(),new Responsavel(),3);
                            if(check()!=0){
                              break;  
                            }
                        }break;  
                    default:
                        break;
                }
            }else{
                System.out.print("\n\tPROGRAMA FINALIZADO");
                programa = false;
            }
        }
        input.close();
        con.desconecta();
    }
    
    public static Dado login(){
        Conexao con = new Conexao();
        con.conexao();
        input.nextLine();
        Dado dado = new Dado();
        String cpf, senha, sql;
        int tipo;
        System.out.print("\n-------------------------------------LOGIN-------------------------------------"+
        "\nCPF: ");
        dado.setCpf(input.nextLine());
        System.out.print("SENHA: ");
        senha = input.nextLine();
        sql = "SELECT * FROM USUARIO WHERE CPF = '"+dado.getCpf()+"' AND SENHA = '"+senha+"'";
        ResultSet rs = con.select(sql);
        try{
            if(rs.next()){
                dado.setTipo(rs.getInt("tipo"));
                return dado;
            }else{
                System.out.println("\n\tLOGIN INVALIDO\n\tTENTE NOVAMENTE");
                return null;
            }
        }catch(SQLException e){
            System.out.print("\n\tERRO DE SISTEMA\n");
            e.printStackTrace();
            return null;
        }
    }

    public static void cadastro(){
        Conexao con =  new Conexao();
        con.conexao();
        String nome,cpf,senha,sql;
        int id;
        ResultSet rs;
        input.nextLine();
        System.out.print("\nNOME: ");
        nome = input.nextLine();
        System.out.print("CPF: ");
        cpf = input.nextLine();
        System.out.print("SENHA: ");
        senha = input.nextLine();
        sql = "INSERT INTO USUARIO(NOME,CPF,SENHA,TIPO)VALUES('"+nome+"','"+cpf+"','"+senha+"',3)";
        con.update(sql);
        sql = "SELECT ID FROM USUARIO WHERE CPF = '"+cpf+"'";
        rs =  con.select(sql);
        try{
            if(rs.next()){
                id = rs.getInt("ID");
                addContato(id);
                addEndereco(id); 
                sql = "UPDATE USUARIO SET IDCONTATOU = '"+id+"',IDENDERECOU = '"+id+"' WHERE ID = '"+id+"'";
                con.update(sql);
                relaciona(cpf);
                con.desconecta();   
            }else{
                sql = "DELETE FROM USUARIO WHERE CPF = '"+cpf+"'";
                con.update(sql);
                con.desconecta();
                System.out.print("\n\tOPERACAO FALHOU");
            }
        }catch(SQLException e){
                System.out.print("\n\tERRO DE SISTEMA");
        }
    }

    public static void relaciona(String cpf){
        Conexao con = new Conexao();
        con.conexao();
        String matricula,sql;
        input.nextLine();
        System.out.print("MATRICULA DO ALUNO A SER RELACIONADO: ");
        matricula = input.nextLine();
        sql = "INSERT INTO USUARIO_ALUNO (CPFR,MATRICULAR) VALUES ('"+cpf+"','"+matricula+"')";
        con.update(sql);
    }

    public static void addContato(int id){
        Conexao con =  new Conexao();
        con.conexao();
        String telefone,email,sql;
        System.out.print("\nTELEFONE: ");
        telefone = input.nextLine();
        System.out.print("EMAIL: ");
        email = input.nextLine();
        sql = "INSERT INTO CONTATO(IDCONTATO,TELEFONE,EMAIL)VALUES('"+id+"','"+telefone+"','"+email+"')";
        con.update(sql);
        con.desconecta();
    }
    
    public static void addEndereco(int id){
        Conexao con =  new Conexao();
        con.conexao();
        String bairro,rua,numero,sql;
        System.out.print("\nBAIRRO: ");
        bairro = input.nextLine();
        System.out.print("RUA: ");
        rua = input.nextLine();
        System.out.print("NUMERO: ");
        numero = input.nextLine();
        sql = "INSERT INTO ENDERECO(IDENDERECO,BAIRRO,RUA,NUMERO)VALUES('"+id+"','"+bairro+"','"+rua+"','"+numero+"')";
        con.update(sql);
        con.desconecta();
    }

    public static void editarCadastro(String cpf){
        Conexao con =  new Conexao();
        con.conexao();
        String sql, editar, editar2, editar3;
        ResultSet rs;
        int escolha, id = 0;
        menu.menuEditar();
        escolha = input.nextInt(); 
        try{
            sql = "SELECT * FROM USUARIO WHERE CPF = '"+cpf+"'";
            rs = con.select(sql);
            if(rs.next()){
                id = rs.getInt("id");
            }
            switch(escolha){
                case 1:
            	    input.nextLine();
                    System.out.print("TELELFONE: ");
                    editar = input.nextLine();
                    sql = "UPDATE CONTATO SET TELEFONE = '"+editar+"'WHERE IDCONTATO = '"+id+"'";
                    con.update(sql);
                    con.desconecta();
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("EMAIL: ");
                    editar = input.nextLine();
                    sql = "UPDATE CONTATO SET EMAIL = '"+editar+"'WHERE IDCONTATO = '"+id+"'";
                    con.update(sql);
                    con.desconecta();
                    break;
                case 3:
                    input.nextLine();
                    System.out.print("BAIRRO: ");
                    editar = input.nextLine();
                    System.out.print("RUA: ");
                    editar2 = input.nextLine();
                    System.out.print("NUMERO: ");
                    editar3 = input.nextLine();
                    sql = "UPDATE ENDERECO SET BAIRRO = '"+editar+"',RUA = '"+editar2+"',NUMERO = '"+editar3+"'WHERE IDENDERECO= '"+id+"'";
                    con.update(sql);
                    con.desconecta();
                    break;
                default:
                    System.out.print("\n\tESCOLHA INVALIDA");
                    con.desconecta();
                    break;
            }
        }catch(SQLException e){
            System.out.print("\n\tERRO AO ATUALIZAR");
            e.printStackTrace();
            con.desconecta();
        }
        
    }

    public static void planejarAula(int id){
        Conexao con = new Conexao();
        con.conexao();
        Date data = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dataFormatada = formatter.format(data);
        char s1,s2,s3,s4;
        input.nextLine();
        System.out.print("\nSEMANA 1: ");
        s1 = input.nextLine().charAt(0);
        System.out.print("\nSEMANA 2: ");
        s2 = input.nextLine().charAt(0);
        System.out.print("\nSEMANA 3: ");
        s3 = input.nextLine().charAt(0);
        System.out.print("\nSEMANA 4: ");
        s4 = input.nextLine().charAt(0);
        String sql = "UPDATE TURMA SET SEMANA1 = '"+s1+"',SEMANA2 = '"+s2+"',SEMANA3 = '"+s3+"',SEMANA4 = '"+s4+"'"+
        ",DATAPL = '"+dataFormatada+"'WHERE IDTURMA = '"+id+"'";
        con.update(sql);
        con.desconecta();
    }

    public static void verificarAluno(String t, SQLCommand command, int tipo){
        Conexao con = new Conexao();
        char status;
        String sql = command.organiza(t);
        con.conexao();
        ResultSet rs = con.select(sql);
        try{
            System.out.print("\nIDTURMA\t|NOME\t\t|STATUS\t|S1\t|S2\t|S3\t|S4");
            while(rs.next()){
                System.out.print("\n"+rs.getInt("IDTURMA"));
                System.out.print("\t|"+rs.getString("NOMEA"));
                System.out.print("\t|"+rs.getString("STATUS"));
                System.out.print("\t|"+rs.getString("SEMANA1"));
                System.out.print("\t|"+rs.getString("SEMANA2"));
                System.out.print("\t|"+rs.getString("SEMANA3"));
                System.out.print("\t|"+rs.getString("SEMANA4"));
                if(tipo == 2){
                    System.out.print("\nALTERAR STATUS (A/N): ");
                    status = input.nextLine().charAt(0);
                    if(status != 'A' && status != 'N'){
                        System.out.print("\n\tSTATUS INVALIDO!");
                    }
                    else{
                        sql = "UPDATE ALUNO SET STATUS ='"+status+"' WHERE MATRICULA = '"+t+"'";
                        con.update(sql);
                    }
                }
            }con.desconecta(); 
        }catch(SQLException e){
            System.out.println("\n\tERRO DE SISTEMA!\n");
            e.printStackTrace();
        }

    }

    public static void verTurmas(){
        Conexao con = new Conexao();
        con.conexao();
        ResultSet rs;
        String sql;
        sql = "SELECT IDTURMA,DATAPL,MATRICULA,NOMEA,STATUS,SEMANA1,SEMANA2,SEMANA3,SEMANA4 FROM TURMA_ALUNO "+
        "LEFT JOIN ALUNO ON TURMA_ALUNO.MATRICULAT = ALUNO.MATRICULA "+
        "LEFT JOIN TURMA ON TURMA_ALUNO.IDTURMAT = TURMA.IDTURMA ";
        rs = con.select(sql);
        try{
            System.out.print("IDTURMA\t|DATAPL\t\t|MTR\t|NOME\t\t|STATUS\t|S1\t|S2\t|S3\t|S4");
            while(rs.next()){
                System.out.print("\n"+rs.getInt("IDTURMA"));
                System.out.print("\t|"+rs.getString("DATAPL"));
                if(rs.getString("DATAPL")!=null){
                    System.out.print("\t|"+rs.getString("MATRICULA"));
                }else{
                    System.out.print("\t\t|"+rs.getString("MATRICULA"));
                }    
                System.out.print("\t|"+rs.getString("NOMEA"));
                System.out.print("\t|"+rs.getString("STATUS"));
                System.out.print("\t|"+rs.getString("SEMANA1"));
                System.out.print("\t|"+rs.getString("SEMANA2"));
                System.out.print("\t|"+rs.getString("SEMANA3"));
                System.out.print("\t|"+rs.getString("SEMANA4"));
            }
        }catch(SQLException e){
            System.out.print("\n\tERRO DE SISTEMA");
            e.printStackTrace();
        }
    }

    public static void funcoesG(int i){
        switch(i){
            case 1:
                cadastro();
                break;
            case 2:
                input.nextLine();
                System.out.print("\nDIGITE O CPF A SER EDITADO: ");
                String cpf = input.nextLine();
                editarCadastro(cpf);
                break;
            case 3:
                System.out.print("\nDIGITE O ID DA TURMA: ");
                int id = input.nextInt();
                planejarAula(id);
                break;
            case 4:
                verTurmas();
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    public static void funcoesP(int i){
        switch(i){
            case 1:
                input.nextLine();
                System.out.print("\nDIGITE A MATRICULA A SER VERIFICADA: ");
                String matricula = input.nextLine();
                verificarAluno(matricula, new Gerente(), 2);
                break;
            case 2:
                verTurmas();
            default:
                break;
        }
    } 
    
    public static int check(){
        System.out.print("\n\nRETORNAR AO LOGIN?\n1-SIM\n0-NAO\nESCOLHA: ");
        int i = input.nextInt();
        return i;
    }

}

