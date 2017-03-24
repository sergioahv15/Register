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
        <title>Mantenimiento de Cursos</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <nav class="navbar" role="navigation">
                    <div class="logo">
                    <a href="index.jsp" class="logo"></a>
                </div>
                    <span class="menu"> </span>
                    <ul>
                        <li class="active"><a href="index.jsp">Inicio<span> </span></a></li>
                        <li><a href="about.jsp">Nuestra Empresa</a></li>
                        <li><a href="catalogo.jsp" onclick="limpiarCategoria();">Catálogo</a></li>
                        <li><a href="tiendas.jsp">Tiendas</a></li>
                        <li><a href="contact.jsp">Contacto</a></li>
                        <% if(tipoUsuario.equals("Administrador")) { %> 
                        <li><a href="gestionProductos.jsp">Administración</a></li>
                        <li><a href="reportes.jsp">Reportes</a></li>
                        <% } %>
                        <li><a href="carrito.jsp">Carrito de Compras</a></li>
                        
                        
                        <li><a href="Logout">Cerrar Sesión</a></li>
                    </ul>
                </nav>
        
        <div class="container">
            <h1 class="text-center">MANTENIMIENTO DE CURSOS</h1>            
            <br/>            
            <div class="text-center">
                <form class="form-inline" action="CursosServlet">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" id="nombre">
                    </div>
                     <div class="form-group">
                        <label for="codigo">Codigo:</label>
                        <input type="text" class="form-control" name="codigo" id="codigo">
                    </div>
                     <div class="form-group">
                        <label for="carrera">Carrera</label>
                        <select class="form-control" name="carrera" id="carrera">
                            <option selected="selected">Todas</option>
                            <c:forEach items="${carreras}" var="item">
                                <option><c:out value="${item.getNombre()}" /></option>
                            </c:forEach>
                            <!--<option selected="selected">Todas</option>
                            <option>Ingenieria en Sistemas</option>
                            <option>Otras Mariconadas</option>
                            <option>Danza</option>-->
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
                      <th>Codigo</th>
                      <th>Nombre</th>
                      <th>Carrera</th>
                      <th>Creditos</th>
                      <th>Horas Semanales</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${cursos}" var="item">
                      <tr>
                        <td><c:out value="${item.getCodigo()}" /></td>
                        <td><c:out value="${item.getNombre()}" /></td>
                        <td><c:out value="${item.getCarrera().getNombre()}" /></td>
                        <td><c:out value="${item.getCreditos()}" /></td>
                        <td><c:out value="${item.getHorasSemanales()}" /></td>
                      </tr>
                    </c:forEach>
                  </tbody>                    
                </table>
            </div>            
        </div>
    </body>
</html>
