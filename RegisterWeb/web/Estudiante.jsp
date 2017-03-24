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
        <title>Editar Estudiante</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">EDITAR ESTUDIANTE</h1>            
            <br/><br/>       
            
            <div class="container"> 
                <form  display="inline-block" action="EstudiantesServlet?modo=<c:out value="${modo}" />" method="post">                    
                    <div class="form-group">
                        <label for="cedula">Cedula:</label>
                        <input value="<c:out value="${estudianteCurrent.getCedula()}" />" type="number" class="form-control" name="cedula" id="cedula" <c:out value="${readonly}" />>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input value="<c:out value="${estudianteCurrent.getNombre()}" />" type="text" class="form-control" name="nombre" id="nombre">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono:</label>
                        <input value="<c:out value="${estudianteCurrent.getTel()}" />" type="number" class="form-control" name="telefono" id="telefono">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input value="<c:out value="${estudianteCurrent.getEmail()}" />" type="text" class="form-control" name="email" id="email">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Fecha de Nacimiento:</label>
                        <input value="<c:out value="${estudianteCurrent.getFechaNac()}" />" type="text" class="form-control" name="fechaNac" id="fechaNac">
                    </div>
                    <div class="form-group">
                        <label for="carrera">Carrera:</label>
                        <select class="form-control" name="carrera" id="carrera">
                            <c:forEach items="${carreras}" var="item">
                                <option
                                    <c:if test="${item.getNombre().equals(estudianteCurrent.getCarrera().getNombre())}">
                                        selected="selected"
                                    </c:if>
                                    ><c:out value="${item.getNombre()}" />                                
                                </option>
                            </c:forEach>
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


