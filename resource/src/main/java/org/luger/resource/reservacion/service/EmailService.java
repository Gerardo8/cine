package org.luger.resource.reservacion.service;

import org.luger.resource.reservacion.model.Reservacion;

public interface EmailService {

    void enviarEmail(Reservacion reservacion);
}
