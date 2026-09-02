package com.example.config;
import org.springframework.context.annotation.ComponentScan; //Trae el componente de busqueda.

//Esta clase le dice al contenedor que busque anotaciones y cree los beans automaticamente.
@ComponentScan(basePackages = "com.example")
public class AppConfig {  
}
