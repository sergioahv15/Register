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
    private ArrayList<Nota> Notas;
    Horario Horario;
    Curso Curso;

    public Grupo() {
        Profesor = new Profesor();
        Estudiantes= new ArrayList<>();
        Notas = new ArrayList<>();
        Horario = new Horario();
        Curso = new Curso();
    }

    public Grupo(int NumeroGrupo, Profesor Profesor, ArrayList<Estudiante> Estudiantes, ArrayList<Nota> Notas,
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
           /* Estudiante e = new Estudiante();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from estudiante e where e.curso like '%%%s%%'";
                SQL= String.format(SQL,g.getCurso().getCodigo());
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Grupos.add(grupo(rs));
                }}
                catch(SQLException ex){}*/
        }
        return Estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> Estudiantes) {
        this.Estudiantes = Estudiantes;
    }

    public ArrayList<Nota> getNotas() {
        return Notas;
    }
    
    
    /*private Nota nota(ResultSet rs) throws SQLException{
        Nota n = new Nota();
        n.setNota(rs.getInt("nota"));
        n.setEstudiante(estudiante(rs));
        n.setGrupo(grupo(rs));
        return n;
    }*/

    public void setNotas(ArrayList<Nota> Notas) {
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
