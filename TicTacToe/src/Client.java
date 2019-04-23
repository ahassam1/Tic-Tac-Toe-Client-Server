import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private PrintWriter out;
	private Socket sock;
	private BufferedReader stdin;
	private BufferedReader in;
	
	public Client (String servername, int portnumber)
	{
		try
			{
				sock = new Socket(servername, portnumber);
				in = new BufferedReader (new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter (sock.getOutputStream(), true);
				stdin = new BufferedReader(new InputStreamReader(System.in));
				
			}
		catch(IOException e)
			{
				e.printStackTrace();
			}
	}
	
	public void communicateServer()
	{
		try 
		{
			while(true)
			{
				String read = "";
				
				while(true)
				{
					read = in.readLine();
					if(read.contains("\0"))
					{	
						read = read.replace("\0", "");
						System.out.println(read);
						break;
					}
					if (read.contains("(A)"))
					{
						read = read.replace("(A)", "");
						System.out.println(read);
					}
					if(read == "QUIT")
					{
						return;
					}
					
				}
				
				read = stdin.readLine();
				out.println(read);
				out.flush();

			}
					
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
				out.close();
				stdin.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String [] args)
	{
		Client client = new Client("localhost", 8099);
		client.communicateServer();
	}
}
