package org.luger.resource.reservacion.service;

import org.bson.types.ObjectId;
import org.luger.resource.reservacion.dao.ReservacionDAO;
import org.luger.resource.reservacion.model.Reservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReservacionService")
public class ReservacionServiceImpl implements ReservacionService {

    @Autowired
    private ReservacionDAO reservacionDAO;

    @Override
    public Reservacion buscarReservacionPorId(ObjectId reservacionId) {
        return reservacionDAO.buscarReservacionPorId(reservacionId);
    }

    @Override
    public List<Reservacion> buscarTodas() {
        return reservacionDAO.buscarTodas();
    }

    @Override
    public void actualizarReservacion(Reservacion reservacion) {
        reservacionDAO.actualizarReservacion(reservacion);
    }

    @Override
    public void borrarReservacion(Reservacion reservacion) {
        reservacionDAO.borrarReservacion(reservacion);
    }

    @Override
    public void guardarReservacion(Reservacion reservacion) {
        reservacionDAO.guardarReservacion(reservacion);
    }
}
