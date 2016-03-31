package org.luger.resource;

import com.mongodb.MongoClient;
import org.luger.resource.funcion.model.Asiento;
import org.luger.resource.funcion.model.Fila;
import org.luger.resource.funcion.model.Funcion;
import org.luger.resource.funcion.model.Sala;
import org.luger.resource.pelicula.model.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GuardarPelicula {
    public static void main(String[] args) {
        Pelicula pelicula =new Pelicula();
        MongoClient mongoClient = new MongoClient();
        Morphia morphia = new Morphia();
        morphia.map(Pelicula.class);
        Datastore datastore= morphia.createDatastore(mongoClient, "cine");

        pelicula.setClasificacion("C");
        pelicula.setNombreImagen("dulces.jpg");
        pelicula.setDuracion("100");
        pelicula.setGenero("Terror");
        pelicula.setPais("USA");
        pelicula.setSinopsis("Lucile Angellier (Michelle Williams) es una hermosa joven que aguarda noticias de su marido, prisionero de guerra, mientras lleva u" +
                "na sofocante existencia junto a su controladora suegra (Kristin Scott Thomas) en un pequeño pueblo de la Francia de 1940. Ambas viven ajenas a la " +
                "realidad de la guerra hasta que un grupo de refugiados parisinos llega a la localidad huyendo de la ocupación, al que le sigue un regimiento de s" +
                "oldados alemanes que establecen sus residencias en los hogares de los habitantes del pueblo. En casa de los Angellier, Lucile intenta en un princi" +
                "pio ignorar a Bruno (Matthias Schoenaerts), el elegante y refinado oficial alemán a quien se le ha encargado vivir con ellas. Pero poco a poco, un po" +
                "deroso amor les unirá y atrapará en un momento donde el amor queda oscurecido por la infame realidad.");
        pelicula.setTitulo("Dulces Sueños Mamá");
        datastore.save(pelicula);

        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L'};

        List<Asiento> asientos = new ArrayList<Asiento>();

        List<Fila> filas = new ArrayList<Fila>();
        Sala sala = new Sala();

        for (int i=0;i<15;i++){
            Asiento asiento = new Asiento();
            asiento.setDeshabilitado(false);
            asiento.setSeleccionado(false);
            asiento.setNumero(Integer.toString(i+1));
            asientos.add(i,asiento);
        }

        for (int i =0;i<12;i++){
            Fila fila = new Fila();
            fila.setAsientos(asientos);
            fila.setFila(Character.toString(alphabet[i]));
            filas.add(fila);
        }

        sala.setFilas(filas);
        sala.setNombre("1");

        Date date = new Date();

        for(int i = 0;i<8;i++){

            Funcion funcion =new Funcion();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, Integer.parseInt(pelicula.getDuracion())+10);
            date = calendar.getTime();
            funcion.setFecha(date);
            funcion.setSala(sala);
            funcion.setPelicula(pelicula);
            datastore.save(funcion);
        }
    }
}
