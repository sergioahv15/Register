/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Profesor;
import Register.presentation.model.ProfesorModel;
import Register.presentation.view.ProfesorView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class ProfesorController {
    ProfesorView view;
    ProfesorModel model;
    
    public ProfesorController(ProfesorView view, ProfesorModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        
        Profesor nuevo = new Profesor();
        model.clearErrors();
        
        nuevo.setCedula(Integer.parseInt(view.cedulaFld.getText()));
        /*if (view.cedulaFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }*/
        
        nuevo.setNombre(view.nombreFld.getText());
        /*if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }*/
        
        nuevo.setTel(Integer.parseInt(view.telefonoFld.getText()));
        
        nuevo.setEmail(view.emailFld.getText());
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.Add_PRO(nuevo);
                        model.setMensaje("PROFESOR AGREGADO");
                        model.setProfesorCurrent(new Profesor());
                        
                        List<Profesor> rowsAgr = Application.Model.search_PRO_NOM(model.getFiltro().getNombre());
                        model.setProfesores(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.update(nuevo);
                        model.setMensaje("PROFESOR MODIFICADADO");
                        model.setProfesorCurrent(nuevo);
                        
                        List<Profesor> rowsMod = Application.Model.search_PRO_NOM(model.getFiltro().getNombre());
                        model.setProfesores(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Profesor ya existe");
                model.setMensaje("PROFESOR YA EXISTE");
                model.setProfesorCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setProfesorCurrent(nuevo);
        }
        
    }
}
