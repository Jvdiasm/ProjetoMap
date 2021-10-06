package sep;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Responsavel implements SQLCommand{
    @Override
    public String organiza(String t) {
        Conexao con = new Conexao();
        con.conexao();
        String sql = "SELECT * FROM USUARIO_ALUNO WHERE CPFR = '"+t+"'";
        ResultSet rs =  con.select(sql);
        try{
            if(rs.next()){
                t = rs.getString("MATRICULAR");
            }    
            con.desconecta();
            return "SELECT IDTURMA,NOMEA,STATUS,SEMANA1,SEMANA2,SEMANA3,SEMANA4 FROM TURMA_ALUNO "+
            "LEFT JOIN ALUNO ON TURMA_ALUNO.MATRICULAT = ALUNO.MATRICULA "+
            "LEFT JOIN TURMA ON TURMA_ALUNO.IDTURMAT = TURMA.IDTURMA "+
            "WHERE ALUNO.MATRICULA = '"+t+"'";
        }catch(SQLException e){
            System.out.println("\n\t\tERRO!");
            e.printStackTrace();
            return null;
        }
    }
}
