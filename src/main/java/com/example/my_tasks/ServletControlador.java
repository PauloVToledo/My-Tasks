package com.example.my_tasks;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("verCalendario".equals(action)) {
            // Lógica para ver el calendario
            response.sendRedirect("verCalendario.jsp");
        } else if ("agregarTarea".equals(action)) {
            // Lógica para agregar tarea
            response.sendRedirect("agregarTarea.jsp");
        } else if ("eliminarTarea".equals(action)) {
            // Lógica para eliminar tarea
            response.sendRedirect("eliminarTarea.jsp");
        } else {
            // Acción desconocida
            response.sendRedirect("index.jsp");
        }
    }
}
