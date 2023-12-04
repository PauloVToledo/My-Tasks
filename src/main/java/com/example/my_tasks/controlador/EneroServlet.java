package com.example.my_tasks.controlador;

import com.example.my_tasks.modelo.Tarea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@WebServlet("/EneroServlet")
public class EneroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de tareas del contexto de aplicación para enero
        ServletContext contexto = getServletContext();
        List<Tarea> listaTareasEnero = (List<Tarea>) contexto.getAttribute("listaTareasEnero");

        // Verificar si la lista de tareas no es nula y no está vacía antes de pasarla al JSP
        if (listaTareasEnero != null && !listaTareasEnero.isEmpty()) {
            // Guardar la lista de tareas en un atributo de solicitud para acceder desde el JSP
            request.setAttribute("tareasEnero", listaTareasEnero);
        } else {
            // Enviar un mensaje si no hay tareas para mostrar
            request.setAttribute("mensaje", "No hay tareas para mostrar en enero.");
        }

        // Redirigir al JSP correspondiente a enero (por ejemplo, enero.jsp)
        request.getRequestDispatcher("/meses/enero.jsp").forward(request, response);
    }
}