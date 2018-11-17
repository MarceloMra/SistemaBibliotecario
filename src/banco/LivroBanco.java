/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Marcelo Moreira
 */
public class LivroBanco extends ExecuteSQL{
    
    public LivroBanco(Connection con) {
        super(con);
    }
    
    public boolean cadastrarLivro(String titulo, String autor, String editora, int edicao){
        String sql = "insert into livro values(0,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, editora);
            ps.setInt(4, edicao);
            ps.setString(5, "Ativo");
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean atualizarLivro(int id, String titulo, String autor, String editora, int edicao){
        String sql = "update livro set titulo='"+titulo+"', autor='"+autor+"', editora='"+editora+"', edicao='"+edicao+"' where id_livro='"+id+"'";
        
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
    
    public boolean excluirLivro(int id){
        String sql = "delete from livro where id_livro=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            String sq = "update livro set situacao=? where id_livro='"+id+"'";
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
}
