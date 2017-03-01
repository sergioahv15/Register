/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.presentation.model.ProfesorModel;
import Register.presentation.view.ProfesorView;

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
        /*
        Profesor nueva = new Profesor();
        model.clearErrors();
        
        nueva.setId(view.idFld.getText());
        if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        
        nueva.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        
        if (view.sexoFldFem.isSelected()) nueva.setSexo('F');
        else if (view.sexoFldMasc.isSelected()) nueva.setSexo('M');
        else nueva.setSexo(' ');
        if (!view.sexoFldFem.isSelected() && !view.sexoFldMasc.isSelected()){
            model.getErrores().put("sexo", "Sexo requerido");
        }
        
        nueva.setEstadoCivil((EstadoCivil) view.estadoFld.getSelectedItem());
        
        nueva.setPasatiempoMusica(view.pasatiempoFldMusica.isSelected());
        
        nueva.setPasatiempoCine(view.pasatiempoFldCine.isSelected());
        
        nueva.setPasatiempoDeporte(view.pasatiempoFldDeporte.isSelected());
        
        nueva.setPasatiempoVideoJuegos(view.pasatiempoFldVideoJuegos.isSelected());
        
        nueva.setPasatiempoCocina(view.pasatiempoFldCocina.isSelected());
        
        nueva.setPasatiempoOtro(view.pasatiempoFldOtro.isSelected());
        
        nueva.setPasatiempoOtroTexto(view.pasatiempoFldOtroDescripcion.getText());
        if (view.pasatiempoFldOtro.isSelected() && view.pasatiempoFldOtroDescripcion.getText().length()==0){
            model.getErrores().put("pasatiempoOtroDescripcion", "Pasatiempo requerido");
        }
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.addProfesor(nueva);
                        model.setMensaje("PROFESOR AGREGADO");
                        model.setProfesorCurrent(new Profesor());
                        
                        List<Profesor> rowsAgr = Application.Model.searchProfesors(model.getFiltro());
                        model.setProfesors(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.updateProfesor(nueva);
                        model.setMensaje("PROFESOR MODIFICADADO");
                        model.setProfesorCurrent(nueva);
                        
                        List<Profesor> rowsMod = Application.Model.searchProfesors(model.getFiltro());
                        model.setProfesors(rowsMod);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Profesor ya existe");
                model.setMensaje("PROFESOR YA EXISTE");
                model.setProfesorCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setProfesorCurrent(nueva);
        }
        */
    }
}
