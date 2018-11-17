/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Moreira
 */
public class EmprestimoBanco extends ExecuteSQL{
    
    public EmprestimoBanco(Connection con) {
        super(con);
    }
    
    public boolean realizarEmprestimo(int idExemplar, int idUsuario, int idBiblio, String dataEmprestimo, String dataDevolucaoEstimad){
        String sql = "insert into emprestimo values(0,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, idExemplar);
            ps.setInt(2, idUsuario);
            ps.setInt(3, idBiblio);
            ps.setInt(4, 0);
            ps.setString(5, dataEmprestimo);
            ps.setString(6, dataDevolucaoEstimad);
            ps.setString(7, "1111-11-11");
            ps.setFloat(8, 0);
            
            if(ps.executeUpdate() > 0){
                atualizarSituacaoExemplar(idExemplar, "Emprestado");
                return true;        
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "EXcEPTION");
            return false;
        }
    }
    
    
    public boolean excluirEmprestimo(int id){
        String sql = "delete from emprestimo where id_emprestimo='"+id+"'";
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
    
    
    public boolean devolverEmprestimo(int idEmprestimo, float valMulta, int idExemplar){
        String sql;
        LocalDate hoje = LocalDate.now();
        if(valMulta != 0){
            sql = "update emprestimo set data_devolucao='"+hoje.format(DateTimeFormatter.ISO_DATE)+"' where id_emprestimo='"+idEmprestimo+"'";
        }else{
            sql = "update emprestimo set data_devolucao='"+hoje.format(DateTimeFormatter.ISO_DATE)+"', valor_multa='"+valMulta+"' where id_emprestimo='"+idEmprestimo+"'";
        }
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if(ps.executeUpdate() > 0){
                return atualizarSituacaoExemplar(idExemplar, "Ativo");
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    
    public boolean renovarEmprestimo(int id, int novaQtdRenov, float valMulta){
        LocalDate novaData = LocalDate.now().plusDays(31);
        String sql;
        if(valMulta == 0){
            sql = "update emprestimo set data_devolucao_estimada='"+novaData.format(DateTimeFormatter.ISO_DATE)+"', qtd_renovacoes='"+novaQtdRenov+"' where id_emprestimo='"+id+"'";
        }else{
            sql = "update emprestimo set data_devolucao_estimada='"+novaData.format(DateTimeFormatter.ISO_DATE)+"', qtd_renovacoes='"+novaQtdRenov+"', valor_multa='"+valMulta+"' where id_emprestimo='"+id+"'";
        }
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    
    private boolean atualizarSituacaoExemplar(int idExemplar, String situacao){
        String sql = "update exemplar set situacao='"+situacao+"' where id_exemplar='"+idExemplar+"'";
        
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
