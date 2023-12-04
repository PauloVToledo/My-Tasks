<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ver Calendario</title>
    <link rel="stylesheet" type="text/css" href="estiloCalendario.css">
    <!-- Incluye el enlace al archivo de estilos para el calendario -->
    <style>
        /* Agrega un nuevo estilo para el contenedor de los botones */
        .meses-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin: 20px;
        }

        /* Estilo de cada botón */
        form {
            width: 23%;
            margin-bottom: 20px;
            box-sizing: border-box;
            text-align: center;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        h1,h2{
            display: inline-block;
            margin-right: 10px;
        }
    </style>
</head>
<body>

<h1>Mi</h1>
<h2>Calendario</h2>

<!-- Agrega el contenedor para los botones -->
<div class="meses-container">
    <form action="meses/enero.jsp" method="post">
        <button type="submit" name="action" value="verMesEnero">Enero</button>
    </form>

    <form action="meses/febrero.jsp" method="post">
        <button type="submit" name="action" value="verMesFebrero">Febrero</button>
    </form>

    <form action="meses/marzo.jsp" method="post">
        <button type="submit" name="action" value="verMesMarzo">Marzo</button>
    </form>

    <form action="meses/abril.jsp" method="post">
        <button type="submit" name="action" value="verMesAbril">Abril</button>
    </form>

    <form action="meses/mayo.jsp" method="post">
        <button type="submit" name="action" value="verMesMayo">Mayo</button>
    </form>

    <form action="meses/junio.jsp" method="post">
        <button type="submit" name="action" value="verMesJunio">Junio</button>
    </form>

    <form action="meses/julio.jsp" method="post">
        <button type="submit" name="action" value="verMesJulio">Julio</button>
    </form>

    <form action="meses/agosto.jsp" method="post">
        <button type="submit" name="action" value="verMesAgosto">Agosto</button>
    </form>

    <form action="meses/septiembre.jsp" method="post">
        <button type="submit" name="action" value="verMesSeptiembre">Septiembre</button>
    </form>

    <form action="meses/octubre.jsp" method="post">
        <button type="submit" name="action" value="verMesOctubre">Octubre</button>
    </form>

    <form action="meses/noviembre.jsp" method="post">
        <button type="submit" name="action" value="verMesNoviembre">Noviembre</button>
    </form>

    <form action="meses/diciembre.jsp" method="post">
        <button type="submit" name="action" value="verMesDiciembre">Diciembre</button>
    </form>
</div>

<a href="index.jsp">Volver a la Página Principal</a>
</body>
</html>