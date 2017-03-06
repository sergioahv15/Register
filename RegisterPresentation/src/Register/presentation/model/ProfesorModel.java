/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Profesor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class ProfesorModel extends java.util.Observable{
    public ProfesorModel() {
        initProfesor();
        initProfesores();
    }

//======= PROFESOR ============    
    Profesor profesorCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initProfesor(){
        setProfesorCurrent(new Profesor());
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
    public Profesor getProfesorCurrent() {
        return profesorCurrent;
    }

    public void setProfesorCurrent(Profesor profesorCurrent) {
        this.profesorCurrent = profesorCurrent;
        setChanged();
        notifyObservers(PROFESOR_CURRENT);        
    }

//======== PROFESORES ===========
    Profesor filtro;
    ProfesorTableModel profesoresModel;
    
    private void initProfesores(){
        filtro = new Profesor();
        List<Profesor> rows = new ArrayList<Profesor>();
        setProfesores(rows);
    }
    
    public void setProfesores(List<Profesor> rows){
        int[] cols={ProfesorTableModel.CEDULA,ProfesorTableModel.NOMBRE,ProfesorTableModel.TELEFONO,ProfesorTableModel.EMAIL};
        setProfesoresModel(new ProfesorTableModel(cols,rows));        
    }
    
    public Profesor getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Profesor filtro) {
        this.filtro = filtro;
    }
    
     public ProfesorTableModel getProfesoresModel() {
        return profesoresModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(PROFESOR_CURRENT);
        setChanged();        
        notifyObservers(PROFESORES_MODEL);
    }
    
    public void setProfesoresModel(ProfesorTableModel profesoresModel) {
        this.profesoresModel = profesoresModel;
        setChanged();
        notifyObservers(PROFESORES_MODEL);
    }
    
    public static Integer PROFESOR_CURRENT=1;
    public static Integer PROFESORES_MODEL=2;
}

