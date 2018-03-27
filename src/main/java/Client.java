import java.net.Socket;

public class Client extends Thread{

	private Socket infoServerSocket;
	private String host;
	private int port;
	
	private Thread thread;


	public Client(String host, int port) {
		super();
		this.host = host;
		this.port = port;
		
		thread = new Thread(this);
	}
	
	public void init() {
		try {
			infoServerSocket = new Socket(host, port);
		} catch (Exception e) {
		}
		
		thread.start();
	}
	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 8080);
		client.init();
	}

}

