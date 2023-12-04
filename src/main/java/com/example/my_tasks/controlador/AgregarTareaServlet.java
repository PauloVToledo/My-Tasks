package com.example.my_tasks.controlador;

import com.example.my_tasks.modelo.Tarea;
import com.example.my_tasks.modelo.datos.DBGenerator;
import com.example.my_tasks.modelo.datos.DAO.TareaDAO;
import org.jooq.DSLContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "agregarTareaServlet", value = "/agregarTarea")
public class AgregarTareaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TareasBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarTarea.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher respuesta = req.getRequestDispatcher("/agregadoNoCorrecto.jsp");
            if (req.getParameter("nombre").length() != 0 && req.getParameter("tipo").length() != 0 &&
                    req.getParameter("descripcion").length() != 0 && req.getParameter("hora").length() != 0 &&
                    req.getParameter("dia").length() != 0 && req.getParameter("mes").length() != 0 &&
                    req.getParameter("año").length() != 0) {

                String nombre = req.getParameter("nombre");
                String tipo = req.getParameter("tipo");
                String descripcion = req.getParameter("descripcion");
                String hora = req.getParameter("hora");
                String dia = req.getParameter("dia");
                String mes = req.getParameter("mes");
                String año = req.getParameter("año");

                Tarea tarea = new Tarea(nombre, tipo, descripcion, hora, dia, mes, año);

                try {
                    if (agregarTarea(tarea)) {
                        req.setAttribute("tarea", tarea);
                        respuesta = req.getRequestDispatcher("/agregadoCorrecto.jsp");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            respuesta.forward(req, resp);
        }

    private boolean agregarTarea(Tarea tarea) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("TareasDB");
        List<Tarea> tareas = TareaDAO.obtenerTarea(query, "tipo", tarea.getTipo());
        if (tareas.size() != 0) {
            return false;
        } else {
            TareaDAO.agregarTarea(query, tarea);
            return true;
        }
    }
}
