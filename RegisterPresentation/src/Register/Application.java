/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import Register.presentation.controller.CursosController;
import Register.presentation.model.CursoModel;
import Register.presentation.model.ModelProxy;
import Register.presentation.view.CursosView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Herrera
 */
public class Application {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
       Model=new ModelProxy();
        //Model=new Model();
        CursoModel cursoModel = new CursoModel();
        
        CursosView cursosView= new CursosView();
        PERSONAS_VIEW=cursosView;
        CursosController cursoscontroller = new CursosController(cursosView,cursoModel);
        cursosView.setVisible(true);

        //CursoView cursoView = new CursoView(cursosView,true);
        //PERSONA_VIEW=cursoView;
        //CursoController cursocontroller = new CursoController(cursoView,cursoModel);
     }
    
   // public static CursoView PERSONA_VIEW;
    public static CursosView PERSONAS_VIEW;    
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    public static IModel Model;
}
