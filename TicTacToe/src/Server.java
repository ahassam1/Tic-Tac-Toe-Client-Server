import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
private ServerSocket serversocket;
private ExecutorService pool;
PrintWriter out;
BufferedReader in;

	public Server (int portnumber)
	{
		try 
			{
				serversocket = new ServerSocket(portnumber);
				pool = Executors.newCachedThreadPool();
			}
		
		catch(IOException e)
			{
				e.printStackTrace();
			}
	}
	private void communicatewithclient() throws IOException
	{	
	  try {
		  while(true)
		  	{

			  Player xPlayer = new Player(serversocket.accept(),'X'); 
			  Player oPlayer = new Player(serversocket.accept(),'O');
			  Referee theRef = new Referee ();
			  
			  theRef.setxPlayer(xPlayer);
			  theRef.setoPlayer(oPlayer);
			  
			  Game theGame = new Game();
			  theGame.appointReferee(theRef);
			  
			  System.out.println("Game has started");
			  
			  pool.execute(theGame);
			  			  
		  	}
	  	  }
	  catch (Exception e)
	  {
		  pool.shutdown();
	  }
	}
	
	public static void main(String [] args) throws IOException
	{
		Server server = new Server(8099);
		System.out.println("Server online");
		
		server.communicatewithclient();
		
	}



}
