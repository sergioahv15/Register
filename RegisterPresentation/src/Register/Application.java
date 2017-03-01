/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import Register.presentation.controller.CursoController;
import Register.presentation.controller.CursosController;
import Register.presentation.controller.ProfesorController;
import Register.presentation.controller.ProfesoresController;
import Register.presentation.model.CursoModel;
import Register.presentation.model.ModelProxy;
import Register.presentation.model.ProfesorModel;
import Register.presentation.view.CursoView;
import Register.presentation.view.CursosView;
import Register.presentation.view.ProfesorView;
import Register.presentation.view.ProfesoresView;
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
        ProfesorModel profesorModel = new ProfesorModel();
        
        CursosView cursosView= new CursosView();
        CURSOS_VIEW=cursosView;
        CursosController cursoscontroller = new CursosController(cursosView,cursoModel);
        cursosView.setVisible(true);
        
        ProfesoresView profesoresView= new ProfesoresView();
        PROFESORES_VIEW=profesoresView;
        ProfesoresController profesoresController = new ProfesoresController(profesoresView,profesorModel);
        profesoresView.setVisible(true);

        CursoView cursoView = new CursoView(cursosView,true);
        CURSO_VIEW=cursoView;
        CursoController cursoController = new CursoController(cursoView,cursoModel);
        
        ProfesorView profesorView = new ProfesorView(profesoresView,true);
        PROFESOR_VIEW=profesorView;
        ProfesorController profesorController = new ProfesorController(profesorView,profesorModel);
     }
    
    public static CursoView CURSO_VIEW;
    public static CursosView CURSOS_VIEW; 
    public static ProfesorView PROFESOR_VIEW;
    public static ProfesoresView PROFESORES_VIEW; 
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    public static IModel Model;
}
