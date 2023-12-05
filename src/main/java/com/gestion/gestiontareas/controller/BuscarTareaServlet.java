package com.gestion.gestiontareas.controller;

import com.gestion.gestiontareas.model.Tarea;
import com.gestion.gestiontareas.model.data.DBGenerator;
import com.gestion.gestiontareas.model.data.dao.TareaDAO;
import org.jooq.DSLContext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuscarTareaServlet", value = "/buscarTarea")
public class BuscarTareaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TareasDB");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/buscarTarea.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DSLContext query = null;
        try {
            query = DBGenerator.conectarBD("TareasDB");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String nombreTarea = req.getParameter("nombre");

        // Realiza la búsqueda en la base de datos por nombre
        List<Tarea> tareasEncontradas = TareaDAO.obtenerTarea(query, "nombre", nombreTarea);

        // Agrega el resultado a la solicitud
        req.setAttribute("tareasEncontradas", tareasEncontradas);

        // Redirige a la página de resultados
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resultadoBusqueda.jsp");
        dispatcher.forward(req, resp);
    }
}
