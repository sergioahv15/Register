/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Carrera;
import Register.Entities.Curso;
import Register.Entities.Grupo;
import Register.presentation.model.OfertaModel;
import Register.presentation.view.OfertaView;
import java.util.List;

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
        Curso filtro= new Curso();        
        if(view.carreraFld.getSelectedItem().toString().equals("Todas")){
            model.getFiltro().getCarrera().setNombre("Todas");
            filtro.getCarrera().setNombre("Todas");
        }else{
            Carrera carreraCur = Application.Model.search_CAR(view.carreraFld.getSelectedItem().toString(),"").get(0);
            model.getFiltro().setCarrera(carreraCur);
            filtro.setCarrera(carreraCur);
        }
        int cicloSelec = Integer.parseInt(view.cicloFld.getSelectedItem().toString());
        model.getFiltro().getCiclo().setNumero(cicloSelec);
        filtro.getCiclo().setNumero(cicloSelec);
        List<Curso> rows = Application.Model.search_CUR(filtro.getCarrera().getNombre(),filtro.getCiclo().getNumero());
        model.setCursos(rows);        
    }

    public void preAgregar(int row){
        Curso seleccionado = model.getOfertaModel().getRowAt(row);
        Application.CURSO_CURRENT = seleccionado;
        List<Grupo> rows = Application.Model.search_GRU(seleccionado.getCodigo(),"");
        System.out.println(rows.toString());
        Application.GRUPO_MODEL.setGrupos(rows); 
        Application.GRUPOS_VIEW.setVisible(true);
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
