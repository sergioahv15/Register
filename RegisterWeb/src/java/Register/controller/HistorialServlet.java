/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Estudiante;
import Register.IModel;
import Register.model.ModelProxy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio
 */
public class HistorialServlet extends HttpServlet {

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
            
            if(request.getParameter("getHistorial") != null){
                Integer ced_est = (Integer) request.getSession().getAttribute("idUsuario");
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
        
            if(request.getParameter("getHistorial") != null){
                Integer ced_est = (Integer) request.getSession().getAttribute("idUsuario");
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
