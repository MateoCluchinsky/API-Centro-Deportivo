package com.tuempresa.centrodeportivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO: Seguridad deshabilitada temporalmente para facilitar el desarrollo y pruebas de los endpoints.
// Se implementará la configuración de Spring Security en la próxima etapa.
@SpringBootApplication
public class CentrodeportivoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentrodeportivoApplication.class, args);
    }
}