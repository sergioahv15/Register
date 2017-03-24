/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Estudiante;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class NotaModel extends java.util.Observable{
    public NotaModel() {
        initNota();
        initNotas();
    }

//======= NOTA ============    
    String notaCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initNota(){
        setNotaCurrent(new String());
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
    public String getNotaCurrent() {
        return notaCurrent;
    }

    public void setNotaCurrent(String notaCurrent) {
        this.notaCurrent = notaCurrent;
        setChanged();
        notifyObservers(NOTA_CURRENT);        
    }

//======== NOTAS ===========
    String filtro;
    NotaTableModel notasModel;
    
    private void initNotas(){
        filtro = new String();
        List<String> rows = new ArrayList<String>();
        setNotas(rows);
    }
    
    public void setNotas(List<String> rows){
        int[] cols={NotaTableModel.ESTUDIANTE,NotaTableModel.NOTA};
        setNotasModel(new NotaTableModel(cols,rows));        
    }
    
    public String getFiltro() {
        return filtro;
    }
    
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
     public NotaTableModel getNotasModel() {
        return notasModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(NOTA_CURRENT);
        setChanged();        
        notifyObservers(NOTAS_MODEL);
    }
    
    public void setNotasModel(NotaTableModel notasModel) {
        this.notasModel = notasModel;
        setChanged();
        notifyObservers(NOTAS_MODEL);
    }
    
    public static Integer NOTA_CURRENT=1;
    public static Integer NOTAS_MODEL=2;
}


