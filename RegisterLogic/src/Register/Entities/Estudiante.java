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
    
    private String nombre;
    private int tel;
    private String email;
    private Date fechaNac;
    Carrera carrera;
    Historial historial;
    
  

    public Estudiante(String nombre, int tel, String email, Date fechaNac,Carrera c,Historial h,
            String clave, int cedula) {
        super(clave, cedula, 2);
        this.nombre = nombre;
        this.tel = tel;
        this.email = email;
        this.fechaNac = fechaNac;
        this.carrera= c;
        this.historial= h;
    }

    public Estudiante() {        
        super();
        this.nombre="";
        this.tel=0;
        this.email="";
        this.fechaNac= new Date();
        this.carrera= null;
        this.historial= null;        
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial Historial) {
        this.historial = Historial;
    }    

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera Carrera) {
        this.carrera = Carrera;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
}
