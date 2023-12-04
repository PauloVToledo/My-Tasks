<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
    <link rel="stylesheet" type="text/css" href="estiloIndex.css">

    <style>
        body {
            background-image: url('menu.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }
        h1,h2{
            display: inline-block;
        }
    </style>
</head>

<body>
<h1>My</h1><h2>Tasks</h2>
<h3>Tareas Dinámicas</h3>

<form action="ServletControlador" method="post">
    <button type="submit" name="action" value="verCalendario">Ver mi Calendario</button>
    <button type="submit" name="action" value="agregarTarea">Agregar Tarea</button>
    <button type="submit" name="action" value="eliminarTarea">Eliminar Tarea</button>
</form>
</body>
</html>
