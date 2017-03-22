/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class HistorialModel extends java.util.Observable{
    public HistorialModel() {
        initHistorial();
        initHistoriales();
    }

//======= HISTORIAL ============    
    String historialCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initHistorial(){
        setHistorialCurrent(new String());
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
    public String getHistorialCurrent() {
        return historialCurrent;
    }

    public void setHistorialCurrent(String historialCurrent) {
        this.historialCurrent = historialCurrent;
        setChanged();
        notifyObservers(HISTORIAL_CURRENT);        
    }

//======== HISTORIALS ===========
    String filtro;
    HistorialTableModel historialesModel;
    
    private void initHistoriales(){
        filtro = new String();
        List<String> rows = new ArrayList<String>();
        setHistoriales(rows);
    }
    
    public void setHistoriales(List<String> rows){
        int[] cols={HistorialTableModel.CURSO,HistorialTableModel.NOTA};
        setHistorialesModel(new HistorialTableModel(cols,rows));        
    }
    
    public String getFiltro() {
        return filtro;
    }
    
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
     public HistorialTableModel getHistorialesModel() {
        return historialesModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(HISTORIAL_CURRENT);
        setChanged();        
        notifyObservers(HISTORIALES_MODEL);
    }
    
    public void setHistorialesModel(HistorialTableModel historialesModel) {
        this.historialesModel = historialesModel;
        setChanged();
        notifyObservers(HISTORIALES_MODEL);
    }
    
    public static Integer HISTORIAL_CURRENT=1;
    public static Integer HISTORIALES_MODEL=2;
}


