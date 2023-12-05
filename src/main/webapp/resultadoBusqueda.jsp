<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Resultado de Búsqueda</title>
</head>
<body>
<h1 class="encabezado">Resultado de Búsqueda</h1>

<div class="centrado">
    <c:if test="${not empty tareasEncontradas}">
        <c:forEach var="tarea" items="${tareasEncontradas}">
            <label>Nombre: <c:out value="${tarea.nombre}" /></label><br>
            <label>Tipo: <c:out value="${tarea.tipo}" /></label><br>
            <label>Descripcion: <c:out value="${tarea.descripcion}" /></label><br>
            <label>Hora: <c:out value="${tarea.hora}" /></label><br>
            <label>Dia: <c:out value="${tarea.dia}" /></label><br>
            <label>Mes: <c:out value="${tarea.mes}" /></label><br>
            <label>Año: <c:out value="${tarea.año}" /></label><br>
        </c:forEach>
    </c:if>

    <c:if test="${empty tareasEncontradas}">
        <p>No se encontraron tareas para la búsqueda.</p>
    </c:if>

    <br>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
