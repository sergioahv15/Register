/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Ciclo;
import Register.Entities.Ciclo;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class CicloModel extends java.util.Observable{
    public CicloModel() {
        initCiclo();
        initCiclos();
    }

//======= CICLO ============    
    Ciclo cicloCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initCiclo(){
        setCicloCurrent(new Ciclo());
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
    public Ciclo getCicloCurrent() {
        return cicloCurrent;
    }

    public void setCicloCurrent(Ciclo cicloCurrent) {
        this.cicloCurrent = cicloCurrent;
        setChanged();
        notifyObservers(CICLO_CURRENT);        
    }
    
//======== CICLOS ===========
    Ciclo filtro;
    CicloTableModel ciclosModel;
    
    private void initCiclos(){
        filtro = new Ciclo();
        List<Ciclo> rows = new ArrayList<Ciclo>();
        setCiclos(rows);
    }
    
    public void setCiclos(List<Ciclo> rows){
        int[] cols={CicloTableModel.NUMERO,CicloTableModel.ANYO,CicloTableModel.FECHA_INICIO,CicloTableModel.FECHA_FIN,CicloTableModel.ACTIVO};
        setCiclosModel(new CicloTableModel(cols,rows));        
    }
    
    public Ciclo getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Ciclo filtro) {
        this.filtro = filtro;
    }
    
     public CicloTableModel getCiclosModel() {
        return ciclosModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(CICLO_CURRENT);
        setChanged();        
        notifyObservers(CICLOS_MODEL);
    }
    
    public void setCiclosModel(CicloTableModel ciclosModel) {
        this.ciclosModel = ciclosModel;
        setChanged();
        notifyObservers(CICLOS_MODEL);
    }
    
    public static Integer CICLO_CURRENT=1;
    public static Integer CICLOS_MODEL=2;
}


