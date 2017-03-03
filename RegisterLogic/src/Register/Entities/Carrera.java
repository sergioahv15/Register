/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;

/**
 *
 * @author Herrera
 */
public class Carrera {
    private String Codigo;
    private String Nombre;
    private String Titulo;
    private ArrayList<Curso> Cursos;

    public Carrera(String Codigo, String Nombre,String titulo, ArrayList<Curso> c) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Titulo=titulo;
        this.Cursos=c;
    }
    
    public Carrera(String Codigo, String Nombre) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    public Carrera() {
        this.Codigo="00000";
        this.Nombre="";
        this.Titulo="";
        this.Cursos= new ArrayList<>();
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public ArrayList<Curso> getCursos() {
        return Cursos;
    }

    public void setCursos(ArrayList<Curso> Cursos) {
        this.Cursos = Cursos;
    }
    
    
    
}
