/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Curso;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class OfertaModel extends java.util.Observable{
    public OfertaModel() {
        initCurso();
        initCursos();
    }

//======= OFERTA ============    
    Curso ofertaCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initCurso(){
        setOfertaCurrent(new Curso());
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
    public Curso getOfertaCurrent() {
        return ofertaCurrent;
    }

    public void setOfertaCurrent(Curso ofertaCurrent) {
        this.ofertaCurrent = ofertaCurrent;
        setChanged();
        notifyObservers(OFERTA_CURRENT);        
    }

//======== OFERTAS ===========
    Curso filtro;
    CursoTableModel ofertasModel;
   
    private void initCursos(){
        filtro = new Curso();
        List<Curso> rows = new ArrayList<Curso>();
        setCursos(rows);
    }
    
    public void setCursos(List<Curso> rows){
        int[] cols={CursoTableModel.CODIGO,CursoTableModel.NOMBRE,CursoTableModel.CARRERA,CursoTableModel.CREDITOS,CursoTableModel.HORAS_SEMANALES};
        setCursosModel(new CursoTableModel(cols,rows));        
    }
    
    public Curso getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Curso filtro) {
        this.filtro = filtro;
    }
    
     public CursoTableModel getOfertaModel() {
        return ofertasModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(OFERTA_CURRENT);
        setChanged();        
        notifyObservers(OFERTAS_MODEL);
    }
    
    public void setCursosModel(CursoTableModel ofertasModel) {
        this.ofertasModel = ofertasModel;
        setChanged();
        notifyObservers(OFERTAS_MODEL);
    }
    
    public static Integer OFERTA_CURRENT=1;
    public static Integer OFERTAS_MODEL=2;
}
