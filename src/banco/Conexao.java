package banco;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author AM-PC04
 */
public class Conexao {
    private static Connection con;
    
    public Conexao(){
        if(con == null){
            this.con = AbrirConexao();
        }
    }
    
    public static Connection getConexao(){
        return con;
    }
    
    private static Connection AbrirConexao(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/biblioteca";
            con = DriverManager.getConnection(url, "root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco", "Sistema Bibliotecário",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return con;
    }
    
    
    public static void FecharConexao(){
        try{
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
