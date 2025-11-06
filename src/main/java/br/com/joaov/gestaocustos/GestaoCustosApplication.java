package br.com.joaov.gestaocustos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GestaoCustosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoCustosApplication.class, args);
    }

}
