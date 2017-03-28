/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Usuario;
import Register.presentation.model.UsuarioModel;
import Register.presentation.view.SeguridadView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class UsuariosController {
    SeguridadView view;
    UsuarioModel model;
    
    public UsuariosController(SeguridadView view, UsuarioModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){        
        Usuario filtro= new Usuario();
        if(view.cedulaFld.getText().equals("")){
            model.getFiltro().setCedula(0);
            filtro.setCedula(model.getFiltro().getCedula());
        }
        else{
            model.getFiltro().setCedula(Integer.parseInt(view.cedulaFld.getText()));
            filtro.setCedula(model.getFiltro().getCedula());
        }                   
        String tipo = view.tipoFld.getSelectedItem().toString();        
        List<Usuario> rows = Application.Model.search_ADM_MAT(filtro.getCedula(), tipo);
        model.setUsuarios(rows);       
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setUsuarioCurrent(new Usuario());
        Application.USUARIO_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Usuario seleccionada = model.getUsuariosModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setUsuarioCurrent(seleccionada);
        Application.USUARIO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Usuario seleccionada = model.getUsuariosModel().getRowAt(row); 
        try {
            Application.Model.deleteUsuario(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Usuario> rowsMod = Application.Model.searchUsuarios(model.getFiltro());
        model.setUsuarios(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
