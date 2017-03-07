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
    private String FechaNac;
    Carrera Carrera;

  

    public Estudiante(String nombre, int tel, String email, String fechaNac,Carrera c,
            String clave, int cedula) {
        super(clave, cedula, 2);
        this.Nombre = nombre;
        this.Tel = tel;
        this.Email = email;
        this.FechaNac = fechaNac;
        this.Carrera= c;
        
    }

    public Estudiante() {
        super("",0,2);
        this.Nombre="";
        this.Tel=0;
        this.Email="";
        this.FechaNac= "";
        this.Carrera= new Carrera();
        
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
