/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Curso;
import Register.presentation.model.CursoModel;
import Register.presentation.view.CursoView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class CursoController {
    CursoView view;
    CursoModel model;
    
    public CursoController(CursoView view, CursoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        /*
        Curso nueva = new Curso();
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
                        Application.Model.addCurso(nueva);
                        model.setMensaje("CURSO AGREGADA");
                        model.setCursoCurrent(new Curso());
                        
                        List<Curso> rowsAgr = Application.Model.searchCursos(model.getFiltro());
                        model.setCursos(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.updateCurso(nueva);
                        model.setMensaje("CURSO MODIFICADADA");
                        model.setCursoCurrent(nueva);
                        
                        List<Curso> rowsMod = Application.Model.searchCursos(model.getFiltro());
                        model.setCursos(rowsMod);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Curso ya existe");
                model.setMensaje("CURSO YA EXISTE");
                model.setCursoCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCursoCurrent(nueva);
        }
        */
    }
}
