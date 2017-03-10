/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.console.controller;

import Register.Entities.Usuario;
import Register.IModel;
import Register.console.model.Model;
import Register.console.view.View;

/**
 *
 * @author Herrera
 */
public class Controller {
    
     
     IModel Logic;
     Model Model;
     View View;
    public Controller(IModel logic,Model model,View view) {
        this.View=view;
        this.Logic=logic;
        this.Model=model;
        view.setController(this);
        view.setModel(model);
    }

    
    
    public int login(int ced,String clave){
        Usuario u=Logic.login(clave);
        
        //a=u.getTipo();
        if(u!=null){
            Model.setUsuario(u);
        }
        
        return u.getTipo();
    }
    
    
}
