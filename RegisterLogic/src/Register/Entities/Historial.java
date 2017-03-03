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

   /* public ArrayList<Curso> getHistorial() {
        if(Historial.isEmpty()){
            Curso c = new Curso();
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from historial c where c.grupo like '%%%s%%'";
                SQL= String.format(SQL,g.getCurso().getCodigo());
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Grupos.add(grupo(rs));
                }}
                catch(SQLException ex){}
        }
        return Historial;
    }*/

    public void setHistorial(ArrayList<Curso> Historial) {
        this.Historial = Historial;
    }
    
    
    
}
