package apigateway.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cliente-service", r -> r.path("/cliente/**").uri("lb://cliente-service"))
                .route("viaje-service", r -> r.path("/viaje/**").uri("lb://viaje-service"))
                // Agrega más rutas para tus microservicios
                .build();
    }
}
