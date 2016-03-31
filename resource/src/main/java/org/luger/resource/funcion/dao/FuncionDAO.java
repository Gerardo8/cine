package org.luger.resource.funcion.dao;


import org.bson.types.ObjectId;
import org.luger.resource.funcion.model.Funcion;

import java.util.List;


public interface FuncionDAO {

    Funcion buscarFuncionPorId(ObjectId funcionId);

    List<Funcion> buscarFuncionesPorPeliculaId(ObjectId peliculaId);

    List<Funcion> buscarTodas();

    void actualizarFuncion(Funcion funcion);

    void borrarFuncion(Funcion funcion);

    void guardarFuncion(Funcion funcion);
}
