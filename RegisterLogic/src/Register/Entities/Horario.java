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
    
    private ArrayList<String> Dias;
    private String HoraInicio;
    private String HoraFin;

    public Horario() {
        Dias = new ArrayList<>();
    }

    public Horario(ArrayList<String> dias, String horaInicio, String horaFin) {
        this.Dias = dias;
        this.HoraInicio = horaInicio;
        this.HoraFin = horaFin;
    }

    public ArrayList<String> getDias() {        
        return Dias;
    }

    public void setDias(ArrayList<String> dias) {
        this.Dias = dias;
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

    public String printDias(){
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
    }
    
    
}
