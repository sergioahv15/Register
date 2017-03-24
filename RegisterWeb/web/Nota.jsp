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
        <title>Registro de Notas</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">CALIFICAR ESTUDIANTE</h1>            
            <br/><br/>       
            
            <div class="container"> 
                <form  display="inline-block" action="GruposProfeServlet" method="post">                    
                    <div class="form-group">
                        <label for="cedula">Cedula:</label>
                        <input value="<c:out value="${estudianteCurrent.getCedula()}" />" type="number" class="form-control" name="cedula" id="cedula" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input value="<c:out value="${estudianteCurrent.getNombre()}" />" type="text" class="form-control" name="nombre" id="nombre" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nota">Nota:</label>
                        <input value="<c:out value="${nota}" />" type="number" class="form-control" name="nota" id="nota">
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