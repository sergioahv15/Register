/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterC;

import Register.Entities.Ciclo;
import Register.IModel;
import Register.console.controller.Controller;
import Register.console.model.Model;
import Register.console.model.ModelProxy;
import Register.console.view.View;

import java.awt.Color;
import java.io.IOException;
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
     public static void main(String[] args) throws IOException {
         Model model = new Model();
         proxy= new ModelProxy();
         View view= new View();
         Controller controller= new Controller(proxy, model,view);
         view.menuPrincipalS();
     }
    
    public static IModel proxy;
}
