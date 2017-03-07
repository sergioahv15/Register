/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.Entities;

import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class Horario {
    
    private boolean Lunes;
    private boolean Martes;
    private boolean Miercoles;
    private boolean Jueves;
    private boolean Viernes;
    private String HoraInicio;
    private String HoraFin;

    public Horario() {
        this.Lunes=false;
        this.Martes=false;
        this.Miercoles=false;
        this.Jueves=false;
        this.Viernes=false;
        this.HoraInicio="";
        this.HoraFin= "";
                
    }

    public Horario(boolean l,boolean m,boolean k,boolean j,boolean v, String horaInicio, String horaFin) {
        this.Lunes=l;
        this.Martes=m;
        this.Miercoles=k;
        this.Jueves=j;
        this.Viernes=v;
        this.HoraInicio = horaInicio;
        this.HoraFin = horaFin;
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

    /*public String printDias(){
        String dias = "";
        for(int i=0;i<Dias.size();i++){
            if(Dias.size()>1 && i > 0){
                dias += " y " + Dias.get(i);
            }
            dias += Dias.get(i);
        }
        return dias;
    }
    
    @Override
    public String toString() {
        return "Horario: " + printDias() + "de " + HoraInicio + " a " + HoraFin;
    }*/
    
    
}
