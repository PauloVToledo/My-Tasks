<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Tarea</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <!-- Puedes agregar enlaces a archivos CSS u otros recursos aquí -->
</head>
<body>
<h1>Eliminar Tarea</h1>

<!-- Formulario para seleccionar la tarea a eliminar -->
<form action="ServletTarea" method="post">
    <label for="idTarea">Selecciona la Tarea a Eliminar:</label>
    <select id="idTarea" name="idTarea" required>
        <!-- Aquí puedes cargar dinámicamente las tareas existentes desde tu base de datos o sistema de almacenamiento -->
        <option value="1">Tarea 1</option>
        <option value="2">Tarea 2</option>
        <option value="3">Tarea 3</option>
        <!-- Agrega más opciones según sea necesario -->
    </select>

    <br>

    <button type="submit">Eliminar Tarea</button>
</form>

<br>
<a href="index.jsp">Volver a la Página Principal</a>
</body>
</html>
