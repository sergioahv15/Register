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
   
    public void close(){
        try {
            out.writeInt(Protocol.CLOSE);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
        }
    }

    @Override
    public List<Curso> search_CUR_NOM(String nombre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> search_CUR_COD(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> search_CUR_CAR(String carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Curso curso) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carrera> search_CAR_NOM(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carrera> search_CAR_COD(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Carrera carrera) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> search_PRO_NOM(String nombre) {
        try {
            out.writeInt(Protocol.SEARCH_PROFESOR_NOMBRE);
            out.writeObject(nombre);
            out.flush();
            int error = in.readInt();
            List<Profesor> profesores = (List<Profesor>) in.readObject();
            
            //
            System.out.println(profesores.get(0).getNombre());
            //
            
            return profesores;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Profesor>();
        }
    }

    @Override
    public List<Profesor> search_PRO_CED(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Profesor profe) throws Exception {
        try {
            out.writeInt(Protocol.UPDATE_PROFESOR);
            out.writeObject(profe);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Profesor no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Profesor no existe");
        }
    }

    @Override
    public List<Estudiante> search_EST_NOM(String nombre) {
        try {
            out.writeInt(Protocol.SEARCH_ESTUDIANTES_NOMBRE);
            out.writeObject(nombre);
            out.flush();
            int error = in.readInt();
            List<Estudiante> estudiantes = (List<Estudiante>) in.readObject();
            
            //
            System.out.println(estudiantes.get(0).getNombre());
            //
            
            return estudiantes;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Estudiante>();
        }
    }

    @Override
    public List<Estudiante> search_EST_CED(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> search_EST_CAR(String carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estudiante estu) throws Exception {
        try {
            out.writeInt(Protocol.UPDATE_ESTUDIANTE);
            out.writeObject(estu);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Estudiante no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Estudiante no existe");
        }
    }

    @Override
    public List<Ciclo> search_CIC_ANYO(int annio) {
        try {
            out.writeInt(Protocol.SEARCH_CICLOS_ANYO);
            out.writeObject(annio);
            out.flush();
            int error = in.readInt();
            List<Ciclo> ciclos = (List<Ciclo>) in.readObject();
            
            //
            System.out.println(ciclos.get(0).getFechaInicio());
            //
            
            return ciclos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Ciclo>();
        }
    }

    @Override
    public void update(Ciclo ciclo) throws Exception {
        try {
            out.writeInt(Protocol.UPDATE_CICLOS);
            out.writeObject(ciclo);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Ciclo no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Ciclo no existe");
        }
    }

    @Override
    public List<Curso> ofertaAcad(String carrera, int ciclo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> search_HIS_ACT(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Add_CUR(Curso c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Add_CAR(Carrera c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Add_PRO(Profesor p) throws Exception {
        try {
            out.writeInt(Protocol.ADD_PROFESOR);
            out.writeObject(p);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Profesor ya existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Profesor ya existe");
        }
    }

    @Override
    public void Add_EST(Estudiante c) throws Exception {
        try {
            out.writeInt(Protocol.ADD_ESTUDIANTE);
            out.writeObject(c);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Estudiante ya existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Estudiante ya existe");
        }
    }

    @Override
    public void Add_CIC(Ciclo c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
