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
 * @author Fabio
 */
public class Curso implements Serializable{
    
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
        this.Codigo = "";
        this.Nombre = "";
        this.Creditos = 0;
        this.HorasSemanales = 0;        
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

    public Curso(String codigo, String nombre, int creditos, int horasSemanales) {
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Creditos = creditos;
        this.HorasSemanales = horasSemanales;
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

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
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
       if(Grupos.isEmpty()){
            Grupo g = new Grupo();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from grupo g where g.curso like '%%%s%%'";
                SQL= String.format(SQL,g.getCurso().getCodigo());
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Grupos.add(grupo(rs));
                }}
                catch(SQLException ex){}
            }
            
        return Grupos;
    }
    

    private Grupo grupo(ResultSet rs) throws SQLException{
        Grupo g = new Grupo();
        g.setNumeroGrupo(rs.getInt("numero_grupo"));
        g.setProfesor(profesor(rs));
        g.setCurso(this);
        return g;
        
}
    
    private Profesor profesor(ResultSet rs) throws SQLException{
        Profesor p = new Profesor();
        p.setCedula(rs.getShort("cedula"));
        p.setClave(rs.getString("clave"));
        p.setNombre(rs.getString("nombre"));
        p.setTel(rs.getInt("tel"));
        p.setEmail(rs.getString("email"));
        return p;
    }
    
    

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.Grupos = grupos;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + Codigo + ", nombre=" + Nombre + ", creditos=" + Creditos + ", horasSemanales=" + HorasSemanales + '}';
    }
    
    
}
