package org.luger.resource.pelicula.service;

import org.bson.types.ObjectId;
import org.luger.resource.pelicula.dao.PeliculaDAO;
import org.luger.resource.pelicula.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PeliculaService")
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    public Pelicula buscarPeliculaPorId(ObjectId peliculaId) {
        return peliculaDAO.buscarPeliculaPorId(peliculaId);
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculaDAO.buscarTodas();
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculaDAO.actualizarPelicula(pelicula);
    }

    @Override
    public void borrarPelicula(Pelicula pelicula) {
        peliculaDAO.borrarPelicula(pelicula);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculaDAO.guardarPelicula(pelicula);
    }
}
