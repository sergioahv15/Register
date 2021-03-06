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
        <title>Seguridad</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="js/Script.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="fragments/NavBar_Menu.jspf" %>
            <h1 class="text-center">MANTENIMIENTO DE ADMINISTRADORES Y MATRICULADORES</h1>            
            <br/><br/>
            
            <center>
                <form action="SeguridadServlet" method="post"><button name="btnAgregar" class="btn btn-success" type="submit">Agregar Usuario</button></form>
            </center>
            
            <br/><br/>
            
            <div class="text-center">
                <form name="form1" class="form-inline" action="SeguridadServlet">
                    <div class="form-group">
                        <label for="cedula">Cedula:</label>
                        <input type="number" class="form-control" name="cedula" id="cedula">
                    </div>  
                    <div class="form-group">
                        <label for="tipo">Tipo:</label>
                        <select class="form-control" name="tipo" id="tipo">
                            <option selected="selected">Administrador</option>
                            <option>Matriculador</option>
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
                      <th>Cedula</th>
                      <th>Tipo</th>
                      <th class="text-center">Mantenimiento</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${usuarios}" var="item">
                      <tr>
                        <td><c:out value="${item.getCedula()}" /></td>
                        <td><c:out value="${item.getTipo()}" /></td>
                        <td class="text-center"><form action="SeguridadServlet?usuario=${item.getCedula()}" method="post">
                            <button name="btnEditar" class="btn btn-info" type="submit">Editar Usuario</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>
