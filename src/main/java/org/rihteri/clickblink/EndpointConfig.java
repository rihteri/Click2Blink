package org.rihteri.clickblink;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Required plumbing for Spring
 * @author rihteri
 *
 */
@Configuration
public class EndpointConfig {

    @Bean
    public BlinkChannelHandler blinkEndpoint() {
        return new BlinkChannelHandler();
    }

    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    } 
}
