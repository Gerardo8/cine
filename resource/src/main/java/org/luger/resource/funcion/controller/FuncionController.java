package org.luger.resource.funcion.controller;

import org.bson.types.ObjectId;
import org.luger.resource.funcion.model.Funcion;
import org.luger.resource.funcion.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @RequestMapping(value = "/funcion",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    List<Funcion> buscarTodas() throws Exception{
        return funcionService.buscarTodas();
    }

    @RequestMapping(value = "/funcionPelicula/{timestamp}/{machineIdentifier}/{processIdentifier}/{counter}",
            method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    List<Funcion> buscarFuncionesPorPeliculaId(@PathVariable int timestamp,@PathVariable int machineIdentifier,
                                               @PathVariable short processIdentifier,@PathVariable int counter) throws Exception{
        ObjectId peliculaId = new ObjectId(timestamp,machineIdentifier,processIdentifier,counter);
        return funcionService.buscarFuncionesPorPeliculaId(peliculaId);
    }

    @RequestMapping(value = "/funcion/{timestamp}/{machineIdentifier}/{processIdentifier}/{counter}",
            method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody
    Funcion buscarFuncionPorId(@PathVariable int timestamp,@PathVariable int machineIdentifier,
                               @PathVariable short processIdentifier,@PathVariable int counter) throws Exception{
        ObjectId funcionId = new ObjectId(timestamp,machineIdentifier,processIdentifier,counter);
        return funcionService.buscarFuncionPorId(funcionId);
    }

    @RequestMapping(value = "/funcion",method = RequestMethod.PUT,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String actualizarFuncion(@RequestBody Funcion funcion)throws Exception{
        funcionService.actualizarFuncion(funcion);
        return "Funcion actualizada";
    }

    @RequestMapping(value = "/funcion",method = RequestMethod.POST,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String guardarFuncion(@RequestBody Funcion funcion) throws Exception {
        funcionService.guardarFuncion(funcion);
        return "Funcion Guardada";
    }

    @RequestMapping(value = "/funcion",method = RequestMethod.DELETE,headers={"Accept=application/json","Content-Type=application/json"})
    @ResponseBody
    String borrarFuncion(@RequestBody Funcion funcion) throws Exception {
        funcionService.borrarFuncion(funcion);
        return "Funcion borrarda";
    }
}
