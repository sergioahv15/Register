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
import Register.Entities.PlanEstudio;
import Register.Entities.Profesor;
import Register.IModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Curso> search_CUR_NOM(String nombre)throws Exception{
        List<Curso> resultado = new ArrayList<Curso>();
        try {
            String SQL="select * from curso cur where c.nombre like '%%%s%%'";
            SQL = String.format(SQL, nombre);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(curso(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    
    private Curso curso(ResultSet rs) throws SQLException{
        Curso c = new Curso();
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        c.setCreditos(rs.getInt("creditos"));
        c.setHorasSemanales(rs.getInt("horas_semanales"));
        c.setPlanEstu(planEstudio(rs));
        c.setCiclo(ciclo(rs));
        //c.setGrupos(grupos);
        return c;
    }
    
    private PlanEstudio planEstudio(ResultSet rs) throws SQLException{
        PlanEstudio p = new PlanEstudio();
        p.setTitulo(rs.getString("titulo"));
        //p.setCarrera(carrera(rs));
        return p;
    }
    
    private Ciclo ciclo(ResultSet rs) throws SQLException{
        Ciclo c = new Ciclo();
        c.setNumero(rs.getInt("numero"));
        c.setAnyo(rs.getInt("anyo"));
        c.setFechaInicio(rs.getDate("fecha_inicio"));
        c.setFechaFin(rs.getDate("fecha_fin"));
        return c;
    }

    @Override
    public List<Curso> search_CUR_COD(String codigo) {
        List<Curso> c = new ArrayList<Curso>();
        //String SQL= "select * from ";
        return c;
    }

    @Override
    public List<Curso> search_CUR_CAR(Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Curso c) throws Exception {
        String SQL="update curso set nombre='%s',creditos='%d',"
                + "horasSemanales'%d' where codigo='%s';";
        SQL= String.format(SQL,c.getNombre(),c.getCreditos(),c.getHorasSemanales());
        int count= database.executeUpdate(SQL);
        if (count ==0){
        throw new Exception("Curso no existente");
        }
    }

    @Override
    public Carrera search_CAR_NOM(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrera search_CAR_COD(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Carrera carrera) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> search_PRO_NOM(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> search_PRO_CED(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Profesor p) throws Exception {
        String SQL="update profesor set clave='%s',nombre='%s',tel='%d',email='%s' where cedula='%s'";
        SQL= String.format(SQL, p.getClave(),p.getNombre(),p.getTel(),
                p.getEmail());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Profesor no existe");
        }
    }

    @Override
    public List<Estudiante> search_EST_NOM(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> search_EST_CED(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> search_EST_CAR(Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estudiante estu) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciclo> search_CIC_ANYO(int annio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ciclo ciclo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> ofertaAcad(Carrera carrera, Ciclo ciclo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo> search_GRU_COD(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> search_HIS_ACT(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo> search_GRU_PRO(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> search_EST_GRU(int numGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> search_HIS_GLOB(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  void close(){
    }
}

    