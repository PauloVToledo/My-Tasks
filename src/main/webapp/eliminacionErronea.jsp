<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eliminar libro</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1 class="encabezado"> Eliminar tarea</h1>
<h2 class="subtitulo">Datos Incorrectos, favor comprobar nuevamente</h2>
<form action="registroTarea" method="post">
    <div class="centrado">
        <label> Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Eliminar" class="boton">
    </div>
</form>
</body>
</html>