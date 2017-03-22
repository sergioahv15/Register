<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Estudiantes</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">MANTENIMIENTO DE ESTUDIANTES</h1>            
            <br/><br/>
            
            <center>
                <form action="EstudiantesServlet" method="post"><button name="btnAgregar" class="btn btn-success" type="submit">Agregar Estudiante</button></form>
            </center>
            
            <br/><br/>
            
            <div class="text-center">
                <form class="form-inline" action="EstudiantesServlet">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" id="nombre">
                    </div>
                     <div class="form-group">
                        <label for="cedula">Cedula:</label>
                        <input type="number" class="form-control" name="cedula" id="cedula">
                    </div>  
                    <div class="form-group">
                        <label for="carrera">Carrera:</label>
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
                      <th>Cedula</th>
                      <th>Nombre</th>
                      <th>Telefono</th>
                      <th>Email</th>
                      <th>Fecha Nacimiento</th>
                      <th>Carrera</th>
                      <th class="text-center">Mantenimiento</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${estudiantes}" var="item">
                      <tr>
                        <td><c:out value="${item.getCedula()}" /></td>
                        <td><c:out value="${item.getNombre()}" /></td>
                        <td><c:out value="${item.getTel()}" /></td>
                        <td><c:out value="${item.getEmail()}" /></td>
                        <td><c:out value="${item.getFechaNac()}" /></td>
                        <td><c:out value="${item.getCarrera().getNombre()}" /></td>
                        <td class="text-center"><form action="EstudiantesServlet?est=${item.getCedula()}" method="post">
                                <button name="btnEditar" class="btn btn-info" type="submit">Editar Estudiante</button></form></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>
