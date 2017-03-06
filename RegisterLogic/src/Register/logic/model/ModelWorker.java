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
import Register.Entities.Profesor;
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
        int filtroInt;
        Curso c;
        Carrera car;
        Profesor p;
        Estudiante es;
        Ciclo ci;
        while (continuar) {
            try {
                method = in.readInt();
                System.out.println("Operacion: "+method);
                switch(method){
                case Protocol.SEARCH_CURSOS_NOMBRE:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CUR_NOM(filtro));
                    break;
                case Protocol.SEARCH_CURSOS_CODIGO:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CUR_COD(filtro));
                    break;
                
                case Protocol.SEARCH_CURSOS_CARRERA:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CUR_CAR(filtro));
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
                case Protocol.SEARCH_CARRERA_NOMBRE:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CAR_NOM(filtro));
                    break;
                case Protocol.SEARCH_CARRERA_CODIGO:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CUR_COD(filtro));
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
                case Protocol.SEARCH_PROFESOR_NOMBRE:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_PRO_NOM(filtro));
                    break;
                case Protocol.SEARCH_PROFESOR_CEDULA:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_PRO_CED(filtroInt));
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
                case Protocol.SEARCH_ESTUDIANTES_NOMBRE:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_EST_NOM(filtro));
                    break;
                case Protocol.SEARCH_ESTUDIANTES_CEDULA:
                     filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_EST_CED(filtroInt));
                    break;
                case Protocol.SEARCH_ESTUDIANTES_CARRERA:
                    filtro=(String) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_EST_CAR(filtro));
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
                case Protocol.SEARCH_CICLOS_ANYO:
                    filtroInt=(Integer) in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.search_CIC_ANYO(filtroInt));
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
