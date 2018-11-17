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
import model.Config;

/**
 *
 * @author Marcelo Moreira
 */
public class Sistema extends ExecuteSQL{
    private static int qtdRenovacoesPermitir;
    private static float valorMultaPorDia;

    public Sistema(Connection con) {
        super(con);
        inicializarVariaveis();
    }
    
    public static void inicializarVariaveis(){
        String sql = "select * from config";
        ArrayList<Config> retorno = new ArrayList<>();
        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Config c = new Config();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setValor(rs.getString(3));
                retorno.add(c);
            }
            
            for(Config c : retorno){
                if(c.getNome().equals("qtd_renov")){
                    qtdRenovacoesPermitir = Integer.parseInt(c.getValor());
                }else if(c.getNome().equals("mul_per_day")){
                    valorMultaPorDia = Float.parseFloat(c.getValor());
                }
            }
            //JOptionPane.showMessageDialog(null, "Inicialização correta das variaveis de sistema!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar ao banco para inicializar as variaveis do sistema!", "Erro na inicialização das variáveis", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Variáveis de sistemas estão formatadas incorretamentes no BD!", "Formato incorreto", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public static int getQtdRenovacoesPermitir() {
        return qtdRenovacoesPermitir;
    }

    public static float getValorMultaPorDia() {
        return valorMultaPorDia;
    } 

    
}
