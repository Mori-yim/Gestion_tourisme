package com.example.Gestion_Tourisme.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI springTourismOpenAPI() {
        return new OpenAPI()
                // 🔹 Ajout de sécurité JWT (Authorization: Bearer <token>)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                // 🔹 Informations sur l'API
                .info(new Info()
                        .title("API Tourisme Cameroun")
                        .description("Backend Spring Boot pour la gestion du tourisme au Cameroun")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipe Dev Tourisme")
                                .email("contact@tourisme-cm.com")
                                .url("https://tourisme-cm.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                // 🔹 Lien vers la doc externe
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation Complète")
                        .url("https://github.com/Mori-yim/"));
    }

//    @Bean
//    public OpenAPI apiInfo() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Tourism API")
//                        .description("API pour la gestion du tourisme au Cameroun")
//                        .version("1.0.0"));
//    }
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("TourismApp API")
//                        .version("1.0")
//                        .description("API de gestion du tourisme au Cameroun (Spring Boot + Angular)"));
//    }
}

