<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
    <link rel="stylesheet" type="text/css" href="estiloIndex.css">

    <style>
        body {
            /* Establece la imagen de fondo y ajusta el estilo según sea necesario */
            background-image: url('menu.jpg');
            background-size: cover; /* Puedes ajustar esto según tus necesidades */
            background-repeat: no-repeat;
            /* Agrega más estilos según sea necesario */
        }

        /* Puedes agregar más estilos CSS según tus necesidades */
    </style>
</head>
<body>
<h1>Bienvenido a My Tasks</h1>
<h2>Tareas Dinámicas</h2>

<form action="ServletControlador" method="post">
    <button type="submit" name="action" value="verCalendario">Ver mi Calendario</button>
    <button type="submit" name="action" value="agregarTarea">Agregar Tarea</button>
    <button type="submit" name="action" value="eliminarTarea">Eliminar Tarea</button>
</form>
</body>
</html>
