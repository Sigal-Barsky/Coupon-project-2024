package com.sys.coupon.cofig;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration

public class OpenAPIConfiguration {
    @Bean
    public OpenAPI defineOpenAPI(@Value("springdoc-openapi-ui") String serviceTitle, @Value("1.6.12") String serviceVersion){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("test program");

        Contact myContact = new Contact();
        myContact.setName("Sb");
        myContact.setEmail("none");

        Info info = new Info()
                .title("coupon Management System API")
                .version("1.0")
                .description("manages coupons")
                .contact(myContact);

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes(
                                securitySchemeName,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )

//                .security(List.of(new SecurityRequirement().addList(securitySchemeName)))
                .info(info.version(serviceVersion)).servers(List.of(server));

    }

}
