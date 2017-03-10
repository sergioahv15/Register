/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import Register.logic.model.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;

/**
 *
 * @author Herrera
 */
public class Estudiante extends Usuario {
    

    private String Nombre;
    private int Tel;
    private String Email;
    private String FechaNac;
    Carrera Carrera;
    private ArrayList<Grupo> Historial;
  

    public Estudiante(String nombre, int tel, String email, String fechaNac,Carrera c,ArrayList<Grupo> historial,
            String clave, int cedula) {
        super(clave, cedula, 2);
        this.Nombre = nombre;
        this.Tel = tel;
        this.Email = email;
        this.FechaNac = fechaNac;
        this.Carrera= c;
        this.Historial=historial;
    }

    public Estudiante() {
        super("",0,2);
        this.Nombre="";
        this.Tel=0;
        this.Email="";
        this.FechaNac= "";
        this.Carrera= new Carrera();
        this.Historial= new ArrayList<>();
        
    }

    public ArrayList<Grupo> getHistorial() {
        if(Historial.isEmpty()){
            Grupo g = new Grupo();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from matriculado m where m.estudiante_cedula like %d";
                SQL= String.format(SQL,this.Cedula);
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Historial.add(grupo(rs));
                }}
                catch(SQLException ex){}
        }

        return Historial;
    }
    
    public Grupo grupo(ResultSet rs) throws SQLException{
        Grupo g = new Grupo();
        g.setNumeroGrupo(rs.getInt("numero_grupo"));
        g.setProfesor(profesor(rs));
        g.setHorario(horario(rs));
        g.setCurso(curso(rs));
        return g;
    }
    
    private Profesor profesor(ResultSet rs) throws SQLException{
        Profesor p = new Profesor();
        p.setNombre(rs.getString("nombre"));
        p.setClave(rs.getString("clave"));
        p.setCedula(rs.getInt("cedula"));
        p.setEmail(rs.getString("email"));
        p.setTel(rs.getInt("tel"));
        return p;
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
        int activo = rs.getInt("activo");
        if(activo==1)c.setActivo(true);
        else if(activo ==0)c.setActivo(false);
        return c;
    }

     private Horario horario(ResultSet rs) throws SQLException{
        Horario h = new Horario();
        h.setHoraFin(rs.getString("hora_fin"));
        h.setHoraInicio(rs.getString("hora_ ini"));
        return h;
    }
    
    public void setHistorial(ArrayList<Grupo> Historial) {
        this.Historial = Historial;
    }

    

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int tel) {
        this.Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }


    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.FechaNac = fechaNac;

   
  }
}
