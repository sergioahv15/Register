/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.controller;

import Register.Entities.Carrera;
import Register.Entities.Curso;
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
public class CarrerasServlet extends HttpServlet {

    Carrera CARRERA_CURRENT;
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
            
            String nombre=request.getParameter("nombre");
            String codigo=request.getParameter("codigo");
                        
            List<Carrera> carreras = model.search_CAR(nombre, codigo);            
            
            request.setAttribute("carreras", carreras);
            request.getRequestDispatcher("Carreras.jsp").forward(request, response);
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
        int anyoCurrent = 2017;
        
        if(request.getParameter("mantCarreras") != null){
            request.getRequestDispatcher("Carreras.jsp").forward(request, response);
        }
        
        if (request.getParameter("carrera") != null) {
            String codigo = request.getParameter("carrera");
            CARRERA_CURRENT = model.search_CAR(codigo, "").get(0);
            List<Curso> cursosCarrera = model.search_CUR("","", codigo);
            request.setAttribute("cursosCarrera", cursosCarrera);
            request.getRequestDispatcher("CursosCarrera.jsp").forward(request, response);
        }     
        
        if (request.getParameter("curso") != null) {
            String codigo = request.getParameter("curso");
            if(request.getParameter("btnEditar") != null){                
                Curso cursoCarrera = model.search_CUR("",codigo,"Todas").get(0);
                request.setAttribute("curso", cursoCarrera);
                request.setAttribute("modo","2");
                request.setAttribute("readonly", "readonly");
                request.getRequestDispatcher("Carrera.jsp").forward(request, response);
            }else if(request.getParameter("btnEliminar") != null){
                Curso cursoCarrera = model.search_CUR("",codigo,"Todas").get(0);                
                try{
                    model.delete(cursoCarrera);
                    List<Curso> cursosCarrera = model.search_CUR("","", CARRERA_CURRENT.getNombre());
                    request.setAttribute("cursosCarrera", cursosCarrera);
                    request.getRequestDispatcher("CursosCarrera.jsp").forward(request, response);
                }catch(Exception ex){
                    
                }
            }
        }
        
        if(request.getParameter("btnAgregar") != null){     
            request.setAttribute("modo","1");
            request.getRequestDispatcher("Carrera.jsp").forward(request, response);
        }
        
        
        if (request.getParameter("modo") != null) {
            int modo = Integer.parseInt(request.getParameter("modo"));
            if(modo == 1){            
                try {
                    Curso nuevo = new Curso();
                    nuevo.setCodigo(request.getParameter("codigo"));
                    nuevo.setNombre(request.getParameter("nombre"));
                    
                    nuevo.setCarrera(model.search_CAR(CARRERA_CURRENT.getNombre(),"").get(0));
                    
                    nuevo.setCreditos(Integer.parseInt(request.getParameter("creditos")));
                    nuevo.setHorasSemanales(Integer.parseInt(request.getParameter("horas")));
                    
                    int ciclo = Integer.parseInt(request.getParameter("ciclo"));
                    nuevo.setCiclo(model.search_CIC(anyoCurrent,ciclo).get(0));

                    model.Add_CUR(nuevo);
                    List<Curso> cursosCarrera = model.search_CUR("","", CARRERA_CURRENT.getNombre());
                    request.setAttribute("cursosCarrera", cursosCarrera);
                    request.getRequestDispatcher("CursosCarrera.jsp").forward(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else if(modo == 2){
                try {
                    Curso nuevo = new Curso();
                    nuevo.setCodigo(request.getParameter("codigo"));
                    nuevo.setNombre(request.getParameter("nombre"));
                    
                    nuevo.setCarrera(model.search_CAR(CARRERA_CURRENT.getNombre(),"").get(0));
                    
                    nuevo.setCreditos(Integer.parseInt(request.getParameter("creditos")));
                    nuevo.setHorasSemanales(Integer.parseInt(request.getParameter("horas")));
                    
                    int ciclo = Integer.parseInt(request.getParameter("ciclo"));
                    nuevo.setCiclo(model.search_CIC(anyoCurrent,ciclo).get(0));

                    model.update(nuevo);
                    List<Curso> cursosCarrera = model.search_CUR("","", CARRERA_CURRENT.getNombre());
                    request.setAttribute("cursosCarrera", cursosCarrera);
                    request.getRequestDispatcher("CursosCarrera.jsp").forward(request, response);
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
