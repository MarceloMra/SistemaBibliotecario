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
public class UsuarioBanco extends ExecuteSQL{
    
    public UsuarioBanco(Connection con) {
        super(con);
    }
    
    public boolean cadastrarUsuario(String nome, String cpf, int tipo, String email, String senha){
        String sql = "insert into usuario values(0,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, cpf);
            if(tipo == 0){
                ps.setString(3, "Aluno");
            }else{
                ps.setString(3, "Professor");
            }
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
    
    public boolean excluirUsuario(int id){
        String sql = "delete from usuario where id_usuario=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            String sq = "update usuario set situacao='Excluido' where id_usuario=?";
            try{
                PreparedStatement p = getCon().prepareStatement(sq);
                p.setInt(1, id);

                if(p.executeUpdate() > 0){
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException e) {
                return false;
            }
        }
    }
    
    public boolean atualizarUsuario(int id, String nome, String cpf, String tipo, String email, String senha){
        String sql;
        if(senha.equals("")){
            sql = "update usuario set nome='"+nome+"', cpf='"+cpf+"', tipo='"+tipo+"', email='"+email+"' where id_usuario='"+id+"'";
        }else{
            sql = "update usuario set nome='"+nome+"', cpf='"+cpf+"', tipo='"+tipo+"', email='"+email+"', senha='"+senha+"' where id_usuario='"+id+"'";
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
