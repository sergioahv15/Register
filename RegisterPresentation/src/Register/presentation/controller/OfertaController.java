/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Curso;
import Register.presentation.model.OfertaModel;
import Register.presentation.view.OfertaView;

/**
 *
 * @author Fabio
 */
public class OfertaController {
    OfertaView view;
    OfertaModel model;
    
    public OfertaController(OfertaView view, OfertaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        /*model.getFiltro().setNombre(view.textNombreOferta.getText());
        Carrera filtro= new Carrera();
        filtro.setNombre(model.getFiltro().getNombre());
        List<Oferta> rows = Application.Model.search_CUR_CAR(filtro.getNombre());
        //List<Oferta> rows = Model.searchOferta(model.getFiltro());
        model.setOferta(rows);
        */
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setOfertaCurrent(new Curso());
        Application.CURSO_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Curso seleccionada = model.getOfertaModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setOfertaCurrent(seleccionada);
        Application.CURSO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        /*Oferta seleccionada = model.getOfertaModel().getRowAt(row); 
        try {
            Application.Model.deleteOferta(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Oferta> rowsMod = Application.Model.searchOferta(model.getFiltro());
        model.setOferta(rowsMod);
        */
    }
    
    public void close(){
        Application.Model.close();
    }
}
