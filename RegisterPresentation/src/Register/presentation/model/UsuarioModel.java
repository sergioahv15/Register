/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Usuario;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class UsuarioModel extends java.util.Observable{
    public UsuarioModel() {
        initUsuario();
        initUsuarios();
    }

//======= USUARIO ============    
    Usuario usuarioCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initUsuario(){
        setUsuarioCurrent(new Usuario());
        clearErrors();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Hashtable<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Hashtable<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new Hashtable<String,String>());
        setMensaje("");
        
    }
    public Usuario getUsuarioCurrent() {
        return usuarioCurrent;
    }

    public void setUsuarioCurrent(Usuario usuarioCurrent) {
        this.usuarioCurrent = usuarioCurrent;
        setChanged();
        notifyObservers(USUARIO_CURRENT);        
    }

//======== USUARIOS ===========
    Usuario filtro;
    UsuarioTableModel usuariosModel;
    
    private void initUsuarios(){
        filtro = new Usuario();
        List<Usuario> rows = new ArrayList<Usuario>();
        setUsuarios(rows);
    }
    
    public void setUsuarios(List<Usuario> rows){
        int[] cols={UsuarioTableModel.CEDULA,UsuarioTableModel.TIPO};
        setUsuariosModel(new UsuarioTableModel(cols,rows));        
    }
    
    public Usuario getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Usuario filtro) {
        this.filtro = filtro;
    }
    
     public UsuarioTableModel getUsuariosModel() {
        return usuariosModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(USUARIO_CURRENT);
        setChanged();        
        notifyObservers(USUARIOS_MODEL);
    }
    
    public void setUsuariosModel(UsuarioTableModel usuariosModel) {
        this.usuariosModel = usuariosModel;
        setChanged();
        notifyObservers(USUARIOS_MODEL);
    }
    
    public static Integer USUARIO_CURRENT=1;
    public static Integer USUARIOS_MODEL=2;
}

