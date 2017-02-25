/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author Estudiante
 */
public class PlanEstudio {
    private String Titulo;
    private ArrayList<Curso> Cursos;
    private Carrera Carrera;

    public PlanEstudio(String titulo, ArrayList<Curso> cursos, Carrera carrera) {
        this.Titulo = titulo;
        this.Cursos = cursos;
        this.Carrera = carrera;
    }

    public PlanEstudio() {
        this.Titulo= "";
        this.Cursos= new ArrayList<Curso>();
        this.Carrera= new Carrera();
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public List<Curso> getCursos() {
        return Cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.Cursos = cursos;
    }

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.Carrera = carrera;
    }
    
    
    
}
