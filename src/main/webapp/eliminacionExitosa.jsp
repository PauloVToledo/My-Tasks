<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Eliminar Tarea</title>
</head>
<body>
<h1 class="encabezado"> Eliminar Tarea</h1>
<div class="centrado">
    <p class="subtitulo">Eliminacion exitosa</p> <br>
    <label class="campoTexto"> Nombre : <c:out value="${tarea.getNombre()}"></c:out> </label>
    <br>
    <label class="campoTexto"> Tipo : <c:out value="${tarea.getTipo()}"></c:out></label>
    <br>
    <label class="campoTexto"> Hora : <c:out value="${tarea.getHora()}"></c:out></label>
    <br>
    <label class="campoTexto"> Dia : <c:out value="${tarea.getDia()}"></c:out></label>
    <br>
    <label class="campoTexto"> Mes : <c:out value="${tarea.getMes()}"></c:out></label>
    <br>
    <label class="campoTexto"> Año : <c:out value="${tarea.getAño()}"></c:out></label>
    <a class="boton" href="index.jsp">Volver</a>
</div>

</body>
</html>