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
import com.sun.org.apache.bcel.internal.generic.AASTORE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herrera
 */
public class Model implements IModel{
    
    private DataBase database;
    Hashtable<String,Usuario> usuarios;
    
    public Model() throws Exception{
        database= new DataBase(null, null, null);
        initAdministradores();
    }
    
    void initAdministradores() throws Exception{
        usuarios= new Hashtable<>();
        usuarios.put("111",new Usuario("", 0, ""));
        usuariosEstudiante();
        usuariosProfesor();
     
    }
    
    public void usuariosEstudiante()throws Exception{
        
        try {
            String SQL="select * from estudiante";
            ResultSet rs= database.executeQuery(SQL);
            while(rs.next()){
                Estudiante e= usuarioEstudiante(rs);
                Object o= e.getCedula();
                usuarios.put((String)o,e);
            }
        } catch (Exception e) {
        }
       
    }
    
    private Estudiante usuarioEstudiante(ResultSet rs) throws SQLException{
        Estudiante e = new Estudiante();
        e.setNombre(rs.getString("nombre"));
        e.setClave(rs.getString("clave"));
        e.setCedula(rs.getInt("cedula"));
        e.setEmail(rs.getString("email"));
        e.setTel(rs.getInt("tel"));
        e.setFechaNac(rs.getString("fecha_nac"));
        e.setCarrera(search_CAR(rs.getString("nom"),"").get(0));//********************************
        return e;
    }
    
    public void usuariosProfesor()throws Exception{
        
        try {
            String SQL="select * from profesor";
            ResultSet rs= database.executeQuery(SQL);
            while(rs.next()){
                Profesor p= usuarioProfesor(rs);
                Object o= p.getCedula();
                usuarios.put((String)o, p);
            }
        } catch (Exception e) {
        }
        
    }

    private Profesor usuarioProfesor(ResultSet rs) throws SQLException{
        Profesor p = new Profesor();
        p.setClave(rs.getString("clave"));
        p.setCedula(rs.getInt("cedula"));
        
        return p;
    }
    
    @Override
    public List<Curso> search_CUR(String nombre, String codigo, String carrera) {
        List<Curso> resultado = new ArrayList<Curso>();
        String SQL = "";
        try {
            
            if(!codigo.equals("") && nombre.equals("") && carrera.equals("Todas")){
                SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                        "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.codigo like '%%%s%%'";
                SQL = String.format(SQL, codigo);
            }else if(codigo.equals("") && carrera.equals("Todas")){
                SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                        "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.nombre like '%%%s%%'";
                SQL = String.format(SQL, nombre);
            }else if(!codigo.equals("") && carrera.equals("Todas")){
                SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                        "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.nombre like '%%%s%%' and curso.codigo like '%%%s%%'";
                SQL = String.format(SQL, nombre, codigo);
            }else if(codigo.equals("") && (!carrera.equals("Todas"))){
                SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                        "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.nombre like '%%%s%%' and carrera.nombre='%s'";
                SQL = String.format(SQL, nombre, carrera);
            }else if(!codigo.equals("") && (!carrera.equals("Todas"))){
                SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                        "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.nombre like '%%%s%%' and curso.codigo like '%%%s%%' and carrera.nombre='%s'";
                SQL = String.format(SQL, nombre, codigo, carrera);
            }
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(curso(rs));
            }
        } catch (Exception e) {}
            return resultado;
    }
    
    @Override
    public List<Curso> search_CUR(String carrera, int ciclo) {
        List<Curso> resultado = new ArrayList<Curso>();
        String SQL = "";
        try {
           if(!carrera.equals("") && ciclo==-1){
                 SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                                    "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.carrera_codigo ='%s'";
                 SQL = String.format(SQL,carrera);
            }else if(carrera.equals("") && ciclo==0){
                SQL="select * from curso";
            }else if(carrera.equals("Todas")){
                    SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                            "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.ciclo ='%d'";
                    SQL = String.format(SQL, ciclo);
                    }else if(!carrera.equals("Todas")){
                            SQL="select curso.codigo, curso.nombre, curso.creditos, curso.horas_semanales, curso.ciclo, carrera.nombre nom "+
                                    "from curso inner join carrera on curso.carrera_codigo=carrera.codigo where curso.ciclo ='%d' and carrera.nombre='%s'";
                            SQL = String.format(SQL, ciclo, carrera);
                        }
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(curso(rs));
            }
        } catch (Exception e) {}
            return resultado;
    }
    
    @Override
    public void delete(Curso curso) throws Exception {
        String SQL="delete from curso where codigo='%s'";     
        SQL = String.format(SQL, curso.getCodigo());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Persona no existe");
        }        
    }
    
    @Override
    public void delete(int grupo, int estudiante) throws Exception {
        String SQL="delete from matriculado where numero_grupo=%d and estudiante=%d";     
        SQL = String.format(SQL, grupo, estudiante);
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Grupo no existe");
        }        
    }
    
    @Override
    public void matricular(int grupo, int estudiante) throws Exception {
        String SQL="insert into matriculado (estudiante,numero_grupo) values(%d,%d)";     
        SQL = String.format(SQL, estudiante, grupo);
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Grupo no existe");
        }        
    }
    
    private Curso curso(ResultSet rs) throws SQLException{
        Curso c = new Curso();
        c.setCodigo(rs.getString("codigo"));
        c.setNombre(rs.getString("nombre"));
        c.setCreditos(rs.getInt("creditos"));
        c.setHorasSemanales(rs.getInt("horas_semanales"));
        c.setCarrera(search_CAR(rs.getString("nom"),"").get(0));
        Ciclo cic = new Ciclo(); cic.setNumero(rs.getInt("ciclo"));
        c.setCiclo(cic);
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
        System.out.println(c);
        String SQL="update curso set carrera_codigo='%s' where codigo='%s'";
        SQL= String.format(SQL,c.getCarrera().getCodigo() ,c.getCodigo());
        int count= database.executeUpdate(SQL);
        if (count ==0){
        throw new Exception("Curso no existente");
        }
    }

    @Override
    public List<Carrera> search_CAR(String nombre, String codigo) {
        List<Carrera> resultado = new ArrayList<Carrera>();
        String SQL="";
        try {
            if(nombre.equals("") && codigo.equals("")){
                SQL="select * from carrera";
            }else if(!(nombre.equals("")) && codigo.equals("")){
                SQL="select * from carrera car where car.nombre like '%%%s%%'";
                SQL = String.format(SQL, nombre);
            }else if(nombre.equals("") && !(codigo.equals(""))){
                SQL="select * from carrera car where car.codigo like '%%%s%%'";
                SQL = String.format(SQL, codigo);
            }else if(!(nombre.equals("")) && !(codigo.equals(""))){
                SQL="select * from carrera car where car.nombre like '%%%s%%' and car.codigo like '%%%s%%'";
                SQL = String.format(SQL, nombre, codigo);
            }            
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(carrera(rs));
            }
        } catch (Exception e) {}
            return resultado;
    } 

    @Override
    public void updateNota(int grupo, int estudiante, int nota) throws Exception {
        String SQL="update nota set nota=%d where numero_grupo=%d and ced = %d";
        SQL=String.format(SQL,nota,grupo,estudiante);
        int count= database.executeUpdate(SQL);
        if (count ==0){
            throw new Exception("carrera no existente");
        }
    }
    
    @Override
    public void update(Carrera carrera) throws Exception {
         String SQL="update carrera set nombre='%s'"
                + "titulo='%s' where codigo='%s';";
        SQL= String.format(SQL,carrera.getNombre(),carrera.getTitulo(),carrera.getCodigo());
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
           if(nombre.equals("") && ced==0){ 
                SQL="select * from profesor";
                SQL = String.format(SQL);
            }else if(ced!=0){ 
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
    public void Add_GRU(Grupo g) throws Exception {
        System.out.println(g);
        int lunes,martes,miercoles,jueves,viernes;
        lunes = martes = miercoles = jueves = viernes =0;
        if(g.isLunes()) lunes = 1;if(g.isMartes()) martes = 1;if(g.isMiercoles()) miercoles = 1;
        if(g.isJueves()) jueves = 1;if(g.isViernes()) viernes = 1;
        String SQL="insert into grupo (curso,profesor,hora_ini,hora_fin,lunes,martes,miercoles,jueves,viernes)"
                + " values('%s',%d,'%s','%s',%d,%d,%d,%d,%d)";
        SQL= String.format(SQL,g.getCurso().getCodigo(),g.getProfesor().getCedula(),
                g.getHoraInicio(),g.getHoraFin(),lunes,martes,miercoles,jueves,viernes);
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Curso ya existente");
        }
    }

    @Override
    public List<Grupo> search_GRU(String curso,String carrera) {        
        List<Grupo> resultado = new ArrayList<Grupo>();
        String SQL = "";
        try {
            if(!(curso.equals("")) && carrera.equals("")){
                SQL="select * from grupo g where g.curso='%s'";
                SQL = String.format(SQL, curso);
            }else if(curso.equals("") && !(carrera.equals(""))){
                SQL="select grupo.numero_grupo,grupo.curso,grupo.profesor,grupo.hora_ini,grupo.hora_fin,grupo.lunes,grupo.martes,"+
                        "grupo.miercoles,grupo.jueves,grupo.viernes from grupo,curso where grupo.curso=curso.codigo and curso.carrera_codigo='%s'";
                SQL = String.format(SQL, carrera);
            }
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(grupo(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public List<Grupo> search_GRU(int ciclo,String carrera) {        
        List<Grupo> resultado = new ArrayList<Grupo>();
        System.out.println("Ciclo: " + ciclo + ", Carrera: " +carrera);
        try {            
            String SQL="select grupo.numero_grupo,grupo.curso,grupo.profesor,grupo.hora_ini,grupo.hora_fin,grupo.lunes,grupo.martes,"+
                    "grupo.miercoles,grupo.jueves,grupo.viernes from grupo,curso where grupo.curso=curso.codigo and curso.carrera_codigo='%s' and curso.ciclo=%d";
            SQL = String.format(SQL, carrera,ciclo);            
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(grupo(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    
    @Override
    public List<Grupo> search_GRU(int estudiante) {
        List<Grupo> resultado = new ArrayList<Grupo>();
        try {            
            String SQL="select grupo.numero_grupo,grupo.curso,grupo.profesor,grupo.hora_ini,grupo.hora_fin,grupo.lunes,grupo.martes,"+
                    "grupo.miercoles,grupo.jueves,grupo.viernes from grupo,matriculado where grupo.numero_grupo=matriculado.numero_grupo and matriculado.estudiante=%d";
            SQL = String.format(SQL, estudiante);            
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(grupo(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    
    @Override
    public List<Grupo> search_GRU_PRO(int profesor) {
        List<Grupo> resultado = new ArrayList<Grupo>();
        try {            
            String SQL="select * from grupo where grupo.profesor=%d";
            SQL = String.format(SQL, profesor);            
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(grupo(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    
    private Grupo grupo(ResultSet rs) throws SQLException{
        Grupo g = new Grupo();
        g.setNumeroGrupo(rs.getInt("numero_grupo"));
        g.setCurso(search_CUR("",rs.getString("curso"),"Todas").get(0));
        g.setProfesor(search_PRO("",rs.getInt("profesor")).get(0));
        g.setHoraInicio(rs.getString("hora_ini"));
        g.setHoraFin(rs.getString("hora_fin"));
        if(rs.getInt("lunes")==1) g.setLunes(true);
        if(rs.getInt("martes")==1) g.setMartes(true);
        if(rs.getInt("miercoles")==1) g.setMiercoles(true);
        if(rs.getInt("jueves")==1) g.setJueves(true);
        if(rs.getInt("viernes")==1) g.setViernes(true);
        return g;
    }
        
    @Override
    public void update(Grupo g) throws Exception {
        int lunes,martes,miercoles,jueves,viernes;
        lunes = martes = miercoles = jueves = viernes =0;
        if(g.isLunes()) lunes = 1;if(g.isMartes()) martes = 1;if(g.isMiercoles()) miercoles = 1;
        if(g.isJueves()) jueves = 1;if(g.isViernes()) viernes = 1;
        String SQL="update grupo set numero_grupo=%d,curso='%s',profesor=%d,hora_ini='%s',hora_fin='%s',"+
                "lunes=%d,martes=%d,miercoles=%d,jueves=%d,viernes=%d where numero_grupo=%d";  //REVISAR %d
        SQL= String.format(SQL, g.getNumeroGrupo(),g.getCurso().getCodigo(),g.getProfesor().getCedula(),
                g.getHoraInicio(),g.getHoraFin(),lunes,martes,miercoles,jueves,viernes,g.getNumeroGrupo());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Grupo no existe");
        }
    }
    
    @Override
    public List<Estudiante> search_EST(String nombre, int ced, String carrera) {
        List<Estudiante> resultado = new ArrayList<Estudiante>();
        String SQL = "";
        try {
            
           if(ced==0 && carrera.equals("") && nombre.equals("")){
                SQL="select estudiante.clave, estudiante.cedula, estudiante.nombre, estudiante.tel, estudiante.email, estudiante.fecha_nac, carrera.nombre nom "+
                        "from estudiante";
                SQL = String.format(SQL, ced);
            }else if(ced!=0 && carrera.equals("") && nombre.equals("")){
                SQL="select estudiante.clave, estudiante.cedula, estudiante.nombre, estudiante.tel, estudiante.email, estudiante.fecha_nac, carrera.nombre nom "+
                        "from estudiante inner join carrera on estudiante.carrera_codigo=carrera.codigo where estudiante.cedula like %d";
                SQL = String.format(SQL, ced);
            }else if(ced==0 && carrera.equals("Todas")){
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
        e.setCarrera(search_CAR(rs.getString("nom"),"").get(0));
       
        return e;
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
    public List<Ciclo> search_CIC(int anyo, int numero) {
        List<Ciclo> resultado = new ArrayList<Ciclo>();
        String SQL = "";
        try {
          if(numero==-1 && anyo==-1){
                SQL="select * from ciclo c where c.activo = 1";
                SQL = String.format(SQL);
            }else if(numero==0 && anyo==0){
                SQL="select * from ciclo";
                SQL = String.format(SQL);
            }else if(numero==0){
                SQL="select * from ciclo c where c.anyo =%d";
                SQL = String.format(SQL, anyo);
            }else if(numero==1||numero==2){
                SQL="select * from ciclo c where c.anyo =%d and c.numero=%d";
                SQL = String.format(SQL, anyo, numero);
            }
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado.add(ciclo(rs));
            }
        } catch (Exception e) {
        }
         return resultado;
    }
    
    @Override
    public Ciclo search_CIC_ACTUAL() {
        Ciclo resultado = new Ciclo();
        String SQL = "";
        try {
          
                SQL="select * from ciclo c where c.activo = 1";
                SQL = String.format(SQL);
            
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado = ciclo(rs);
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    @Override
    public void update(Ciclo ciclo) throws Exception {
        int count;
        String SQL1="update ciclo set activo=0 where numero=1 or numero =2";
        String SQL2= "update ciclo set activo=1 where fecha_inicio='%s'";
        count = database.executeUpdate(SQL1);
        if(count==0){
            throw new Exception("ciclo no existe");
        }
        SQL2= String.format(SQL2, ciclo.getFechaInicio());
        count= database.executeUpdate(SQL2);
        if(count==0){
            throw new Exception("ciclo no existe");
        }
    }

    @Override
    public List<Curso> ofertaAcad(String carrera, int ciclo) {
        List<Curso> resultado = new ArrayList<Curso>();
        
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
        System.out.println(c);
        String SQL="insert into curso (codigo,nombre,creditos,horas_semanales,ciclo,carrera_codigo)"
                + " values('%s','%s',%d,%d,%d,'%s')";
        SQL=String.format(SQL,c.getCodigo(),c.getNombre(),c.getCreditos(),c.getHorasSemanales(),c.getCiclo().getNumero()
                ,c.getCarrera().getCodigo());
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
                + "values(%d,%d,'%s','%s',%b)";
        SQL=String.format(SQL,c.getNumero(),c.getAnyo(),c.getFechaInicio(),c.getFechaFin(),c.isActivo());
        int count= database.executeUpdate(SQL);
        if(count==0){
            throw new Exception("Ciclo ya existente");
        }
    }    

    @Override
    public String login(int ced,String clave) {
        String usuario = "nulo";
        try{
            String SQL="select tipo from usuario u where u.cedula =%d and u.contrasena ='%s'";
            SQL=String.format(SQL,ced,clave);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                String type=rs.getString("tipo");
                if(type!=null) usuario=type;
            }
        }catch(Exception e){}
        return usuario;
    }

    @Override
    public Usuario logout(int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    @Override
    public ArrayList<String> search_HIST(int estudiante) {
        ArrayList<String> historial = new ArrayList<String>();        
        try{
            String SQL= "select curso.nombre,nota.nota from curso,grupo,nota where curso.codigo=grupo.curso and grupo.numero_grupo=nota.numero_grupo and nota.ced=%d";   //REVISAR ESTO!!!
            SQL= String.format(SQL,estudiante);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                historial.add(historial(rs));
            }
        }catch(SQLException ex){}
        return historial;
    }
    
    private String historial(ResultSet rs) throws SQLException{
        String linea;
        String nombre_curso=rs.getString("nombre");
        String nota=rs.getString("nota");
        if(nota.equals("-1")) linea=nombre_curso+" en progreso";
        else linea=nombre_curso+" "+nota;
        return linea;
    }
    
    @Override
    public ArrayList<String> search_NOTAS(int grupo) {
        ArrayList<String> notas = new ArrayList<String>();        
        try{
            String SQL= "select * from nota n where n.numero_grupo like %d";   //REVISAR ESTO!!!
            SQL= String.format(SQL,grupo);
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                notas.add(nota(rs));
            }
        }catch(SQLException ex){}
        return notas;
    }
    
    //String cadena = "texto de que quieras";
   // String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
   // String[] palabrasSeparadas = cadena.split(delimitadores);

    private String nota(ResultSet rs) throws SQLException{
        String rubro;
        String ced=rs.getString("ced");
        String nota=rs.getString("nota");
        if(nota.equals("-1")) rubro=ced+" Sin Asignar";
        else rubro=ced+" "+nota;
        return rubro;
    }

    @Override
    public Usuario search_USU(int cedula) {
        Usuario resultado = new Usuario();
        String SQL = "";
        try {
          
                SQL="select * from usuario u where u.cedula = %d";
                SQL = String.format(SQL,cedula);
            
            ResultSet rs = database.executeQuery(SQL);
            while(rs.next()){
                resultado = usuario(rs);
            }
        } catch (Exception e) {
        }
         return resultado;
    }

    private Usuario usuario(ResultSet rs) throws SQLException{
            Usuario e = new Usuario();
        
        e.setClave(rs.getString("clave"));
        e.setCedula(rs.getInt("cedula"));
        e.setTipo(rs.getString("tipo"));
       
        return e;
    }
    
    @Override
    public void delete(Usuario u) {
        String SQL="delete from usuario where cedula=%d";     
        SQL = String.format(SQL, u.getCedula());
        int count= database.executeUpdate(SQL);
        if(count==0){
            try {
                throw new Exception("Usuario no existe");
            } catch (Exception ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    @Override
    public void ADD_USU(Usuario u) {
        String SQL="insert into usuario (cedula,contrasena,tipo)"
                + "values(%d,'%s','%s')";
        SQL=String.format(SQL,u.getCedula(),u.getClave(),u.getTipo());
        int count= database.executeUpdate(SQL);
        if(count==0){
            try {
                throw new Exception("Usuario ya existente");
            } catch (Exception ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    