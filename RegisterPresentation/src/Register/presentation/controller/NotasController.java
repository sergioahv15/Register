/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.presentation.model.EstudianteModel;
import Register.presentation.model.NotaModel;
import Register.presentation.view.EstudiantesView;
import Register.presentation.view.NotasView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class NotasController {
    NotasView view;
    NotaModel model;
    
    public NotasController(NotasView view, NotaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
               
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setNotaCurrent(new String());
        Application.NOTA_VIEW.setVisible(true);
    }
    
    public void preAgregar(int row){
        /*Estudiante seleccionado = model.getEstudiantesModel().getRowAt(row);
        Application.ESTUDIANTE_CURRENT = seleccionado;
        Application.CARRERA_CURRENT = seleccionado.getCarrera();
        List<Grupo> rows = Application.Model.search_GRU("",Application.CARRERA_CURRENT.getCodigo());
        //Application.GRUPO_MODEL.setGrupos(rows); 
        Application.MATRICULADOS_VIEW.setVisible(true);
        */
        
        /*
        Estudiante seleccionado = model.getEstudiantesModel().getRowAt(row);
        Application.ESTUDIANTE_CURRENT = seleccionado;
        List<Grupo> rows = Application.Model.search_GRU(seleccionado.getCedula());
        Application.GRUPO_MODEL.setGrupos(rows); 
        Application.MATRICULADOS_VIEW.setVisible(true);
        */
    }
    
    public void editar(int row){
        model.clearErrors();
        String seleccionado = model.getNotasModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setNotaCurrent(seleccionado);
        Application.NOTA_VIEW.setVisible(true);        
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

