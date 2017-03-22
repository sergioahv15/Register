<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Carrera</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">EDITAR CARRERA</h1>            
            <br/><br/>        
            
            <center>
                <form action="CarrerasServlet" method="post"><button name="btnAgregar" class="btn btn-success" type="submit">Agregar Curso</button></form>
            </center>
            
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
                      <c:forEach items="${cursosCarrera}" var="item">
                      <tr>
                        <td><c:out value="${item.getCodigo()}" /></td>
                        <td><c:out value="${item.getNombre()}" /></td>
                        <td><c:out value="${item.getCarrera().getNombre()}" /></td>
                        <td><c:out value="${item.getCreditos()}" /></td>
                        <td><c:out value="${item.getHorasSemanales()}" /></td>
                        <td class="text-center"><form action="CarrerasServlet?curso=${item.getCodigo()}" method="post">
                                <button name="btnEditar" class="btn btn-info" type="submit">Editar Curso</button>
                            <button name="btnEliminar" class="btn btn-danger" type="submit">Eliminar Curso</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>
