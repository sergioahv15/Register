/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class Grupo {
    
    private int NumeroGrupo;
    private Profesor Profesor;
    private ArrayList<Estudiante> Estudiantes;
    private ArrayList<Nota> Notas;
    Horario Horario;

    public Grupo() {
        Profesor = new Profesor();
        Estudiantes= new ArrayList<>();
        Notas = new ArrayList<>();
        Horario = new Horario();
    }

    public Grupo(int NumeroGrupo, Profesor Profesor, ArrayList<Estudiante> Estudiantes, ArrayList<Nota> Notas, Horario Horario) {
        this.NumeroGrupo = NumeroGrupo;
        this.Profesor = Profesor;
        this.Estudiantes = Estudiantes;
        this.Notas = Notas;
        this.Horario = Horario;
    }

    public int getNumeroGrupo() {
        return NumeroGrupo;
    }

    public void setNumeroGrupo(int NumeroGrupo) {
        this.NumeroGrupo = NumeroGrupo;
    }

    public Profesor getProfesor() {
        return Profesor;
    }

    public void setProfesor(Profesor Profesor) {
        this.Profesor = Profesor;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return Estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> Estudiantes) {
        this.Estudiantes = Estudiantes;
    }

    public ArrayList<Nota> getNotas() {
        return Notas;
    }

    public void setNotas(ArrayList<Nota> Notas) {
        this.Notas = Notas;
    }

    public Horario getHorario() {
        return Horario;
    }

    public void setHorario(Horario Horario) {
        this.Horario = Horario;
    }

    

    @Override
    public String toString() {
        return "Grupo{" + "numeroGrupo=" + NumeroGrupo + '}';
    }
    
    
}
