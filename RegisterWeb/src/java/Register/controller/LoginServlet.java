/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Usuario;
import Register.IModel;
import Register.model.ModelProxy;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.Alert;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fabio
 */
public class LoginServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        Usuario ACTIVE_USER = null;
        IModel model = new ModelProxy();
        int usuario = Integer.parseInt(request.getParameter("usuario"));
        String pass = request.getParameter("password");
        String tipo = model.login(usuario, pass);
        if(!tipo.equals("nulo")){
            HttpSession session=request.getSession(true);
            session.setAttribute("loginStatus", "login");
            switch(tipo){
                case "profesor":
                    ACTIVE_USER = model.search_PRO("", usuario).get(0);
                    session.setAttribute("usuario", ACTIVE_USER);
                    session.setAttribute("idUsuario",ACTIVE_USER.getCedula());                            
                    session.setAttribute("tipo", "Profesor");
                    System.out.println("LOGIN EXITOSO PROFESOR");                   
                break;
                case "estudiante":
                    ACTIVE_USER = model.search_EST("", usuario,"Todas").get(0);
                    session.setAttribute("usuario", ACTIVE_USER);
                    session.setAttribute("idUsuario",ACTIVE_USER.getCedula());                            
                    session.setAttribute("tipo", "Estudiante"); 
                    System.out.println("LOGIN EXITOSO ESTUDIANTE");                                  
                break;
                case "matriculador":
                    ACTIVE_USER = new Usuario("",0,"matriculador");
                    session.setAttribute("usuario", ACTIVE_USER);
                    session.setAttribute("idUsuario",ACTIVE_USER.getCedula());                            
                    session.setAttribute("tipo", "Matriculador"); 
                    System.out.println("LOGIN EXITOSO MATRICULADOR");                    
                break;
                case "administrador":
                    ACTIVE_USER = new Usuario("",0,"administrador");
                    session.setAttribute("usuario", ACTIVE_USER);
                    session.setAttribute("idUsuario",ACTIVE_USER.getCedula());                            
                    session.setAttribute("tipo", "Administrador"); 
                    System.out.println("LOGIN EXITOSO ADMINISTRADOR");
                break;
                case "nulo":
                    System.out.println("LOGIN FALLIDO - NULO");
                break;
            }
            request.getRequestDispatcher("Menu.jsp").forward(request, response);
        } else{
            HttpSession session=request.getSession(false);
            
           // response.sendError(0, "Usuario o contraseña incorrectas");
            //response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
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
