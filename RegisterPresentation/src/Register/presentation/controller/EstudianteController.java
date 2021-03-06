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
import Register.presentation.view.EstudianteView;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class EstudianteController {
    EstudianteView view;
    EstudianteModel model;
    
    public EstudianteController(EstudianteView view, EstudianteModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
      
        Estudiante nuevo = new Estudiante();
        model.clearErrors();
        
        nuevo.setCedula(Integer.parseInt(view.cedulaFld.getText()));
        /*if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }*/
        
        nuevo.setNombre(view.nombreFld.getText());
        /*if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }*/
        
        nuevo.setTel(Integer.parseInt(view.telefonoFld.getText()));
        
        nuevo.setEmail(view.emailFld.getText());
        
        nuevo.setFechaNac(view.fechaNacFld.getText());
        
        nuevo.setCarrera(Application.Model.search_CAR(view.carreraFld.getSelectedItem().toString(),"").get(0));
        
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.Add_EST(nuevo);
                        model.setMensaje("CURSO AGREGADO");
                        model.setEstudianteCurrent(new Estudiante());
                        
                        List<Estudiante> rowsAgr = Application.Model.search_EST("",0,"Todas");
                        model.setEstudiantes(rowsAgr);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.update(nuevo);
                        model.setMensaje("ESTUDIANTE MODIFICADADO");
                        model.setEstudianteCurrent(nuevo);
                        
                        List<Estudiante> rowsMod = Application.Model.search_EST("",0,"Todas");
                        model.setEstudiantes(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Estudiante ya existe");
                model.setMensaje("ESTUDIANTE YA EXISTE");
                model.setEstudianteCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setEstudianteCurrent(nuevo);
        }
        
    }
}
