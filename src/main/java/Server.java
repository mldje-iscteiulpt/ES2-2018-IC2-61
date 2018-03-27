import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	
//	private final static int N=10;
//	private ExecutorService threadPool = Executors.newFixedThreadPool(N);

	public Server(int PORT) {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
	
		
		System.out.println("O servidor está operacional");
		try {
			while (true) {
				Socket infoClientSocket = serverSocket.accept();
				System.out.println("O cliente está ligado");
				ClientHandler clientHandler = new ClientHandler(this, infoClientSocket);
				clientHandler.init();
				clientHandler.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server(8080);
		server.init();

	}
}