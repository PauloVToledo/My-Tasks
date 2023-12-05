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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MostrarTareasServlet", value = "/mostrarTareas")
public class MostrarTareasServlet extends HttpServlet {
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
        try {
            req.setAttribute("tareas",agregarTareasEjemplo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarTareas.jsp");
        respuesta.forward(req,resp);
    }

    private List agregarTareasEjemplo() throws ClassNotFoundException {
        List<Tarea> tareas = new ArrayList<>();
        tareas = TareaDAO.obtenerTareas(DBGenerator.conectarBD("TareasDB"));
        return tareas;
    }
}