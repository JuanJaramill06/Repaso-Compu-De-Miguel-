package com.example;

import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext; //Usar interfaz de ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

// Este es un contenedor dentro de un contenedor, entonces practicamente crea el ApplicationContext y lo mantiene disponible para los servlets.
//ApplicationContext es la fabrica de los objetos Beans, los conecta y los administra.
public class Application {
 private static final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);//creamos el contexto (solo una vez), debe apuntar al mismo contenedor, lee el archivo de configuración de AppConfig.java que me dicee los pasquetes en los que debe buscar anotaciones. 

    public static ApplicationContext getContext() { //devuelve contenedor de spring para que los Servlets pidan los beans que necesitan.
        return context;
    }
}

