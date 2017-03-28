/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Usuario;
import Register.presentation.model.UsuarioModel;
import Register.presentation.view.UsuarioView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class UsuarioController {
    UsuarioView view;
    UsuarioModel model;
    
    public UsuarioController(UsuarioView view, UsuarioModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        
        Usuario nuevo = new Usuario();
        model.clearErrors();
        
        nuevo.setCedula(Integer.parseInt(view.cedulaFld.getText()));
               
        nuevo.setClave(view.passFld.getText());
        
        nuevo.setTipo(view.tipoFld.getSelectedItem().toString());
       
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.ADD_USU(nuevo);
                        model.setMensaje("USUARIO AGREGADO");
                        model.setUsuarioCurrent(new Usuario());
                        
                        List<Usuario> rowsAgr = Application.Model.search_ADM_MAT(model.getFiltro().getCedula(),"Administrador");
                        model.setUsuarios(rowsAgr); 
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.update_USU(nuevo);
                        model.setMensaje("USUARIO MODIFICADADO");
                        model.setUsuarioCurrent(nuevo);
                        
                        List<Usuario> rowsMod = Application.Model.search_ADM_MAT(model.getFiltro().getCedula(),"Administrador");
                        model.setUsuarios(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Usuario ya existe");
                model.setMensaje("PROFESOR YA EXISTE");
                model.setUsuarioCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setUsuarioCurrent(nuevo);
        }
    }
}
