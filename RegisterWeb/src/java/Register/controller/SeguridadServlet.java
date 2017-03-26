/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Profesor;
import Register.Entities.Usuario;
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
public class SeguridadServlet extends HttpServlet {

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
            
            if(request.getParameter("seguridad") != null){
                request.getRequestDispatcher("Seguridad.jsp").forward(request, response);
            }else{
            int cedula=0;
                String cedula_str = request.getParameter("cedula");            
                if(!cedula_str.equals("")) cedula = Integer.parseInt(cedula_str);

                String tipo = request.getParameter("tipo");

                List<Usuario> usuarios = model.search_ADM_MAT(cedula,tipo);

                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("Seguridad.jsp").forward(request, response);
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
        
        if(request.getParameter("seguridad") != null){
            request.getRequestDispatcher("Seguridad.jsp").forward(request, response);
        }
        
        if (request.getParameter("usuario") != null) {
            int cedula = Integer.parseInt(request.getParameter("usuario"));
            if(request.getParameter("btnEditar") != null){                
                Usuario usuarioCurrent = model.search_USU(cedula);
                request.setAttribute("usuarioCurrent", usuarioCurrent);
                request.setAttribute("modo","2");
                request.setAttribute("readonly", "readonly");
                request.getRequestDispatcher("Usuario.jsp").forward(request, response);
            }
        }
        
        if(request.getParameter("btnAgregar") != null){     
            request.setAttribute("modo","1");
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        }
        
        if (request.getParameter("modo") != null) {
            int modo = Integer.parseInt(request.getParameter("modo"));
            if(modo == 1){            
                try {
                    Usuario nuevo = new Usuario();
                    nuevo.setCedula(Integer.parseInt(request.getParameter("cedula")));
                    nuevo.setClave(request.getParameter("contra"));
                    nuevo.setTipo(request.getParameter("tipo").toLowerCase());
                    
                    model.ADD_USU(nuevo);
                    List<Usuario> usuarios = model.search_ADM_MAT(0,"Administrador");                                              
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("Seguridad.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(ProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(modo == 2){
                try {
                    Usuario nuevo = new Usuario();
                    nuevo.setCedula(Integer.parseInt(request.getParameter("cedula")));
                    nuevo.setClave(request.getParameter("contra"));
                    nuevo.setTipo(request.getParameter("tipo").toLowerCase());
                    
                    model.update_USU(nuevo);
                    List<Usuario> usuarios = model.search_ADM_MAT(0,"Administrador");                                              
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("Seguridad.jsp").forward(request, response);
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
