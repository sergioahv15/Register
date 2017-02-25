/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Application;
import Register.Entities.Curso;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Estudiante
 */
public class CursoModel extends java.util.Observable{
    public CursoModel() {
        initCurso();
        initCursos();
    }

//======= PERSONA ============    
    Curso cursoCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initCurso(){
        setCursoCurrent(new Curso());
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
    public Curso getCursoCurrent() {
        return cursoCurrent;
    }

    public void setCursoCurrent(Curso cursoCurrent) {
        this.cursoCurrent = cursoCurrent;
        setChanged();
        notifyObservers(PERSONA_CURRENT);        
    }

//======== PERSONAS ===========
    Curso filtro;
    CursoTableModel cursosModel;
    
    private void initCursos(){
        filtro = new Curso();
        List<Curso> rows = new ArrayList<Curso>();
        setCursos(rows);
    }
    
    public void setCursos(List<Curso> rows){
        //int[] cols={CursoTableModel.ID,CursoTableModel.NOMBRE,CursoTableModel.SEXO,CursoTableModel.PASATIEMPO_CINE,CursoTableModel.ESTADO_CIVIL};
        //setCursosModel(new CursoTableModel(cols,rows));        
    }
    
    public Curso getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Curso filtro) {
        this.filtro = filtro;
    }
    
     public CursoTableModel getCursosModel() {
        return cursosModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(PERSONA_CURRENT);
        setChanged();        
        notifyObservers(PERSONAS_MODEL);
    }
    
    public void setCursosModel(CursoTableModel cursosModel) {
        this.cursosModel = cursosModel;
        setChanged();
        notifyObservers(PERSONAS_MODEL);
    }
    
    public static Integer PERSONA_CURRENT=1;
    public static Integer PERSONAS_MODEL=2;
}
