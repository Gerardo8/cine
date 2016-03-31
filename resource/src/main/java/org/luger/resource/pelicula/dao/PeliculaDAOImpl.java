package org.luger.resource.pelicula.dao;

import org.bson.types.ObjectId;
import org.luger.resource.pelicula.model.Pelicula;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PeliculaDAO")
public class PeliculaDAOImpl implements PeliculaDAO{

    @Autowired
    private Datastore datastore;

    @Override
    public Pelicula buscarPeliculaPorId(ObjectId peliculaId) {
        return datastore.get(Pelicula.class,peliculaId);
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return datastore.find(Pelicula.class).asList();
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        datastore.save(pelicula);
    }

    @Override
    public void borrarPelicula(Pelicula pelicula) {
        datastore.delete(pelicula);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        datastore.save(pelicula);
    }
}
