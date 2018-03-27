import java.net.Socket;

public class ClientHandler extends Thread{
	
	private Server server;
	private Socket infoClientSocket;
	
	public ClientHandler(Server server, Socket infoClientSocket) {
		this.server=server;
		this.infoClientSocket=infoClientSocket;
		
	}
	
	@Override
	public void run() {
		super.run();
	}

	public void init() {
		
	}

}
