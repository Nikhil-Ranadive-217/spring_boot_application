package com.springboot.CloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
		
		
	}
	
	//Circuit Breaker Configuration at API gateway END 
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCutomizer()
	{
		return factory -> factory.configureDefault(
							id -> new Resilience4JConfigBuilder(id)
							.circuitBreakerConfig(io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.ofDefaults())
							.build()
							);
		
	}
	

	//Configuration for Ratelimiter and reddis
	@Bean
	KeyResolver userKeyResolver()
	{
		return exchange -> Mono.just("userKey");
	}

}
