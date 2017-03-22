/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.console.view;
import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.Entities.Usuario;
import Register.console.controller.Controller;
import Register.console.model.Model;
import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;
/**
 *
 * @author Herrera
 */
public class View implements java.util.Observer{
    
    Controller Controller;
    Model Model;
    
    public View(){}
    
    
    public void setController(Controller controller){
        this.Controller=controller;
    }
     public void setModel(Model model){
        this.Model=model;
        model.addObserver(this);
       
    }       
            
    public String login() {
        
        Scanner lector = new Scanner(System.in);
        System.out.println();
        System.out.println("LOGIN");
        System.out.println("Digite cedula");
        int ced = lector.nextInt();
        System.out.println("Digite clave");
        String clv=lector.next();
        
        return Controller.login(ced, clv);
       
    }

    public void menuPrincipalS() throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            
            String tipo = login();
            
            switch (tipo) {
                case "profesor": 
                    menuProfesorS();
                    break;
                case "estudiante": 
                    menuEstudiantesS();
                     break;
                case "matriculador":
                    menuMatriculadorS();
                    break;
                case "administrador":
                    menuAdministrativoS();
                    break;    
                default: {
                    salir = 's';
                    break;
                }
            }
        }
    }
    
                            ////MENU ADMINISTRATIVO
    
   
    
    
    
    void menuAdministrativo(){
        System.out.println("\n\n\n\n\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("MENU ADMINISTRATIVO");
        System.out.println("1.Mantenimiento de Ciclos");
        System.out.println("2.Mantenimiento de Cursos");
        System.out.println("3.Mantenimiento de Carreras");
        System.out.println("4.Mantenimiento de Profesores");
        System.out.println("5.Mantenimiento de Estudiantes");
        System.out.println("6.Oferta Academica");
        System.out.println("7.Seguridad");
        System.out.println("8.Salir");
        
     }
    
    void menuSeguridad(){
         System.out.println("\n\n\n\n\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("MENU SEGURIDAD");
        System.out.println("1.Agregar usuario");
        System.out.println("2.Eliminar usuario");
        System.out.println("3.Salir");
    }
    
    void menuMatriculador(){
        System.out.println("\n\n\n\n\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("MENU MATRICULADOR");
        System.out.println("1.Matricula");
        System.out.println("2.Salir");
    }
    
    void mantenimientoCiclos(){
        Ciclo c =Controller.searchCicloActual();
        Object cicloA = (c.getNumero()!=0)?c: "Sin definir";
        System.out.println("MANTENIMIENTO DE CICLOS                               CICLO ACTUAL: "+ cicloA.toString());
        System.out.println("1.Insertar Ciclo");
        System.out.println("2.Seleccionar Ciclo Actual");
        System.out.println("3.Consultar Ciclo");
        //System.out.println("4.Eliminar Ciclo");
        System.out.println("4.Salir");
    }
    
    void mantenimientoCarreras(){
        System.out.println("MANTENIMIENTO DE CARRERAS");
        System.out.println("1.Insertar Carrera");
        System.out.println("2.Consultar Carrera");
        System.out.println("3.Editar Carrera");
        //System.out.println("4.Eliminar Carrera");
        System.out.println("4.Salir");
    }
    
    void menuEditarCarrera(){
        //System.out.println("1.Editar información de la carrera");
        System.out.println("1.Agregar curso");
        System.out.println("2.Eliminar curso");
        System.out.println("3.Cambiar orden de cursos");
        System.out.println("4.Salir");
    }
    
    void mantenimientoCursos(){
        System.out.println("MANTENIMIENTO DE CURSOS");
        System.out.println("1.Agregar curso");
        System.out.println("2.Consultar curso");
        //System.out.println("3.Editar curso");
        //System.out.println("4.Eliminar curso");
        System.out.println("3.Salir");
    }
    
    void mantenimientoProfesores(){
        System.out.println("MANTENIMIENTO DE PROFESORES");
        System.out.println("1.Agregar profesor");
        System.out.println("2.Consultar profesor");
        //System.out.println("3.Editar profesor");
        //System.out.println("4.Eliminar profesor");
        System.out.println("3.Salir");
    }
    
    void mantenimientoEstudiantes(){
        System.out.println("MANTENIMIENTO DE ESTUDIANTES");
        System.out.println("1.Agregar estudiante");
        System.out.println("2.Consultar estudiante");
        //System.out.println("3.Editar estudiante");
        //System.out.println("4.Eliminar estudiante");
        System.out.println("3.Matricula");
        System.out.println("4.Consultar historial");
        System.out.println("5.Salir");
    }
    
     public void menuAdministrativoS() throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuAdministrativo();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    mantenimientoCicloS();
                    break;
                case 2: 
                    mantenimientoCursoS();
                     break;
                case 3:
                    mantenimientoCarreraS();
                    break;
                case 4:
                    mantenimientoProfesorS();
                    break;
                case 5:
                    mantenimientoEstudianteS();
                    break;
                case 6:
                    ofertaAcademica();
                    break;
                case 7:
                    seguridadS();
                    break;
                case 8:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        
    }
     
     public void menuMatriculadorS() throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuMatriculador();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    matricula();
                    break;
                case 2:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        
    }
     
     public void menuSeguridadS() throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuMatriculador();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarUsuario();
                    break;
                case 2: 
                    eliminarUsuario();
                    break;
                case 3:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        menuAdministrativoS();
    }
     
     public void mantenimientoCicloS() throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            mantenimientoCiclos();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarCiclo();
                    break;
                case 2:
                    editarCiclo();
                    
                     break;
                case 3:
                    consultarCiclo();
                    break;
                /*case 4:
                    eliminarCiclo();
                    break;*/
                case 4:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        menuAdministrativoS();
    }
     
     
    
     public void mantenimientoCarreraS() throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            mantenimientoCarreras();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarCarrera();
                    break;
                
                case 2:
                    consultarCarrera();
                    break;
                case 3:
                    editarCarrera();
                    break;
                /*case 4:
                    eliminarCarrera();
                    break;*/
                case 4:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        menuAdministrativoS();
    }
     
     public String editarCarreraS(String codigoCarrera) throws IOException, Exception {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        String bandera ="no";
        while (salir == 'n') {
            menuEditarCarrera();
            int num = lector.nextInt();
            
            switch (num) {
               /* case 1: 
                    bandera=editarInfoCarrera(codigoCarrera);
                    break;*/
                case 1: 
                     bandera=agregarCursoACarrera(codigoCarrera);
                     break;
                case 2:
                    bandera=eliminarCursoACarrera(codigoCarrera);
                    break;
                case 3:
                    bandera=cambiarOrden(codigoCarrera);
                    break;
                case 4:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
            return bandera;
        }
        return bandera;
    }
     
    
     
     public void mantenimientoCursoS() throws Exception{
         Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            mantenimientoCursos();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarCurso();
                    break;
                case 2:
                    consultarCurso();
                    
                     break;
                /*case 3:
                    editarCurso();
                    break;
                case 4:
                    eliminarCurso();
                    break;*/
                case 3:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        menuAdministrativoS();
    }
     
                   
                    
                 

    public void mantenimientoProfesorS() throws Exception{
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            mantenimientoProfesores();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarProfesor();
                    break;
                case 2:
                    consultarProfesor();
                    
                     break;
                /*case 3:
                    editarProfesor();
                    break;
                case 4:
                    eliminarProfesor();
                    break;*/
                case 3:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        menuAdministrativoS();
    }

     public void mantenimientoEstudianteS() throws Exception{
           Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            mantenimientoEstudiantes();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarEstudiante();
                    break;
                case 2:
                    consultarEstudiante();
                    
                     break;
                /*case 3:
                    editarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;*/
                case 3:
                    matricula();
                    break;
                case 4:
                    consultarHistorial();
                    break;
                case 5:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        menuAdministrativoS();
    }
     
     
     public void seguridadS(){
     
     }
        
        
        ///////CICLO
    
    
    public void agregarCiclo() throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE CICLO");
            Scanner lector = new Scanner(System.in);
            Ciclo c;
            System.out.println("Digite el numero de ciclo (FORMATO 1/2)");
            int numero = lector.nextInt();
            System.out.println("Digite año al que pertenece el ciclo");
            int anyo = lector.nextInt();
            System.out.println("Digite fecha de inicio (FORMATO 12/31/1994)");
            String inicio = lector.next();
            System.out.println("Digite fecha de finalizacion (FORMATO 12/31/1994)");
            String fin = lector.next();
           
            boolean actual =false;
            c= new Ciclo(numero,anyo, inicio, fin, actual);
            
            Controller.addCiclo(c);
            System.out.println("Ciclo agregado con éxito");
            System.out.println("¿Desea agregar uno nuevo? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
    }
    
    public void editarCiclo() throws Exception{
        System.out.println("\n\n\n\n\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("MENU CICLO ACTUAL");
        List<Ciclo> ciclos= Controller.searchCiclos(0,0);   
        if(ciclos.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            ciclos.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite el numero del ciclo");
        int numero= lector.nextInt();
        System.out.println("Digite el año del ciclo");
        int anyo= lector.nextInt();
        Controller.updateCiclo(numero,anyo);
        System.out.println("Ciclo editado con éxito, digite una tecla para salir");
        String bandera=lector.next();
        mantenimientoCicloS();
    }
    
    public void consultarCiclo() throws Exception{
        System.out.println("\n\n\n\n\n");
        System.out.println("CONSULTA DE CICLOS");
        Scanner lector = new Scanner(System.in);
        List<Ciclo> ciclos= Controller.searchCiclos(0,0);   
        if(ciclos.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            ciclos.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite una tecla para salir");
        String tecla= lector.next();
    }
    
    public void eliminarCiclo(){
        
    }
    
                        //////////CARRERA
    
    public void agregarCarrera() throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE CARRERA");
            Scanner lector = new Scanner(System.in);
            Carrera c;
            System.out.println("Digite codigo de la carrera");
            String cod = lector.next();
            System.out.println("Digite nombre");
            String nombre = lector.next();
            System.out.println("Digite titulo a obtener");
            String titulo = lector.next();
            c= new Carrera(cod, nombre,titulo);
            Controller.addCarrera(c);
            System.out.println("Carrera agregada con éxito");
            System.out.println("¿Desea agregar una nueva Carrera? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
    }
     
    public void consultarCarrera(){
        System.out.println("\n\n\n\n\n");
        System.out.println("CONSULTA DE CARRERAS");
        Scanner lector = new Scanner(System.in);
        List<Carrera> carreras= Controller.searchCarreras("","");
        if(carreras.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            carreras.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite una tecla para salir");
        String tecla= lector.next();
    }
    
    public void eliminarCarrera(){
        
    }
    
    
    public void editarCarrera() throws Exception{
        System.out.println("\n\n\n\n\n");
        System.out.println("GESTIÓN DE CURSOS DE CARRERA");
        Scanner lector = new Scanner(System.in);
        List<Carrera> carreras= Controller.searchCarreras("", "");
        if(carreras.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            carreras.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite el codigo de la carrera");
        String codigo= lector.next();
        String bandera="si";
        while(bandera.equals("si")){
           bandera= editarCarreraS(codigo);
        }
        mantenimientoCarreraS();
    }
    
    public String agregarCursoACarrera(String codigoCarrera) throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE CURSO");
            Scanner lector = new Scanner(System.in);
            List<Curso> cursos= Controller.searchCursos("", "", "Todas");
            if(cursos.isEmpty()){
                System.out.println("Lista vacía");
            }
            else{
                cursos.stream().forEach((c) -> {
                    System.out.println(c);
                });}
            System.out.println("Digite el codigo del curso");
            String codigoCurso= lector.next();
            Controller.agregarCursoACarrera(codigoCurso,codigoCarrera);
            System.out.println("Curso agregado con éxito");
            System.out.println("¿Desea agregar uno nuevo? si/no");
            bandera=lector.next();
        }
        return "si";
    }
    
    
    
    public String editarInfoCarrera(String codigoCarrera) throws Exception{
        Scanner lector = new Scanner(System.in);
        System.out.println("Digite nuevo nombre");
        String nombre = lector.next();
        System.out.println("Digite nuevo titulo");
        String titulo = lector.next();
        Controller.updateCarrera(codigoCarrera,nombre,titulo);
        System.out.println("Carrera editada con éxito, digite una tecla para salir");
        String a =lector.next();
        return "si";  
    }
    
    
   
    
    public String eliminarCursoACarrera(String codigoCarrera) throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("ELIMINAR CURSO DE CARRERA");
            Scanner lector = new Scanner(System.in);
            List<Curso> cursos= Controller.searchCursos(codigoCarrera, -1);
            for(Curso ci:cursos){
                System.out.println(ci);
            }
            System.out.println("Digite el codigo del curso que desea eliminar");
            String codCurso=lector.next();
            Controller.deleteCurso(codCurso);
            System.out.println("Curso eliminado con éxito");
            System.out.println("¿Desea eliminar uno nuevo? si/no");
            bandera=lector.next();
        }
        return "si";
        
    
    }
    
    public String cambiarOrden(String codigoCarrera){
        String bandera= "si";

        return bandera;
    }
              //////  CURSO
    
     public void agregarCurso() throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE CURSO");
            Scanner lector = new Scanner(System.in);
            Curso c;
            System.out.println("Digite el codigo");
            String cod = lector.next();
            System.out.println("Digite el nombre");
            String nombre = lector.next();
            System.out.println("Digite numero de creditos");
            int creditos = lector.nextInt();
            System.out.println("Digite numero de horas semanales");
            int horas = lector.nextInt();
            List<Ciclo> ciclos= Controller.searchCiclos(0,0);
            for(Ciclo ci:ciclos){
                System.out.println(ci);
            }
            System.out.println("Digite el año del ciclo al cual desea agregar el curso");
            int anyoCiclo=lector.nextInt();
            System.out.println("Digite el numero del ciclo al cual desea agregar el curso");
            int numeroCiclo=lector.nextInt();
            List<Carrera> carreras= Controller.searchCarreras("","");
            carreras.stream().forEach((a) -> {
                System.out.println(a);
            });
            System.out.println("Digite el codigo de la carrera a la que pertenece el curso");
            String codigoCarrera=lector.next();

            c= new Curso(cod, nombre, creditos, horas);
            Controller.agregarCurso(c, anyoCiclo,numeroCiclo,codigoCarrera);
            System.out.println("Curso agregado con éxito");
            System.out.println("¿Desea agregar uno nuevo? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
    }
    
    public void editarCurso(){
        
    }
    
    public void consultarCurso() throws Exception{
        System.out.println("\n\n\n\n\n");
        System.out.println("CONSULTA DE CURSOS");
        Scanner lector = new Scanner(System.in);
        List<Curso> cursos= Controller.searchCursos("", "", "Todas");
        if(cursos.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            cursos.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite una tecla para salir");
        String tecla= lector.next();
    }
    
    public void eliminarCurso(){
    
    }
    
    
                   ////PROFESOR
    
    
    public void agregarProfesor() throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE PROFESOR");
            Scanner lector = new Scanner(System.in);
            Profesor p;
            System.out.println("Digite cedula");
            int ced = lector.nextInt();
            System.out.println("Digite clave");
            String clave = lector.next();
            System.out.println("Digite nombre");
            String nombre = lector.next();
            System.out.println("Digite telefono");
            int tel = lector.nextInt();
            System.out.println("Digite email");
            String email = lector.next();
            p= new Profesor(nombre, tel, email, clave, ced, email);
            Controller.addProfesor(p);
            System.out.println("Profesor agregado con éxito");
            System.out.println("¿Desea agregar uno nuevo? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
    }
    
    
    public void editarProfesor(){
    
    }
    
    public void consultarProfesor(){
        System.out.println("\n\n\n\n\n");
        System.out.println("CONSULTA DE Profesores");
        Scanner lector = new Scanner(System.in);
        List<Profesor> profesors= Controller.searchProfesor("",0);
        if(profesors.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            profesors.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite una tecla para salir");
        String tecla= lector.next();
    }
    
    public void eliminarProfesor() throws Exception{
        
    }
    
    
                  /////ESTUDIANTE
    
    
    
    
    public void agregarEstudiante() throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE ESTUDIANTE");
            Scanner lector = new Scanner(System.in);
            Profesor p;
            System.out.println("Digite cedula");
            int ced = lector.nextInt();
            System.out.println("Digite clave");
            String clave = lector.next();
            System.out.println("Digite nombre");
            String nombre = lector.next();
            System.out.println("Digite telefono");
            int tel = lector.nextInt();
            System.out.println("Digite email");
            String email = lector.next();
            System.out.println("Digite fecha de nacimiento");
            String fechaNac = lector.next();
            List<Carrera> carreras= Controller.searchCarreras("","");
            carreras.stream().forEach((c) -> {
                System.out.println(c);
            });
            System.out.println("Digite el codigo de la carrera a la que pertenece el estudiante");
            String codigoCarrera= lector.next();
            Estudiante estu = new Estudiante(nombre, tel, email, fechaNac,clave, ced);
            Controller.addEstudiante(estu,codigoCarrera);
            System.out.println("Estudiante agregado con éxito");
            System.out.println("¿Desea agregar uno nuevo? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
    }
    
    public void editarEstudiante(){
    
    }
    
    public void consultarEstudiante() throws Exception{
        System.out.println("\n\n\n\n\n");
        System.out.println("CONSULTA DE ESTUDIANTES");
        Scanner lector = new Scanner(System.in);
        List<Estudiante> estudiantes= Controller.searchEstudiantes("" , 0, "");
        if(estudiantes.isEmpty()){
            System.out.println("Lista vacía");
        }
        else{
            estudiantes.stream().forEach((c) -> {
                System.out.println(c);
            });}
        System.out.println("Digite una tecla para salir");
        String tecla= lector.next();
    }
    
    public void eliminarEstudiante(){
    
    }
    
    public void matricula() throws Exception{
        int numCiclo;
        String bandera = "si";
        while (bandera.equals("si")) {
        System.out.println("\n\n\n\n\n");
        System.out.println("MATRICULA\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("Digite la cedula del estudiante");
        int cedula=lector.nextInt();
        List<Grupo> grupos= Controller.searchGrupos(cedula);   ////
        if(grupos.isEmpty()){
            System.out.println("El estudiante no tiene ningun curso matriculado");
        }
        else{
            grupos.stream().forEach((c) -> {
                System.out.println(c);
            });}
        String bandera2="si";
        while (bandera2.equals("si")) {
                    numCiclo=menuMatriculaS(cedula);
                    bandera2="no";
                    bandera= (numCiclo==0)? "no":"si";
                }
        }
 
        menuAdministrativoS();
    }
    void menuMatricula(){
         
        System.out.println("1.Matricular nuevo curso");
        System.out.println("2.Eliminar curso");
        System.out.println("3.Cambiar ciclo");
        System.out.println("4.Salir");
    }
    
    
     int menuMatriculaS(int cedula) throws Exception{
         Scanner lector = new Scanner(System.in);
         int retorno =0;
        char salir = 'n';
        while (salir == 'n') {
            menuMatricula();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    matricularCursoEstudiante(cedula);
                    break;
                case 2: 
                    eliminarCursoEstudiante();
                     break;
                case 3: 
                    retorno=cambiarCiclo();
                     break;
                 case 4:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
        return retorno;
    }
    
    
     public void matricularCursoEstudiante(int cedula) throws Exception{
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("\n\n\n\n\n");
            System.out.println("MATRICULA\n");
            Scanner lector = new Scanner(System.in);
             List<Grupo> grupos= Controller.searchOferta(cedula);   ////
            if(grupos.isEmpty()){
                System.out.println("No hay oferta academica para el ciclo seleccionado");
            }
            else{
                grupos.stream().forEach((c) -> {
                    System.out.println(c);
                });}
             System.out.println("Digite el numero del grupo que quiere matricular ");
             int numGrupo=lector.nextInt();
             Controller.matricular(numGrupo, cedula);
             System.out.println("Grupo matriculado con éxito");
             System.out.println("¿Desea agregar uno nuevo? si/no");
             bandera=lector.next();
        }
        menuAdministrativoS();
     }
     public void eliminarCursoEstudiante(){}
     
     
     public void consultarHistorial() throws Exception{
         Scanner lector = new Scanner(System.in);
         System.out.println("CONSULTA DE HISTORIAL DE ESTUDIANTE");
         System.out.println("Digite la cedula del estudiante");
         int cedula=lector.nextInt();
         List<String> notas= Controller.searchHistorial(cedula);
            if(notas.isEmpty()){
                System.out.println("Sin cursos");
            }
            else{
                notas.stream().forEach((c) -> {
                    System.out.println(c);
                });}
        System.out.println("Digite una tecla para salir");
        String tecla=lector.next();
        mantenimientoEstudianteS();
     }
     
    public int cambiarCiclo(){
        return 0;
    }
    
              ////OFERTA ACADEMICA
    
    public void ofertaAcademica() throws Exception{
        System.out.println("\n\n\n\n\n");
        System.out.println("OFERTA ACADEMICA\n");
        String bandera = "si";
        Scanner lector = new Scanner(System.in);
        List<Carrera> carreras= Controller.searchCarreras("","");
        carreras.stream().forEach((c) -> {
            System.out.println(c);
        });
        System.out.println("Digite el nombre de la carrera a la cual se creara la oferta");
        String nombreCarrera=lector.next();
        List<Ciclo> ciclos= Controller.searchCiclos(0,0);   ////
        ciclos.stream().forEach((c) -> {
            System.out.println(c);
        });
        //System.out.println("Digite el año del ciclo al cual desea agregar el curso");
        //int anyoCiclo=lector.nextInt();
        System.out.println("Digite el numero del ciclo al cual desea agregar el curso");
        int numeroCiclo=lector.nextInt();
        while (bandera.equals("si")) {
            List<Curso> cursos= Controller.ofertaAcademica(nombreCarrera,numeroCiclo);
            cursos.stream().forEach((c) -> {
            System.out.println(c);
            });
            System.out.println("Digite el codigo del curso al que desea gestionar");
            String codigoCurso= lector.next();
                while (bandera.equals("si")) {
                    menuAgregaGruposS(codigoCurso);
                    bandera="no";
                }
            System.out.println("¿Desea seleccionar un nuevo curso? si/no");
            bandera=lector.next();
        }
 
        menuAdministrativoS();
    }
    
    void menuAgregaGrupos(){
        System.out.println("1.Agregar grupo a curso seleccionado");
        System.out.println("2.Editar grupo");
        System.out.println("3.Salir");
    }
    
    void menuAgregaGruposS(String cod) throws Exception{
         Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuAgregaGrupos();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    agregarGrupo(cod);
                    break;
                case 2: 
                    editarGrupo();
                     break;
                 case 3:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
    }
    
    
    void agregarGrupo(String codigoCurso) throws Exception{
        System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("AGREGAR GRUPO");
            Scanner lector = new Scanner(System.in);
            List<Profesor> profesor= Controller.searchProfesor("",0);
            profesor.stream().forEach((c) -> {
                System.out.println(c);
            });
            System.out.println("Digite la cedula del profesor al que le asignará el grupo");
            int cedulaProf=lector.nextInt();
            System.out.println("¿Se impartirá el curso los Lunes?  si/no");
            String Lunes= lector.next();
            boolean L= (Lunes.equals("si"))?true:false;
            System.out.println("¿Se impartirá el curso los Martes? si/no");
            String Martes= lector.next();
            boolean M= (Martes.equals("si"))?true:false;
            System.out.println("¿Se impartirá el curso los Miercoles? si/no");
            String Miercoles= lector.next();
            boolean K= (Miercoles.equals("si"))?true:false;
            System.out.println("¿Se impartirá el curso los Jueves? si/no");
            String Jueves= lector.next();
            boolean J= (Jueves.equals("si"))?true:false;
            System.out.println("¿Se impartirá el curso los Viernes? si/no");
            String Viernes= lector.next();
            boolean V= (Viernes.equals("si"))?true:false;
            System.out.println("Digite la hora de inicio del grupo");
            String horaIni= lector.next();
            System.out.println("Digite la hora final del grupo");
            String horaFin= lector.next();
            Grupo grupo = new Grupo(L, M, K, J, V, horaIni, horaFin);
            Controller.addGrupo(grupo,cedulaProf,codigoCurso);
            System.out.println("grupo agregado correctamente");
            System.out.println("¿Desea agregar un nuevo grupo? si/no");
            bandera=lector.next();
        }
        menuAgregaGruposS(bandera);
    }
    
    void editarGrupo(){
    
    }
    
    
    
                                          /////MENU PROFESORES                      
    
     public void menuProfesoresS(){
        System.out.println("\n\n\n\n\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("1.Registrar notas");
        System.out.println("2.Salir");
    }
    
   void menuProfesorS() throws Exception{
         Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuProfesoresS();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    registrarNotas();
                    break;
                case 2:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
    }
    
   
   public void registrarNotas() throws Exception{
       System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("REGISTRO DE NOTAS");
            Scanner lector = new Scanner(System.in);
            List<Grupo> grupos= Controller.searchGruposPro();
            if(grupos.isEmpty()){
                System.out.println("El Profesor no tiene ningun grupo asignado");
            }
            else{
                grupos.stream().forEach((c) -> {
                    System.out.println(c);
                });}
            System.out.println("Digite el numero del grupo");
            int numeroGrupo=lector.nextInt();
            List<String> notas= Controller.searchNotas(numeroGrupo);
            if(notas.isEmpty()){
                System.out.println("El grupo no tiene estudiantes matriculados");
            }
            else{
                notas.stream().forEach((c) -> {
                    System.out.println(c);
                });}
            System.out.println("Digite la cedula del estudiante al que desea agregar/modificar la nota");
            int cedula=lector.nextInt();
            System.out.println("Digite nota");
            int nota= lector.nextInt();
            Controller.updateNota(numeroGrupo, cedula, nota);
            System.out.println("nota agregada/actualizada correctamente");
            System.out.println("¿Desea agregar un nueva? si/no");
            bandera=lector.next();
        }
        menuAgregaGruposS(bandera);
        
   }
    
                                           ///MENU ESTUDIANTIL
                    
    public void menuEstudiantil(){
        System.out.println("\n\n\n\n\n");
        Scanner lector = new Scanner(System.in);
        System.out.println("1.Consultar historial academico");
        System.out.println("2.Salir");
    }
     
   void menuEstudiantesS() throws Exception{
         Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuEstudiantil();
            int num = lector.nextInt();
            
            switch (num) {
                case 1: 
                    historialAcademico();
                    break;
                case 2:
                    salir = 's';
                    break;
                 default: {
                    System.out.println("Opcion incorrecta...");
                    break;
                }
            }
        }
    }
   
   public void historialAcademico() throws Exception{
       Scanner lector = new Scanner(System.in);
       List<String> notas= Controller.searchHistorial();
            if(notas.isEmpty()){
                System.out.println("Sin cursos");
            }
            else{
                notas.stream().forEach((c) -> {
                    System.out.println(c);
                });}
        System.out.println("Digite una tecla para salir");
        String tecla=lector.next();
        menuAdministrativoS();
   }
    
   public void agregarUsuario() throws Exception{
       System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("INSERSION DE USUARIOS");
            Scanner lector = new Scanner(System.in);
            System.out.println("Digite cedula");
            int cedula = lector.nextInt();
            System.out.println("Digite clave");
            String clave = lector.next();
            
            System.out.println("Digite tipo de usuario (administrador/matriculador)");
            String tipo = lector.next();
            Usuario usuario= new Usuario(clave, cedula, tipo);
            Controller.addUsuario(usuario);
            System.out.println("Usuario agregado con éxito");
            System.out.println("¿Desea agregar uno nuevo? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
   }
   
   public void eliminarUsuario() throws Exception{
       System.out.println("\n\n\n\n\n");
        String bandera = "si";
        while (bandera.equals("si")) {
            System.out.println("MENU ELIMINAR USUARIOS");
            Scanner lector = new Scanner(System.in);
            System.out.println("Digite cedula");
            int cedula = lector.nextInt();
            Controller.deleteUsuario(cedula);
            System.out.println("Usuario eliminado con éxito");
            System.out.println("¿Desea eliminado uno nuevo? si/no");
            bandera=lector.next();
        }
        menuAdministrativoS();
   }
   
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
    



}
