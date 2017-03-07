/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.presentation.model.CicloModel;
import Register.presentation.view.CiclosView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class CiclosController {
    CiclosView view;
    CicloModel model;
    
    public CiclosController(CiclosView view, CicloModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.getFiltro().setAnyo(Integer.parseInt(view.anyoFld.getSelectedItem().toString()));
        Ciclo filtro= new Ciclo();
        filtro.setAnyo(model.getFiltro().getAnyo());
        List<Ciclo> rows = Application.Model.search_CIC_ANYO(filtro.getAnyo());
        model.setCiclos(rows);
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setCicloCurrent(new Ciclo());
        Application.CURSO_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Ciclo seleccionada = model.getCiclosModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setCicloCurrent(seleccionada);
        Application.CURSO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Ciclo seleccionada = model.getCiclosModel().getRowAt(row); 
        try {
            Application.Model.deleteCiclo(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Ciclo> rowsMod = Application.Model.searchCiclos(model.getFiltro());
        model.setCiclos(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
