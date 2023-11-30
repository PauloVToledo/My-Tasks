package com.example.my_tasks;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletTarea")
public class ServletTarea extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String tipoTarea = request.getParameter("tipoTarea");
        String hora = request.getParameter("hora");
        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String ano = request.getParameter("ano");

        // Aquí puedes realizar acciones con los datos recibidos del formulario
        // Por ejemplo, guardarlos en una base de datos, procesarlos, etc.

        // Una vez que se haya procesado la información, podrías redirigir a una página de éxito o mostrar algún mensaje
        response.sendRedirect("agregadoCorrecto.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para manejar las solicitudes GET si es necesario
    }
}