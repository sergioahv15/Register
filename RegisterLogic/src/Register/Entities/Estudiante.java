/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

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
    private Date FechaNac;
    Carrera Carrera;
    Historial Historial;
  

    public Estudiante(String nombre, int tel, String email, Date fechaNac,Carrera c,Historial h,
            String clave, int cedula) {
        super(clave, cedula, 2);
        this.Nombre = nombre;
        this.Tel = tel;
        this.Email = email;
        this.FechaNac = fechaNac;
        this.Carrera= c;
        this.Historial= h;
    }

    public Estudiante() {
        super("",2,2);
        this.Nombre="";
        this.Tel=0;
        this.Email="";
        this.FechaNac= new java.sql.Date(1900,01,01);
        this.Carrera= new Carrera();
        this.Historial= new Historial();
    }

    public Historial getHistorial() {
        return Historial;
    }

    public void setHistorial(Historial Historial) {
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

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.FechaNac = fechaNac;
    }
    
    
    
    
}
