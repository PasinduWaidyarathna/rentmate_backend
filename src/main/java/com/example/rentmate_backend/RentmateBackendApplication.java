package com.example.rentmate_backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Student OPEN API",
				version = "1.0.0",
				description="Student OPEN API documentation"
		),
		servers = @Server(
				url ="http://localhost:8080/api/v1",
				description="Student OPEN API url"
		)
)
public class RentmateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentmateBackendApplication.class, args);
	}

}
