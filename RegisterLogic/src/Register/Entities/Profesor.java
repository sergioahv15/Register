/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herrera
 */
public class Profesor extends Usuario {
    
    private String Nombre;
    private int Tel;
    private String Email;
    private ArrayList<Grupo> Grupos;

    public Profesor(String Nombre, int Tel, String Email,ArrayList<Grupo> grupos, String clave, int cedula) {
        super(clave, cedula, 1);
        this.Nombre = Nombre;
        this.Tel = Tel;
        this.Email = Email;
        this.Grupos = grupos;
    }

    public Profesor() {
        super("",1,1);
        this.Nombre="";
        this.Email="";
        this.Tel=00000000;
        this.Grupos= new ArrayList<Grupo>() {};
    }

    public ArrayList<Grupo> getGrupos() {
        return Grupos;
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
    
    
}
