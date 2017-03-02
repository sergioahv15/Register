/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Estudiante;
import Register.presentation.model.EstudianteModel;
import Register.presentation.view.EstudiantesView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class EstudiantesController {
    EstudiantesView view;
    EstudianteModel model;
    
    public EstudiantesController(EstudiantesView view, EstudianteModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.getFiltro().setNombre(view.nombreFld.getText());
        Estudiante filtro= new Estudiante();
        filtro.setNombre(model.getFiltro().getNombre());
        List<Estudiante> rows = Application.Model.search_EST_NOM(filtro.getNombre());
        //List<Estudiante> rows = Model.searchEstudiantes(model.getFiltro());
        model.setEstudiantes(rows);
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setEstudianteCurrent(new Estudiante());
        Application.ESTUDIANTE_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Estudiante seleccionada = model.getEstudiantesModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setEstudianteCurrent(seleccionada);
        Application.ESTUDIANTE_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Estudiante seleccionada = model.getEstudiantesModel().getRowAt(row); 
        try {
            Application.Model.deleteEstudiante(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Estudiante> rowsMod = Application.Model.searchEstudiantes(model.getFiltro());
        model.setEstudiantes(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}