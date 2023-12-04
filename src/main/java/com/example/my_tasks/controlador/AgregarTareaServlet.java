package com.example.my_tasks.controlador;

import com.example.my_tasks.modelo.Tarea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AgregarTareaServlet")
public class AgregarTareaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el contexto de la aplicación
        ServletContext contexto = getServletContext();

        // Obtener la lista de tareas del contexto de aplicación
        List<Tarea> listaTareas = (List<Tarea>) contexto.getAttribute("listaTareas");

        // Si la lista de tareas aún no existe en el contexto de aplicación, crearla y almacenarla
        if (listaTareas == null) {
            listaTareas = new ArrayList<>();
            contexto.setAttribute("listaTareas", listaTareas);
        }

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String tipoTarea = request.getParameter("tipoTarea");
        String hora = request.getParameter("hora");
        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String ano = request.getParameter("ano");
        String descripcion = request.getParameter("descripcion");

        // Crear la tarea con los datos recibidos
        Tarea nuevaTarea = new Tarea(nombre, tipoTarea,descripcion, hora, dia, mes, ano);

        // Agregar la tarea a la lista de tareas en el contexto de aplicación
        listaTareas.add(nuevaTarea);

        // Redirigir a la página principal (index.jsp)
        response.sendRedirect("index.jsp");
    }
}