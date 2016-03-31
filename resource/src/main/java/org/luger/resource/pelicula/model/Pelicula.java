package org.luger.resource.pelicula.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity(value="peliculas", noClassnameStored=true)
public class Pelicula {

    @Id
    private ObjectId peliculaId;
    private String titulo;
    private String sinopsis;
    private String pais;
    private String genero;
    private String duracion;
    private String clasificacion;
    private String nombreImagen;
//    @Property("fecha_estreno")
//    private Date fechaEstreno;
//    @Property("fecha_fin")
//    private Date fechaFin;


    public ObjectId getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(ObjectId peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
}
