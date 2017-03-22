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
public class Grupo implements Serializable{
    
    private int NumeroGrupo;
    private Profesor Profesor;
    private ArrayList<Estudiante> Estudiantes;
    private ArrayList<String> Notas;
    Curso Curso;
    private boolean Lunes;
    private boolean Martes;
    private boolean Miercoles;
    private boolean Jueves;
    private boolean Viernes;
    private String HoraInicio;
    private String HoraFin;

    public Grupo() {
        Profesor = new Profesor();
        Estudiantes= new ArrayList<>();
        Notas = new ArrayList<>();
        Curso = new Curso();
        this.Lunes=false;
        this.Martes=false;
        this.Miercoles=false;
        this.Jueves=false;
        this.Viernes=false;
        this.HoraInicio="";
        this.HoraFin= "";    
        this.NumeroGrupo=0;
    }

    public Grupo( Profesor Profesor, ArrayList<Estudiante> Estudiantes, ArrayList<String> Notas,Curso c) {
        this.Profesor = Profesor;
        this.Estudiantes = Estudiantes;
        this.Notas = Notas;
        this.Curso=c;
    }
    
    public Grupo( boolean l,boolean m, boolean k,boolean j,boolean v, String horaIni,String horaFin) {
        this.Lunes=l;
        this.Martes=m;
        this.Miercoles=k;
        this.Jueves=j;
        this.Viernes=v;
        this.HoraInicio=horaIni;
        this.HoraFin=horaFin;        
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

    public ArrayList<String> pullNotas() {
        if(Notas.isEmpty()){
            DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from nota n where n.numero_grupo like %d";   //REVISAR ESTO!!!
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
        String ced=rs.getString("ced");
        String nota=rs.getString("nota");
        if(nota.equals("-1")) rubro=ced+" Sin Asignar";
        else rubro="Cedula: " + ced+" Nota: "+nota;
        return rubro;
    }
    

    public void setNotas(ArrayList<String> Notas) {
        this.Notas = Notas;
    }
    
    public ArrayList<String> getNotas(){
        return this.Notas;
    }

    public boolean isLunes() {
        return Lunes;
    }

    public void setLunes(boolean Lunes) {
        this.Lunes = Lunes;
    }

    public boolean isMartes() {
        return Martes;
    }

    public void setMartes(boolean Martes) {
        this.Martes = Martes;
    }

    public boolean isMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(boolean Miercoles) {
        this.Miercoles = Miercoles;
    }

    public boolean isJueves() {
        return Jueves;
    }

    public void setJueves(boolean Jueves) {
        this.Jueves = Jueves;
    }

    public boolean isViernes() {
        return Viernes;
    }

    public void setViernes(boolean Viernes) {
        this.Viernes = Viernes;
    }
    
    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.HoraInicio = horaInicio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String horaFin) {
        this.HoraFin = horaFin;
    }
    
    public String getHorario(){
        String horario = "";
        if(Lunes) horario += "Lunes - ";
        if(Martes) horario += "Martes - ";
        if(Miercoles) horario += "Miercoles - ";
        if(Jueves) horario += "Jueves - ";
        if(Viernes) horario += "Viernes - ";
        horario += "de " + HoraInicio;        
        horario += " a " + HoraFin;
        return horario;
    }
    
    @Override
    public String toString() {
        String dias= Lunes? "L,":"" ;
        dias += Martes? "M,":"" ;
        dias += Miercoles? "K,":"" ;
        dias += Jueves? "J,":"" ;
        dias += Viernes? "V":"" ;
        
        return "Grupo{" + "Numero=" + NumeroGrupo + ",Profesor=" + Profesor.getNombre() + ",Curso=" + Curso.getNombre() + "\n"+
               "El curso se impartira los dias:"+ dias + " de " + HoraInicio + " a " + HoraFin +'}';
    }
}



