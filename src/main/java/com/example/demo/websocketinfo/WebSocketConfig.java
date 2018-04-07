package com.example.demo.websocketinfo;

import org.springframework.web.socket.server.standard.ServerEndpointExporter;

public class WebSocketConfig {

	public ServerEndpointExporter serverEndpointExporter() {

		return new ServerEndpointExporter();
	}
}
