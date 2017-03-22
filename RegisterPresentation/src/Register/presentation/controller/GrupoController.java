/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Grupo;
import Register.presentation.model.GrupoModel;
import Register.presentation.view.GrupoView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class GrupoController {
    GrupoView view;
    GrupoModel model;
    
    public GrupoController(GrupoView view, GrupoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        
        Grupo nuevo = new Grupo();
        model.clearErrors();
        
        nuevo.setNumeroGrupo(Integer.parseInt(view.numeroFld.getText()));
                
        nuevo.setProfesor(Application.Model.search_PRO(view.profeFld.getSelectedItem().toString(), 0).get(0));
        
        nuevo.setCurso(Application.Model.search_CUR("", Application.CURSO_CURRENT.getCodigo(), "Todas").get(0));
        
        nuevo.setHoraInicio(view.inicioFld.getSelectedItem().toString());
        nuevo.setHoraFin(view.finFld.getSelectedItem().toString());
        
        String dia1 = view.diaFld1.getSelectedItem().toString();
        String dia2 = view.diaFld2.getSelectedItem().toString();
        
        if(dia1.equals("Lunes")) nuevo.setLunes(true);
        else if(dia1.equals("Martes")) nuevo.setMartes(true);
        else if(dia1.equals("Miercoles")) nuevo.setMiercoles(true);
        else if(dia1.equals("Jueves")) nuevo.setJueves(true);
        else if(dia1.equals("Viernes")) nuevo.setViernes(true);
        
        if(!dia1.equals("Lunes") && dia2.equals("Lunes")) nuevo.setLunes(true);
        else if(!dia1.equals("Martes") && dia2.equals("Martes")) nuevo.setMartes(true);
        else if(!dia1.equals("Miercoles") && dia2.equals("Miercoles")) nuevo.setMiercoles(true);
        else if(!dia1.equals("Jueves") && dia2.equals("Jueves")) nuevo.setJueves(true);
        else if(!dia1.equals("Viernes") && dia2.equals("Viernes")) nuevo.setViernes(true);
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.Add_GRU(nuevo);
                        model.setMensaje("GRUPO AGREGADO");
                        model.setGrupoCurrent(new Grupo());
                        
                        List<Grupo> rowsAgr = Application.Model.search_GRU(Application.CURSO_CURRENT.getCodigo(),"");
                        model.setGrupos(rowsAgr); 
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.update(nuevo);
                        model.setMensaje("GRUPO MODIFICADO");
                        model.setGrupoCurrent(nuevo);
                        
                        List<Grupo> rowsMod = Application.Model.search_GRU(Application.CURSO_CURRENT.getCodigo(),"");
                        model.setGrupos(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Grupo ya existe");
                model.setMensaje("CURSO YA EXISTE");
                model.setGrupoCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setGrupoCurrent(nuevo);
        }
        
    }
}
