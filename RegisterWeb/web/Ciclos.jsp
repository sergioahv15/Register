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
        <title>Mantenimiento de Ciclos</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">MANTENIMIENTO DE CICLOS</h1>            
            <br/>            
            <div class="text-center">
                <form class="form-inline" action="CiclosServlet">
                    <div class="form-group">
                        <label for="anyo">Anyo</label>
                        <select class="form-control" name="anyo" id="anyo">
                            <option selected="selected">2017</option>
                            <option>2018</option>
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
                      <th>Anyo</th>
                      <th>Numero</th>
                      <th>Fecha Inicio</th>
                      <th>Fecha Fin</th>
                      <th class="text-center">Estado</th>
                      <th class="text-center">Activar</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${ciclos}" var="item">
                      <tr>
                        <td><c:out value="${item.getAnyo()}" /></td>
                        <td><c:out value="${item.getNumero()}" /></td>
                        <td><c:out value="${item.getFechaInicio()}" /></td>
                        <td><c:out value="${item.getFechaFin()}" /></td>
                        <td class="text-center">
                            <c:choose>
                                <c:when test="${item.isActivo()}">
                                    Activo <span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
                                </c:when>    
                                <c:otherwise>
                                    Inactivo
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td class="text-center"><form action="CiclosServlet?anyo=${item.getAnyo()}&numero=${item.getNumero()}" method="post">
                                <button name="btnActivar" class="btn btn-warning" type="submit">Activar</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>            
        </div>
    </body>
</html>
