/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Carrera;
import Register.Entities.Estudiante;
import Register.Entities.Grupo;
import Register.Entities.Profesor;
import Register.IModel;
import Register.model.ModelProxy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class EstudiantesServlet extends HttpServlet {

    Estudiante ESTUDIANTE_CURRENT;
    
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
            
            if(request.getParameter("mantEstudiantes") != null){
                List<Carrera> carreras = model.search_CAR("","");
                request.setAttribute("carreras", carreras);
                request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
            }else{            
                String nombre=request.getParameter("nombre");
                int cedula=0;
                String cedula_str = request.getParameter("cedula");            
                if(!cedula_str.equals("")) cedula = Integer.parseInt(cedula_str);

                String carrera = request.getParameter("carrera");

                List<Carrera> carreras = model.search_CAR("","");

                List<Estudiante> estudiantes = model.search_EST(nombre, cedula, carrera);            

                request.setAttribute("carreras", carreras);
                request.setAttribute("estudiantes", estudiantes);
                request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
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

        if(request.getParameter("mantEstudiantes") != null){
            List<Carrera> carreras = model.search_CAR("","");
            request.setAttribute("carreras", carreras);
            request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
        }
            
        
        if (request.getParameter("est") != null) {
            int cedula = Integer.parseInt(request.getParameter("est"));
            if(request.getParameter("btnEditar") != null){                
                List<Carrera> carreras = model.search_CAR("","");            
                Estudiante estudianteCurrent = model.search_EST("", cedula, "Todas").get(0);
                request.setAttribute("estudianteCurrent", estudianteCurrent);
                request.setAttribute("modo","2");
                request.setAttribute("readonly", "readonly");
                request.setAttribute("carreras", carreras);
                request.getRequestDispatcher("Estudiante.jsp").forward(request, response);
            }
            if(request.getParameter("btnMatricular") != null){                
                int cedula_est = Integer.parseInt(request.getParameter("est"));
                ESTUDIANTE_CURRENT = model.search_EST("", cedula_est, "Todas").get(0);
                List<Grupo> grupos = model.search_GRU(cedula_est);
                request.setAttribute("grupos", grupos);
                request.getRequestDispatcher("GruposMatriculados.jsp").forward(request, response);
            }
        }
        
        if(request.getParameter("btnMatricularCursos") != null){ 
            request.getRequestDispatcher("Matricula.jsp").forward(request, response);
        }  
        
        if(request.getParameter("btnConsultaHistorial") != null){
            int ced_est = Integer.parseInt(request.getParameter("est"));
            List<String> historial = model.search_HIST(ced_est);
            Estudiante estudianteCurrent = model.search_EST("", ced_est, "Todas").get(0);
            List<String> cursos = new ArrayList();
            List<String> historial_est = new ArrayList();
            String delimitador = " ";
            for(String h:historial){
                String[] nota_format = h.split(delimitador);
                cursos.add(nota_format[0]);
                if(nota_format.length==3)historial_est.add(nota_format[1]+" "+nota_format[2]);
                else historial_est.add(nota_format[1]);
            }
            request.setAttribute("estudianteCurrent", estudianteCurrent);
            request.setAttribute("cursos", cursos);
            request.setAttribute("historial", historial_est);
            request.getRequestDispatcher("Historial.jsp").forward(request, response);
        }
        
        if(request.getParameter("btnAgregarCurso") != null){ 
            int num_grupo = Integer.parseInt(request.getParameter("grupo"));
            try {
                model.matricular(num_grupo, ESTUDIANTE_CURRENT.getCedula());
                List<Grupo> grupos = model.search_GRU(ESTUDIANTE_CURRENT.getCedula());
                request.setAttribute("grupos", grupos);
                request.getRequestDispatcher("GruposMatriculados.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EstudiantesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if(request.getParameter("btnDesmatricular") != null){ 
            int num_grupo = Integer.parseInt(request.getParameter("grupo"));
            try {
                model.delete(num_grupo, ESTUDIANTE_CURRENT.getCedula());
                List<Grupo> grupos = model.search_GRU(ESTUDIANTE_CURRENT.getCedula());
                request.setAttribute("grupos", grupos);
                request.getRequestDispatcher("GruposMatriculados.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EstudiantesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if(request.getParameter("btnBuscarGrupos") != null){ 
            int ciclo = Integer.parseInt(request.getParameter("ciclo"));
            List<Grupo> grupos = model.search_GRU(ciclo, ESTUDIANTE_CURRENT.getCarrera().getCodigo());
            request.setAttribute("grupos", grupos);
            request.getRequestDispatcher("Matricula.jsp").forward(request, response);
        }  
        
        if(request.getParameter("btnAgregar") != null){     
            request.setAttribute("modo","1");
            List<Carrera> carreras = model.search_CAR("",""); 
            request.setAttribute("carreras", carreras);
            request.getRequestDispatcher("Estudiante.jsp").forward(request, response);
        }
        
        
        
        if (request.getParameter("modo") != null) {
            int modo = Integer.parseInt(request.getParameter("modo"));
            if(modo == 1){            
                try {
                    Estudiante nuevo = new Estudiante();
                    nuevo.setCedula(Integer.parseInt(request.getParameter("cedula")));
                    nuevo.setNombre(request.getParameter("nombre"));
                    nuevo.setTel(Integer.parseInt(request.getParameter("telefono")));
                    nuevo.setEmail(request.getParameter("email"));
                    nuevo.setFechaNac(request.getParameter("fechaNac"));
                    nuevo.setCarrera(model.search_CAR(request.getParameter("carrera"), "").get(0));
                    
                    model.Add_EST(nuevo);
                    List<Estudiante> estudiantes = model.search_EST("", 0, "Todas");
                    request.setAttribute("estudiantes", estudiantes);
                    List<Carrera> carreras = model.search_CAR("",""); 
                    request.setAttribute("carreras", carreras);
                    request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(ProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(modo == 2){
                try {
                    Estudiante nuevo = new Estudiante();
                    nuevo.setCedula(Integer.parseInt(request.getParameter("cedula")));
                    nuevo.setNombre(request.getParameter("nombre"));
                    nuevo.setTel(Integer.parseInt(request.getParameter("telefono")));
                    nuevo.setEmail(request.getParameter("email"));
                    nuevo.setFechaNac(request.getParameter("fechaNac"));
                    nuevo.setCarrera(model.search_CAR(request.getParameter("carrera"), "").get(0));
                    
                    model.update(nuevo);
                    List<Estudiante> estudiantes = model.search_EST("", 0, "Todas");
                    request.setAttribute("estudiantes", estudiantes);
                    List<Carrera> carreras = model.search_CAR("",""); 
                    request.setAttribute("carreras", carreras); 
                    request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(ProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
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
