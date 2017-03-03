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

/**
 *
 * @author sergio
 */
public class Historial {
   
    private Estudiante Estudiante;
    private ArrayList<Curso> Historial;

    public Historial(Estudiante Estudiante, ArrayList<Curso> Historial) {
        this.Estudiante = Estudiante;
        this.Historial = Historial;
    }

    public Historial() {
         Estudiante= new Estudiante();
        Historial = new ArrayList<Curso>();
    }

    public Estudiante getEstudiante() {
        return Estudiante;
    }

    public void setEstudiante(Estudiante Estudiante) {
        this.Estudiante = Estudiante;
    }

    /*public ArrayList<Curso> getHistorial() {
        if(Historial.isEmpty()){
            Curso c = new Curso();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from historial h where h.curso like %d";
                SQL= String.format(SQL,c.getHistorial().getEstudiante().getCedula());
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Historial.add(curso(rs));
                }}
                catch(SQLException ex){}
        }
        return Historial;
    }*/

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
        c.setFechaInicio(rs.getDate("fecha_inicio"));
        c.setFechaFin(rs.getDate("fecha_fin"));
        return c;
    }
    
    public void setHistorial(ArrayList<Curso> Historial) {
        this.Historial = Historial;
    }
    
    
    
}
