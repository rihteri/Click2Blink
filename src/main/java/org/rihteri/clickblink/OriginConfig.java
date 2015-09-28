package org.rihteri.clickblink;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(
		value = "classpath:META-INF/config.properties",
		ignoreResourceNotFound = false)
public class OriginConfig {
	@PostConstruct
	public void setOrigin() {
		OriginConfig.allowed_origin = this.allowed_origin_property;
	}
	
	/**
	 * This bean is needed to resolve expressions in Value annotation
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer
						propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/**
	 * Used to populate value from Spring
	 */
	@Value("${server.allowed_origin}")
	private String allowed_origin_property;
	
	/**
	 * A static copy of the allowed origin to enable access
	 * from ServerEndpointConfig which is not constructed by
	 * Spring
	 */
	private static String allowed_origin;
	
	/**
	 * Use this to get the allowed origin configuration value outside of a
	 * Spring-constructed bean
	 * @return The server.allowed_origin property from config.properties
	 */
	public static String getAllowedOrigin() {
		return allowed_origin;
	}
}
