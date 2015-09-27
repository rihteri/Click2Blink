package org.rihteri.clickblink;

import javax.websocket.server.ServerEndpointConfig;

/**
 * An endpoint configurator
 * @author rihteri
 *
 */
public class BlinkWebsocketConfigurator
		extends ServerEndpointConfig.Configurator {
	/**
	 * Important for security. This prevents other sites from
	 * opening a web socket pipe here.
	 */
	@Override
	public boolean checkOrigin(String originHeaderValue) {
        return originHeaderValue.equals("http://localhost:8080");
    }
}
