<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Tarea</title>
    <link rel="stylesheet" type="text/css" href="agregarTarea.css">
</head>
<body>


<style>
    h1,h2{
        display: inline-block;
        margin-right: 10px;
    }
</style>

<h1>Agregar</h1><h2>Tarea</h2>

<!-- Formulario para agregar una nueva tarea -->
<form action="AgregarTareaServlet" method="post">
    <label for="nombre">Nombre de la Tarea:</label>
    <input type="text" id="nombre" name="nombre" required>

    <br>

    <label for="tipo">Tipo de Tarea:</label>
    <input type="text" id="Tipo" name="tipo" required>
    </select>


    <br>

    <label for="hora">Hora:</label>
    <input type="text" id="hora" name="hora" required>
    </select>

    <br>

    <label for="dia">Día:</label>
    <input type="text" id="dia" name="dia" required>
    </select>

    <br>

    <label for="mes">Mes:</label>
    <input type="text" id="mes" name="mes" required>
    </select>

    <br>

    <label for="ano">Año:</label>
    <input type="text" id="ano" name="ano" required>
    </input>
    </select>

    <br>

    <button type="submit">Agregar Tarea</button>
</form>


<br>
<a href="index.jsp">Volver a la Página Principal</a>
</body>
</html>