package com.example.my_tasks.controlador;

import com.example.my_tasks.modelo.Tarea;
import com.example.my_tasks.modelo.datos.DBConnector;
import com.example.my_tasks.modelo.datos.DBGenerator;
import com.example.my_tasks.modelo.datos.DAO.TareaDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EneroServlet")
public class EneroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DSLContext create = null;
        try {
            DBGenerator.iniciarBD("TareasBD");
            create = DBGenerator.conectarBD("TareasBD");

            List<Tarea> listaTareasEnero = TareaDAO.obtenerTareas(create);

            if (listaTareasEnero != null && !listaTareasEnero.isEmpty()) {
                request.setAttribute("tareasEnero", listaTareasEnero);
            } else {
                request.setAttribute("mensaje", "No hay tareas para mostrar en enero.");
            }

            // Cerrar la conexión después de haber realizado las operaciones
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar errores
        } finally {
            if (create != null) {
                DBConnector.closeConnection(); // Cerrar la conexión si se estableció
            }
        }

        // Redirigir al JSP correspondiente a enero
        request.getRequestDispatcher("/meses/enero.jsp").forward(request, response);
    }
}