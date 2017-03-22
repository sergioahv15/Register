/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

/**
 *
 * @author Herrera
 */
public class Protocol {
    
    public static final String SERVER = "localhost";
    public static final int PORT = 1234;
    
    public static final int SEARCH_CURSOS=0;
    public static final int SEARCH_CURSOS2=1;
    public static final int UPDATE_CURSO=2;
    public static final int DELETE_CURSO=3;
    
    public static final int SEARCH_CARRERA=4;
    public static final int UPDATE_CARRERA=5;
    
    public static final int SEARCH_PROFESOR=6;
    public static final int UPDATE_PROFESOR=7;
   
    public static final int SEARCH_ESTUDIANTES=8;
    public static final int UPDATE_ESTUDIANTE=9;
    
    public static final int SEARCH_CICLOS=10;
    public static final int UPDATE_CICLOS=11;
    
    public static final int SEARCH_GRUPOS=12;
    public static final int SEARCH_GRUPOS2=13;
    public static final int SEARCH_GRUPOS3=14;
    public static final int SEARCH_GRUPOS4=15;
    public static final int UPDATE_GRUPO=16;
    public static final int MATRICULAR_GRUPO=17;
    public static final int DELETE_GRUPO_MATRICULADO=18;
    
    public static final int OFERTA_ACADEMICA=19;
    public static final int SEARCH_HISTORIAL_ACTIVO=20;
    
    public static final int ADD_CURSO=21;
    public static final int ADD_CARRERA=22;
    public static final int ADD_PROFESOR=23;
    public static final int ADD_ESTUDIANTE=24;
    public static final int ADD_CICLO=25;
    public static final int ADD_GRUPO=26;
    
    public static final int LOGIN=27;
    public static final int LOGOUT=28;
    public static final int CLOSE=29;
    
    public static final int SEARCH_NOTAS=30;
    public static final int UPDATE_NOTA=31;
    public static final int SEARCH_CICLO_ACTUAL=32;
    
    public static final int SEARCH_USER=33;
    public static final int DELETE_USER=34;
    public static final int ADD_USER=35;
    
    
    public static final int ERROR_NO_ERROR=0;
    public static final int ERROR_SEARCH_CURSOS_NOMBRE=1;
    public static final int ERROR_SEARCH_CURSOS_CODIGO=2;
    public static final int ERROR_SEARCH_CURSOS_CARRERA=3;
    public static final int ERROR_UPDATE_CURSO=4;   
    public static final int ERROR_GET_CARRERA_NOMBRE=5;
    public static final int ERROR_GET_CARRERA_CODIGO=6;
    public static final int ERROR_UPDATE_CARRERA=7;   
    public static final int ERROR_GET_PROFESOR_NOMBRE=8;
    public static final int ERROR_GET_PROFESOR_CEDULA=9;
    public static final int ERROR_UPDATE_PROFESOR=10;  
    public static final int ERROR_GET_ESTUDIANTES_NOMBRE=11;
    public static final int ERROR_GET_ESTUDIANTES_CEDULA=12;
    public static final int ERROR_GET_ESTUDIANTES_CARRERA=13;
    public static final int ERROR_UPDATE_ESTUDIANTE=14;    
    public static final int ERROR_GET_CICLOS_ANYO=15;
    public static final int ERROR_UPDATE_CICLOS=16;   
    public static final int ERROR_OFERTA_ACADEMICA=17;
    public static final int ERROR_SEARCH_HISTORIAL_ACTIVO=18;
    public static final int ERROR_ADD_CARRERA=19;
    public static final int ERROR_ADD_PROFESOR=20;
    public static final int ERROR_ADD_ESTUDIANTE=21;
    public static final int ERROR_ADD_CICLO=22;
    public static final int ERROR_ADD_CURSO=23;
    public static final int ERROR_LOGIN=24;
    public static final int ERROR_LOGOUT=25;
    public static final int ERROR_SEARCH_CICLO_ACTUAL=26;
    public static final int ERROR_SEARCH_USER=33;
    public static final int ERROR_DELETE_USER=34;
    public static final int ERROR_ADD_USER=35;
}
