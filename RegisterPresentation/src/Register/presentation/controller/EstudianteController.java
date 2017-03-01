/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.presentation.model.EstudianteModel;
import Register.presentation.view.EstudianteView;

/**
 *
 * @author Fabio
 */
public class EstudianteController {
    EstudianteView view;
    EstudianteModel model;
    
    public EstudianteController(EstudianteView view, EstudianteModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        /*
        Estudiante nueva = new Estudiante();
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
                        Application.Model.addEstudiante(nueva);
                        model.setMensaje("PROFESOR AGREGADO");
                        model.setEstudianteCurrent(new Estudiante());
                        
                        List<Estudiante> rowsAgr = Application.Model.searchEstudiantes(model.getFiltro());
                        model.setEstudiantes(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.updateEstudiante(nueva);
                        model.setMensaje("PROFESOR MODIFICADADO");
                        model.setEstudianteCurrent(nueva);
                        
                        List<Estudiante> rowsMod = Application.Model.searchEstudiantes(model.getFiltro());
                        model.setEstudiantes(rowsMod);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Estudiante ya existe");
                model.setMensaje("PROFESOR YA EXISTE");
                model.setEstudianteCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setEstudianteCurrent(nueva);
        }
        */
    }
}
