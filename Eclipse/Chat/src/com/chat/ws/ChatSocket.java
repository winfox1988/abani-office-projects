package com.chat.ws;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

/**
 * Jetty WebSocketServlet implementation class ChatSocket
 */
@WebServlet("/wschat")
public class ChatSocket extends WebSocketServlet {

	private static final long serialVersionUID = -7054293726665450156L;
	private final Set<ChatSocketWebSocket> members = new CopyOnWriteArraySet<ChatSocketWebSocket>();
	
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
		return new ChatSocketWebSocket();
	}

	class ChatSocketWebSocket implements WebSocket.OnTextMessage {
		private Connection conn;
		@Override
		public void onClose(int arg0, String closeMsg) {
			System.out.println("ChatSocket.ChatSocketWebSocket.onClose() " + closeMsg);
			this.conn.close();
		}

		@Override
		public void onOpen(Connection conn) {
			System.out.println("connected " + conn.hashCode());
			members.add(this);
			this.conn = conn;
		}

		@Override
		public void onMessage(String arg0) {
			System.out.println("ChatSocket.ChatSocketWebSocket.onMessage() " + arg0);
			for (ChatSocketWebSocket member : members) {
					sendMessage(member.conn, "From Server " + arg0);
			}
		}
		
		private void sendMessage(Connection con, final String msg) {
			try {
				if (con.isOpen()) {
					con.sendMessage(msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
