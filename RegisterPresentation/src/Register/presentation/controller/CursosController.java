/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
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
        Curso filtro= new Curso();
        model.getFiltro().setNombre(view.textNombreCurso.getText());
        filtro.setNombre(model.getFiltro().getNombre());
        model.getFiltro().setCodigo(view.textCodigo.getText());
        filtro.setCodigo(model.getFiltro().getCodigo());
        if(view.carreraFld.getSelectedItem().toString().equals("Todas")){
            model.getFiltro().getCarrera().setNombre("Todas");
            filtro.getCarrera().setNombre("Todas");
        }else{
            Carrera carreraCur = Application.Model.search_CAR(view.carreraFld.getSelectedItem().toString(),"").get(0);
            model.getFiltro().setCarrera(carreraCur);
            filtro.setCarrera(carreraCur);
        }
        List<Curso> rows = Application.Model.search_CUR(filtro.getNombre(),filtro.getCodigo(),filtro.getCarrera().getNombre());
        model.setCursos(rows); 
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setCursoCurrent(new Curso());
        Application.CURSO_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Curso seleccionada = model.getCursosModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setCursoCurrent(seleccionada);
        Application.CURSO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Curso seleccionada = model.getCursosModel().getRowAt(row); 
        try {
            Application.Model.deleteCurso(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Curso> rowsMod = Application.Model.searchCursos(model.getFiltro());
        model.setCursos(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
