/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ValidarCurso() {
    var codigo, nombre, creditos, horas;

    codigo = document.getElementById("codigo").value;
    nombre = document.getElementById("nombre").value;
    creditos = document.getElementById("creditos").value;
    horas = document.getElementById("horas").value;



    if (codigo === "" || nombre === "" || creditos === "" || horas === "") {
        alert("Todos los campos son obligatorios")
        return false;
    } else if (codigo.length > 10) {
        alert("El codigo es demasiado largo");
        return false;
    } else if (!isNaN(nombre)) {
        alert("El nombre no puede contener numeros");
        return false;
    } else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    } else if (creditos.length > 11) {
        alert("Digito demasiado grande en creditos");
        return false;
    } else if (horas.length > 11) {
        alert("Digito demasiado grande en horas");
        return false;
    }

}

function ValidarLogin() {
    var usuario, password;

    usuario = document.getElementById("usuario").value;
    password = document.getElementById("password").value;
   

    if (usuario === "" || password === "") {
        alert("Todos los campos son obligatorios")
        return false;
    } else if (usuario.length > 11) {
        alert("El usuario es demasiado largo");
        return false;
    }  else if (password.length > 45) {
        alert("La contraseña es demasiado larga");
        return false;
    }  else if (isNaN(usuario)) {
        alert("El identificador del usuario debe de ser un numero");
        return false;
    }  

}



function ValidarGrupo() {
    var dia1, dia2, horaIni, hiraFin,profesor;

    dia1 = document.getElementById("dia1").value;
    dia2 = document.getElementById("dia2").value;
    horaIni = document.getElementById("horaIni").value;
    hiraFin = document.getElementById("hiraFin").value;
    profesor = document.getElementById("profesor").value;


    if (dia1 === "-----" || dia2 === "-----") {
        alert("Todos los campos son obligatorios")
        return false;
    }

}


function ValidarCarreraBusqueda() {
    var nombre, codigo;
    codigo = document.forms["form1"]["codigo"].value;
    nombre = document.forms["form1"]["nombre"].value;
    expresion = /[a-z]/;


    if (!expresion.test(nombre)) {
        alert("El nombre ingresado no es valido");
        return false;
    }  else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    } else if (codigo.length > 10) {
        alert("El codigo es demasiado largo");
        return false;
    } else if (nombre === "" && codigo === "") {
        alert("Debe de ingresar al menos un  criterio de busqueda");
        return false;
    } 

}



function ValidarCursoBusqueda() {
    var nombre, codigo;
    codigo = document.forms["form1"]["codigo"].value;
    nombre = document.forms["form1"]["nombre"].value;
    expresion = /[a-z]/;

    if (!expresion.test(nombre)) {
        alert("El nombre ingresado no es valido");
        return false;
    } else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    } else if (codigo.length > 10) {
        alert("El codigo es demasiado largo");
        return false;
    }

}




function ValidarProfesorBusqueda() {
    var nombre, cedula;
    cedula = document.forms["form1"]["cedula"].value;
    nombre = document.forms["form1"]["nombre"].value;
    
    var expresion = /[a-z]/;

    if (!expresion.test(nombre)) {
        alert("El nombre ingresado no es valido");
        return false;
    } else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    } else if (nombre === "" && cedula === "") {
        alert("Debe de ingresar al menos un  criterio de busqueda");
        return false;
    }
}

function ValidarEstudianteBusqueda() {
    var nombre, cedula;
    cedula = document.forms["form1"]["cedula"].value;
    nombre = document.forms["form1"]["nombre"].value;
    expresion = /[a-z]/;

    if (!expresion.test(nombre)) {
        alert("El nombre ingresado no es valido");
        return false;
    } else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    }

}

function ValidarProfesor() {
    var cedula, nombre, telefono, email;

    var cedula = document.getElementById("cedula").value;
    var nombre = document.getElementById("nombre").value;
    var telefono = document.getElementById("telefono").value;
    var email = document.getElementById("email").value;

    expresion = /\w+@\w+\.+[a-z]/;

    if (cedula === "" || nombre === "" || telefono === "" || email === "") {
        alert("Todos los campos son obligatorios")
        return false;
    } else if (cedula.length > 11) {
        alert("La cédula es demasiado larga");
        return false;
    } else if (!isNaN(nombre)) {
        alert("El nombre no puede contener numeros");
        return false;
    } else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    } else if (telefono.length > 11) {
        alert("El telefono es demasiado largo");
        return false;
    } else if (!expresion.test(email)) {
        alert("El correo ingresado no es valido");
        return false;
    } else if (email.length > 45) {
        alert("El email es demasiado largo");
        return false;
    } else if (isNaN(telefono)) {
        alert("El teléfono ingresado no es un número");
        return false;
    }
}

function ValidarEstudiante() {
    var cedula, nombre, telefono, email, fechaNac;

    var cedula = document.getElementById("cedula").value;
    var nombre = document.getElementById("nombre").value;
    var telefono = document.getElementById("telefono").value;
    var email = document.getElementById("email").value;
    var fechaNac = document.getElementById("fechaNac").value;

    expresion = /\w+@\w+\.+[a-z]/;

    if (cedula === "" || nombre === "" || telefono === "" || email === "" || fechaNac === "") {
        alert("Todos los campos son obligatorios")
        return false;
    } else if (cedula.length > 11) {
        alert("La cédula es demasiado larga");
        return false;
    } else if (!isNaN(nombre)) {
        alert("El nombre no puede contener numeros");
        return false;
    } else if (nombre.length > 45) {
        alert("El nombre es demasiado largo");
        return false;
    } else if (telefono.length > 11) {
        alert("El telefono es demasiado largo");
        return false;
    } else if (!expresion.test(email)) {
        alert("El correo ingresado no es valido");
        return false;
    } else if (email.length > 45) {
        alert("El email es demasiado largo");
        return false;
    } else if (isNaN(telefono)) {
        alert("El teléfono ingresado no es un número");
        return false;
    } else if (fechaNac > 45) {
        alert("La fecha es demasiado larga");
        return false;
    }

}