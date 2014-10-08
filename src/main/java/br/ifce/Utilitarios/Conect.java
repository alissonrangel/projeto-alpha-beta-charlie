package br.ifce.Utilitarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ifce.Utilitarios.Conexao;

public class Conect {
	
	public String getContato(){
	try {
        Conexao Con = new Conexao();
        
        PreparedStatement stm = Con.getConnection().prepareStatement("select * from contato;");
        
        ResultSet rs = stm.executeQuery();
        rs.next();
             
        //System.out.println(rs.getString("nome"));
        
        
        return rs.getString("nome");
        
    } catch (SQLException ex) {
        Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
    }
	
		return "vazio";
	}
}
