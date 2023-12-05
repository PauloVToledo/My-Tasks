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

    @WebServlet(name = "ModificarTareaServlet", value = "/modificarTarea")
    public class ModificarTareaServlet extends HttpServlet {
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
            RequestDispatcher respuesta = req.getRequestDispatcher("/modificarTarea.jsp");
            respuesta.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            DSLContext query = null;
            try {
                query = DBGenerator.conectarBD("TareasDB");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // Obtener parámetros del formulario
            String nombreTarea = req.getParameter("nombre");
            String columnaTabla = req.getParameter("columna");
            String nuevoDato = req.getParameter("nuevoDato");

            // Verificar que los datos no sean nulos o vacíos
            if (nombreTarea != null && !nombreTarea.isEmpty() &&
                    columnaTabla != null && !columnaTabla.isEmpty() &&
                    nuevoDato != null && !nuevoDato.isEmpty()) {

                // Realizar la modificación solo si los datos son válidos
                boolean modificacionExitosa = TareaDAO.modificarTarea(query, nombreTarea, columnaTabla, nuevoDato);

                if (modificacionExitosa) {
                    // Obtén la tarea actualizada antes de redirigir
                    Object tareaObject = TareaDAO.obtenerTarea(query, "nombre", nombreTarea).get(0);

                    // Realiza un casting explícito a la clase Tarea
                    if (tareaObject instanceof Tarea) {
                        Tarea tareaActualizada = (Tarea) tareaObject;

                        // Agrega la tarea actualizada como atributo de la solicitud
                        req.setAttribute("tarea", tareaActualizada);

                        // Redirige a la página de éxito
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/modificacionExitosa.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        // Manejo de error si la tarea no es del tipo esperado
                        resp.sendRedirect(req.getContextPath() + "/modificacionErronea.jsp");
                    }
                } else {
                    // Si la modificación falla, redirige a la página de error
                    resp.sendRedirect(req.getContextPath() + "/modificacionErronea.jsp");
                }
            } else {
                // Si algún dato es nulo o vacío, redirige a la página de error
                resp.sendRedirect(req.getContextPath() + "/modificacionErronea.jsp");
            }
        }
    }
