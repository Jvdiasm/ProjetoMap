package sep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
  public Statement stm;
  public ResultSet rs;
  private Connection con = null;
  private String hostName = "localhost";
  private String userName = "root";
  private String password = "";
  private String jdbcDriver = "com.mysql.jdbc.Driver";
  private String dataBaseName = "projeto";
  private String dataBasePrefix = "jdbc:mysql://";
  private String dataBasePort = "3306";

  private String url = dataBasePrefix + hostName + ":" + dataBasePort + "/" + dataBaseName;

  
  public Connection conexao() {
    try {
      if (con == null) {
        System.setProperty("jdbc.Drivers", jdbcDriver);
        con = DriverManager.getConnection(url, userName, password);
      } else if (con.isClosed()) {
        con = null;
        return conexao();
      }
    } catch (SQLException e) {
      System.out.println("\nERRO DE CONEXAO!");  
      e.printStackTrace();
    }
    return con;
  }

  public void update(String sql){
    try{
      stm = con.createStatement();
      stm.executeUpdate(sql);
    }catch(SQLException e){
      e.printStackTrace();
      System.out.println("\nERRO!gravação");
    }
  }

  public ResultSet select(String sql){
    try{
      stm = con.createStatement();
      rs = stm.executeQuery(sql);
      return rs;
    }catch(SQLException e){
      e.printStackTrace();
      System.out.println("\nERRO!leitura");
      return null;
    }
  }

  public void desconecta(){
    try{
      con.close();
    }catch(SQLException  e){
      System.out.println("\nERRO");
    }
  }
}
