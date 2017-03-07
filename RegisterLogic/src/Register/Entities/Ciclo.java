/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Fabio
 */
public class Ciclo {
    
    private int Numero;
    private int Anyo;
    private String FechaInicio;
    private String FechaFin;
    private boolean Activo;
    private ArrayList<Curso> Cursos;
    
    
    public Ciclo() {
        Numero= 0;
        Anyo=1999;
        Activo = false;
        FechaInicio= "";
        FechaFin= "";
        Cursos = new ArrayList<Curso>();
    }

    public Ciclo(int numero, int anyo, String fechaInicio, String fechaFin,ArrayList<Curso> c, boolean a) {
        this.Numero = numero;
        this.Anyo = anyo;
        this.FechaInicio = fechaInicio;
        this.FechaFin = fechaFin;
        this.Cursos= c;
        this.Activo=a;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    
    
    public ArrayList<Curso> getCursos() {
        return Cursos;
    }

    public void setCursos(ArrayList<Curso> Cursos) {
        this.Cursos = Cursos;
    }
    
    

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        this.Numero = numero;
    }

    public int getAnyo() {
        return Anyo;
    }

    public void setAnyo(int anyo) {
        this.Anyo = anyo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.FechaFin = fechaFin;
    }
    
    @Override
    public String toString() {
        return "Ciclo{" + "numero=" + Numero + ", anyo=" + Anyo + ", fechaInicio=" + FechaInicio + ", fechaFin=" + FechaFin + '}';
    }

    public void getNumero(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
