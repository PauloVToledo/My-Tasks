package com.gestion.gestiontareas.controller;

import com.gestion.gestiontareas.model.Tarea;
import com.gestion.gestiontareas.model.data.DBGenerator;
import com.gestion.gestiontareas.model.data.dao.TareaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "eliminarTareaServlet", value = "/eliminarTarea")
public class EliminarTareaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TareasDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminarTarea.jsp");
        // envía la respuesta
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminacionErronea.jsp");

        String nombreParameter = req.getParameter("nombre");

        if (nombreParameter == null || nombreParameter.trim().isEmpty()) {
            // El parámetro nombre es nulo o está vacío
            respuesta.forward(req, resp);
            return;  // Importante agregar el return después de la redirección
        }

        String nombre = nombreParameter;

        // Obtener detalles de la tarea antes de eliminarla
        Tarea tarea = null;
        try {
            tarea = obtenerDetallesTarea(nombre);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            if (tarea != null && eliminarTarea(tarea)) {
                req.setAttribute("tarea", tarea);
                respuesta = req.getRequestDispatcher("/eliminacionExitosa.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        respuesta.forward(req, resp);
    }


    private Tarea obtenerDetallesTarea(String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("TareasDB");
        List<Tarea> tareas = TareaDAO.obtenerTarea(query, "nombre", nombre);
        if (!tareas.isEmpty()) {
            return tareas.get(0); // Devuelve el primer resultado
        } else {
            return null; // O devuelve null si no se encontró ninguna tarea
        }
    }

    private boolean eliminarTarea(Tarea tarea) throws ClassNotFoundException {
        if (tarea == null) {
            return false; // No intentar eliminar si la tarea no existe
        }

        DSLContext query = DBGenerator.conectarBD("TareasDB");
        return TareaDAO.eliminarTarea(query, tarea);
    }
}
