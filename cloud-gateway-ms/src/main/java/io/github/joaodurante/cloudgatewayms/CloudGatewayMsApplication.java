package io.github.joaodurante.cloudgatewayms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayMsApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/customer/**").uri("lb://customer-ms"))
				.route(r -> r.path("/card/**").uri("lb://card-ms"))
				.route(r -> r.path("/credit-appraisal/**").uri("lb://credit-appraisal-ms"))
				.build();
	}
}
