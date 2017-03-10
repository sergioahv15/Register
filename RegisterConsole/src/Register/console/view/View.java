/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.console.view;
import Register.Entities.Curso;
import Register.console.controller.Controller;
import Register.console.model.Model;
import java.io.Console;
import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;
/**
 *
 * @author Herrera
 */
public class View implements java.util.Observer{
    
    Controller Controller;
    Model Model;
    public View() {
      
    }
            
            
    
    public void setController(Controller controller){
        this.Controller=controller;
    }
     public void setModel(Model model){
        this.Model=model;
        model.addObserver(this);
       
    }       
            
    public void menuPrincipal() {
        Scanner lector = new Scanner(System.in);
        System.out.println();
        System.out.println("LOGIN");
        System.out.println("Digite cedula");
        int ced = lector.nextInt();
        System.out.println("Digite clave");
        String clv=lector.next();
        int i= Controller.login(ced, clv);
       
    }

    public void menuPrincipalS() throws IOException {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuPrincipal();
            int num = lector.nextInt();
            
            switch (num) {
                case 0: 
                    menuAdministrativo();
                    break;
                case 1: 
                    menuProfesores();
                     break;
                case 2:
                    menuEstudiantil();
                 default: {
                    salir = 's';
                    break;
                }
            }
        }
    }
    
    void menuAdministrativo(){
        Scanner lector = new Scanner(System.in);
        System.out.println("MENU ADMINISTRATIVO");
        System.out.println("Digite NRC");
        System.out.println("1.Insertar Ciclo");
        System.out.println("2.Insertar Curso");
        
        System.out.println("3.Insertar Profesor");
        System.out.println("4.Insertar Estudiante");
        System.out.println("5.Insertar Carrera");

        
        
    }
    
     public void menuAdministrativoS() throws IOException {
        Scanner lector = new Scanner(System.in);
        char salir = 'n';
        while (salir == 'n') {
            menuAdministrativo();
            int num = lector.nextInt();
            
            switch (num) {
                case 0: 
                    menuAdministrativo();
                    break;
                case 1: 
                    menuProfesores();
                     break;
                case 2:
                    menuEstudiantil();
                 default: {
                    salir = 's';
                    break;
                }
            }
        }
    }
    
    public void insertarCurso(){
        Scanner lector = new Scanner(System.in);
        Curso c = new Curso();
        System.out.println("Digite NRC");
        String nrc = lector.next();
        System.out.println("Digite nombre");
        String nom = lector.next();
        System.out.println("Digite creditos");
        int cre = lector.nextInt();
        System.out.println("Digite horas semanales");
        int horas = lector.nextInt();
    }
    
    public void insertarCiclo(){
        
    }
    
    public void insertarEstudiante(){
        
    }
    
    public void insertaProfesor(){
        
    }
    
    void menuProfesores(){
         Scanner lector = new Scanner(System.in);
        System.out.println("MENU PROFESORES");
        int ced = lector.nextInt();
    }
    
    void menuEstudiantil(){
        Scanner lector = new Scanner(System.in);
        System.out.println("MENU ESTUDIANTIL");
        int ced = lector.nextInt();
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
