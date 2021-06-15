package br.com.senai.gasolineapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication // faz a classe se comportar como start do projeto
@EnableSwagger2
public class GasolineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasolineApiApplication.class, args);
	}

}
