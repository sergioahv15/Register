<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>


<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN -  Sistema de Matricula</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="js/Script.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  </head>
    <body>
                
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <br/><br/><br/><br/>
                
                <h1 class="text-center">Sistema de Matricula</h1>
                <br/><br/>
                <h2 class="text-center">LOGIN</h2>
                
                <br/><br/>
                <form name="form1" action="LoginServlet" method="post" onsubmit="ValidarLogin();">
                    <div class="form-group" id="groupUsario">
                        <label for="cedula">Usuario:</label>
                        <input type="number" class="form-control" id="usuario" autofocus="true" name="usuario" required>
                    </div>

                    <div class="form-group" id="groupPassword">
                        <label for="nombre">Contraseña:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>

                    <center>                        
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary" id="ingresarBtn">Ingresar</button>
                        </div>
                    </center>

                </form>     
            </div>
    </body>
</html>
