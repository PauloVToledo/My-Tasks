<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Menu</title>
</head>
<body>
<h1 class="encabezado"> Menú principal libros </h1>
<br>
<form action="registroTarea" method="get">
    <div class="centrado">
        <input type="submit" value="Registrar tarea" class="boton">
    </div>
</form>
<br>
<form action="mostrarTareas" method="get">
    <div class="centrado">
        <input type="submit" value="Mostrar tareas" class="boton">
    </div>
</form>
<br>
<form action="eliminarTarea" method="get">
    <div class="centrado">
        <input type="submit" value="Eliminar tarea" class="boton">
    </div>
</form>
</body>
</html>