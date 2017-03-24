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
        <title>Editar Carrera</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="js/Script.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">EDITAR CURSO</h1>            
            <br/><br/>       
            
            <div class="container"> 
                <form  display="inline-block" action="CarrerasServlet?modo=<c:out value="${modo}" />" method="post" onsubmit="return ValidarCurso();" required>                    
                    <div class="form-group">
                        <label for="codigo">Codigo:</label>
                        <input value="<c:out value="${curso.getCodigo()}" />" type="text" class="form-control" name="codigo" id="codigo" <c:out value="${readonly}" /> required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input value="<c:out value="${curso.getNombre()}" />" type="text" class="form-control" name="nombre" id="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="codigo">Creditos:</label>
                        <input value="<c:out value="${curso.getCreditos()}" />" type="number" class="form-control" name="creditos" id="creditos" required>
                    </div>
                    <div class="form-group">
                        <label for="horas">Horas Semanales:</label>
                        <input value="<c:out value="${curso.getHorasSemanales()}" />" type="number" class="form-control" name="horas" id="horas" required>
                    </div>
                     <div class="form-group">
                        <label for="ciclo">Ciclo:</label>
                        <select class="form-control" name="ciclo" id="ciclo">
                            <c:choose>
                                <c:when test="${curso.getCiclo().getNumero()==1}">
                                    <option selected="selected">1</option>
                                    <option>2</option>
                                </c:when>    
                                <c:otherwise>
                                    <option selected="selected">2</option>
                                    <option>1</option>
                                </c:otherwise>
                            </c:choose>
                            <!--<option selected="selected">1</option>
                            <option>2</option>-->
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

