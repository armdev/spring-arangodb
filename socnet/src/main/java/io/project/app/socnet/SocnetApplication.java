package io.project.app.socnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.project"})
@EntityScan("io.project.app.socnet.domain")
public class SocnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocnetApplication.class, args);
	}

}
