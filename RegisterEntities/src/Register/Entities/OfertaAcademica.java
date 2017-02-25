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
public class OfertaAcademica {
    ArrayList<Curso> Cursos; 
    Ciclo Ciclo;         //Ciclo que va a estar por default para todo el sistema

    public OfertaAcademica(ArrayList<Curso> Cursos, Ciclo Ciclo) {
        this.Cursos = Cursos;
        this.Ciclo = Ciclo;
    }

    public OfertaAcademica() {
    Ciclo = new Ciclo();
    Cursos= new ArrayList<>();
    }

    public ArrayList<Curso> getCursos() {
        return Cursos;
    }

    public void setCursos(ArrayList<Curso> Cursos) {
        this.Cursos = Cursos;
    }

    public Ciclo getCiclo() {
        return Ciclo;
    }

    public void setCiclo(Ciclo Ciclo) {
        this.Ciclo = Ciclo;
    }
    
    
    
}
