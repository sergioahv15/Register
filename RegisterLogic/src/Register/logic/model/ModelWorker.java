/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.logic.model;

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
                    ModelWorker.this.run();
                }
            });
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(ModelWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(){
        boolean continuar = true;
        int method;
        
        while (continuar) {
            try {
                method = in.readInt();
                System.out.println("Operacion: "+method);
               // switch(method){
                //case 
                    //break;
                //}
            } catch (IOException ex) {
                System.out.println(ex);
                continuar = false;
            }                        
        }
    }
}
