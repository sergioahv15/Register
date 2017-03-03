/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Historial {
    
    private ArrayList<Ciclo> Ciclos;
    private Estudiante Estudiante;
    private ArrayList<Curso> Historial;

    public Historial(ArrayList<Ciclo> ciclos, Estudiante Estudiante, ArrayList<Curso> Historial) {
        this.Ciclos = ciclos;
        this.Estudiante = Estudiante;
        this.Historial = Historial;
    }

    public Historial() {
        Ciclos = new ArrayList<Ciclo>();
        Estudiante= new Estudiante();
        Historial = new ArrayList<Curso>();
    }

    public ArrayList<Ciclo> getCiclo() {
        return Ciclos;
    }

    public void setCiclo(ArrayList<Ciclo> Ciclos) {
        this.Ciclos = Ciclos;
    }

    public Estudiante getEstudiante() {
        return Estudiante;
    }

    public void setEstudiante(Estudiante Estudiante) {
        this.Estudiante = Estudiante;
    }

    public ArrayList<Curso> getHistorial() {
        return Historial;
    }

    public void setHistorial(ArrayList<Curso> Historial) {
        this.Historial = Historial;
    }
    
    
    
}
