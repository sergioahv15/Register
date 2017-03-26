/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.Entities.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herrera
 */
public interface IModel {
      public void Add_CUR(Curso c) throws Exception;
      public List<Curso> search_CUR(String nombre, String codigo, String carrera);
      public List<Curso> search_CUR(String carrera, int ciclo);
      public void update(Curso curso)throws Exception;
      public void delete(Curso curso) throws Exception;
      
      public void Add_CAR(Carrera c) throws Exception;
      public List<Carrera> search_CAR(String nombre, String codigo);
      public void update(Carrera carrera)throws Exception;
      
      public void Add_PRO(Profesor p) throws Exception;
      public List<Profesor> search_PRO(String nombre, int ced);
      public void update(Profesor profe)throws Exception;
      
      public void Add_EST(Estudiante c) throws Exception;
      public List<Estudiante> search_EST(String nombre, int ced , String carrera);
      public void update(Estudiante estu)throws Exception;
            
      public void Add_CIC(Ciclo c) throws Exception;
      public List<Ciclo> search_CIC(int annio,int numero);
      public Ciclo search_CIC_ACTUAL();
      public void update(Ciclo ciclo)throws Exception;
      
      public void Add_GRU(Grupo grupo) throws Exception;
      public List<Grupo> search_GRU(String curso, String carrera);
      public List<Grupo> search_GRU(int estudiante);
      public List<Grupo> search_GRU(int ciclo, String carrera);
      public List<Grupo> search_GRU_PRO(int profesor);
      public void update(Grupo grupo)throws Exception;
      public void delete(int grupo, int estudiante) throws Exception;
      public void matricular(int grupo, int estudiante) throws Exception;
      
      public ArrayList<String> search_NOTAS(int grupo);
      public void updateNota(int grupo,int estudiante, int nota)throws Exception;
      public ArrayList<String> search_HIST(int estudiante);
      
      
      public List<Curso> ofertaAcad(String carrera, int ciclo);
      
      public Usuario search_USU(int cedula);
      public List<Usuario> search_ADM_MAT(int cedula,String tipo);
      public void update_USU(Usuario u);
      public void delete(Usuario u);
      public void ADD_USU(Usuario u);
      
      
      public String login (int ced,String clave);
      public Usuario logout(int ced);
      
      public List<Curso> search_HIS_ACT(int ced);     

      public void close();

}
