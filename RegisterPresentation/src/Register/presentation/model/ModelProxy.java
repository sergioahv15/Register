/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.IModel;
import Register.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Fabio
 */
public class ModelProxy implements IModel{
    ObjectInputStream in;
    ObjectOutputStream out;

    public ModelProxy() {
        try{
            Socket skt = new Socket(Protocol.SERVER,Protocol.PORT);
            out = new ObjectOutputStream(skt.getOutputStream() );
            out.flush();
            in = new ObjectInputStream(skt.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
            System.exit(-1);
        }        
    }    
   
    @Override
    public List<Curso> searchCursosDisp(Curso filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCurso(Curso curso) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrera getCarrera(String nombre, String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> getProfesor(String nombre, int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProfesor(Profesor profe) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> getEstudiantes(String nombre, int ced, Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciclo> getCiclos(int annio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCiclo(Ciclo ciclo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ofertaAcad(Carrera carrera, Ciclo ciclo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> searchCursosEstu(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo> searchGruposProf(Profesor profe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> getEstuGrupo(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void close(){
        try {
            out.writeInt(Protocol.CLOSE);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
        }
    }

   
}
