package org.luger.resource.pelicula.controller;

import org.bson.types.ObjectId;
import org.luger.resource.pelicula.model.Pelicula;
import org.luger.resource.pelicula.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @RequestMapping(value = "/pelicula/{timestamp}/{machineIdentifier}/{processIdentifier}/{counter}",
            method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    Pelicula buscarPeliculaPorId(@PathVariable int timestamp,@PathVariable int machineIdentifier,
                                 @PathVariable short processIdentifier,@PathVariable int counter) throws Exception{
        ObjectId peliculaId = new ObjectId(timestamp,machineIdentifier,processIdentifier,counter);
        return peliculaService.buscarPeliculaPorId(peliculaId);
    }

    @RequestMapping(value = "/pelicula",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    List<Pelicula> buscarTodas() throws Exception{
        return peliculaService.buscarTodas();
    }

    @RequestMapping(value = "/pelicula",method = RequestMethod.PUT,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String actualizarPelicula(@RequestBody Pelicula pelicula)throws Exception{
        peliculaService.actualizarPelicula(pelicula);
        return "Reservacion actualizada";
    }

    @RequestMapping(value = "/pelicula",method = RequestMethod.POST,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String guardarPelicula(@RequestBody Pelicula pelicula) throws Exception {
        peliculaService.guardarPelicula(pelicula);
        return "Reservacion Guardada";
    }

    @RequestMapping(value = "/pelicula",method = RequestMethod.DELETE,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String borrarPelicula(@RequestBody Pelicula pelicula) throws Exception {
        peliculaService.borrarPelicula(pelicula);
        return "Reservacion borrarda";
    }
}
