package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.model.Tarea;
import com.gestion.gestionlibros.model.data.DBGenerator;
import com.gestion.gestionlibros.model.data.dao.TareaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registrarLibroServlet", value = "/registroLibro")
public class RegistrarLibroServlet extends HttpServlet {
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
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroLibro.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if(req.getParameter("nombre").length()!=0 && req.getParameter("tipo").length()!=0 && req.getParameter("descripcion").length()!=0 && req.getParameter("hora").length()!=0 && req.getParameter("dia").length()!=0 && req.getParameter("mes").length()!=0 && req.getParameter("año").length()!=0){
            String nombre = req.getParameter("nombre");
            String tipo = req.getParameter("tipo");
            String descripcion = req.getParameter("descripcion");
            String hora = req.getParameter("hora");
            String dia = req.getParameter("dia");
            String mes = req.getParameter("mes");
            String año = req.getParameter("año");
            Tarea tarea = new Tarea(nombre,tipo,descripcion,hora,dia,mes,año);
            try {
                if(agregarTarea(tarea)){
                    req.setAttribute("tarea",tarea);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarTarea(Tarea tarea) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("TareasDB");
        List<TareaDAO> tareas = TareaDAO.obtenerTarea(query,"nombre", tarea.getNombre());
        if(tareas.size()!=0){
            return false;
        }
        else{
            TareaDAO.agregarTarea(query,tarea);
            return true;
        }
    }
}
