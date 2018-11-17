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
import model.ItemBuscaExemplar;

/**
 *
 * @author Marcelo Moreira
 */
public class BuscaExemplarBanco extends ExecuteSQL{
    
    public BuscaExemplarBanco(Connection con) {
        super(con);
    }
    
    public ArrayList<ItemBuscaExemplar> listarExemplar(){
        String sql = "select e.id_exemplar, e.id_livro, e.codigo_barras, l.titulo, l.autor, l.editora, e.data_cadastro, e.situacao from exemplar as e, livro as l where e.situacao!='Excluido' and e.id_livro=l.id_livro order by l.titulo asc";
        ArrayList<ItemBuscaExemplar> retorno = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                ItemBuscaExemplar b = new ItemBuscaExemplar();
                b.setIdExemplar(rs.getInt(1));
                b.setIdLivro(rs.getInt(2));
                b.setCodBarras(rs.getString(3));
                b.setTitulo(rs.getString(4));
                b.setAutor(rs.getString(5));
                b.setEditora(rs.getString(6));
                b.setDataCadastro(rs.getDate(7));
                b.setSituacaoExemplar(rs.getString(8));
                retorno.add(b);
            }
            
            return retorno;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public ArrayList<ItemBuscaExemplar> buscarItemExemplar(String cont, int tipoBusca){
        String sql = null;
        ArrayList<ItemBuscaExemplar> result = new ArrayList<>();
        if(tipoBusca == 0){
            try{
                int id = Integer.parseInt(cont);
                sql = "select e.id_exemplar, e.id_livro, e.codigo_barras, l.titulo, l.autor, l.editora, e.data_cadastro, e.situacao from exemplar as e, livro as l where e.situacao!='Excluido' and e.id_livro=l.id_livro and e.id_exemplar='"+cont+"' order by l.titulo asc";
            }catch(NumberFormatException e){
                return result;
            }
        }else if(tipoBusca == 1){
            sql = "select e.id_exemplar, e.id_livro, e.codigo_barras, l.titulo, l.autor, l.editora, e.data_cadastro, e.situacao from exemplar as e, livro as l where e.situacao!='Excluido' and e.id_livro=l.id_livro and e.codigo_barras='"+cont+"' order by l.titulo asc";
        }else if(tipoBusca == 2){
            sql = "select e.id_exemplar, e.id_livro, e.codigo_barras, l.titulo, l.autor, l.editora, e.data_cadastro, e.situacao from exemplar as e, livro as l where e.situacao!='Excluido' and e.id_livro=l.id_livro and l.titulo like '%"+cont+"%' order by l.titulo asc";
        }else if(tipoBusca == 3){
            sql = "select e.id_exemplar, e.id_livro, e.codigo_barras, l.titulo, l.autor, l.editora, e.data_cadastro, e.situacao from exemplar as e, livro as l where e.situacao!='Excluido' and e.id_livro=l.id_livro and l.autor like '%"+cont+"%' order by l.titulo asc";
        }else if(tipoBusca == 4){
            sql = "select e.id_exemplar, e.id_livro, e.codigo_barras, l.titulo, l.autor, l.editora, e.data_cadastro, e.situacao from exemplar as e, livro as l where e.situacao!='Excluido' and e.id_livro=l.id_livro and l.editora like '%"+cont+"%' order by l.titulo asc";
        }else{
            return result;
        }
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
   
            while(rs.next()){               
                ItemBuscaExemplar b = new ItemBuscaExemplar();
                b.setIdExemplar(rs.getInt(1));
                b.setIdLivro(rs.getInt(2));
                b.setCodBarras(rs.getString(3));
                b.setTitulo(rs.getString(4));
                b.setAutor(rs.getString(5));
                b.setEditora(rs.getString(6));
                b.setDataCadastro(rs.getDate(7));
                b.setSituacaoExemplar(rs.getString(8));
                result.add(b);
            }
            
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }
}
