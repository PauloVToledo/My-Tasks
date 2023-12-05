<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar Tarea</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1 class="encabezado">Modificar Tarea</h1>
<form action="modificarTarea" method="post">
    <div class="centrado">
        <label> Nombre de la tarea:</label>
        <input name="nombre" type="text" class="campoTexto">
        <br><br>
        <label> Columna a modificar:</label>
        <input name="columna" type="text" class="campoTexto">
        <small>Escribe el nombre de la columna (Nombre, Tipo, Descripcion, etc.)</small>
        <br><br>
        <label> Nuevo dato:</label>
        <input name="nuevoDato" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Modificar" class="boton">
    </div>
</form>
</body>
</html>
