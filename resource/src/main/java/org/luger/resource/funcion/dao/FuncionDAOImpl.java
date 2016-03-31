package org.luger.resource.funcion.dao;

import org.bson.types.ObjectId;
import org.luger.resource.funcion.model.Funcion;
import org.luger.resource.pelicula.model.Pelicula;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FuncionDAO")
public class FuncionDAOImpl implements FuncionDAO {

    @Autowired
    private Datastore datastore;

    @Override
    public Funcion buscarFuncionPorId(ObjectId funcionId) {
        return datastore.get(Funcion.class,funcionId);
    }

    @Override
    public List<Funcion> buscarFuncionesPorPeliculaId(ObjectId peliculaId) {
        Pelicula pelicula = datastore.get(Pelicula.class,peliculaId);
        return datastore.createQuery(Funcion.class).field("pelicula").equal(pelicula).asList();
    }

    @Override
    public List<Funcion> buscarTodas() {
        return datastore.find(Funcion.class).asList();
    }

    @Override
    public void actualizarFuncion(Funcion funcion) {
        datastore.save(funcion);
    }

    @Override
    public void borrarFuncion(Funcion funcion) {
        datastore.delete(funcion);
    }

    @Override
    public void guardarFuncion(Funcion funcion) {
        datastore.save(funcion);
    }

}
