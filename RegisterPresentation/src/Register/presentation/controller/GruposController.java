/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
import Register.Entities.Grupo;
import Register.presentation.model.GrupoModel;
import Register.presentation.view.GruposView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class GruposController {
    GruposView view;
    GrupoModel model;
    
    public GruposController(GruposView view, GrupoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
       /* model.getFiltro().setNombre(view.textNombreGrupo.getText());
        Carrera filtro= new Carrera();
        filtro.setNombre(model.getFiltro().getNombre());
        List<Grupo> rows = Application.Model.search_CUR_CAR(filtro.getNombre());
        //List<Grupo> rows = Model.searchGrupos(model.getFiltro());
        model.setGrupos(rows);
        */
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setGrupoCurrent(new Grupo());
        Application.GRUPO_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Grupo seleccionada = model.getGruposModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setGrupoCurrent(seleccionada);
        Application.GRUPO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Grupo seleccionada = model.getGruposModel().getRowAt(row); 
        try {
            Application.Model.deleteGrupo(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Grupo> rowsMod = Application.Model.searchGrupos(model.getFiltro());
        model.setGrupos(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
