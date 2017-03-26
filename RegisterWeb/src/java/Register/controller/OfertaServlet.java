/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Carrera;
import Register.Entities.Curso;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.IModel;
import Register.model.ModelProxy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio
 */
public class OfertaServlet extends HttpServlet {

    Carrera CARRERA_CURRENT;
    Curso CURSO_CURRENT;
    Grupo GRUPO_CURRENT;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            IModel model = new ModelProxy();            
            
            if(request.getParameter("oferta") != null){
                List<Carrera> carreras = model.search_CAR("","");
                request.setAttribute("carreras", carreras);
                request.getRequestDispatcher("OfertaAcademica.jsp").forward(request, response);
            }else{
                String carrera = request.getParameter("carrera");           

                int ciclo = Integer.parseInt(request.getParameter("ciclo"));

                List<Curso> cursos = model.search_CUR(carrera,ciclo);
                List<Carrera> carreras = model.search_CAR("","");

                request.setAttribute("cursos", cursos);
                request.setAttribute("carreras", carreras);
                request.getRequestDispatcher("OfertaAcademica.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        IModel model = new ModelProxy();
        
        if(request.getParameter("oferta") != null){
            List<Carrera> carreras = model.search_CAR("","");
            request.setAttribute("carreras", carreras);
            request.getRequestDispatcher("OfertaAcademica.jsp").forward(request, response);
        }
        
        if(request.getParameter("curso") != null){
            String cod_curso = request.getParameter("curso");
            
            CURSO_CURRENT = model.search_CUR("", cod_curso, "Todas").get(0);
            CARRERA_CURRENT = model.search_CAR("", CURSO_CURRENT.getCarrera().getCodigo()).get(0);
            
            List<Grupo> grupos = model.search_GRU(cod_curso, "");
            request.setAttribute("grupos", grupos);
            request.getRequestDispatcher("Grupos.jsp").forward(request, response);
        }
        
        if (request.getParameter("grupo") != null) {
            int num_grupo = Integer.parseInt(request.getParameter("grupo"));
            if(request.getParameter("btnEditar") != null){                
                List<Grupo> grupos = model.search_GRU("", CARRERA_CURRENT.getCodigo());
                System.out.println(grupos.toString());
                Grupo grupoCurrent = null;
                for(Grupo g : grupos){
                    if(g.getNumeroGrupo()==num_grupo)grupoCurrent = g;
                }
                GRUPO_CURRENT = grupoCurrent;
                String dia1 = "";
                String dia2 = "";
                String horaIni = grupoCurrent.getHoraInicio();
                String horaFin = grupoCurrent.getHoraFin();
                if(grupoCurrent.isLunes()){
                    dia1="Lunes";
                }else if(grupoCurrent.isMartes()){
                    dia1="Martes";
                }else if(grupoCurrent.isMiercoles()){
                    dia1="Miercoles";
                }else if(grupoCurrent.isJueves()){
                    dia1="Jueves";
                }else if(grupoCurrent.isViernes()){
                    dia1="Viernes";
                }
                
                if(grupoCurrent.isLunes() && !(dia1.equals("Lunes"))){
                    dia2="Lunes";
                }else if(grupoCurrent.isMartes() && !(dia1.equals("Martes"))){
                    dia2="Martes";
                }else if(grupoCurrent.isMiercoles() && !(dia1.equals("Miercoles"))){
                    dia2="Miercoles";
                }else if(grupoCurrent.isJueves() && !(dia1.equals("Jueves"))){
                    dia2="Jueves";
                }else if(grupoCurrent.isViernes() && !(dia1.equals("Viernes"))){
                    dia2="Viernes";
                }                
                
                List<Profesor> profes = model.search_PRO("", 0);
                
                request.setAttribute("horaIni", horaIni);
                request.setAttribute("horaFin", horaFin);
                request.setAttribute("dia1", dia1);
                request.setAttribute("dia2", dia2);
                request.setAttribute("profes", profes);
                request.setAttribute("modo","2");
                request.setAttribute("readonly", "readonly");
                request.getRequestDispatcher("Grupo.jsp").forward(request, response);
            }
        }
        
        if(request.getParameter("btnAgregar") != null){     
            request.setAttribute("modo","1");
            List<Profesor> profes = model.search_PRO("", 0); 
            request.setAttribute("profes", profes);
            request.getRequestDispatcher("Grupo.jsp").forward(request, response);
        }
        
        
        if (request.getParameter("modo") != null) {
            int modo = Integer.parseInt(request.getParameter("modo"));
            Grupo nuevo = new Grupo();
            nuevo.setProfesor(model.search_PRO(request.getParameter("profesor"), 0).get(0));

            nuevo.setCurso(model.search_CUR("",CURSO_CURRENT.getCodigo(),"Todas").get(0));

            nuevo.setHoraInicio(request.getParameter("horaIni"));
            nuevo.setHoraFin(request.getParameter("horaFin"));

            String dia1 = request.getParameter("dia1");
            String dia2 = request.getParameter("dia2");

            if(dia1.equals("Lunes")) nuevo.setLunes(true);
            else if(dia1.equals("Martes")) nuevo.setMartes(true);
            else if(dia1.equals("Miercoles")) nuevo.setMiercoles(true);
            else if(dia1.equals("Jueves")) nuevo.setJueves(true);
            else if(dia1.equals("Viernes")) nuevo.setViernes(true);

            if(!dia1.equals("Lunes") && dia2.equals("Lunes")) nuevo.setLunes(true);
            else if(!dia1.equals("Martes") && dia2.equals("Martes")) nuevo.setMartes(true);
            else if(!dia1.equals("Miercoles") && dia2.equals("Miercoles")) nuevo.setMiercoles(true);
            else if(!dia1.equals("Jueves") && dia2.equals("Jueves")) nuevo.setJueves(true);
            else if(!dia1.equals("Viernes") && dia2.equals("Viernes")) nuevo.setViernes(true);
            if(modo == 1){            
                try {           
                    model.Add_GRU(nuevo);
                    List<Grupo> grupos = model.search_GRU(CURSO_CURRENT.getCodigo(), "");
                    request.setAttribute("grupos", grupos);
                    request.getRequestDispatcher("Grupos.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(modo == 2){
                try {
                    nuevo.setNumeroGrupo(GRUPO_CURRENT.getNumeroGrupo());
                    model.update(nuevo);
                    List<Grupo> grupos = model.search_GRU(CURSO_CURRENT.getCodigo(), "");
                    request.setAttribute("grupos", grupos);
                    request.getRequestDispatcher("Grupos.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }        
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
