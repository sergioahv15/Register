<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%

    HttpSession sesion = request.getSession(true);
    String tipoUsuario = "";
    if(sesion!=null){
        if (sesion.getAttribute("usuario")  == null) {
            response.sendRedirect("LoginJSP.jsp");
        }else{
            tipoUsuario = (String)sesion.getAttribute("tipo");
        }
    }else{
        response.sendRedirect("Login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta Academica</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">OFERTA ACADEMICA</h1>            
            <br/><br/>
            
            <div class="text-center">
                <form class="form-inline" action="OfertaServlet">                    
                    <div class="form-group">
                        <label for="carrera">Carrera:</label>
                        <select class="form-control" name="carrera" id="carrera">
                            <option selected="selected">Todas</option>
                            <c:forEach items="${carreras}" var="item">
                                <option><c:out value="${item.getNombre()}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="ciclo">Ciclo:</label>
                        <select class="form-control" name="ciclo" id="ciclo">
                            <option selected="selected">1</option>
                            <option>2</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </div>                      
                </form>
            </div>            
            <br/><br/>           
            <div class="container">     
                <table class="table table-bordered">
                    <thead>
                    <tr>
                      <th>Codigo</th>
                      <th>Nombre</th>
                      <th>Carrera</th>
                      <th>Creditos</th>
                      <th>Horas Semanales</th>
                      <th class="text-center">Mantenimiento</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${cursos}" var="item">
                      <tr>
                        <td><c:out value="${item.getCodigo()}" /></td>
                        <td><c:out value="${item.getNombre()}" /></td>
                        <td><c:out value="${item.getCarrera().getNombre()}" /></td>
                        <td><c:out value="${item.getCreditos()}" /></td>
                        <td><c:out value="${item.getHorasSemanales()}" /></td>
                        <td class="text-center"><form action="OfertaServlet?curso=${item.getCodigo()}" method="post"><button name="btnVerGrupos" class="btn btn-success" type="submit">Ver Grupos</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>
