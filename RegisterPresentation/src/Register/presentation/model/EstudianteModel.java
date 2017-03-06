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
public class EstudianteModel extends java.util.Observable{
    public EstudianteModel() {
        initEstudiante();
        initEstudiantes();
    }

//======= ESTUDIANTE ============    
    Estudiante estudianteCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initEstudiante(){
        setEstudianteCurrent(new Estudiante());
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
    public Estudiante getEstudianteCurrent() {
        return estudianteCurrent;
    }

    public void setEstudianteCurrent(Estudiante estudianteCurrent) {
        this.estudianteCurrent = estudianteCurrent;
        setChanged();
        notifyObservers(ESTUDIANTE_CURRENT);        
    }

//======== ESTUDIANTEES ===========
    Estudiante filtro;
    EstudianteTableModel estudiantesModel;
    
    private void initEstudiantes(){
        filtro = new Estudiante();
        List<Estudiante> rows = new ArrayList<Estudiante>();
        setEstudiantes(rows);
    }
    
    public void setEstudiantes(List<Estudiante> rows){
        int[] cols={EstudianteTableModel.NOMBRE,EstudianteTableModel.CEDULA,EstudianteTableModel.TELEFONO,EstudianteTableModel.EMAIL,EstudianteTableModel.FECHA_NAC,EstudianteTableModel.CARRERA};
        setEstudiantesModel(new EstudianteTableModel(cols,rows));        
    }
    
    public Estudiante getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Estudiante filtro) {
        this.filtro = filtro;
    }
    
     public EstudianteTableModel getEstudiantesModel() {
        return estudiantesModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(ESTUDIANTE_CURRENT);
        setChanged();        
        notifyObservers(ESTUDIANTES_MODEL);
    }
    
    public void setEstudiantesModel(EstudianteTableModel estudiantesModel) {
        this.estudiantesModel = estudiantesModel;
        setChanged();
        notifyObservers(ESTUDIANTES_MODEL);
    }
    
    public static Integer ESTUDIANTE_CURRENT=1;
    public static Integer ESTUDIANTES_MODEL=2;
}

