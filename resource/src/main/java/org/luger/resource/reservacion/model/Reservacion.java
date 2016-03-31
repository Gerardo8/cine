package org.luger.resource.reservacion.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;


@Entity(value="reservaciones", noClassnameStored=true)
public class Reservacion {

    @Id
    private ObjectId reservacionId;
    private String nombreCliente;
    private String emailCliente;
    private String nombreSala;
    private Date fechaFuncion;
    private String[] asientos;
    private String nombrePelicula;
    private float total;

    public ObjectId getReservacionId() {
        return reservacionId;
    }

    public void setReservacionId(ObjectId reservacionId) {
        this.reservacionId = reservacionId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Date getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(Date fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public String[] getAsientos() {
        return asientos;
    }

    public void setAsientos(String[] asientos) {
        this.asientos = asientos;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
