package org.luger.resource.funcion.service;

import org.bson.types.ObjectId;
import org.luger.resource.funcion.dao.FuncionDAO;
import org.luger.resource.funcion.model.Funcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FuncionService")
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionDAO funcionDAO;

    @Override
    public Funcion buscarFuncionPorId(ObjectId funcionId) {
        return funcionDAO.buscarFuncionPorId(funcionId);
    }

    @Override
    public List<Funcion> buscarFuncionesPorPeliculaId(ObjectId peliculaId) {
        return funcionDAO.buscarFuncionesPorPeliculaId(peliculaId);
    }

    @Override
    public List<Funcion> buscarTodas() {
        return funcionDAO.buscarTodas();
    }

    @Override
    public void actualizarFuncion(Funcion funcion) {
        funcionDAO.actualizarFuncion(funcion);
    }

    @Override
    public void borrarFuncion(Funcion funcion) {
        funcionDAO.borrarFuncion(funcion);
    }

    @Override
    public void guardarFuncion(Funcion funcion) {
        funcionDAO.guardarFuncion(funcion);
    }
}
