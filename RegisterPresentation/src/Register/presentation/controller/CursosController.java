/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Curso;
import Register.presentation.model.CursoModel;
import Register.presentation.view.CursosView;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class CursosController {
    CursosView view;
    CursoModel model;
    
    public CursosController(CursosView view, CursoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.getFiltro().setNombre(view.nombreFld.getText());
        Curso filtro= new Curso();
        filtro.setNombre(model.getFiltro().getNombre());
        List<Curso> rows = Application.Model.searchCursos(filtro);
        //List<Curso> rows = Model.searchCursos(model.getFiltro());
        model.setCursos(rows);
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setCursoCurrent(new Curso());
        Application.PERSONA_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Curso seleccionada = model.getCursosModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setCursoCurrent(seleccionada);
        Application.PERSONA_VIEW.setVisible(true);
    }

    public void borrar(int row){
        Curso seleccionada = model.getCursosModel().getRowAt(row); 
        try {
            Application.Model.deleteCurso(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Curso> rowsMod = Application.Model.searchCursos(model.getFiltro());
        model.setCursos(rowsMod);
    }
    
    public void close(){
        Application.Model.close();
    }
}
