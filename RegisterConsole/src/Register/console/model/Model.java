/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.console.model;

import Register.Entities.Usuario;
import java.util.Hashtable;

/**
 *
 * @author Herrera
 */
public class Model extends java.util.Observable {
    Hashtable<String,String> errores;
    Usuario Usuario;
    
    public Model(){
        Usuario=null;
        clearErrors();
    }
    
    public Hashtable<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Hashtable<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new Hashtable<String,String>());
        
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();  
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
        setChanged();
        notifyObservers(); 
    }
    
}
