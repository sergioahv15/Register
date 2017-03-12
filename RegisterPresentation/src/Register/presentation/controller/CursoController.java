/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Curso;
import Register.presentation.model.CursoModel;
import Register.presentation.view.CursoView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class CursoController {
    CursoView view;
    CursoModel model;
    
    public CursoController(CursoView view, CursoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        
        Curso nuevo = new Curso();
        model.clearErrors();
        
        nuevo.setCodigo(view.codigoFld.getText());
        /*if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }*/
        
        nuevo.setNombre(view.nombreFld.getText());
        /*if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        */
        
        nuevo.setCarrera(Application.Model.search_CAR(Application.CARRERA_CURRENT.getNombre(),"").get(0));
        
        nuevo.setCreditos(Integer.parseInt(view.creditosFld.getText()));
        
        nuevo.setHorasSemanales(Integer.parseInt(view.horasFld.getText()));
        
                //**************************** OJO CON EL CICLO QUE SE LE ASIGNA **********************************
                        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.Add_CUR(nuevo);
                        model.setMensaje("CURSO AGREGADO");
                        model.setCursoCurrent(new Curso());                        
                        List<Curso> rowsAgr = Application.Model.search_CUR("","",Application.CARRERA_CURRENT.getNombre());
                        model.setCursos(rowsAgr);  
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.update(nuevo);
                        model.setMensaje("CURSO MODIFICADADO");
                        model.setCursoCurrent(nuevo);                        
                        List<Curso> rowsMod = Application.Model.search_CUR("","",Application.CARRERA_CURRENT.getNombre());
                        model.setCursos(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Curso ya existe");
                model.setMensaje("CURSO YA EXISTE");
                model.setCursoCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCursoCurrent(nuevo);
        }
        
    }
}
