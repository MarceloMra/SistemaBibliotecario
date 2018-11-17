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
import javax.swing.JOptionPane;
import model.ItemBuscaEmprestimo;

/**
 *
 * @author Marcelo Moreira
 */
public class BuscaEmprestimoBanco extends ExecuteSQL{
    
    public BuscaEmprestimoBanco(Connection con) {
        super(con);
    }
    
    public ArrayList<ItemBuscaEmprestimo> listarEmprestimos(){
        String sql = "select e.id_emprestimo, e.id_exemplar, e.id_usuario, e.id_bibliotecaria, e.qtd_renovacoes, e.data_emprestimo, e.data_devolucao_estimada, e.data_devolucao, e.valor_multa, l.titulo, u.nome, ex.codigo_barras from usuario as u, emprestimo as e, exemplar as ex, livro as l where e.id_exemplar=ex.id_exemplar and ex.id_livro=l.id_livro and e.id_usuario=u.id_usuario";
        ArrayList<ItemBuscaEmprestimo> result = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ItemBuscaEmprestimo b = new ItemBuscaEmprestimo();
                
                b.setIdEmprestimo(rs.getInt(1));
                b.setIdExemplar(rs.getInt(2));
                b.setIdUsuario(rs.getInt(3));
                b.setIdBibliotecaria(rs.getInt(4));
                b.setQtdRenovacoes(rs.getInt(5));
                b.setDataEmprestimo(rs.getDate(6));
                b.setDataPrevistaDevol(rs.getDate(7));
                b.setDataDevolucao(rs.getDate(8));
                b.setMulta(rs.getFloat(9));
                b.setTitulo(rs.getString(10));
                b.setNomeUsuario(rs.getString(11));
                b.setCodBarras(rs.getString(12));
                result.add(b);
            }
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return result;
        }
    }
    
    public ArrayList<ItemBuscaEmprestimo> buscarItemEmprestimo(String cont, int tipoBusca){
        String sql = null;
        ArrayList<ItemBuscaEmprestimo> result = new ArrayList<>();
        if(tipoBusca == 0){
            try{
                int id = Integer.parseInt(cont);
                sql = "select e.id_emprestimo, e.id_exemplar, e.id_usuario, e.id_bibliotecaria, e.qtd_renovacoes, e.data_emprestimo, e.data_devolucao_estimada, e.data_devolucao, e.valor_multa, l.titulo, u.nome, ex.codigo_barras from usuario as u, emprestimo as e, exemplar as ex, livro as l where e.id_exemplar=ex.id_exemplar and ex.id_livro=l.id_livro and e.id_usuario=u.id_usuario and e.id_emprestimo='"+cont+"' order by data_emprestimo desc";
            }catch(NumberFormatException e){
                return result;
            }
        }else if(tipoBusca == 1){
            sql = "select e.id_emprestimo, e.id_exemplar, e.id_usuario, e.id_bibliotecaria, e.qtd_renovacoes, e.data_emprestimo, e.data_devolucao_estimada, e.data_devolucao, e.valor_multa, l.titulo, u.nome, ex.codigo_barras from usuario as u, emprestimo as e, exemplar as ex, livro as l where e.id_exemplar=ex.id_exemplar and ex.id_livro=l.id_livro and e.id_usuario=u.id_usuario and u.id_usuario='"+cont+"' order by data_emprestimo desc";
        }else if(tipoBusca == 3){
            sql = "select e.id_emprestimo, e.id_exemplar, e.id_usuario, e.id_bibliotecaria, e.qtd_renovacoes, e.data_emprestimo, e.data_devolucao_estimada, e.data_devolucao, e.valor_multa, l.titulo, u.nome, ex.codigo_barras from usuario as u, emprestimo as e, exemplar as ex, livro as l where e.id_exemplar=ex.id_exemplar and ex.id_livro=l.id_livro and e.id_usuario=u.id_usuario and u.nome like '%"+cont+"%' order by data_emprestimo desc";
        }else if(tipoBusca == 4){
            sql = "select e.id_emprestimo, e.id_exemplar, e.id_usuario, e.id_bibliotecaria, e.qtd_renovacoes, e.data_emprestimo, e.data_devolucao_estimada, e.data_devolucao, e.valor_multa, l.titulo, u.nome, ex.codigo_barras from usuario as u, emprestimo as e, exemplar as ex, livro as l where e.id_exemplar=ex.id_exemplar and ex.id_livro=l.id_livro and e.id_usuario=u.id_usuario and l.titulo like '%"+cont+"%' order by data_emprestimo desc";
        }else if(tipoBusca == 2){
            sql = "select e.id_emprestimo, e.id_exemplar, e.id_usuario, e.id_bibliotecaria, e.qtd_renovacoes, e.data_emprestimo, e.data_devolucao_estimada, e.data_devolucao, e.valor_multa, l.titulo, u.nome, ex.codigo_barras from usuario as u, emprestimo as e, exemplar as ex, livro as l where e.id_exemplar=ex.id_exemplar and ex.id_livro=l.id_livro and e.id_usuario=u.id_usuario and ex.codigo_barras='"+cont+"' order by data_emprestimo desc";
        }else{
            return result;
        }
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
   
            while(rs.next()){               
                ItemBuscaEmprestimo b = new ItemBuscaEmprestimo();
                b.setIdEmprestimo(rs.getInt(1));
                b.setIdExemplar(rs.getInt(2));
                b.setIdUsuario(rs.getInt(3));
                b.setIdBibliotecaria(rs.getInt(4));
                b.setQtdRenovacoes(rs.getInt(5));
                b.setDataEmprestimo(rs.getDate(6));
                b.setDataPrevistaDevol(rs.getDate(7));
                b.setDataDevolucao(rs.getDate(8));
                b.setMulta(rs.getFloat(9));
                b.setTitulo(rs.getString(10));
                b.setNomeUsuario(rs.getString(11));
                b.setCodBarras(rs.getString(12));
                result.add(b);
            }
            
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
