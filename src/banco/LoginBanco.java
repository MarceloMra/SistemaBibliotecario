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
import model.Bibliotecaria;

/**
 *
 * @author Marcelo Moreira
 */
public class LoginBanco extends ExecuteSQL {

    public LoginBanco(Connection con) {
        super(con);
    }

    public Bibliotecaria logar(String email, String senha) {
        try {
            String sql = "select * from bibliotecaria where email='" + email + "' and senha='" + senha + "' and situacao !='Excluido'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Bibliotecaria b = new Bibliotecaria();
                b.setId(rs.getInt(1));
                b.setNome(rs.getString(2));
                b.setCpf(rs.getString(3));
                b.setTipo(rs.getString(4));
                b.setEmail(rs.getString(5));
                b.setSenha(rs.getString(6));
                return b;

            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }
    }

}
