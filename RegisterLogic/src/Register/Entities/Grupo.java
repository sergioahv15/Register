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
 * @author Fabio
 */
public class Grupo {
    
    private int NumeroGrupo;
    private Profesor Profesor;
    private ArrayList<Estudiante> Estudiantes;
    private ArrayList<String> Notas;
    Horario Horario;
    Curso Curso;

    public Grupo() {
        Profesor = new Profesor();
        Estudiantes= new ArrayList<>();
        Notas = new ArrayList<>();
        Horario = new Horario();
        Curso = new Curso();
    }

    public Grupo(int NumeroGrupo, Profesor Profesor, ArrayList<Estudiante> Estudiantes, ArrayList<String> Notas,
            Horario Horario,Curso c) {
        this.NumeroGrupo = NumeroGrupo;
        this.Profesor = Profesor;
        this.Estudiantes = Estudiantes;
        this.Notas = Notas;
        this.Horario = Horario;
        this.Curso=c;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    
    
    public int getNumeroGrupo() {
        return NumeroGrupo;
    }

    public void setNumeroGrupo(int NumeroGrupo) {
        this.NumeroGrupo = NumeroGrupo;
    }

    public Profesor getProfesor() {
        return Profesor;
    }

    public void setProfesor(Profesor Profesor) {
        this.Profesor = Profesor;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        if(Estudiantes.isEmpty()){
            
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from matriculado m where m.grupo_numero_grupo like %d";   //REVISAR ESTO!!!
                SQL= String.format(SQL,this.NumeroGrupo);
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Estudiantes.add(estudiante(rs));
                }}
                catch(SQLException ex){}
        }
        return Estudiantes;
    }

    private Estudiante estudiante(ResultSet rs) throws SQLException{
            Estudiante e = new Estudiante();
        e.setNombre(rs.getString("nombre"));
        e.setClave(rs.getString("clave"));
        e.setCedula(rs.getInt("cedula"));
        e.setEmail(rs.getString("email"));
        e.setTel(rs.getInt("tel"));
        e.setFechaNac(rs.getString("fecha_nac"));
        e.setCarrera(carrera(rs));
       // e.setHistorial(historial(rs));
        return e;
    }
    
    private Historial historial(ResultSet rs) throws SQLException{
        Historial h = new Historial();
        h.setEstudiante(estudiante(rs));
        return h;
    }
    
    private Carrera carrera(ResultSet rs) throws SQLException{
        Carrera c = new Carrera();
        c.setTitulo(rs.getString("titulo"));
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }
    
    public void setEstudiantes(ArrayList<Estudiante> Estudiantes) {
        this.Estudiantes = Estudiantes;
    }

    public ArrayList<String> getNotas() {
        if(Notas.isEmpty()){
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from nota n where n.grupo like %d";   //REVISAR ESTO!!!
                SQL= String.format(SQL,this.NumeroGrupo);
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Notas.add(nota(rs));
                }}
                catch(SQLException ex){}
        }
        return Notas;
    }
    
    private String nota(ResultSet rs) throws SQLException{
        String rubro;
        String ced=rs.getString("cedula");
        String nota=rs.getString("nota");
        rubro=ced+" "+nota;
        return rubro;
    }
    

    public void setNotas(ArrayList<String> Notas) {
        this.Notas = Notas;
    }

    public Horario getHorario() {
        return Horario;
    }

    public void setHorario(Horario Horario) {
        this.Horario = Horario;
    }
    
    
   

    

    @Override
    public String toString() {
        return "Grupo{" + "numeroGrupo=" + NumeroGrupo + '}';
    }
    
    
}
