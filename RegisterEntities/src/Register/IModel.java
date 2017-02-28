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
import java.util.List;

/**
 *
 * @author Herrera
 */
public interface IModel {
      public List<Curso> search_CUR_NOM(String nombre);
      public List<Curso> search_CUR_COD(String codigo);
      public List<Curso> search_CUR_CAR(Carrera carrera);
      public void update(Curso curso)throws Exception;
      
      public Carrera search_CAR_NOM(String nombre); 
      public Carrera search_CAR_COD(String codigo);
      public void update(Carrera carrera)throws Exception;
      
      public List<Profesor> search_PRO_NOM(String nombre);
      public List<Profesor> search_PRO_CED(int ced);
      public void update(Profesor profe)throws Exception;
      
      public List<Estudiante> search_EST_NOM(String nombre);
      public List<Estudiante> search_EST_CED(int ced);
      public List<Estudiante> search_EST_CAR(Carrera carrera);
      public void update(Estudiante estu)throws Exception;
      
      public List<Ciclo> search_CIC_ANYO(int annio);
      public void update(Ciclo ciclo)throws Exception;
      
      public List<Curso> ofertaAcad(Carrera carrera, Ciclo ciclo);
      public List<Grupo> search_GRU_COD(String cod);
      
      public List<Curso> search_HIS_ACT(int ced);
      public List<Grupo> search_GRU_PRO(int ced); 
      public List<Estudiante> search_EST_GRU(int numGrupo);
      
      public List<Curso> search_HIS_GLOB(int ced);

}
