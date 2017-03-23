<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Matricula</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">MENU PRINCIPAL</h1>            
            <br/><br/>    
            
            
            <div class="container text-center">  
                <form action="CursosServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="mantCursos">Mantenimiento de Cursos</button>
                    </div>
                </form> 
                <form action="CarrerasServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="mantCarreras">Mantenimiento de Carreras</button>
                    </div>
                </form> 
                <form action="ProfesoresServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="mantProfes">Mantenimiento de Profesores</button>
                    </div>
                </form> 
                <form action="EstudiantesServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="mantEstudiantes">Mantenimiento de Estudiantes</button>
                    </div>
                </form> 
                <form action="CiclosServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="mantCiclos">Mantenimiento de Ciclos</button>
                    </div>
                </form> 
                <form action="OfertaServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="oferta">Oferta Academica</button>
                    </div>
                </form> 
                <form action="GruposProfeServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="regNotas">Registro de Notas</button>
                    </div>
                </form> 
                <form action="HistorialServlet" method="post">
                    <div class="form-group">
                    <button class="btn btn-primary" type="submit" name="getHistorial">Consulta de Historial</button>
                    </div>
                </form> 
            </div>                    
        </div>
    </body>
</html>
