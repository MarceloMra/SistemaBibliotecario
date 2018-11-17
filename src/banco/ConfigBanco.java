/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo Moreira
 */
public class ConfigBanco extends ExecuteSQL{
    
    public ConfigBanco(Connection con) {
        super(con);
    }
    
    public boolean atualizarQtdReno(int qtdRenovacoes){
        String sql = "update config set valor='"+qtdRenovacoes+"' where nome='qtd_renov'";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    public boolean atualizarValorMulta(float valorMulta){
        String sql = "update config set valor='"+valorMulta+"' where nome='mul_per_day'";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
