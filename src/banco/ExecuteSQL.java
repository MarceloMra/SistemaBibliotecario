package banco;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author AM-PC04
 */
public class ExecuteSQL {
    private Connection con;
    
    public ExecuteSQL(Connection con){
        setCon(con);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
}
