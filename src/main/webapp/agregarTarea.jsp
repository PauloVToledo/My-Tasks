<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Tarea</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <!-- Puedes agregar enlaces a archivos CSS u otros recursos aquí -->
</head>
<body>
<h1>Agregar Tarea</h1>

<!-- Formulario para agregar una nueva tarea -->
<form action="ServletTarea" method="post">
    <label for="nombre">Nombre de la Tarea:</label>
    <input type="text" id="nombre" name="nombre" required>

    <br>

    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" name="descripcion" rows="4" cols="50"></textarea>

    <br>

    <button type="submit">Agregar Tarea</button>
</form>

<br>
<a href="index.jsp">Volver a la Página Principal</a>
</body>
</html>
