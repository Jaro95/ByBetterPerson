package pl.jaroslaw.bybetterperson.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class OpenApiConfig {

    @Bean
    public OpenAPI customizeOpenApi() {


        return new OpenAPI()
                .info(new Info()
                        .title("OpenAPI REST interface")
                        .description("This is the API documentation for the rest ByBetterPersonApp REST interface"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local server")
                ));

    }
}
