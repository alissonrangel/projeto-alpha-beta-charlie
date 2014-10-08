/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifce.DAO;

import br.ifce.Bean.ContatoBean;
import br.ifce.Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 */
public class ContatoDAO {
    private Conexao Con;

    public ContatoDAO() {
    
        Con = new Conexao();
    }
    
    public boolean salvarContato(ContatoBean contato){
        try {
            String sql = "insert into contato (nome, endereco, cidade, uf, telefone,"
                    + "celular, email) values (?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEndereco());
            stm.setString(3, contato.getCidade());
            stm.setString(4, contato.getUf());
            stm.setString(5, contato.getTelefone());
            stm.setString(6, contato.getCelular());
            stm.setString(7, contato.getEmail());
            
            stm.execute();
            
            Con.getConnection().commit();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean editarContato(ContatoBean contato){
        try {
            String sql = "update contato set nome = ?, endereco = ?, cidade = ?, "
                    + "uf = ?, telefone = ?, celular = ?, email = ? where id = ?;";
            
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEndereco());
            stm.setString(3, contato.getCidade());
            stm.setString(4, contato.getUf());
            stm.setString(5, contato.getTelefone());
            stm.setString(6, contato.getCelular());
            stm.setString(7, contato.getEmail());
            stm.setInt(8, contato.getId());
            stm.execute();
            
            Con.getConnection().commit();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean excluirContato(ContatoBean contato){
        try {
            String sql = "delete from contato where id=?;";
            
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
          
            stm.setInt(1, contato.getId());
            stm.execute();
            
            Con.getConnection().commit();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<ContatoBean> listarContato(){
        
        List<ContatoBean> lista = new ArrayList<ContatoBean>();
        try {
            String sql = "select * from contato;";
            
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
        
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                ContatoBean contato = new ContatoBean();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setCidade(rs.getString("cidade"));
                contato.setUf(rs.getString("uf"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setEmail(rs.getString("email"));
                
                lista.add(contato);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
