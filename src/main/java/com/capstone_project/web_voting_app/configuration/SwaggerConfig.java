package com.capstone_project.web_voting_app.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "WEB VOTING APPLICATION",
                description = "A web restful app for carrying out an online voting exercise",
                summary = """
                        An application that mirrors actual physical voting\s
                        exercise where you have candidates (contestants in the election),\s
                        voters, election, and the admin to oversee the whole exercise""",
                version = "1.0.0",
                contact = @Contact(
                        name = "GROUP 7 CAPSTONE PROJECT",
                        url = "www.alexxycodes.com",
                        email = "kydjam@yahoo.com"),
                license = @License(name = "INGRYD ACADEMY",
                url = "https://ingrydacademy.edu")
                ),
        servers = @Server(description = "DEV-ENVIRONMENT",
                url="http://localhost:8080")
        /*security = {
                @SecurityRequirement(
                        name = "bearertoken auth")
        }*/
        )

@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "bearer auth",
        description = "JWT authorization",
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
