/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Estudiante;
import Register.presentation.model.HistorialModel;
import Register.presentation.view.HistorialView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class HistorialController {
    HistorialView view;
    HistorialModel model;
    
    public HistorialController(HistorialView view, HistorialModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        List<String> historial = Application.Model.search_HIST(Application.ACTIVE_USER.getCedula());
        model.setHistoriales(historial);
        Estudiante est = Application.Model.search_EST("", Application.ACTIVE_USER.getCedula(), "Todas").get(0);
        view.estudianteFld.setText(est.getNombre());
        view.cedulaFld.setText(String.valueOf(est.getCedula()));
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setHistorialCurrent(new String());
        Application.NOTA_VIEW.setVisible(true);
    }
    
    public void preAgregar(int row){
    }
    
    public void editar(int row){
        model.clearErrors();
        String seleccionado = model.getHistorialesModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setHistorialCurrent(seleccionado);
        Application.NOTA_VIEW.setVisible(true);        
    }

    public void borrar(int row){
        
    }
    
    public void close(){
        Application.Model.close();
    }
}


