package co.edu.uco.infrastructure.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicUserApi() {
        return GroupedOpenApi.builder()
                .group("User API")
                .pathsToMatch("/api/v1/carpooling-uco/customer/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicDriverApi() {
        return GroupedOpenApi.builder()
                .group("Driver API")
                .pathsToMatch("/api/v1/carpooling-uco/driver/**")
                .build();
    }

    @Bean
    public GroupedOpenApi internalProductApi() {
        return GroupedOpenApi.builder()
                .group("Product API")
                .pathsToMatch("/api/v1/carpooling-uco/route/**")
                .build();
    }

}
