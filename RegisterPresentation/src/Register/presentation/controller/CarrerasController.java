/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
import Register.Entities.Curso;
import Register.presentation.model.CarreraModel;
import Register.presentation.view.CarrerasView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class CarrerasController {
    CarrerasView view;
    CarreraModel model;
    
    public CarrerasController(CarrerasView view, CarreraModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.getFiltro().setNombre(view.nombreFld.getText());
        Carrera filtro= new Carrera();
        filtro.setNombre(model.getFiltro().getNombre());
        model.getFiltro().setCodigo(view.codigoFld.getText());
        filtro.setCodigo(model.getFiltro().getCodigo());
        List<Carrera> rows = Application.Model.search_CAR(filtro.getNombre(),filtro.getCodigo());
        model.setCarreras(rows);        
    }

    public void preAgregar(int row){
        Carrera seleccionada = model.getCarrerasModel().getRowAt(row);
        Application.CARRERA_CURRENT = seleccionada;
        List<Curso> rows = Application.Model.search_CUR("","",Application.CARRERA_CURRENT.getNombre());
        Application.CURSO_MODEL.setCursos(rows); 
        Application.CURSOS_CARRERA_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        /*
        model.clearErrors();
        Carrera seleccionada = model.getCarrerasModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setCarreraCurrent(seleccionada);
        Application.CARRERA_VIEW.setVisible(true);
        */
    }

    public void borrar(int row){
        /*Carrera seleccionada = model.getCarrerasModel().getRowAt(row); 
        try {
            Application.Model.deleteCarrera(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Carrera> rowsMod = Application.Model.searchCarreras(model.getFiltro());
        model.setCarreras(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
