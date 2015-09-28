package org.rihteri.clickblink;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.server.ServerEndpointConfig;
/**
 * An endpoint configurator
 * @author rihteri
 *
 */
public class BlinkWebsocketConfigurator
		extends ServerEndpointConfig.Configurator {
	public BlinkWebsocketConfigurator() {
		this.allowed_origin = OriginConfig.getAllowedOrigin();
	}
	
	/**
	 * Important for security. This prevents other sites from
	 * opening a web socket pipe here.
	 */
	@Override
	public boolean checkOrigin(String originHeaderValue) {
        return originHeaderValue.equals(allowed_origin);
    }
	
	/**
	 * Read the allowed origin from configuration file
	 */
	private String allowed_origin;
}
