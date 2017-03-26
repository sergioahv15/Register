/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Carrera;
import Register.Entities.Ciclo;
import Register.IModel;
import Register.model.ModelProxy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio
 */
public class CiclosServlet extends HttpServlet {

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
            
            if(request.getParameter("mantCiclos") != null){
                request.getRequestDispatcher("Ciclos.jsp").forward(request, response);
            }else{            
                int anyo = Integer.parseInt(request.getParameter("anyo"));

                List<Ciclo> ciclos = model.search_CIC(anyo,0);

                request.setAttribute("ciclos", ciclos);
                request.getRequestDispatcher("Ciclos.jsp").forward(request, response);
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
        
        if(request.getParameter("mantCiclos") != null){
            request.getRequestDispatcher("Ciclos.jsp").forward(request, response);
        }
        if(request.getParameter("anyo") != null){
            try{
                int anyo = Integer.parseInt(request.getParameter("anyo"));
                int num = Integer.parseInt(request.getParameter("numero"));
                Ciclo seleccionado = model.search_CIC(anyo, num).get(0);

                model.update(seleccionado);
                List<Ciclo> ciclos = model.search_CIC(anyo,0);            
                request.setAttribute("ciclos", ciclos);                    
                request.getRequestDispatcher("Ciclos.jsp").forward(request, response);
            }catch(Exception e){
                
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
