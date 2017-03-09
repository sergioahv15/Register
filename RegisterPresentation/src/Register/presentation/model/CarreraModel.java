/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Carrera;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class CarreraModel extends java.util.Observable{
    public CarreraModel() {
        initCarrera();
        initCarreras();
    }

//======= CARRERA ============    
    Carrera carreraCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initCarrera(){
        setCarreraCurrent(new Carrera());
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
    public Carrera getCarreraCurrent() {
        return carreraCurrent;
    }

    public void setCarreraCurrent(Carrera carreraCurrent) {
        this.carreraCurrent = carreraCurrent;
        setChanged();
        notifyObservers(CARRERA_CURRENT);        
    }

//======== CARRERAS ===========
    Carrera filtro;
    CarreraTableModel carrerasModel;
    
    private void initCarreras(){
        filtro = new Carrera();
        List<Carrera> rows = new ArrayList<Carrera>();
        setCarreras(rows);
    }
    
    public void setCarreras(List<Carrera> rows){
        int[] cols={CarreraTableModel.CODIGO,CarreraTableModel.NOMBRE,CarreraTableModel.TITULO};
        setCarrerasModel(new CarreraTableModel(cols,rows));        
    }
    
    public Carrera getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Carrera filtro) {
        this.filtro = filtro;
    }
    
     public CarreraTableModel getCarrerasModel() {
        return carrerasModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(CARRERA_CURRENT);
        setChanged();        
        notifyObservers(CARRERAS_MODEL);
    }
    
    public void setCarrerasModel(CarreraTableModel carrerasModel) {
        this.carrerasModel = carrerasModel;
        setChanged();
        notifyObservers(CARRERAS_MODEL);
    }
    
    public static Integer CARRERA_CURRENT=1;
    public static Integer CARRERAS_MODEL=2;
}

