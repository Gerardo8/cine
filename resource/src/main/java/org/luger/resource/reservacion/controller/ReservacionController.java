package org.luger.resource.reservacion.controller;

import org.bson.types.ObjectId;
import org.luger.resource.reservacion.model.Reservacion;
import org.luger.resource.reservacion.service.EmailService;
import org.luger.resource.reservacion.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class ReservacionController {

    @Autowired
    private ReservacionService reservacionService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/reservacion/{timestamp}/{machineIdentifier}/{processIdentifier}/{counter}",
            method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    Reservacion buscarReservacionPorId(@PathVariable int timestamp,@PathVariable int machineIdentifier,
                                 @PathVariable short processIdentifier,@PathVariable int counter) throws Exception{
        ObjectId reservacionId = new ObjectId(timestamp,machineIdentifier,processIdentifier,counter);
        return reservacionService.buscarReservacionPorId(reservacionId);
    }

    @RequestMapping(value = "/reservacion",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    List<Reservacion> buscarTodas() throws Exception{
        return reservacionService.buscarTodas();
    }

    @RequestMapping(value = "/reservacion",method = RequestMethod.PUT,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String actualizarReservacion(@RequestBody Reservacion reservacion)throws Exception{
        reservacionService.actualizarReservacion(reservacion);
        return "Reservacion actualizada";
    }

    @RequestMapping(value = "/reservacion",method = RequestMethod.POST,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String guardarReservacion(@RequestBody Reservacion reservacion) throws Exception {
        reservacionService.guardarReservacion(reservacion);
        emailService.enviarEmail(reservacion);
        return "Reservacion Guardada";
    }

    @RequestMapping(value = "/reservacion",method = RequestMethod.DELETE,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String borrarReservacion(@RequestBody Reservacion reservacion) throws Exception {
        reservacionService.borrarReservacion(reservacion);
        return "Reservacion borrarda";
    }
}
