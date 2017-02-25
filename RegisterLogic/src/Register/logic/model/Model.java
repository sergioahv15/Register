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
import Register.IModel;
import java.util.List;

/**
 *
 * @author Herrera
 */
public class Model implements IModel{
    
    DataBase database = new DataBase(null, null, null);
    
    
    public Model(){
        initUsers();
    }
    
    private void initUsers(){
    
    }

    @Override
    public Carrera getCarrera(String nombre, String codigo) {
        Carrera carrera = new Carrera(codigo, nombre);
        return carrera;
    }

    @Override
    public List<Profesor> getProfesor(String nombre, int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProfesor(Profesor p)throws Exception {
        String SQL="update profesor set clave='%s',nombre='%s',tel='%d',email='%s' where cedula='%s'";
        SQL= String.format(SQL, p.getClave(),p.getNombre(),p.getTel(),
                p.getEmail());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Profesor no existe");
        }
    }

    @Override
    public List<Estudiante> getEstudiantes(String nombre, int ced, Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> searchCursosDisp(Curso filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCurso(Curso c) throws Exception {
        String SQL="update curso set nombre='%s',creditos='%d',"
                + "horasSemanales'%d' where codigo='%s';";
        SQL= String.format(SQL,c.getNombre(),c.getCreditos(),c.getHorasSemanales());
        int count= database.executeUpdate(SQL);
        if (count ==0){
        throw new Exception("Curso no existente");
        }
    }

    @Override
    public List<Ciclo> getCiclos(int annio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCiclo(Ciclo ciclo) {
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
}
