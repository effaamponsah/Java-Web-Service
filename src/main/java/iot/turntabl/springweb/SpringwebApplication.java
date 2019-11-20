package iot.turntabl.springweb;

import iot.turntabl.springweb.controllers.Maths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
	}

	@Bean
	public Maths ops(){
		return new Maths();
	}
}
