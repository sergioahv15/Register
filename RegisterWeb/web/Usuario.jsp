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
        <title>Editar Usuario</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="js/Script.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="fragments/NavBar_Menu.jspf" %>
            <h1 class="text-center">EDITAR USUARIO</h1>            
            <br/><br/>       
            
            <div class="container"> 
                <form  display="inline-block" action="SeguridadServlet?modo=<c:out value="${modo}" />" method="post">                    
                    <div class="form-group">
                        <label for="cedula">Cedula:</label>
                        <input value="<c:out value="${usuarioCurrent.getCedula()}" />" type="number" class="form-control" name="cedula" id="cedula" <c:out value="${readonly}" /> required>
                    </div>
                    
                    <div class="form-group">
                        <label for="contra">Contraseña:</label>
                        <input value="<c:out value="${usuarioCurrent.getClave()}" />" type="text" class="form-control" name="contra" id="contra">
                    </div>
                     
                    <div class="form-group">
                        <label for="tipo">Tipo:</label>
                        <select class="form-control" name="tipo" id="tipo">
                            <c:choose>
                                <c:when test="${usuarioCurrent.getTipo().equals('administrador')}">
                                    <option selected="selected">Administrador</option>
                                    <option>Matriculador</option>
                                </c:when>    
                                <c:otherwise>
                                    <option selected="selected">Matriculador</option>
                                    <option>Administrador</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                    
                    <center>
                        <div class="form-group">
                            <button type="submit" name="btnGuardar" class="btn btn-success">Guardar</button>
                            <button type="submit" name="btnCancelar" class="btn btn-danger">Cancelar</button>
                        </div>
                    </center>
                    
                </form>
            </div>
        </div>
    </body>
</html>



