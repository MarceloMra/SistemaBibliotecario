/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Marcelo Moreira
 */
public class ExemplarBanco extends ExecuteSQL{
    
    public ExemplarBanco(Connection con) {
        super(con);
    }
    
    public boolean cadastrarExemplar(int id_livro, String cod_barras){
        String sql = "insert into exemplar values(0,?,?,?,?)";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, id_livro);
            ps.setString(2, cod_barras);
            ps.setString(3, getDateTime());
            ps.setString(4, "Ativo");
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean excluirExemplar(int id){
        String sql = "delete from exemplar where id_exemplar=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            String sq = "update exemplar set situacao=? where id_exemplar='"+id+"'";
            try{   
                PreparedStatement p = getCon().prepareStatement(sq);
                p.setString(1, "Excluido");
                
                if(p.executeUpdate() > 0){
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException ex1) {
                return false;
            }
        }
    }
    
    public boolean atualizarExemplar(int id, String codBarras){
        String sql = "update exemplar set codigo_barras='"+codBarras+"' where id_exemplar='"+id+"'";
        
        try {
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
    
    
    private String getDateTime() { 
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
	Date date = new Date(); 
	return dateFormat.format(date); 
    }
}
