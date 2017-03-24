/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.presentation.model.NotaModel;
import Register.presentation.view.NotaView;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class NotaController {
    NotaView view;
    NotaModel model;
    
    public NotaController(NotaView view, NotaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
                  
        int nota;
        if(view.notaFld.getText().equals(""))
            nota = -1;
        else nota = Integer.parseInt(view.notaFld.getText());
            
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                       /* Application.Model.Add_EST(nueva);
                        model.setMensaje("CURSO AGREGADO");
                        model.setNotaCurrent(new Nota());
                        
                        List<Nota> rowsAgr = Application.Model.search_EST("",0,"Todas");
                        model.setNotas(rowsAgr);
                        view.setVisible(false);
                        break;*/
                    case Application.MODO_EDITAR:
                        Application.Model.updateNota(Application.GRUPO_CURRENT.getNumeroGrupo(),
                                Application.ESTUDIANTE_CURRENT.getCedula(),nota);
                        model.setMensaje("NOTA ASIGNADA");
                        model.setNotaCurrent(new String());//*********************** OJO AQUII ***********************
                        Application.GRUPO_CURRENT.setNotas(Application.Model.search_NOTAS(Application.GRUPO_CURRENT.getNumeroGrupo()));
                        model.setNotas(Application.GRUPO_CURRENT.getNotas());
                        view.setVisible(false);                        
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Nota ya existe");
                model.setMensaje("NOTA YA EXISTE");
                model.setNotaCurrent(new String());//*********************** OJO AQUII ***********************
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setNotaCurrent(new String());//*********************** OJO AQUII ***********************
        }
    }
}

