package dev.ispiroglu.jobadvertysystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI().info(
        new Info().title("Jod Adverty System API")
            .license(new License().name("Jod Adverty System API"))
    );
  }
}
