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
    
    @Override
    public List<Curso> search_CUR_COD(String codigo) {
        List<Curso> resultado = new ArrayList<Curso>();
        try {
            String SQL="select * from curso cur where c.codigo like '%%%s%%'";
            SQL = String.format(SQL, codigo);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(curso(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public List<Curso> search_CUR_CAR(String carrera) {
        List<Curso> resultado = new ArrayList<Curso>();
        try {
            String SQL="select * from curso cur where c.carrera like '%%%s%%'";   //FIJARSE COMO SALE ATRIBUTO CARRERA DE CURSO EN LA BASE
            SQL = String.format(SQL, carrera);
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
        c.setCarrera(carrera(rs));
        c.setCiclo(ciclo(rs));
        return c;
    }
    
    private Carrera carrera(ResultSet rs) throws SQLException{
        Carrera c = new Carrera();
        c.setTitulo(rs.getString("titulo"));
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        return c;
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
    public void update(Curso c) throws Exception {
        String SQL="update curso set nombre='%s',creditos='%d',"
                + "horas_semanales'%d' where codigo='%s';";
        SQL= String.format(SQL,c.getNombre(),c.getCreditos(),c.getHorasSemanales());
        int count= database.executeUpdate(SQL);
        if (count ==0){
        throw new Exception("Curso no existente");
        }
    }

    @Override
    public List<Carrera> search_CAR_NOM(String nombre) {
        List<Carrera> resultado = new ArrayList<Carrera>();
        try {
            String SQL="select * from carrera car where car.nombre like '%%%s%%'";
            SQL = String.format(SQL, nombre);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(carrera(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public List<Carrera> search_CAR_COD(String codigo) {
        List<Carrera> resultado = new ArrayList<Carrera>();
        try {
            String SQL="select * from carrera car where car.codigo like '%%%s%%'";
            SQL = String.format(SQL, codigo);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(carrera(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    
    
    @Override
    public void update(Carrera carrera) throws Exception {
         String SQL="update carrera set nombre='%s'"
                + "titulo'%s' where codigo='%s';";
        SQL= String.format(SQL,carrera.getNombre(),carrera.getTitulo());
        int count= database.executeUpdate(SQL);
        if (count ==0){
        throw new Exception("carrera no existente");
        }
    }

    @Override
    public List<Profesor> search_PRO_NOM(String nombre) {
        List<Profesor> resultado = new ArrayList<Profesor>();
        try {
            String SQL="select * from profesor pro where pro.nombre like '%%%s%%'";
            SQL = String.format(SQL, nombre);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(profesor(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public List<Profesor> search_PRO_CED(int ced) {
        List<Profesor> resultado = new ArrayList<Profesor>();
        try {
            String SQL="select * from profesor pro where pro.cedula like %d";
            SQL = String.format(SQL, ced);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(profesor(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    private Profesor profesor(ResultSet rs) throws SQLException{
        Profesor p = new Profesor();
        p.setNombre(rs.getString("nombre"));
        p.setClave(rs.getString("clave"));
        p.setCedula(rs.getInt("cedula"));
        p.setEmail(rs.getString("email"));
        p.setTel(rs.getInt("tel"));
        return p;
    }
    
    @Override
    public void update(Profesor p) throws Exception {
        String SQL="update profesor set clave='%s',nombre='%s',tel='%d',email='%s' where cedula='%d'";  //REVISAR %d
        SQL= String.format(SQL, p.getClave(),p.getNombre(),p.getTel(),
                p.getEmail());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Profesor no existe");
        }
    }

    @Override
    public List<Estudiante> search_EST_NOM(String nombre) {
        List<Estudiante> resultado = new ArrayList<Estudiante>();
        try {
            String SQL="select * from estudiante est where est.nombre like '%%%s%%'";
            SQL = String.format(SQL, nombre);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(estudiante(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public List<Estudiante> search_EST_CED(int ced) {
        List<Estudiante> resultado = new ArrayList<Estudiante>();
        try {
            String SQL="select * from estudiante est where est.cedula like %d";
            SQL = String.format(SQL, ced);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(estudiante(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public List<Estudiante> search_EST_CAR(String carrera) {
        List<Estudiante> resultado = new ArrayList<Estudiante>();
        try {
            String SQL="select * from estudiante est where est.carrera like '%%%s%%'";
            SQL = String.format(SQL, carrera);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(estudiante(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    
    private Estudiante estudiante(ResultSet rs) throws SQLException{
            Estudiante e = new Estudiante();
        e.setNombre(rs.getString("nombre"));
        e.setClave(rs.getString("clave"));
        e.setCedula(rs.getInt("cedula"));
        e.setEmail(rs.getString("email"));
        e.setTel(rs.getInt("tel"));
        e.setFechaNac(rs.getDate("fecha_nac"));
        return e;
    }

    @Override
    public void update(Estudiante e) throws Exception {
        String SQL="update estudiante set clave='%s',nombre='%s',tel='%d',email='%s',fecha_nac='%s' where cedula='%d'";  //REVISAR %d y decha de nac
        SQL= String.format(SQL, e.getClave(),e.getNombre(),e.getTel(),
                e.getEmail(),e.getFechaNac());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("estudiante no existe");
        }
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

    