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
        <title>Mantenimiento de Cursos</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="js/Script.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="fragments/NavBar_Menu.jspf" %>
            <h1 class="text-center">MANTENIMIENTO DE CURSOS</h1>            
            <br/>            
            <div class="text-center">
                <form name="form1" class="form-inline" action="CursosServlet" onsubmit="return ValidarCursoBusqueda();">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" id="nombre">
                    </div>
                     <div class="form-group">
                        <label for="codigo">Codigo:</label>
                        <input type="text" class="form-control" name="codigo" id="codigo">
                    </div>
                     <div class="form-group">
                        <label for="carrera">Carrera</label>
                        <select class="form-control" name="carrera" id="carrera">
                            <option selected="selected">Todas</option>
                            <c:forEach items="${carreras}" var="item">
                                <option><c:out value="${item.getNombre()}" /></option>
                            </c:forEach>
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
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>            
        </div>
    </body>
</html>
