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
import Register.Entities.Historial;
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
    
    private DataBase database;
    
    
    public Model(){
        database= new DataBase(null, null, null);
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
            String SQL="select * from curso cur where c.carrera_codigo like '%%%s%%'";   //FIJARSE COMO SALE ATRIBUTO CARRERA DE CURSO EN LA BASE
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
        c.setFechaInicio(rs.getString("fecha_inicio"));
        c.setFechaFin(rs.getString("fecha_fin"));
        int activo = rs.getInt("activo");
        if(activo==1)c.setActivo(true);
        else if(activo ==0)c.setActivo(false);
        return c;
    }

     @Override
    public void update(Curso c) throws Exception {
        String SQL="update curso set nombre='%s',creditos='%d',"
                + "horas_semanales='%d' where codigo='%s';";
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
                + "titulo='%s' where codigo='%s';";
        SQL= String.format(SQL,carrera.getNombre(),carrera.getTitulo());
        int count= database.executeUpdate(SQL);
        if (count ==0){
        throw new Exception("carrera no existente");
        }
    }

    @Override
    public List<Profesor> search_PRO(String nombre, int ced) {
        List<Profesor> resultado = new ArrayList<Profesor>();
        String SQL;
        try {
            if(ced!=0){ 
                SQL="select * from profesor pro where pro.nombre like '%%%s%%' and pro.cedula like '%d'";
                SQL = String.format(SQL, nombre, ced);
            }else{
                SQL="select * from profesor pro where pro.nombre like '%%%s%%'";
                SQL = String.format(SQL, nombre);                
            }
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(profesor(rs));
            }
        } catch (Exception e) {}
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
                p.getEmail(),p.getCedula());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Profesor no existe");
        }
    }
   
    @Override
    public List<Estudiante> search_EST(String nombre, int ced, String carrera) {
        List<Estudiante> resultado = new ArrayList<Estudiante>();
        String SQL = "";
        try {
            if(ced==0 && carrera.equals("Todas")){
                SQL="select estudiante.clave, estudiante.cedula, estudiante.nombre, estudiante.tel, estudiante.email, estudiante.fecha_nac, carrera.nombre nom "+
                        "from estudiante inner join carrera on estudiante.carrera_codigo=carrera.codigo where estudiante.nombre like '%%%s%%'";
                SQL = String.format(SQL, nombre);
            }else if(ced!=0 && carrera.equals("Todas")){
                SQL="select estudiante.clave, estudiante.cedula, estudiante.nombre, estudiante.tel, estudiante.email, estudiante.fecha_nac, carrera.nombre as nom "+
                        "from estudiante inner join carrera on estudiante.carrera_codigo=carrera.codigo where estudiante.nombre like '%%%s%%' and estudiante.cedula like %d";
                SQL = String.format(SQL, nombre, ced);
            }else if(ced==0 && (!carrera.equals("Todas"))){
                SQL="select estudiante.clave, estudiante.cedula, estudiante.nombre, estudiante.tel, estudiante.email, estudiante.fecha_nac, carrera.nombre as nom "+
                        "from estudiante inner join carrera on estudiante.carrera_codigo=carrera.codigo where estudiante.nombre like '%%%s%%' and carrera.nombre='%s'";
                SQL = String.format(SQL, nombre, carrera);
            }else if(ced!=0 && (!carrera.equals("Todas"))){
                SQL="select estudiante.clave, estudiante.cedula, estudiante.nombre, estudiante.tel, estudiante.email, estudiante.fecha_nac, carrera.nombre as nom "+
                        "from estudiante inner join carrera on estudiante.carrera_codigo=carrera.codigo where estudiante.nombre like '%%%s%%' and estudiante.cedula like %d and carrera.nombre='%s'";
                SQL = String.format(SQL, nombre, ced, carrera);
            }
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(estudiante(rs));
            }
        } catch (Exception e) {}
            return resultado;
    }
    
    private Estudiante estudiante(ResultSet rs) throws SQLException{
            Estudiante e = new Estudiante();
        e.setNombre(rs.getString("nombre"));
        e.setClave(rs.getString("clave"));
        e.setCedula(rs.getInt("cedula"));
        e.setEmail(rs.getString("email"));
        e.setTel(rs.getInt("tel"));
        e.setFechaNac(rs.getString("fecha_nac"));
        e.setCarrera(search_CAR_NOM(rs.getString("nom")).get(0));
        //e.setHistorial(historial(rs));
        return e;
    }
    
    private Historial historial(ResultSet rs) throws SQLException{
        Historial h = new Historial();
        h.setEstudiante(estudiante(rs));
        return h;
    }
    

    @Override
    public void update(Estudiante e) throws Exception {
        String SQL="update estudiante set clave='%s',nombre='%s',tel='%d',email='%s',fecha_nac='%s',carrera_codigo='%s' where cedula=%d";  //REVISAR %d y decha de nac
        SQL= String.format(SQL, e.getClave(),e.getNombre(),e.getTel(),
                e.getEmail(),e.getFechaNac(),e.getCarrera().getCodigo(),e.getCedula());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("estudiante no existe");
        }
    }
    
    

    @Override
    public List<Ciclo> search_CIC_ANYO(int anyo) {
        List<Ciclo> resultado = new ArrayList<Ciclo>();
        try {
            String SQL="select * from ciclo c where c.anyo like %d";
            SQL = String.format(SQL, anyo);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(ciclo(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public void update(Ciclo ciclo) throws Exception {
        String SQL;
        Boolean activo = ciclo.isActivo();
        if(activo){
            SQL = "update ciclo set activo=0 where fecha_inicio='%s'";
        }else{
            SQL = "update ciclo set activo=1 where fecha_inicio='%s'";
        }
        SQL= String.format(SQL, ciclo.getFechaInicio());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("ciclo no existe");
        }
    }

    @Override
    public List<Curso> ofertaAcad(String carrera, int ciclo) {
        List<Curso> resultado = new ArrayList<Curso>();
        try {
            String SQL="select * from curso c where c.carrera_codigo like '%%%s%%' AND c.ciclo like %d";    //REVISAR!!!
            SQL = String.format(SQL, carrera,ciclo);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(curso(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    

    @Override
    public List<Curso> search_HIS_ACT(int ced) {
        List<Curso> c = new ArrayList<Curso>();
           /*DataBase db = new DataBase(null,null,null);
            try{
                String SQL= "select * from historial h where h.curso like %d";
                SQL= String.format(SQL,c.getHistorial().getEstudiante().getCedula());
                ResultSet rs= db.executeQuery(SQL);
                while(rs.next()){
                    Historial.add(curso(rs));
                }}
                catch(SQLException ex){}*/
            return c;
    }
    
    public  void close(){
    }

    @Override
    public void Add_CUR(Curso c) throws Exception {
        String SQL="insert into curso (codigo,nombre,creditos,horas_semanales,ciclo,historial_estudiante_cedula,carrera_codigo)"
                + "values('%s','%s',%d,%d,%d,%d,'%s')";
        SQL=String.format(SQL,c.getCodigo(),c.getNombre(),c.getCreditos(),c.getHorasSemanales(),c.getCiclo().getNumero(),
                c.getHistorial().getEstudiante().getCedula(),c.getCarrera());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Curso ya existente");
        }
    }

    @Override
    public void Add_CAR(Carrera c) throws Exception {
        String SQL="insert into carrera (codigo,nombre,titulo)"
                + "values('%s','%s','%s')";
        SQL=String.format(SQL,c.getCodigo(),c.getNombre(),c.getTitulo());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Carrera ya existente");
        }
    }

    @Override
    public void Add_PRO(Profesor p) throws Exception {
        String SQL="insert into profesor (cedula,nombre,tel,email,clave)"
                + "values(%d,'%s',%d,'%s','%s')";
        SQL=String.format(SQL,p.getCedula(),p.getNombre(),p.getTel(),p.getEmail(),p.getClave());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Profesor ya existente");
        }
    }

    @Override
    public void Add_EST(Estudiante e) throws Exception {
        String SQL="insert into estudiante (cedula,nombre,tel,email,clave,carrera_codigo,fecha_nac)"
                + "values(%d,'%s',%d,'%s','%s','%s','%s')";
        SQL=String.format(SQL,e.getCedula(),e.getNombre(),e.getTel(),e.getEmail(),e.getClave(),e.getCarrera().getCodigo(),
            e.getFechaNac());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Estudiante ya existente");
        }
    }

    @Override
    public void Add_CIC(Ciclo c) throws Exception {
       String SQL="insert into ciclo (numero,anyo,fecha_inicio,fecha_fin,activo)"
                + "values(%d,%d,'%s','%s',%d)";
        SQL=String.format(SQL,c.getNumero(),c.getAnyo(),c.getFechaInicio(),c.getFechaFin(),c.isActivo());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Ciclo ya existente");
        }
    }    
}

    