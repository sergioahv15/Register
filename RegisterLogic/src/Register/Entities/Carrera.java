/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import Register.logic.model.DataBase;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Herrera
 */
public class Carrera implements Serializable{
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
    
    public Carrera(String Codigo, String Nombre,String titulo) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Titulo=titulo;
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
        /*if(Cursos.isEmpty()){
            Curso c = new Curso();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from curso c where c.carrera_codigo like '%%%s%%'";
                SQL= String.format(SQL,c.getCarrera().getCodigo());
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Cursos.add(curso(rs));
                }}
                catch(SQLException ex){}
        }*/
        return Cursos;
    }
    
    /*private Curso curso(ResultSet rs) throws SQLException{
        Curso c = new Curso();
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        c.setCreditos(rs.getInt("creditos"));
        c.setHorasSemanales(rs.getInt("horas_semanales"));
        c.setCarrera(this);
        c.setCiclo(ciclo(rs));
        return c;
    }
    
    private Ciclo ciclo(ResultSet rs) throws SQLException{
        Ciclo c = new Ciclo();
        c.setNumero(rs.getInt("numero"));
        c.setAnyo(rs.getInt("anyo"));
        c.setFechaInicio(rs.getString("fecha_inicio"));
        c.setFechaFin(rs.getString("fecha_fin"));
        return c;
    }*/

    public void setCursos(ArrayList<Curso> Cursos) {
        this.Cursos = Cursos;
    }
    
     @Override
    public String toString() {
        return "Carrera{" + "Codigo=" + Codigo + ", Nombre=" + Nombre + ", Titulo=" + Titulo + '}';
                //this.getCursos().toString();
                
        
    }
    
}
