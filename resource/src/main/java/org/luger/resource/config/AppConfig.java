package org.luger.resource.config;


import com.mongodb.MongoClient;
import org.luger.resource.funcion.dao.FuncionDAO;
import org.luger.resource.funcion.dao.FuncionDAOImpl;
import org.luger.resource.funcion.model.Funcion;
import org.luger.resource.pelicula.dao.PeliculaDAO;
import org.luger.resource.pelicula.dao.PeliculaDAOImpl;
import org.luger.resource.pelicula.model.Pelicula;
import org.luger.resource.reservacion.dao.ReservacionDAO;
import org.luger.resource.reservacion.dao.ReservacionDAOImpl;
import org.luger.resource.reservacion.model.Reservacion;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {
    @Bean
    public PeliculaDAO peliculaDAO() {
        return new PeliculaDAOImpl();
    }

    @Bean
    public Pelicula pelicula(){
        return new Pelicula();
    }

    @Bean
    public FuncionDAO funcionDAO() {
        return new FuncionDAOImpl();
    }

    @Bean
    public Funcion funcion(){
        return new Funcion();
    }

    @Bean
    public ReservacionDAO reservacionDAO() {
        return new ReservacionDAOImpl();
    }

    @Bean
    public Reservacion reservacion(){
        return new Reservacion();
    }

    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        Properties javaMailProperties = new Properties();
        sender.setHost("smtp.gmail.com");
        sender.setUsername("cine.proyecto.final@gmail.com");
        sender.setPassword("cineProyecto");
        sender.setPort(587);
        sender.setProtocol("smtp");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.debug", "true");
        sender.setJavaMailProperties(javaMailProperties);
        return sender;
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setPort(9000);
        tomcat.setContextPath("/resource");
        return tomcat;
    }

    @Bean
    public Datastore datastore(){
        MongoClient mongoClient = new MongoClient();
        Morphia morphia = new Morphia();
        return morphia.createDatastore(mongoClient,"cine");
    }
}
