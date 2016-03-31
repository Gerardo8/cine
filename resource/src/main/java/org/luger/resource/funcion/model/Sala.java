package org.luger.resource.funcion.model;

import org.mongodb.morphia.annotations.Embedded;

import java.util.List;


@Embedded
public class Sala {
    private String nombre;
    @Embedded
    private List<Fila> filas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Fila> getFilas() {
        return filas;
    }

    public void setFilas(List<Fila> filas) {
        this.filas = filas;
    }
}
