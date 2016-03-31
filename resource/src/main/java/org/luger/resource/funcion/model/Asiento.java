package org.luger.resource.funcion.model;

import org.mongodb.morphia.annotations.Embedded;


@Embedded
public class Asiento {
    private String numero;
    private boolean deshabilitado;
    private boolean seleccionado;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDeshabilitado() {
        return deshabilitado;
    }

    public void setDeshabilitado(boolean deshabilitado) {
        this.deshabilitado = deshabilitado;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
