/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

/**
 *
 * @author sergio
 */
public class Nota {
    
    int Nota;
    Estudiante Estudiante;
    Grupo Grupo;

    public Nota(int nota, Estudiante estudiante, Grupo grupo) {
        this.Nota = nota;
        this.Estudiante = estudiante;
        this.Grupo = grupo;
    }

    public Nota() {
        Grupo = new Grupo();
        Estudiante = new Estudiante();
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int nota) {
        this.Nota = nota;
    }

    public Estudiante getEstudiante() {
        return Estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.Estudiante = estudiante;
    }

    public Grupo getGrupo() {
        return Grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.Grupo = grupo;
    }
    
    
    
}
