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
    private Date FechaInicio;
    private Date FechaFin;
    private ArrayList<Curso> Cursos;
    
    
    public Ciclo() {
        Numero= 0;
        Anyo=1999;
        FechaInicio= new Date();
        FechaFin= new Date();
        Cursos = new ArrayList<Curso>();
    }

    public Ciclo(int numero, int anyo, Date fechaInicio, Date fechaFin,ArrayList<Curso> c) {
        this.Numero = numero;
        this.Anyo = anyo;
        this.FechaInicio = fechaInicio;
        this.FechaFin = fechaFin;
        this.Cursos= c;
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

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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
