package com.example.my_tasks.modelo;

public class Tarea {
    private String nombre;
    private String tipo;
    private String descripcion;
    private String hora;
    private String dia;
    private String mes;
    private String año;

    public Tarea(String nombre, String tipo, String descripcion, String hora, String dia, String mes, String año) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.hora = hora;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
