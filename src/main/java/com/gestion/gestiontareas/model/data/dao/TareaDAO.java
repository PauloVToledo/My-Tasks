package com.gestion.gestiontareas.model.data.dao;

import com.gestion.gestiontareas.model.Tarea;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class TareaDAO {
    public static void agregarTarea(DSLContext query, Tarea tarea){
        Table tablaTarea= table(name("Tareas"));
        Field[] columnas = tablaTarea.fields("nombre","descripcion","tipo","hora","dia","mes","año");
        query.insertInto(tablaTarea, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4],columnas[5],columnas[6])
                .values(tarea.getNombre(),tarea.getDescripcion(),tarea.getTipo(),tarea.getHora(),tarea.getDia(),tarea.getMes(),tarea.getAño())
                .execute();
    }
    public static boolean modificarTarea(DSLContext query, String nombre, String columnaTabla, Object dato) {
        int filasModificadas = query
                .update(DSL.table("Tareas"))
                .set(DSL.field(columnaTabla), dato)
                .where(DSL.field("nombre").eq(nombre))
                .execute();


        return filasModificadas > 0;
    }

    public static List obtenerTarea(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Tareas")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaTareas(resultados);
    }
    public static List<Tarea> obtenerTareas(DSLContext query) {
        Result<Record> resultados = query.select().from(DSL.table("Tareas")).fetch();

        return obtenerListaTareas(resultados);
    }
    public static boolean eliminarTarea(DSLContext query, Tarea tarea) {
        String nombreTarea=tarea.getNombre();
        int result=0;
        try{
            result=query.deleteFrom(
                            DSL.table("Tareas"))
                    .where(DSL.field("nombre").eq(nombreTarea))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result==1;
    }
    private static List<Tarea> obtenerListaTareas(Result<Record> resultados) {
        List<Tarea> tareas = new ArrayList<>();

        for (Record record : resultados) {
            String nombre = record.getValue(DSL.field("nombre", String.class));
            String tipo = record.getValue(DSL.field("tipo", String.class));
            String descripcion = record.getValue(DSL.field("descripcion", String.class));
            String hora = record.getValue(DSL.field("hora", String.class));
            String dia = record.getValue(DSL.field("dia", String.class));
            String mes = record.getValue(DSL.field("mes", String.class));
            String año = record.getValue(DSL.field("año", String.class));

            tareas.add(new Tarea(nombre, tipo, descripcion, hora, dia, mes, año));
        }

        return tareas;
    }
    }

