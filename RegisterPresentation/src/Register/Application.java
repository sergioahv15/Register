/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import Register.presentation.controller.CursoController;
import Register.presentation.controller.CursosController;
import Register.presentation.controller.EstudianteController;
import Register.presentation.controller.EstudiantesController;
import Register.presentation.controller.ProfesorController;
import Register.presentation.controller.ProfesoresController;
import Register.presentation.model.CursoModel;
import Register.presentation.model.EstudianteModel;
import Register.presentation.model.ModelProxy;
import Register.presentation.model.ProfesorModel;
import Register.presentation.view.CursoView;
import Register.presentation.view.CursosView;
import Register.presentation.view.EstudianteView;
import Register.presentation.view.EstudiantesView;
import Register.presentation.view.GrupoView;
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
       // CursoModel cursoModel = new CursoModel();
        ProfesorModel profesorModel = new ProfesorModel();
        EstudianteModel estudianteModel = new EstudianteModel();
        
        /*
        CursosView cursosView= new CursosView();
        CURSOS_VIEW=cursosView;
        CursosController cursoscontroller = new CursosController(cursosView,cursoModel);
        cursosView.setVisible(true);
        */
        ProfesoresView profesoresView= new ProfesoresView();
        PROFESORES_VIEW=profesoresView;
        ProfesoresController profesoresController = new ProfesoresController(profesoresView,profesorModel);
        profesoresView.setVisible(true);
        
        EstudiantesView estudiantesView= new EstudiantesView();
        ESTUDIANTES_VIEW=estudiantesView;
        EstudiantesController estudiantesController = new EstudiantesController(estudiantesView,estudianteModel);
        estudiantesView.setVisible(true);
        
        
        //CursoView cursoView = new CursoView(cursosView,true);
        //CURSO_VIEW=cursoView;
        //CursoController cursoController = new CursoController(cursoView,cursoModel);        
        ProfesorView profesorView = new ProfesorView(profesoresView,true);
        
        
        PROFESOR_VIEW=profesorView;
        ProfesorController profesorController = new ProfesorController(profesorView,profesorModel);
        
        EstudianteView estudianteView = new EstudianteView(estudiantesView,true);
        ESTUDIANTE_VIEW=estudianteView;
        EstudianteController estudianteController = new EstudianteController(estudianteView,estudianteModel);   
     }
    
    public static CursoView CURSO_VIEW;
    public static CursosView CURSOS_VIEW; 
    public static ProfesorView PROFESOR_VIEW;
    public static ProfesoresView PROFESORES_VIEW; 
    public static EstudianteView ESTUDIANTE_VIEW;
    public static EstudiantesView ESTUDIANTES_VIEW; 
    public static GrupoView GRUPO_VIEW;
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    public static IModel Model;
}
