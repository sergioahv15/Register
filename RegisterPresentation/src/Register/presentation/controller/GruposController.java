/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.presentation.model.GrupoModel;
import Register.presentation.view.GruposProfeView;
import Register.presentation.view.GruposView;
import Register.presentation.view.MatriculaView;
import Register.presentation.view.MatriculadosView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class GruposController {
    GruposView view;
    GrupoModel model;
    //******************
    MatriculadosView view2;
    MatriculaView view3;
    GruposProfeView view4;
    //******************
    
    public GruposController(GruposView view, GrupoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    //*********************************************
    public void setView2(MatriculadosView view2){
        this.view2 = view2;
        view2.setController(this);
        view2.setModel(this.model);
    }
    //*********************************************
    
    //*********************************************
    public void setView3(MatriculaView view3){
        this.view3 = view3;
        view3.setController(this);
        view3.setModel(this.model);
    }
    //*********************************************
    
    //*********************************************
    public void setView4(GruposProfeView view4){
        this.view4 = view4;
        view4.setController(this);
        view4.setModel(this.model);
    }
    //*********************************************
    
    public void buscar(){
        int ciclo = Integer.parseInt(view3.cicloFld.getSelectedItem().toString());
        Application.CARRERA_CURRENT=Application.ESTUDIANTE_CURRENT.getCarrera();
        List<Grupo> rows = Application.Model.search_GRU(ciclo,Application.CARRERA_CURRENT.getCodigo());
        model.setGrupos(rows);
        view2.setVisible(false);
        Application.MATRICULA_VIEW.setVisible(true);
    }
    
    public void matricular(int row) throws Exception{
        model.clearErrors();
        Grupo seleccionado = model.getGruposModel().getRowAt(row); 
        Application.Model.matricular(seleccionado.getNumeroGrupo(), Application.ESTUDIANTE_CURRENT.getCedula());
        List<Grupo> rows = Application.Model.search_GRU(Application.ESTUDIANTE_CURRENT.getCedula());
        Application.GRUPO_MODEL.setGrupos(rows);
        view2.setVisible(true);
        Application.MATRICULA_VIEW.setVisible(false);
    }
    
    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setGrupoCurrent(new Grupo());
        Application.GRUPO_VIEW.setVisible(true);
    }
    
    public void verNotas(int row){
        Grupo seleccionado = model.getGruposModel().getRowAt(row);
        Application.GRUPO_CURRENT = seleccionado;
        seleccionado.setNotas(Application.Model.search_NOTAS(seleccionado.getNumeroGrupo()));
        Application.NOTA_MODEL.setNotas(seleccionado.getNotas()); 
        Application.NOTAS_VIEW.setVisible(true);
    }    
    
    public void editar(int row){
        model.clearErrors();
        Grupo seleccionado = model.getGruposModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setGrupoCurrent(seleccionado);
        Application.GRUPO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        Grupo seleccionado = model.getGruposModel().getRowAt(row); 
        try {
            Application.Model.delete(seleccionado.getNumeroGrupo(),Application.ESTUDIANTE_CURRENT.getCedula());
        } catch (Exception ex) {
            //todo
        }
        List<Grupo> rowsMod = Application.Model.search_GRU(Application.ESTUDIANTE_CURRENT.getCedula());
        model.setGrupos(rowsMod);   
    }
    
    //***********************************************
    public void buscarG(){       
        List<Grupo> grupos = Application.Model.search_GRU_PRO(Application.ACTIVE_USER.getCedula());
        Application.GRUPO_MODEL.setGrupos(grupos); 
    }
    //***********************************************
    
    public void close(){
        Application.Model.close();
    }
    
}
