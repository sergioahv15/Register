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
            <h1 class="text-center">CURSOS MATRICULADOS POR ESTUDIANTE</h1>            
            <br/><br/>        
            
            <center>
                <form action="EstudiantesServlet" method="post"><button name="btnMatricularCursos" class="btn btn-success" type="submit">Matricular Cursos</button></form>
            </center>
            
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
                            <button name="btnDesmatricular" class="btn btn-danger" type="submit">Eliminar Curso</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>