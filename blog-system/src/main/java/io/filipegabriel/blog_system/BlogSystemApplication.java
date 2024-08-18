package io.filipegabriel.blog_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
@SpringBootApplication
public class BlogSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogSystemApplication.class, args);
	}

}
