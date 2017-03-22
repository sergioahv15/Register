/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterC;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.IModel;
import Register.console.controller.Controller;
import Register.console.model.Model;
import Register.console.model.ModelProxy;
import Register.console.view.View;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
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
     public static void main(String[] args) throws IOException, Exception {
         Model model = new Model();
         proxy= new ModelProxy();
         View view= new View();
         Controller controller= new Controller(proxy, model,view);
         view.menuPrincipalS();
         //view.menuProfesoresS();
        // view.registrarNotas();
         //List<Carrera> carreras=proxy.search_CAR_COD("");
        
       /* Scanner lector = new Scanner(System.in);
        List<Curso> cursos= controller.searchCurso("");
            cursos.stream().forEach((c) -> {
                System.out.println(c);
            });
            System.out.println("Digite el codigo del curso que desea agregar a la carrera");
            String NRC= lector.next();*/
     }
    
    public static IModel proxy;
}
