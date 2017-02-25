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
      public List<Curso> searchCursosDisp(Curso filtro);
      public void updateCurso(Curso curso)throws Exception;
      public Carrera getCarrera(String nombre, String codigo); // busqueda por nombre o codigo, dependiendo del parametro que se pase.
      public List<Profesor> getProfesor(String nombre, int ced);
      public void updateProfesor(Profesor profe)throws Exception;
      public List<Estudiante> getEstudiantes(String nombre,int ced, Carrera carrera);
      public List<Ciclo> getCiclos(int annio);
      public void updateCiclo(Ciclo ciclo)throws Exception;
      public void ofertaAcad(Carrera carrera, Ciclo ciclo);
      public List<Curso> searchCursosEstu(Estudiante estudiante);
      public List<Grupo> searchGruposProf(Profesor profe);
      public List<Estudiante> getEstuGrupo(Grupo grupo);
      

}
