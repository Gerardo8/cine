package org.luger.resource.reservacion.service;

import org.luger.resource.reservacion.model.Reservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("EmailService")
public class EmailServiceImpl implements EmailService{
    @Autowired
    private MailSender mailSender; // MailSender interface defines a strategy
    // for sending simple mails

    public void enviarEmail(Reservacion reservacion) {
        reservacion.getAsientos();
        reservacion.getNombreSala();
        String mensage = "Se ha realizado una compra de boletos de cine a nombre de "+reservacion.getNombreCliente()
                + " para la pelicula "+reservacion.getNombrePelicula()+" el dia "+reservacion.getFechaFuncion().toString()
                + "\n Sala: "+reservacion.getNombreSala()+"\n Asientos: "+ Arrays.toString(reservacion.getAsientos());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("cine.proyecto.final@gmail.com");
        simpleMailMessage.setTo(reservacion.getEmailCliente());
        simpleMailMessage.setSubject("Compra de boletos de cine");
        simpleMailMessage.setText(mensage);
        try{
            mailSender.send(simpleMailMessage);
        }
        catch (MailException ex){
            System.err.println(ex.getMessage());
        }
    }
}
