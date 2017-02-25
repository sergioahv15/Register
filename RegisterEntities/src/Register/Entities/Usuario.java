/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.io.Serializable;

/**
 *
 * @author Herrera
 */
public abstract class Usuario implements Serializable{
    protected String Clave;
    protected int Cedula;
    protected int Tipo;

    public Usuario(String clave, int cedula, int tipo) {
        this.Clave = clave;
        this.Cedula = cedula;
        this.Tipo = tipo;
    }

    public Usuario() {
        this.Clave="";
        this.Cedula=0;
        this.Tipo= 0;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String nombre) {
        this.Clave = nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        this.Cedula = cedula;
    }

   /* public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        this.Tipo = tipo;
    }*/
    
    
    
}
