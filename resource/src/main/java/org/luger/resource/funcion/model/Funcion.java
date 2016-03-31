package org.luger.resource.funcion.model;


import org.bson.types.ObjectId;
import org.luger.resource.pelicula.model.Pelicula;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

@Entity(value="funciones", noClassnameStored=true)
public class Funcion {

    @Id
    private ObjectId funcionId;
    private Date fecha;
    @Embedded
    private Sala sala;
    @Reference
    private Pelicula pelicula;

    public ObjectId getFuncionId() {
        return funcionId;
    }

    public void setFuncionId(ObjectId funcionId) {
        this.funcionId = funcionId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
