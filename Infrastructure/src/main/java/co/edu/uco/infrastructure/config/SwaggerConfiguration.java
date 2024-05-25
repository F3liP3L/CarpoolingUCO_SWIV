package co.edu.uco.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI caseOpenAPI() {
        String schemeName = "bearerAuth";
        String bearerFormat = "JWT";
        String scheme = "bearer";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(schemeName)).components(new Components()
                        .addSecuritySchemes(
                                schemeName, new SecurityScheme()
                                        .name(schemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .bearerFormat(bearerFormat)
                                        .in(SecurityScheme.In.HEADER)
                                        .scheme(scheme)
                        )
                )
                .info(new Info()
                        .title("Carpooling UCO API")
                        .description("All events for each of the entities of the uco carpoling application ")
                        .version("0.0.1-SNAPSHOT")
                );
    }

    @Bean
    public GroupedOpenApi authorizedCategory() {
        return GroupedOpenApi.builder()
                .group("Authorized Category API")
                .pathsToMatch("/api/v1/carpooling-uco/authorizedcategory/**")
                .build();
    }

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
    public GroupedOpenApi publicVehicleApi() {
        return GroupedOpenApi.builder()
                .group("Vehicle API")
                .pathsToMatch("/api/v1/carpooling-uco/vehicle/**")
                .build();
    }

    @Bean
    public GroupedOpenApi routeApi() {
        return GroupedOpenApi.builder()
                .group("Route API")
                .pathsToMatch("/api/v1/carpooling-uco/route/**")
                .build();
    }

    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
                .group("Auth API")
                .pathsToMatch("/api/v1/carpooling-uco/auth/**")
                .build();
    }



}
