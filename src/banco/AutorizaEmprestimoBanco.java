/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcelo Moreira
 */
public class AutorizaEmprestimoBanco extends ExecuteSQL{
    
    public AutorizaEmprestimoBanco(Connection con) {
        super(con);
    }
    
    public boolean logar(String email, String senha) {
        try {
            String sql = "select id_usuario from usuario where email='" + email + "' and senha='" + senha + "' and situacao !='Excluido'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                
                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }
    
}
