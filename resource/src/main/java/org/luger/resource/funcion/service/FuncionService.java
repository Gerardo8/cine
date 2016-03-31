package org.luger.resource.funcion.service;

import org.bson.types.ObjectId;
import org.luger.resource.funcion.model.Funcion;

import java.util.List;


public interface FuncionService {
    Funcion buscarFuncionPorId(ObjectId funcionId);

    List<Funcion> buscarFuncionesPorPeliculaId(ObjectId peliculaId);

    List<Funcion> buscarTodas();

    void actualizarFuncion(Funcion funcion);

    void borrarFuncion(Funcion funcion);

    void guardarFuncion(Funcion funcion);
}
