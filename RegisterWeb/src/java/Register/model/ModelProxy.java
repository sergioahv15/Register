/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.model;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.Entities.Usuario;
import Register.IModel;
import Register.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
    public List<Curso> search_CUR(String nombre, String codigo, String carrera) {
        try {
            out.writeInt(Protocol.SEARCH_CURSOS);
            out.writeObject(nombre);
            out.writeObject(codigo);
            out.writeObject(carrera);
            out.flush();
            int error = in.readInt();
            List<Curso> cursos = (List<Curso>) in.readObject();
            
            //
            System.out.println(cursos.get(0).getNombre());
            //
            
            return cursos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Curso>();
        }
    }

    @Override
    public List<Curso> search_CUR(String carrera, int ciclo) {
        try {
            out.writeInt(Protocol.SEARCH_CURSOS2);
            out.writeObject(carrera);
            out.writeObject(ciclo);
            out.flush();
            int error = in.readInt();
            List<Curso> cursos = (List<Curso>) in.readObject();
            
            //
            System.out.println(cursos.get(0).getNombre());
            //
            
            return cursos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Curso>();
        }
    }
    
    @Override
    public void delete(Curso curso) throws Exception {
        try {
            out.writeInt(Protocol.DELETE_CURSO);
            out.writeObject(curso);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Curso no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Curso no existe");
        }
    }
    
    @Override
    public void delete(int grupo, int estudiante) throws Exception {
        try {
            out.writeInt(Protocol.DELETE_GRUPO_MATRICULADO);
            out.writeObject(grupo);
            out.writeObject(estudiante);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Grupo no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Grupo no existe");
        }
    }
    
    @Override
    public void matricular(int grupo, int estudiante) throws Exception {
        try {
            out.writeInt(Protocol.MATRICULAR_GRUPO);
            out.writeObject(grupo);
            out.writeObject(estudiante);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Grupo no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Grupo no existe");
        }
    }
    
    @Override
    public void update(Curso curso) throws Exception {
        try {
            out.writeInt(Protocol.UPDATE_CURSO);
            out.writeObject(curso);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Curso no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Curso no existe");
        }
    }

    @Override
    public List<Carrera> search_CAR(String nombre, String codigo) {
        try {
            out.writeInt(Protocol.SEARCH_CARRERA);
            out.writeObject(nombre);
            out.writeObject(codigo);
            out.flush();
            int error = in.readInt();
            List<Carrera> carreras = (List<Carrera>) in.readObject();            
            return carreras;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Carrera>();
        }
    }

    @Override
    public void update(Carrera carrera) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> search_PRO(String nombre, int ced) {
        try {
            out.writeInt(Protocol.SEARCH_PROFESOR);
            out.writeObject(nombre);
            out.writeObject(ced);
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
    public List<Estudiante> search_EST(String nombre, int ced, String carrera) {
        try {
            out.writeInt(Protocol.SEARCH_ESTUDIANTES);
            out.writeObject(nombre);
            out.writeObject(ced);
            out.writeObject(carrera);
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
    public void Add_GRU(Grupo grupo) throws Exception {
        try {
            out.writeInt(Protocol.ADD_GRUPO);
            out.writeObject(grupo);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Grupo ya existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Grupo ya existe");
        }
    }

    @Override
    public List<Grupo> search_GRU(String curso,String carrera) {
        try {
            out.writeInt(Protocol.SEARCH_GRUPOS);
            out.writeObject(curso);
            out.writeObject(carrera);
            out.flush();
            int error = in.readInt();
            List<Grupo> grupos = (List<Grupo>) in.readObject();            
            //
            System.out.println(grupos.get(0).getProfesor());
            //            
            return grupos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Grupo>();
        }
    }
    
    @Override
    public List<Grupo> search_GRU(int estudiante) {
        try {
            out.writeInt(Protocol.SEARCH_GRUPOS2);
            out.writeObject(estudiante);
            out.flush();
            int error = in.readInt();
            List<Grupo> grupos = (List<Grupo>) in.readObject();            
            //
            System.out.println(grupos.get(0).getProfesor());
            //            
            return grupos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Grupo>();
        }
    }
    
    @Override
    public List<Grupo> search_GRU_PRO(int profesor) {
        try {
            out.writeInt(Protocol.SEARCH_GRUPOS4);
            out.writeObject(profesor);
            out.flush();
            int error = in.readInt();
            List<Grupo> grupos = (List<Grupo>) in.readObject();            
            //
            System.out.println(grupos.get(0).getProfesor());
            //            
            return grupos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Grupo>();
        }
    }
    
    @Override
    public List<Grupo> search_GRU(int ciclo,String carrera) {
        try {
            out.writeInt(Protocol.SEARCH_GRUPOS3);
            out.writeObject(ciclo);
            out.writeObject(carrera);
            out.flush();
            int error = in.readInt();
            List<Grupo> grupos = (List<Grupo>) in.readObject();            
            //
            System.out.println(grupos.get(0).getProfesor());
            //            
            return grupos;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Grupo>();
        }
    }

    @Override
    public void update(Grupo grupo) throws Exception {
        try {
            out.writeInt(Protocol.UPDATE_GRUPO);
            out.writeObject(grupo);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Grupo no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Grupo no existe");
        }
    }
    
    @Override
    public void updateNota(int grupo, int estudiante, int nota) throws Exception {
        try {
            out.writeInt(Protocol.UPDATE_NOTA);
            out.writeObject(grupo);
            out.writeObject(estudiante);
            out.writeObject(nota);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Nota no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Nota no existe");
        }
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
    public List<Ciclo> search_CIC(int annio,int numero) {
        try {
            out.writeInt(Protocol.SEARCH_CICLOS);
            out.writeObject(annio);
            out.writeObject(numero);
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
        try {
            out.writeInt(Protocol.ADD_CURSO);
            out.writeObject(c);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Curso ya existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Curso ya existe");
        }
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

    @Override
    public String login(int ced, String clave) {
        try {
            out.writeInt(Protocol.LOGIN);
            out.writeObject(ced);
            out.writeObject(clave);
            out.flush();
            int error = in.readInt();
            String tipo = (String) in.readObject();
            
            System.out.println(tipo);
            
            return tipo;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new String();
        }
    }

    @Override
    public Usuario logout(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> search_NOTAS(int grupo) {
        try {
            out.writeInt(Protocol.SEARCH_NOTAS);
            out.writeObject(grupo);
            out.flush();
            int error = in.readInt();
            ArrayList<String> notas = (ArrayList<String>) in.readObject();
            return notas;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<String>();
        }
    }

    @Override
    public ArrayList<String> search_HIST(int estudiante) {
        try {
            out.writeInt(Protocol.SEARCH_HISTORIAL_ACTIVO);
            out.writeObject(estudiante);
            out.flush();
            int error = in.readInt();
            ArrayList<String> notas = (ArrayList<String>) in.readObject();
            return notas;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<String>();
        }
    }

    @Override
    public Ciclo search_CIC_ACTUAL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario search_USU(int cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ADD_USU(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
