package org.luger.resource.reservacion.dao;

import org.bson.types.ObjectId;
import org.luger.resource.reservacion.model.Reservacion;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ReservacionDAO")
public class ReservacionDAOImpl implements ReservacionDAO {

    @Autowired
    private Datastore datastore;

    @Override
    public Reservacion buscarReservacionPorId(ObjectId reservacionId) {
        return datastore.get(Reservacion.class,reservacionId);
    }

    @Override
    public List<Reservacion> buscarTodas() {
        return datastore.find(Reservacion.class).asList();
    }

    @Override
    public void actualizarReservacion(Reservacion reservacion) {
        datastore.save(reservacion);
    }

    @Override
    public void borrarReservacion(Reservacion reservacion) {
        datastore.delete(reservacion);
    }

    @Override
    public void guardarReservacion(Reservacion reservacion) {
        datastore.save(reservacion);
    }
}
