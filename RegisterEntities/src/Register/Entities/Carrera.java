/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

/**
 *
 * @author Herrera
 */
public class Carrera {
    private String Codigo;
    private String Nombre;
    private PlanEstudio Plan;

    public Carrera(String Codigo, String Nombre, PlanEstudio plan) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Plan = plan;
    }
    
    public Carrera(String Codigo, String Nombre) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    public Carrera() {
        this.Codigo="00000";
        this.Nombre="";
        this.Plan= new PlanEstudio();
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public PlanEstudio getPlan() {
        return Plan;
    }

    public void setPlan(PlanEstudio plan) {
        this.Plan = plan;
    }
    
    
}
