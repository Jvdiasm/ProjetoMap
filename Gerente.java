package sep;

public class Gerente implements SQLCommand{
    @Override
    public String organiza(String t) {
        return "SELECT IDTURMA,NOMEA,STATUS,SEMANA1,SEMANA2,SEMANA3,SEMANA4 FROM TURMA_ALUNO "+
        "LEFT JOIN ALUNO ON TURMA_ALUNO.MATRICULAT = ALUNO.MATRICULA "+
        "LEFT JOIN TURMA ON TURMA_ALUNO.IDTURMAT = TURMA.IDTURMA "+
        "WHERE ALUNO.MATRICULA = '"+t+"'";
    }
}
