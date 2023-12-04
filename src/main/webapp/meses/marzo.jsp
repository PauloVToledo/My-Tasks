<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.my_tasks.modelo.Tarea" %>
<html>
<head>
    <title>Tareas mes de marzo</title>
    <style>
        /* Estilos para la tabla */
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Tareas mes de marzo</h1>

<!-- Tabla para mostrar las tareas -->
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Tipo de Tarea</th>
        <th>Descripción</th>
        <th>Hora</th>
        <th>Día</th>
        <th>Mes</th>
        <th>Año</th>
        <!-- Otros encabezados si es necesario -->
    </tr>
    </thead>
    <tbody>
    <!-- Lógica para mostrar las tareas -->
    <% if (request.getAttribute("tareasMarzo") != null) {
        List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareasMarzo");
        for (Tarea tarea : tareas) { %>
    <tr>
        <td><%= tarea.getNombre() %></td>
        <td><%= tarea.getTipo() %></td>
        <td><%= tarea.getDescripcion() %></td>
        <td><%= tarea.getHora() %></td>
        <td><%= tarea.getDia() %></td>
        <td><%= tarea.getMes() %></td>
        <td><%= tarea.getAño() %></td>
        <!-- Otros campos si es necesario -->
    </tr>
    <%   }
    } else { %>
    <tr>
        <td colspan="7">No hay tareas para mostrar.</td>
    </tr>
    <% } %>
    </tbody>
</table>

<!-- Función para volver a la página anterior usando JavaScript -->
<button type="button" onclick="goBack()">Volver</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>

</body>
</html>