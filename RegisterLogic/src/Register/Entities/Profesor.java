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
public class Profesor extends Usuario implements Serializable{
    
    private String Nombre;
    private int Tel;
    private String Email;
    private ArrayList<Grupo> Grupos;

    public Profesor(String Nombre, int Tel, String Email,ArrayList<Grupo> grupos, String clave, int cedula) {
        super(clave, cedula, "profesor");
        this.Nombre = Nombre;
        this.Tel = Tel;
        this.Email = Email;
        this.Grupos = grupos;
    }

    public Profesor() {
        super("",0,"profesor");
        this.Nombre="";
        this.Email="";
        this.Tel=00000000;
        this.Grupos= new ArrayList<Grupo>() {};
    }
    
    public Profesor(String Nombre, int Tel, String Email, String clave, int cedula, String tipo) {
        super(clave, cedula, tipo);
        this.Nombre = Nombre;
        this.Tel = Tel;
        this.Email = Email;
    }

    public ArrayList<Grupo> getGrupos() {
        if(Grupos.isEmpty()){
            Grupo g = new Grupo();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from grupo g where g.profesor like %d";
                SQL= String.format(SQL,g.getProfesor().getCedula());
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
        g.setProfesor(this);
        g.setCurso(curso(rs));
        return g;
        
    }
     
     private Curso curso(ResultSet rs) throws SQLException{
        Curso c = new Curso();
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        c.setCreditos(rs.getInt("creditos"));
        c.setHorasSemanales(rs.getInt("horas_semanales"));
        c.setCarrera(carrera(rs));
        c.setCiclo(ciclo(rs));
        return c;
    }
    
    private Carrera carrera(ResultSet rs) throws SQLException{
        Carrera c = new Carrera();
        c.setTitulo(rs.getString("titulo"));
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }
    
    private Ciclo ciclo(ResultSet rs) throws SQLException{
        Ciclo c = new Ciclo();
        c.setNumero(rs.getInt("numero"));
        c.setAnyo(rs.getInt("anyo"));
        c.setFechaInicio(rs.getString("fecha_inicio"));
        c.setFechaFin(rs.getString("fecha_fin"));
        return c;
    }
    
    public void setGrupos(ArrayList<Grupo> Grupos) {
        this.Grupos = Grupos;
    }

    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + Nombre + ", Cedula=" + Cedula  +", Tel=" + Tel + ", Email=" + Email + '}';
    }
    
    
}
