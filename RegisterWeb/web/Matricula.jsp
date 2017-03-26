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
        <title>Matricular Cursos</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="fragments/NavBar_Menu.jspf" %>
            <h1 class="text-center">MATRICULAR GRUPOS</h1>            
            <br/>            
            <div class="text-center">
                <form class="form-inline" action="EstudiantesServlet" method="post">
                    <div class="form-group">
                        <label for="ciclo">Ciclo:</label>
                        <select class="form-control" name="ciclo" id="ciclo">
                            <option selected="selected">1</option>
                            <option>2</option>
                        </select>
                    </div>     
                     
                    <div class="form-group">
                        <button type="submit" name="btnBuscarGrupos" class="btn btn-primary">Buscar Grupos</button>
                    </div>
                </form>
            </div>            
            <br/><br/> 
            
            <div class="container"> 
                <table class="table table-bordered">
                    <thead>
                    <tr>
                      <th>Numero</th>
                      <th>Profesor</th>
                      <th>Horario</th>
                      <th class="text-center">Accion</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${grupos}" var="item">
                      <tr>
                        <td><c:out value="${item.getNumeroGrupo()}" /></td>
                        <td><c:out value="${item.getProfesor().getNombre()}" /></td>
                        <td><c:out value="${item.getHorario()}" /></td>
                        <td class="text-center"><form action="EstudiantesServlet?grupo=${item.getNumeroGrupo()}" method="post">
                            <button name="btnAgregarCurso" class="btn btn-danger" type="submit">Matricular</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>
