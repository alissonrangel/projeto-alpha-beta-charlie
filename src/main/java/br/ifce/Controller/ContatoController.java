/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifce.Controller;

import br.ifce.Bean.ContatoBean;
import br.ifce.DAO.ContatoDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Alisson
 */
@ManagedBean
@SessionScoped
public class ContatoController implements Serializable{
    
    private ContatoBean contatoB;
    private DataModel listaContatos;

    public ContatoController() {
        contatoB = new ContatoBean();
        
    }

    public ContatoBean getContatoB() {
        return contatoB;
    }

    public void setContatoB(ContatoBean contatoB) {
        this.contatoB = contatoB;
    }

    public DataModel getListaContatos() {
        
        ContatoDAO cD = new ContatoDAO();
        
        listaContatos = new ListDataModel(cD.listarContato());
        
        return listaContatos;
    }

    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    
    public void novoContato(){
        contatoB = new ContatoBean();
        
    }
    
    public void selecionarContato(){
        contatoB = (ContatoBean)listaContatos.getRowData();
    }
    
    public String salvaContato(){
        ContatoDAO cD = new ContatoDAO();
        
        if(cD.salvarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso", ""));
            return "listarcontatos";
        }
             
        return "erro";
    }
    
    public String editarContato(){
        ContatoDAO cD = new ContatoDAO();
        
        if(cD.editarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado com sucesso", ""));
            return "listarcontatos";
        }
             
        return "erro";
    }
    
    public String excluirContato(){
        ContatoDAO cD = new ContatoDAO();
        
        if(cD.excluirContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluido com sucesso", ""));
            return "listarcontatos";
        }
             
        return "erro";
    }
    
    
}
