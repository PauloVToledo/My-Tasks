<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mostrar Tareas</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1 class="encabezado">Tareas Ingresadas</h1>
<div class="centrado">
    <table>
        <tr>
            <th>Nombre </th>
            <th>Tipo </th>
            <th>Descripcion </th>
            <th>Hora </th>
            <th>Dia </th>
            <th>Mes </th>
            <th>Año </th>
        </tr>
        <c:forEach items="${tareas}" var="tarea">
            <tr>
                <td><c:out value="${tarea.getNombre()}"></c:out> </td>
                <td> <c:out value="${tarea.getTipo()}"></c:out> </td>
                <td> <c:out value="${tarea.getDescripcion()}"></c:out> </td>
                <td> <c:out value="${tarea.getHora()}"></c:out> </td>
                <td> <c:out value="${tarea.getDia()}"></c:out> </td>
                <td> <c:out value="${tarea.getMes()}"></c:out> </td>
                <td> <c:out value="${tarea.getAño()}"></c:out> </td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>