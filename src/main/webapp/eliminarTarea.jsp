<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Tarea</title>
    <link rel="stylesheet" type="text/css" href="eliminarTarea.css">
    <!-- Puedes agregar enlaces a archivos CSS u otros recursos aquí -->
</head>
<body>
<h1>Eliminar Tarea</h1>

<!-- Lista de tareas con botones de eliminación -->
<ul>
    <li>
        <span>Nombre de la Tarea 1</span>
        <button onclick="eliminarTarea('id_tarea_1')">Eliminar</button>
    </li>
    <li>
        <span>Nombre de la Tarea 2</span>
        <button onclick="eliminarTarea('id_tarea_2')">Eliminar</button>
    </li>
    <!-- Agrega más elementos de la lista según sea necesario -->
</ul>

<script>
    function eliminarTarea(idTarea) {
        alert('Tarea con ID ' + idTarea + ' eliminada.');
    }
</script>

<br>

<a href="index.jsp">Volver a la Página Principal</a>

</body>
</html>
