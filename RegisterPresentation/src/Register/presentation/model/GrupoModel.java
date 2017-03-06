/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Grupo;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class GrupoModel extends java.util.Observable{
    public GrupoModel() {
        initGrupo();
        initGrupos();
    }

//======= CURSO ============    
    Grupo grupoCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initGrupo(){
        setGrupoCurrent(new Grupo());
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
    public Grupo getGrupoCurrent() {
        return grupoCurrent;
    }

    public void setGrupoCurrent(Grupo grupoCurrent) {
        this.grupoCurrent = grupoCurrent;
        setChanged();
        notifyObservers(CURSO_CURRENT);        
    }

//======== CURSOS ===========
    Grupo filtro;
    GrupoTableModel gruposModel;
    
    private void initGrupos(){
        filtro = new Grupo();
        List<Grupo> rows = new ArrayList<Grupo>();
        setGrupos(rows);
    }
    
    public void setGrupos(List<Grupo> rows){
        //int[] cols={GrupoTableModel.ID,GrupoTableModel.NOMBRE,GrupoTableModel.SEXO,GrupoTableModel.PASATIEMPO_CINE,GrupoTableModel.ESTADO_CIVIL};
        //setGruposModel(new GrupoTableModel(cols,rows));        
    }
    
    public Grupo getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Grupo filtro) {
        this.filtro = filtro;
    }
    
     public GrupoTableModel getGruposModel() {
        return gruposModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(CURSO_CURRENT);
        setChanged();        
        notifyObservers(CURSOS_MODEL);
    }
    
    public void setGruposModel(GrupoTableModel gruposModel) {
        this.gruposModel = gruposModel;
        setChanged();
        notifyObservers(CURSOS_MODEL);
    }
    
    public static Integer CURSO_CURRENT=1;
    public static Integer CURSOS_MODEL=2;
}

