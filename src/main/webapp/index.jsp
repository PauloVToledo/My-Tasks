<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Bienvenido a My Tasks ;)</h1>

<form action="ServletControlador" method="post">
    <button type="submit" name="action" value="verCalendario">Ver mi Calendario</button>
    <button type="submit" name="action" value="agregarTarea">Agregar Tarea</button>
    <button type="submit" name="action" value="eliminarTarea">Eliminar Tarea</button>
</form>
</body>
</html>
