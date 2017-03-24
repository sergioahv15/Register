/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.Entities.Usuario;
import Register.presentation.model.LoginModel;
import Register.presentation.view.LoginView;

/**
 *
 * @author Fabio
 */
public class LoginController {
    LoginView view;
    LoginModel model;
    
    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void login(){
        int cedula = Integer.parseInt(view.userFld.getText());        
        String pass = view.passFld.getText();
        String tipo = Application.Model.login(cedula, pass);
        switch(tipo){
            case "profesor":
                Application.ACTIVE_USER = Application.Model.search_PRO("", cedula).get(0);
                System.out.println("LOGIN EXITOSO PROFESOR");
                Application.MENU_VIEW.consultHistBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCarrerasBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCiclosBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCursosBtn.setEnabled(false);
                Application.MENU_VIEW.mantenEstBtn.setEnabled(false);
                Application.MENU_VIEW.mantenProfesBtn.setEnabled(false);
                Application.MENU_VIEW.ofertaAcadBtn.setEnabled(false);      
                Application.MENU_VIEW.setVisible(true);
            break;
            case "estudiante":
                Application.ACTIVE_USER = Application.Model.search_EST("", cedula,"Todas").get(0);
                System.out.println("LOGIN EXITOSO ESTUDIANTE");
                Application.MENU_VIEW.mantenCarrerasBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCiclosBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCursosBtn.setEnabled(false);
                Application.MENU_VIEW.mantenEstBtn.setEnabled(false);
                Application.MENU_VIEW.mantenProfesBtn.setEnabled(false);
                Application.MENU_VIEW.ofertaAcadBtn.setEnabled(false);      
                Application.MENU_VIEW.regNotasBtn.setEnabled(false); 
                Application.MENU_VIEW.setVisible(true);                
            break;
            case "matriculador":
                Application.ACTIVE_USER = new Usuario("",0,"matriculador");
                System.out.println("LOGIN EXITOSO MATRICULADOR");
                Application.MENU_VIEW.mantenCarrerasBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCiclosBtn.setEnabled(false);
                Application.MENU_VIEW.mantenCursosBtn.setEnabled(false);
                Application.MENU_VIEW.mantenProfesBtn.setEnabled(false);
                Application.MENU_VIEW.ofertaAcadBtn.setEnabled(false);      
                Application.MENU_VIEW.regNotasBtn.setEnabled(false); 
                Application.MENU_VIEW.consultHistBtn.setEnabled(false);
                Application.ESTUDIANTES_VIEW.agregarBtn.setEnabled(false);
                Application.ESTUDIANTES_VIEW.consultaBtn.setEnabled(false);
                Application.MENU_VIEW.setVisible(true);
            break;
            case "administrador":
                Application.ACTIVE_USER = new Usuario("",0,"administrador");
                System.out.println("LOGIN EXITOSO ADMINISTRADOR");     
                Application.MENU_VIEW.regNotasBtn.setEnabled(false);
                Application.MENU_VIEW.setVisible(true);
            break;
            case "nulo":
                System.out.println("LOGIN FALLIDO - NULO");
                
            break;
            default:
                
        }
    }
}
