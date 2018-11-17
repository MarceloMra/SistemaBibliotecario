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
public class BibliotecarioBanco extends ExecuteSQL{
    
    public BibliotecarioBanco(Connection con) {
        super(con);
    }
    
    public boolean cadastrarBibliotecario(String nome, String cpf, String tipo,String email, String senha){
        String sql = "insert into bibliotecaria values(0,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, tipo);
            ps.setString(4, email);
            ps.setString(5, senha);
            ps.setString(6, "Ativo");
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean excluirBibliotecario(int id){
        String sql = "delete from bibliotecaria where id_bibliotecaria=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            try{
                String sq = "update bibliotecaria set situacao='Excluido' where id_bibliotecaria='"+id+"'";
                PreparedStatement p = getCon().prepareStatement(sq);

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
    
    public boolean atualizarBibliotecario(int id, String nome, String cpf, String tipo, String email, String senha){
        String sql;
        if(senha.equals("")){
            sql = "update bibliotecaria set nome='"+nome+"', cpf='"+cpf+"', tipo='"+tipo+"', email='"+email+"' where id_bibliotecaria='"+id+"'";
        }else{
            sql = "update bibliotecaria set nome='"+nome+"', cpf='"+cpf+"', tipo='"+tipo+"', email='"+email+"', senha='"+senha+"' where id_bibliotecaria='"+id+"'";
        }
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
}
