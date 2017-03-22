/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.console.controller;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.Entities.Curso;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.Entities.Usuario;
import Register.IModel;
import Register.console.model.Model;
import Register.console.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herrera
 */
public class Controller {
    
     //HOLI FABIO
     IModel Logic;
     Model Model;
     View View;
     
    public Controller(IModel logic,Model model,View view) {
        this.View=view;
        this.Model=model;
        view.setController(this);
        view.setModel(model);
        this.Logic=logic;
    }
    

    
    
    public String login(int ced,String clave){
        String tipo=Logic.login(ced,clave);
        Usuario u = new Usuario(clave, ced, tipo);
        Model.setUsuario(u);
        Ciclo c= searchCicloActual();
        Model.setCiclo(c);
        return tipo;
        
    }
    
    public Ciclo searchCicloActual(){
        Ciclo c = Logic.search_CIC_ACTUAL();
        return c;
    }
    
    public void deleteCurso(String codCurso) throws Exception{
        Curso c = Logic.search_CUR("", codCurso, "Todas").get(0);
        Logic.delete(c);
    }
    
    public void updateCiclo(int numero, int anyo) throws Exception{
        Ciclo c = Logic.search_CIC(anyo, numero).get(0);
        Logic.update(c);
    }
    
    public void updateCarrera(String codigoCarrera,String nombre, String titulo) throws Exception{
        Carrera c = new Carrera(codigoCarrera, nombre, titulo);
        Logic.update(c);
    }
    
    public void addCiclo(Ciclo c) throws Exception{
         Logic.Add_CIC(c);
    }
    
    public void addCarrera(Carrera c) throws Exception{
        Logic.Add_CAR(c);
    }
    
    public List<Profesor> searchProfesores(int ced){
        List<Profesor> p = Logic.search_PRO("", ced);
        return p;
    }
    
    public List<Carrera> searchCarreras(String nombre, String codigo){
        List<Carrera> carreras=Logic.search_CAR(nombre,codigo);
        return carreras;
    }
    
    
    public List<Curso> searchCursos(String carrera, int ciclo) throws Exception{
        List<Curso> cursos=  Logic.search_CUR(carrera,ciclo);
       
        return cursos;
    }
    
    public List<Curso> searchCursos(String nombre,String codigo,String carrera) throws Exception{
        List<Curso> cursos=  Logic.search_CUR(nombre,codigo,carrera);
       
        return cursos;
    }
    
    public List<Ciclo> searchCiclos(int anyo, int numero) throws Exception{
        List<Ciclo> ciclos=  Logic.search_CIC(anyo,numero);
       
        return ciclos;
    }
    
    public List<Grupo> searchGrupos(int cedEstudiante){
        List<Grupo> grupos =  Logic.search_GRU(cedEstudiante);
        return grupos;
    }
    
    public List<Grupo> searchGruposPro(){
        int cedula= Model.getUsuario().getCedula();
        List<Grupo> grupos =  Logic.search_GRU_PRO(cedula);
        return grupos;
    }
    
    public List<String> searchNotas(int numGrupo){
        List<String> notas =  Logic.search_NOTAS(numGrupo);
        return notas;
    }
    
    public List<Grupo> searchOferta(int cedulaEstudiante){
        Ciclo ciclo = Logic.search_CIC(-1, -1).get(0);
        Estudiante estudiante = Logic.search_EST("", cedulaEstudiante, "Todas").get(0);
        Carrera carrera = estudiante.getCarrera();
        List<Grupo> grupos= Logic.search_GRU(ciclo.getNumero(), carrera.getCodigo());
        return grupos;
    }
    
    public void matricular(int grupo, int estudiante) throws Exception{
        Logic.matricular(grupo, estudiante);
    }
    
    public List<Profesor> searchProfesor(String nombre, int cedula){
        List<Profesor> profesores = Logic.search_PRO(nombre, cedula);
        return profesores;
    }
   
    /*public void agregarCursoACarrera(String codCarrera,String codCurso) throws Exception{
        Carrera c= searchCarrera("",codCarrera).get(0);
        Curso cu= searchCurso("",codCurso,"").get(0);
        cu.setCarrera(c);
        Logic.update(cu);
    }*/
    public void agregarCurso(Curso c,int anyoCiclo,int numeroCiclo,String codigoCarrera) throws Exception{
        Ciclo ciclo= Logic.search_CIC (anyoCiclo, numeroCiclo).get(0);
        Carrera carrera= Logic.search_CAR("", codigoCarrera).get(0);
        c.setCarrera(carrera);
        c.setCiclo(ciclo);
        Logic.Add_CUR(c);
    }
    
    public void agregarCursoACarrera(String codigoCurso,String codigoCarrera) throws Exception{
        Curso c = Logic.search_CUR("", codigoCurso,"Todas").get(0);
        c.getCarrera().setCodigo(codigoCarrera);
        Logic.update(c);
    }
    
     public void addProfesor(Profesor p) throws Exception{
         Logic.Add_PRO(p);
    }
     
     public void addEstudiante(Estudiante estu ,String codCarrera) throws Exception{
         Carrera c=Logic.search_CAR("", codCarrera).get(0);
         estu.setCarrera(c);
         Logic.Add_EST(estu);
     }
     
     public void addGrupo(Grupo grupo,int cedulaProf,String codigoCurso) throws Exception{
         Profesor p = Logic.search_PRO("", cedulaProf).get(0);
         grupo.setProfesor(p);
         Curso c= Logic.search_CUR("",codigoCurso,"Todas").get(0);
         grupo.setCurso(c);
         Logic.Add_GRU(grupo);
     }

     public Estudiante searchEstudianteCed(String nombre,int ced) throws Exception{
        Estudiante estudiante=  Logic.search_EST(nombre,ced,"").get(0);
       
        return estudiante;
    }
     
     public List<Estudiante> searchEstudiantes(String nombre,int ced, String carrera) throws Exception{
        List<Estudiante> estudiantes=  Logic.search_EST(nombre,ced,carrera);
       
        return estudiantes;
    }
     
     public List<String> searchHistorial(){
         
         List<String> notas= Logic.search_HIST(Model.getUsuario().getCedula());
         return notas;
     }
     
     public List<String> searchHistorial(int cedula){
         List<String> notas= Logic.search_HIST(cedula);
         return notas;
     }
     
     
    public List<Curso> ofertaAcademica(String codigoCarrera,int numCiclo){
        List<Curso> cursos = Logic.search_CUR(codigoCarrera,numCiclo);
        return cursos;
    } 
     
    public void updateNota(int grupo, int estudiante, int nota) throws Exception{
        Logic.updateNota(grupo, estudiante, nota);
    }
    
    public void deleteUsuario(int cedula){
        Usuario u = Logic.search_USU(cedula);
        Logic.delete(u);
    }
    
    public void addUsuario(Usuario usuario){
        Logic.ADD_USU(usuario);
    }
}
