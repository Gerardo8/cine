package org.luger.resource.funcion.model;

import org.mongodb.morphia.annotations.Embedded;

import java.util.List;

@Embedded
public class Fila {
    private String fila;
    @Embedded
    private List<Asiento> asientos;

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }
}
