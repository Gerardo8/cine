package org.luger.resource.pelicula.dao;


import org.bson.types.ObjectId;
import org.luger.resource.pelicula.model.Pelicula;

import java.util.List;


public interface PeliculaDAO {

    Pelicula buscarPeliculaPorId(ObjectId peliculaId);

    List<Pelicula> buscarTodas();

    void actualizarPelicula(Pelicula pelicula);

    void borrarPelicula(Pelicula pelicula);

    void guardarPelicula(Pelicula pelicula);
}
