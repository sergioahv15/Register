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
public class Curso {
    
    private String Codigo;
    private String Nombre;
    private int Creditos;
    private int HorasSemanales;
    private Carrera Carrera;
    private ArrayList<Grupo> Grupos;
    Ciclo Ciclo;

    public Curso() {
        Carrera= new Carrera();
        Grupos = new ArrayList<>();
        Ciclo= new Ciclo();
    }

    public Curso(String codigo, String nombre, int creditos, int horasSemanales, Carrera c,ArrayList<Grupo> g,
            Ciclo ci) {
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Creditos = creditos;
        this.HorasSemanales = horasSemanales;
        this.Carrera=c;
        this.Grupos=g;
        this.Ciclo=ci;
    }

    public Ciclo getCiclo() {
        return Ciclo;
    }

    public void setCiclo(Ciclo Ciclo) {
        this.Ciclo = Ciclo;
    }
    
    

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.Carrera = carrera;
    }

    
    
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int creditos) {
        this.Creditos = creditos;
    }

    public int getHorasSemanales() {
        return HorasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.HorasSemanales = horasSemanales;
    }

    public ArrayList<Grupo> getGrupos() {
        return Grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.Grupos = grupos;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + Codigo + ", nombre=" + Nombre + ", creditos=" + Creditos + ", horasSemanales=" + HorasSemanales + '}';
    }
    
    
}
