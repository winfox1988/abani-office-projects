/**
 * 
 */
package com.chat.ws;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

/**
 * @author behera
 *
 */
@WebServlet("/echo")
public class EchoSocketServlet extends WebSocketServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916222144137039836L;

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.websocket.WebSocketFactory.Acceptor#doWebSocketConnect(javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, String arg1) {
		return new EchoSocket();
	}
	class EchoSocket implements WebSocket.OnTextMessage {
		private Connection conn;
		@Override
		public void onClose(int arg0, String arg1) {
			System.out.println("Connection closed");
		}

		@Override
		public void onOpen(Connection conn) {
			this.conn = conn;
		}

		@Override
		public void onMessage(String msg) {
			System.out.println("Client message :: " + msg);
			try {
				conn.sendMessage("From Server :: " + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
