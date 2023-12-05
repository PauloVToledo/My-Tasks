<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Buscar Tarea por Nombre</title>
</head>
<body>
<h1 class="encabezado">Buscar Tarea por Nombre</h1>
<form action="buscarTarea" method="post">
    <div class="centrado">
        <label>Nombre de la Tarea:</label>
        <input name="nombre" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Buscar" class="boton">
    </div>
</form>

<a class="boton" href="index.jsp">Volver</a>
</body>
</html>
