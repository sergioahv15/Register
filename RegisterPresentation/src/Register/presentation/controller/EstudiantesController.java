/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
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
        /*
        model.getFiltro().setNombre(view.nombreFld.getText());
        Estudiante filtro= new Estudiante();
        filtro.setNombre(model.getFiltro().getNombre());
        List<Estudiante> rows = Application.Model.search_EST_NOM(filtro.getNombre());
        //List<Estudiante> rows = Model.searchEstudiantes(model.getFiltro());
        model.setEstudiantes(rows);
        */
        model.getFiltro().setNombre(view.nombreFld.getText());
        Estudiante filtro= new Estudiante();
        filtro.setNombre(model.getFiltro().getNombre());
        if(view.cedulaFld.getText().equals("")){
            model.getFiltro().setCedula(0);
            filtro.setCedula(model.getFiltro().getCedula());
        }
        else{
            model.getFiltro().setCedula(Integer.parseInt(view.cedulaFld.getText()));
            filtro.setCedula(model.getFiltro().getCedula());
        }
        if(view.carreraFld.getSelectedItem().toString().equals("Todas")){
            model.getFiltro().getCarrera().setNombre("Todas");
            filtro.getCarrera().setNombre("Todas");
        }else{
            Carrera carreraEst = Application.Model.search_CAR_NOM(view.carreraFld.getSelectedItem().toString()).get(0);
            model.getFiltro().setCarrera(carreraEst);
            filtro.setCarrera(carreraEst);
        }
                
        List<Estudiante> rows = Application.Model.search_EST(filtro.getNombre(), filtro.getCedula(), filtro.getCarrera().getNombre());
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
        Estudiante seleccionado = model.getEstudiantesModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setEstudianteCurrent(seleccionado);
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
