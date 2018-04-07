package com.example.demo.websocketinfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/webScoketServer/{userName}")
@Component
public class WebScoketServer {

	private static final Set<WebScoketServer> connection = new CopyOnWriteArraySet<>();

	private String nickname;
	private Session session;

	private static String getDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return sdf.format(date);
	}

	@OnOpen
	public void strat(@PathParam("userName") String userName, Session session) {
		this.nickname = userName;
		this.session = session;
		connection.add(this);
		String message = String.format("* %s %s", nickname, "加入聊天式");

	}

	@OnClose
	public void end() {
		connection.remove(this);
		String message = String.format("* %s %s", nickname, "退出聊天室");
		broadcast(message);
	}

	@OnMessage
	public void pushMsg(String message) {
		broadcast("[" + this.nickname + "]" + getDateTime(new Date()) + ":" + message);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		System.exit(1);
	}

	private static void broadcast(String msg) {
		for (WebScoketServer client : connection) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (Exception e) {
				// TODO: handle exception
				connection.remove(client);
				try {
					client.session.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				String message = String.format("* %s %s", client.nickname, "断开连接");
				broadcast(message);
			}
		}
	}

}
