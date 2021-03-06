/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.controller;

import Register.Application;
import Register.presentation.view.MenuView;
import java.awt.Menu;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class MenuController {
    MenuView view;
    
    public MenuController(MenuView view) {
        this.view = view;
        view.setController(this);
    }

    public void consultarOpcion(int opc){
        switch(opc){
            case 1:
                Application.CURSOS_VIEW.setVisible(true);
            break;
            case 2:
                Application.CARRERAS_VIEW.setVisible(true);
            break;
            case 3:
                Application.PROFESORES_VIEW.setVisible(true);
            break;
            case 4:
                Application.ESTUDIANTES_VIEW.setVisible(true);
            break;
            case 5:
                Application.CICLOS_VIEW.setVisible(true);
            break;
            case 6:
                Application.OFERTA_VIEW.setVisible(true);
            break;
            case 7:
               Application.GRUPOS_PROFE_VIEW.setVisible(true);
            break;
            case 8:
                Application.HISTORIAL_VIEW.setVisible(true);
                Application.CED_EST_CURRENT = Application.ACTIVE_USER.getCedula();
            break;
            case 9:
                Application.SEGURIDAD_VIEW.setVisible(true);
            break;
            case 10:
                Application.CURSOS_VIEW.setVisible(false);
                Application.CARRERAS_VIEW.setVisible(false);
                Application.PROFESORES_VIEW.setVisible(false);
                Application.ESTUDIANTES_VIEW.setVisible(false);
                Application.CICLOS_VIEW.setVisible(false);
                Application.OFERTA_VIEW.setVisible(false);
                Application.GRUPOS_PROFE_VIEW.setVisible(false);
                Application.HISTORIAL_VIEW.setVisible(false);
                Application.SEGURIDAD_VIEW.setVisible(false);                
                Application.LOGIN_CONTROLLER.logout();
            break;
        }
    }
}

