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
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author Marcelo Moreira
 */
public class BuscaUsuarioBanco extends ExecuteSQL{
    
    public BuscaUsuarioBanco(Connection con) {
        super(con);
    }
    
    
    public ArrayList<Usuario> listarUsuarios(){
        String sql = "select * from usuario where situacao!='Excluido' order by nome asc";
        ArrayList<Usuario> retorno = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Usuario b = new Usuario();
                b.setId(rs.getInt(1));
                b.setNome(rs.getString(2));
                b.setCpf(rs.getString(3));
                b.setTipo(rs.getString(4));
                b.setEmail(rs.getString(5));
                b.setSenha(rs.getString(6));
                retorno.add(b);
            }
            
            return retorno;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public ArrayList<Usuario> buscarUsuario(String cont, int tipoBusca){
        String sql = null;
        ArrayList<Usuario> result = new ArrayList<>();
        if(tipoBusca == 0){
            try{
                int id = Integer.parseInt(cont);
                sql = "select * from usuario where id_usuario='"+id+"' and situacao!='Excluido'";
            }catch(NumberFormatException e){
                return result;
            }
        }else if(tipoBusca == 1){
            sql = "select * from usuario where nome like '%"+cont+"%' and situacao!='Excluido' order by nome asc";
        }else if(tipoBusca == 2){
            sql = "select * from usuario where tipo='"+cont+"' and situacao!='Excluido'";
        }else if(tipoBusca == 3){
            sql = "select * from usuario where cpf='"+cont+"' and situacao!='Excluido'";
        }else if(tipoBusca == 4){
            sql = "select * from usuario where email='"+cont+"' and situacao!='Excluido'";
        }else{
            return result;
        }
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
   
            while(rs.next()){               
                Usuario b = new Usuario();
                b.setId(rs.getInt(1));
                b.setNome(rs.getString(2));
                b.setCpf(rs.getString(3));
                b.setTipo(rs.getString(4));
                b.setEmail(rs.getString(5));
                b.setSenha(rs.getString(6));
                result.add(b);
            }
            
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }
}
