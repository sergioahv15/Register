/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Profesor;
import Register.presentation.model.ProfesorModel;
import Register.presentation.view.ProfesoresView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class ProfesoresController {
    ProfesoresView view;
    ProfesorModel model;
    
    public ProfesoresController(ProfesoresView view, ProfesorModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.getFiltro().setNombre(view.nombreFld.getText());
        Profesor filtro= new Profesor();
        filtro.setNombre(model.getFiltro().getNombre());
        List<Profesor> rows = Application.Model.search_PRO_NOM(filtro.getNombre());
        model.setProfesores(rows);
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setProfesorCurrent(new Profesor());
        Application.PROFESOR_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Profesor seleccionada = model.getProfesoresModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setProfesorCurrent(seleccionada);
        Application.PROFESOR_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Profesor seleccionada = model.getProfesorsModel().getRowAt(row); 
        try {
            Application.Model.deleteProfesor(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Profesor> rowsMod = Application.Model.searchProfesors(model.getFiltro());
        model.setProfesors(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
