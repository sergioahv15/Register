/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.logic.model;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herrera
 */
public class ModelWorker {
    Socket skt;
    ObjectInputStream in;
    ObjectOutputStream out;
    IModel Model;

    public ModelWorker(Socket skt, IModel Model) {
        this.skt = skt;
        this.Model=Model;
    }
    
    public void start(){
        try {
            out = new ObjectOutputStream(skt.getOutputStream() );
            out.flush();
            in = new ObjectInputStream(skt.getInputStream());
            System.out.println("Worker atendiendo peticiones...");
            Thread t = new Thread(new Runnable(){
                public void run(){
                    try {
                        ModelWorker.this.run();
                    } catch (Exception ex) {
                        Logger.getLogger(ModelWorker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(ModelWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() throws ClassNotFoundException, Exception{
        boolean continuar = true;
        int method;
        String filtro;
        //***********
        String filtro2;
        String filtro3;
        //***********
        int filtroInt;
        int filtroInt2;
        int filtroInt3;
        Curso c;
        Carrera car;
        Grupo g;
        Profesor p;
        Estudiante es;
        Ciclo ci;
        Usuario u;
        while (continuar) {
            try {
                method = in.readInt();
                System.out.println("Operacion: "+method);
                switch(method){
                case Protocol.ADD_CURSO:
                    c=(Curso)in.readObject();
                    try {
                        Model.Add_CUR(c);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_CURSO);
                    }
                    break;
                case Protocol.SEARCH_CURSOS:
                    filtro=(String) in.readObject();
                    filtro2=(String) in.readObject();
                    filtro3=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CUR(filtro,filtro2,filtro3));
                    break;
                case Protocol.SEARCH_CURSOS2:
                    filtro=(String) in.readObject();
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CUR(filtro,filtroInt));
                    break;
                case Protocol.SEARCH_GRUPOS:
                    filtro=(String) in.readObject();
                    filtro2=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_GRU(filtro,filtro2));
                    break;
                case Protocol.SEARCH_GRUPOS2:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_GRU(filtroInt));
                    break;
                case Protocol.SEARCH_GRUPOS3:
                    filtroInt=(Integer) in.readObject();
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_GRU(filtroInt,filtro));
                    break;
                case Protocol.SEARCH_GRUPOS4:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_GRU_PRO(filtroInt));
                    break;
                case Protocol.SEARCH_NOTAS:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_NOTAS(filtroInt));
                    break; 
                case Protocol.SEARCH_HISTORIAL_ACTIVO:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_HIST(filtroInt));
                    break; 
                case Protocol.UPDATE_CURSO:
                    c= (Curso)in.readObject();
                    try {
                        Model.update(c);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.UPDATE_USER:
                    u= (Usuario)in.readObject();
                    try {
                        Model.update_USU(u);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.UPDATE_NOTA:
                    filtroInt=(Integer) in.readObject();
                    filtroInt2=(Integer) in.readObject();
                    filtroInt3=(Integer) in.readObject();
                    try {
                        Model.updateNota(filtroInt,filtroInt2,filtroInt3);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.UPDATE_GRUPO:
                    g= (Grupo)in.readObject();
                    try {
                        Model.update(g);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.DELETE_CURSO:
                    c= (Curso)in.readObject();
                    try {
                        Model.delete(c);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.DELETE_GRUPO_MATRICULADO:
                    filtroInt=(Integer) in.readObject();
                    filtroInt2=(Integer) in.readObject();
                    try {
                        Model.delete(filtroInt,filtroInt2);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.MATRICULAR_GRUPO:
                    filtroInt=(Integer) in.readObject();
                    filtroInt2=(Integer) in.readObject();
                    try {
                        Model.matricular(filtroInt,filtroInt2);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_UPDATE_CURSO);
                    }
                    break;
                case Protocol.ADD_CARRERA:
                    car=(Carrera)in.readObject();
                    try {
                        Model.Add_CAR(car);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_CARRERA);
                    }
                    break;
                case Protocol.ADD_GRUPO:
                    g=(Grupo)in.readObject();
                    try {
                        Model.Add_GRU(g);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_CARRERA);
                    }
                    break;
                case Protocol.SEARCH_CARRERA:
                    filtro=(String) in.readObject();
                    filtro2=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CAR(filtro,filtro2));
                    break;
                case Protocol.UPDATE_CARRERA:
                     car=(Carrera)in.readObject();
                    try {
                            Model.update(car);
                            out.writeInt(Protocol.ERROR_NO_ERROR);
                        } catch (Exception e) {
                            out.writeInt(Protocol.ERROR_UPDATE_CARRERA);
                        }
                    break;
                case Protocol.ADD_PROFESOR:
                    p=(Profesor)in.readObject();
                    try {
                        Model.Add_PRO(p);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_PROFESOR);
                    }
                    break;                  
                case Protocol.SEARCH_PROFESOR:
                    filtro=(String) in.readObject();
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_PRO(filtro,filtroInt));
                    break;
                case Protocol.UPDATE_PROFESOR:
                    p=(Profesor)in.readObject();
                     try {
                            Model.update(p);
                            out.writeInt(Protocol.ERROR_NO_ERROR);
                        } catch (Exception e) {
                            out.writeInt(Protocol.ERROR_UPDATE_PROFESOR);
                        }
                    break;
                case Protocol.ADD_ESTUDIANTE:
                    es=(Estudiante)in.readObject();
                    try {
                        Model.Add_EST(es);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_ESTUDIANTE);
                    }
                    break;
                case Protocol.ADD_USER:
                    u=(Usuario)in.readObject();
                    try {
                        Model.ADD_USU(u);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_ESTUDIANTE);
                    }
                    break;
                case Protocol.SEARCH_ESTUDIANTES:
                    filtro=(String) in.readObject();
                    filtroInt=(Integer) in.readObject();
                    filtro2=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_EST(filtro,filtroInt,filtro2));
                    break;
                case Protocol.UPDATE_ESTUDIANTE:
                    es=(Estudiante)in.readObject();
                    try {
                            Model.update(es);
                            out.writeInt(Protocol.ERROR_NO_ERROR);
                        } catch (Exception e) {
                            out.writeInt(Protocol.ERROR_UPDATE_ESTUDIANTE);
                        }
                    break;
                case Protocol.ADD_CICLO:
                    ci=(Ciclo)in.readObject();
                    try {
                        Model.Add_CIC(ci);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception e) {
                        out.writeInt(Protocol.ERROR_ADD_CICLO);
                    }
                    break;
                case Protocol.SEARCH_CICLOS:
                    filtroInt=(Integer) in.readObject();
                    filtroInt2=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CIC(filtroInt,filtroInt2));
                    break;
                case Protocol.SEARCH_ADM_MAT:
                    filtroInt=(Integer) in.readObject();
                    filtro = (String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_ADM_MAT(filtroInt,filtro));
                    break;
                case Protocol.SEARCH_USER:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_USU(filtroInt));
                    break;
                case Protocol.UPDATE_CICLOS:
                    ci=(Ciclo)in.readObject();
                    try {
                            Model.update(ci);
                            out.writeInt(Protocol.ERROR_NO_ERROR);
                        } catch (Exception e) {
                            out.writeInt(Protocol.ERROR_UPDATE_CICLOS);
                        }
                    break;
                case Protocol.LOGIN:                    
                    filtroInt=(Integer)in.readObject();
                    filtro=(String)in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.login(filtroInt,filtro));
                    break;
                case Protocol.SEARCH_CICLO_ACTUAL:
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CIC_ACTUAL());
                    break;
                case Protocol.CLOSE:
                    skt.close();
                    continuar = false;
                    break;
                 }
                out.flush();
            } catch (IOException ex) {
                System.out.println(ex);
                continuar = false;
            }                        
        }
    }
}
