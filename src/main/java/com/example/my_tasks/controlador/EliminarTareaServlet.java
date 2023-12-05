package com.example.my_tasks.controlador;

import com.example.my_tasks.modelo.Tarea;
import com.example.my_tasks.modelo.datos.DAO.TareaDAO;
import com.example.my_tasks.modelo.datos.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

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
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminarTarea.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminacionErronea.jsp");

        String nombreParameter = req.getParameter("nombre");
        String tipoParameter = req.getParameter("tipo");
        String descripcionParameter = req.getParameter("descripcion");
        String horaParameter = req.getParameter("hora");
        String diaParameter = req.getParameter("dia");
        String mesParameter = req.getParameter("mes");
        String añoParameter = req.getParameter("año");

        if (nombreParameter != null && tipoParameter != null && descripcionParameter != null && horaParameter != null && diaParameter != null && mesParameter != null && añoParameter != null) {

            String nombre = nombreParameter;
            String tipo = tipoParameter;
            String descripcion = descripcionParameter;
            String hora = horaParameter;
            String dia = diaParameter;
            String mes = mesParameter;
            String año = añoParameter;

            Tarea tarea = new Tarea(nombre, tipo, descripcion, hora, dia, mes, año);

            try {
                if (eliminarTarea(tarea)) {
                    req.setAttribute("tarea", tarea);
                    respuesta = req.getRequestDispatcher("/eliminacionExitosa.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        respuesta.forward(req, resp);
    }




    private boolean eliminarTarea(Tarea tarea) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("TareasDB");
        return TareaDAO.eliminarTarea(query, tarea);
    }

}