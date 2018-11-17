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
import model.Livro;

/**
 *
 * @author Marcelo Moreira
 */
public class BuscaLivroBanco extends ExecuteSQL{
    
    public BuscaLivroBanco(Connection con) {
        super(con);
    }
    
    public ArrayList<Livro> listarLivros(){
        String sql = "select * from livro where situacao !='Excluido' order by titulo asc";
        ArrayList<Livro> retorno = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Livro b = new Livro();
                b.setId(rs.getInt(1));
                b.setTitulo(rs.getString(2));
                b.setAutor(rs.getString(3));
                b.setEditora(rs.getString(4));
                b.setEdicao(rs.getInt(5));
                
                retorno.add(b);
            }
            
            return retorno;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public ArrayList<Livro> buscarLivro(String cont, int tipoBusca){
        String sql = null;
        ArrayList<Livro> result = new ArrayList<>();
        if(tipoBusca == 0){
            try{
                int id = Integer.parseInt(cont);
                sql = "select * from livro where id_livro='"+id+"' and situacao !='Excluido'";
            }catch(NumberFormatException e){
                return result;
            }
        }else if(tipoBusca == 1){
            sql = "select * from livro where titulo like '%"+cont+"%' and situacao !='Excluido' order by titulo asc";
        }else if(tipoBusca == 2){
            sql = "select * from livro where autor like '%"+cont+"%' and situacao !='Excluido' order by titulo asc";
        }else if(tipoBusca == 3){
            sql = "select * from livro where editora like '%"+cont+"%' and situacao !='Excluido' order by titulo asc";
        }else{
            return result;
        }
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
   
            while(rs.next()){               
                Livro b = new Livro();
                b.setId(rs.getInt(1));
                b.setTitulo(rs.getString(2));
                b.setAutor(rs.getString(3));
                b.setEditora(rs.getString(4));
                b.setEdicao(rs.getInt(5));
                
                result.add(b);
            }
            
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }
}
