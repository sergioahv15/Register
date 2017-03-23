<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta Academica</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">EDITAR GRUPO</h1>            
            <br/><br/>       
            
            <div class="container"> 
                <form  display="inline-block" action="OfertaServlet?modo=<c:out value="${modo}" />" method="post">                    
                    <div class="form-group">
                        <label for="numero">Numero:</label>
                        <input value="<c:out value="${grupoCurrent.getNumeroGrupo()}" />" type="number" class="form-control" name="numero" id="numero" <c:out value="${readonly}" />>
                    </div>                    
                    <div class="form-group">
                        <label>Dias:</label>
                        <select class="form-control" name="dia1" id="dia1">
                            <option selected="selected">-----</option>
                            <option <c:if test="${dia1.equals('Lunes')}">selected="selected"</c:if>>Lunes</option>
                            <option <c:if test="${dia1.equals('Martes')}">selected="selected"</c:if>>Martes</option>
                            <option <c:if test="${dia1.equals('Miercoles')}">selected="selected"</c:if>>Miercoles</option>
                            <option <c:if test="${dia1.equals('Jueves')}">selected="selected"</c:if>>Jueves</option>
                            <option <c:if test="${dia1.equals('Viernes')}">selected="selected"</c:if>>Viernes</option> 
                        </select>
                        <br/>
                        <select class="form-control" name="dia2" id="dia2">
                            <option selected="selected">-----</option>
                            <option <c:if test="${dia2.equals('Lunes')}">selected="selected"</c:if>>Lunes</option>
                            <option <c:if test="${dia2.equals('Martes')}">selected="selected"</c:if>>Martes</option>
                            <option <c:if test="${dia2.equals('Miercoles')}">selected="selected"</c:if>>Miercoles</option>
                            <option <c:if test="${dia2.equals('Jueves')}">selected="selected"</c:if>>Jueves</option>
                            <option <c:if test="${dia2.equals('Viernes')}">selected="selected"</c:if>>Viernes</option> 
                        </select>                   
                    </div> 
                    
                    <div class="form-group">
                        <label for="horaIni">Hora Inicio:</label>
                        <select class="form-control" name="horaIni" id="horaIni">
                            <option <c:if test="${horaIni.equals('7am')}">selected="selected"</c:if>>7am</option>
                            <option <c:if test="${horaIni.equals('8am')}">selected="selected"</c:if>>8am</option>
                            <option <c:if test="${horaIni.equals('9am')}">selected="selected"</c:if>>9am</option>
                            <option <c:if test="${horaIni.equals('10am')}">selected="selected"</c:if>>10am</option>
                            <option <c:if test="${horaIni.equals('11am')}">selected="selected"</c:if>>11am</option>
                            <option <c:if test="${horaIni.equals('12pm')}">selected="selected"</c:if>>12pm</option>
                            <option <c:if test="${horaIni.equals('1pm')}">selected="selected"</c:if>>1pm</option>
                            <option <c:if test="${horaIni.equals('2pm')}">selected="selected"</c:if>>2pm</option>
                            <option <c:if test="${horaIni.equals('3pm')}">selected="selected"</c:if>>3pm</option>
                            <option <c:if test="${horaIni.equals('4pm')}">selected="selected"</c:if>>4pm</option>
                            <option <c:if test="${horaIni.equals('5pm')}">selected="selected"</c:if>>5pm</option>
                            <option <c:if test="${horaIni.equals('6pm')}">selected="selected"</c:if>>6pm</option>
                            <option <c:if test="${horaIni.equals('7pm')}">selected="selected"</c:if>>7pm</option>
                            <option <c:if test="${horaIni.equals('8pm')}">selected="selected"</c:if>>8pm</option>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="horaFin">Hora Fin:</label>
                        <select class="form-control" name="horaFin" id="horaFin">
                            <option <c:if test="${horaFin.equals('7am')}">selected="selected"</c:if>>7am</option>
                            <option <c:if test="${horaFin.equals('8am')}">selected="selected"</c:if>>8am</option>
                            <option <c:if test="${horaFin.equals('9am')}">selected="selected"</c:if>>9am</option>
                            <option <c:if test="${horaFin.equals('10am')}">selected="selected"</c:if>>10am</option>
                            <option <c:if test="${horaFin.equals('11am')}">selected="selected"</c:if>>11am</option>
                            <option <c:if test="${horaFin.equals('12pm')}">selected="selected"</c:if>>12pm</option>
                            <option <c:if test="${horaFin.equals('1pm')}">selected="selected"</c:if>>1pm</option>
                            <option <c:if test="${horaFin.equals('2pm')}">selected="selected"</c:if>>2pm</option>
                            <option <c:if test="${horaFin.equals('3pm')}">selected="selected"</c:if>>3pm</option>
                            <option <c:if test="${horaFin.equals('4pm')}">selected="selected"</c:if>>4pm</option>
                            <option <c:if test="${horaFin.equals('5pm')}">selected="selected"</c:if>>5pm</option>
                            <option <c:if test="${horaFin.equals('6pm')}">selected="selected"</c:if>>6pm</option>
                            <option <c:if test="${horaFin.equals('7pm')}">selected="selected"</c:if>>7pm</option>
                            <option <c:if test="${horaFin.equals('8pm')}">selected="selected"</c:if>>8pm</option>
                        </select>
                    </div>                    
                    <div class="form-group">
                        <label for="profesor">Profesor:</label>
                        <select class="form-control" name="profesor" id="profesor">
                            <c:forEach items="${profes}" var="item">
                                <option
                                    <c:if test="${item.getNombre().equals(grupoCurrent.getProfesor().getNombre())}">
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


