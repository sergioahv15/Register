/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Usuario;
import Register.presentation.controller.CarrerasController;
import Register.presentation.controller.CiclosController;
import Register.presentation.controller.CursoController;
import Register.presentation.controller.CursosController;
import Register.presentation.controller.EstudianteController;
import Register.presentation.controller.EstudiantesController;
import Register.presentation.controller.GrupoController;
import Register.presentation.controller.GruposController;
import Register.presentation.controller.HistorialController;
import Register.presentation.controller.LoginController;
import Register.presentation.controller.MenuController;
import Register.presentation.controller.NotaController;
import Register.presentation.controller.NotasController;
import Register.presentation.controller.OfertaController;
import Register.presentation.controller.ProfesoresController;
import Register.presentation.model.CarreraModel;
import Register.presentation.model.CicloModel;
import Register.presentation.model.CursoModel;
import Register.presentation.model.EstudianteModel;
import Register.presentation.model.GrupoModel;
import Register.presentation.model.HistorialModel;
import Register.presentation.model.LoginModel;
import Register.presentation.model.ModelProxy;
import Register.presentation.model.NotaModel;
import Register.presentation.model.OfertaModel;
import Register.presentation.model.ProfesorModel;
import Register.presentation.view.CarrerasView;
import Register.presentation.view.CiclosView;
import Register.presentation.view.CursoView;
import Register.presentation.view.CursosCarreraView;
import Register.presentation.view.CursosView;
import Register.presentation.view.EstudianteView;
import Register.presentation.view.EstudiantesView;
import Register.presentation.view.GrupoView;
import Register.presentation.view.GruposProfeView;
import Register.presentation.view.GruposView;
import Register.presentation.view.HistorialView;
import Register.presentation.view.LoginView;
import Register.presentation.view.MatriculaView;
import Register.presentation.view.MatriculadosView;
import Register.presentation.view.MenuView;
import Register.presentation.view.NotaView;
import Register.presentation.view.NotasView;
import Register.presentation.view.OfertaView;
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
       
       ACTIVE_USER=null;
       
        CICLO_ACTIVO = new Ciclo();
        CARRERA_CURRENT = new Carrera();
        CURSO_CURRENT = new Curso();
        ESTUDIANTE_CURRENT = new Estudiante();
        GRUPO_CURRENT = new Grupo();
        CursoModel cursoModel = new CursoModel();
        CURSO_MODEL = cursoModel;
        NotaModel notaModel = new NotaModel();
        NOTA_MODEL = notaModel;
        HistorialModel historialModel = new HistorialModel();
        HISTORIAL_MODEL = historialModel;
        
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView,loginModel);
        loginView.setVisible(true);
        
        GrupoModel grupoModel = new GrupoModel();
        GRUPO_MODEL = grupoModel;
        ProfesorModel profesorModel = new ProfesorModel();
        EstudianteModel estudianteModel = new EstudianteModel();
        CicloModel cicloModel = new CicloModel();
        CarreraModel carreraModel = new CarreraModel();
        OfertaModel ofertaModel = new OfertaModel();
                
        OfertaView ofertaView= new OfertaView();
        OFERTA_VIEW=ofertaView;
        OfertaController ofertaController = new OfertaController(ofertaView,ofertaModel);
        //ofertaView.setVisible(true);
        
        CarrerasView carrerasView= new CarrerasView();
        CARRERAS_VIEW=carrerasView;
        CarrerasController carrerasController = new CarrerasController(carrerasView,carreraModel);
        //carrerasView.setVisible(true);
        
        GruposView gruposView = new GruposView();
        GRUPOS_VIEW=gruposView;
        GruposController gruposController = new GruposController(gruposView,grupoModel);
        
        CursosView cursosView= new CursosView();
        CURSOS_VIEW=cursosView;
        CursosController cursosController = new CursosController(cursosView,cursoModel);
        //cursosView.setVisible(true);
        
        CursosCarreraView cursosCarreraView = new CursosCarreraView();
        CURSOS_CARRERA_VIEW = cursosCarreraView;
        
        cursosController.setView2(cursosCarreraView);
        
        MatriculadosView matriculadosView = new MatriculadosView();
        MATRICULADOS_VIEW=matriculadosView;
        
        gruposController.setView2(matriculadosView);
        
        GruposProfeView gruposProfeView = new GruposProfeView();
        GRUPOS_PROFE_VIEW=gruposProfeView;
        
        gruposController.setView4(gruposProfeView);
        
        //gruposProfeView.setVisible(true);
        
        ProfesoresView profesoresView= new ProfesoresView();
        PROFESORES_VIEW=profesoresView;
        ProfesoresController profesoresController = new ProfesoresController(profesoresView,profesorModel);
        //profesoresView.setVisible(true);
                
        EstudiantesView estudiantesView= new EstudiantesView();
        ESTUDIANTES_VIEW=estudiantesView;
        EstudiantesController estudiantesController = new EstudiantesController(estudiantesView,estudianteModel);
        //estudiantesView.setVisible(true);
        
        NotasView notasView= new NotasView();
        NOTAS_VIEW=notasView;
        NotasController notasController = new NotasController(notasView,notaModel);
        
        HistorialView historialView= new HistorialView();
        HISTORIAL_VIEW=historialView;
        HistorialController historialController = new HistorialController(historialView,historialModel);
        //historialView.setVisible(true);

        
        CiclosView ciclosView = new CiclosView();
        CICLOS_VIEW = ciclosView;
        CiclosController ciclosController = new CiclosController(ciclosView,cicloModel);
        //ciclosView.setVisible(true);
        

        CursoView cursoView = new CursoView(cursosCarreraView,true);
        CURSO_VIEW=cursoView;
        CursoController cursoController = new CursoController(cursoView,cursoModel);    
        
        GrupoView grupoView = new GrupoView(gruposView,true);
        GRUPO_VIEW=grupoView;
        GrupoController grupoController = new GrupoController(grupoView,grupoModel);
        
        MatriculaView matriculaView = new MatriculaView(matriculadosView,true);
        MATRICULA_VIEW=matriculaView;
        
        gruposController.setView3(matriculaView);
        //ProfesorView profesorView = new ProfesorView(profesoresView,true);
        
        
        //PROFESOR_VIEW=profesorView;
        //ProfesorController profesorController = new ProfesorController(profesorView,profesorModel);
        
        EstudianteView estudianteView = new EstudianteView(estudiantesView,true);
        ESTUDIANTE_VIEW=estudianteView;
        EstudianteController estudianteController = new EstudianteController(estudianteView,estudianteModel);   
        
        NotaView notaView = new NotaView(notasView,true);
        NOTA_VIEW=notaView;
        NotaController notaController = new NotaController(notaView,notaModel);
        
        
        MenuView menuView = new MenuView();
        MENU_VIEW = menuView;
        MenuController menuController = new MenuController(menuView);
     }
    
     public static Usuario ACTIVE_USER;    
     
    public static CursoView CURSO_VIEW;
    public static CursosView CURSOS_VIEW;
    public static CursoModel CURSO_MODEL;
    public static GrupoModel GRUPO_MODEL;
    public static Estudiante ESTUDIANTE_CURRENT;
    public static CarrerasView CARRERAS_VIEW;
    public static Carrera CARRERA_CURRENT;
    public static Curso CURSO_CURRENT;
    public static CursosCarreraView CURSOS_CARRERA_VIEW;
    public static OfertaView OFERTA_VIEW;
    public static ProfesorView PROFESOR_VIEW;
    public static ProfesoresView PROFESORES_VIEW; 
    public static EstudianteView ESTUDIANTE_VIEW;
    public static EstudiantesView ESTUDIANTES_VIEW; 
    public static CiclosView CICLOS_VIEW;
    public static Ciclo CICLO_ACTIVO;
    public static GruposView GRUPOS_VIEW;
    public static GrupoView GRUPO_VIEW;
    public static MatriculadosView MATRICULADOS_VIEW;
    public static GruposProfeView GRUPOS_PROFE_VIEW;
    public static MatriculaView MATRICULA_VIEW;
    public static NotasView NOTAS_VIEW;
    public static HistorialView HISTORIAL_VIEW;
    public static NotaView NOTA_VIEW;
    public static NotaModel NOTA_MODEL;
    public static HistorialModel HISTORIAL_MODEL;
    public static Grupo GRUPO_CURRENT;
    public static MenuView MENU_VIEW;
    public static int ANYO_CURRENT=2017;
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    public static IModel Model;
}
