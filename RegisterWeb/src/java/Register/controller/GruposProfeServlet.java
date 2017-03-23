/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

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
public class GruposProfeServlet extends HttpServlet {

    Profesor PROFESOR_CURRENT;
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
        
        if(request.getParameter("regNotas") != null){
            List<Grupo> grupos = model.search_GRU_PRO(1);//********************************************OJO      ******************
            request.setAttribute("grupos", grupos);
            request.getRequestDispatcher("GruposProfe.jsp").forward(request, response);
        }
        
        if(request.getParameter("btnCalificaciones") != null){
            int num_grupo = Integer.parseInt(request.getParameter("grupo"));
            List<Grupo> grupos = model.search_GRU_PRO(1);//********************************************OJO      ******************
            for(Grupo g : grupos){
                if(g.getNumeroGrupo() == num_grupo) GRUPO_CURRENT = g;
            }
            List<String> notas = model.search_NOTAS(num_grupo);
            List<String> estudiantes = new ArrayList();
            List<String> notas_est = new ArrayList();
            String delimitador = " ";
            for(String nota:notas){
                String[] nota_format = nota.split(delimitador);
                estudiantes.add(nota_format[0]);
                if(nota_format.length==3)notas_est.add(nota_format[1]+" "+nota_format[2]);
                else notas_est.add(nota_format[1]);
            }
            request.setAttribute("estudiantes", estudiantes);
            request.setAttribute("notas", notas_est);
            request.getRequestDispatcher("Notas.jsp").forward(request, response);
        }
        
        if(request.getParameter("btnAsignarNota") != null){
            int cedula = Integer.parseInt(request.getParameter("estudiante"));
            int nota;
            String nota_str = request.getParameter("nota");
            if(nota_str.equals("Sin Asignar")) nota=0;
            else nota = Integer.parseInt(request.getParameter("nota"));
            Estudiante estudiante = model.search_EST("", cedula, "Todas").get(0);
            request.setAttribute("estudianteCurrent", estudiante);
            request.setAttribute("nota", nota);
            request.getRequestDispatcher("Nota.jsp").forward(request, response);            
        }
        
        if(request.getParameter("btnGuardar") != null){
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nota_str = request.getParameter("nota");
            int nota_est = -1;
            if(!nota_str.equals("")) nota_est = Integer.parseInt(request.getParameter("nota")); 
            try {
                model.updateNota(GRUPO_CURRENT.getNumeroGrupo(), cedula, nota_est);
                List<String> notas = model.search_NOTAS(GRUPO_CURRENT.getNumeroGrupo());
                List<String> estudiantes = new ArrayList();
                List<String> notas_est = new ArrayList();
                String delimitador = " ";
                for(String nota:notas){
                    String[] nota_format = nota.split(delimitador);
                    estudiantes.add(nota_format[0]);
                    if(nota_format.length==3)notas_est.add(nota_format[1]+" "+nota_format[2]);
                    else notas_est.add(nota_format[1]);
                }
                request.setAttribute("estudiantes", estudiantes);
                request.setAttribute("notas", notas_est);
                request.getRequestDispatcher("Notas.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(GruposProfeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
