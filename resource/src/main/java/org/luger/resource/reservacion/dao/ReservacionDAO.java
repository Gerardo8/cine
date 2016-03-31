package org.luger.resource.reservacion.dao;


import org.bson.types.ObjectId;
import org.luger.resource.reservacion.model.Reservacion;

import java.util.List;


public interface ReservacionDAO {

    Reservacion buscarReservacionPorId(ObjectId reservacionId);

    List<Reservacion> buscarTodas();

    void actualizarReservacion(Reservacion reservacion);

    void borrarReservacion(Reservacion reservacion);

    void guardarReservacion(Reservacion reservacion);
}
