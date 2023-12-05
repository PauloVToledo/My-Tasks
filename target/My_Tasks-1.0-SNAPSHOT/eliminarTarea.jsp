<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Eliminar tarea</title>
</head>
<body>
<h1 class="encabezado"> Eliminar tarea</h1>
<form action="eliminarTarea" method="post">
    <div class="centrado">
        <label> Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <label> Tipo:</label>
        <input name="tipo" type="text" class="campoTexto">
        <label> Descripcion:</label>
        <input name="descripcion" type="text" class="campoTexto">
        <label> Hora:</label>
        <input name="hora" type="number" class="campoTexto">
        <label> Dia:</label>
        <input name="dia" type="text" class="campoTexto">
        <label> Mes:</label>
        <input name="mes" type="text" class="campoTexto">
        <label> Año:</label>
        <input name="año" type="number" class="campoTexto">
        <br><br>
        <input type="submit" value="Eliminar" class="boton">
    </div>
</form>
</body>
</html>
