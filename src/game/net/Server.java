package game.net;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	
	private static ServerSocket socket;

	public static void start(int port) throws IOException {
		socket = new ServerSocket(port);
	}
}
