/***
@ A Hassam
@ Version 1
@ Feb 2
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class Player {
	/**
	 * name of player
	 */
	String name;
	/**
	 * board used by the player 
	 */
	Board board;
	/**
	 * opponent of the player 
	 */
	Player opponent;
	/**
	 * player's mark, can be x or y 
	 */
	char mark;
	/**
	 * constructor that assigns name and mark to player 
	 * @param name
	 * @param mark
	 */
	
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	BufferedReader stdin;
	GridFrame frame;

	public Player(Socket s, char mark) {
		
		this.sock = s;
		this.mark = mark;
		
		try 
			{
				in = new BufferedReader (new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter (sock.getOutputStream());
				
			}
		catch (IOException e)
			{
				e.printStackTrace();
			}
	}
	
	/**
	 * Displays the boardstate to a client 
	 */
	public void clientdisplay()
	{	
		sendstring("          |col 0|col 1|col 2" + "(A)");
		sendstring("          +-----+-----+-----+" + "(A)");
		sendstring("          |     |     |     |" + "(A)");
		sendstring("    row 0 |  " + board.getMark(0, 0) + "  | " + board.getMark(0, 1) + "   | " + board.getMark(0, 2) +   "   | " + "(A)");
		sendstring("          |     |     |     |" + "(A)");
		sendstring("          +-----+-----+-----+" + "(A)");
		sendstring("          |     |     |     |" + "(A)");
		sendstring("    row 1 |  " + board.getMark(1, 0) + "  | " + board.getMark(1, 1) + "   | " + board.getMark(1, 2) +   "   | " + "(A)");
		sendstring("          |     |     |     |" + "(A)");
		sendstring("          +-----+-----+-----+" + "(A)");
		sendstring("          |     |     |     |" + "(A)");
		sendstring("    row 2 |  " + board.getMark(2, 0) + "  | " + board.getMark(2, 1) + "   | " + board.getMark(2, 2) +   "   | " + "(A)");
		sendstring("          |     |     |     |" + "(A)");
		sendstring("          +-----+-----+-----+" + "(A)");
	
	}
	public void sendstring (String s)
	{
		out.println(s);
		out.flush();
	}
	/**
	 * reads input from console and assigns mark to input row/column 
	 * @throws IOException 
	 */
	private void makemove() throws IOException {	
		
		/*
		clientdisplay();
		sendstring("Enter the row for: " + mark + " player: " + name + "\0");
		int row = Integer.parseInt(in.readLine());
		sendstring("Enter the column for: " + mark + " player: " + name + "\0");
		int column = Integer.parseInt(in.readLine());
		board.addMark (row, column, mark);
		*/		
	}
	/**
	 * allows players to take make moves until a player has won or the board is full 
	 * @throws IOException 
	 */
	public void play() throws IOException {
		
		while(board.oWins() == false && board.xWins() == false && board.isFull() == false)
		{
			makemove();
			
			if (board.oWins() == true)
			{	
				frame.textArea.append("Player O wins");
				opponent.frame.textArea.append("Player O wins");
				break;
			}
			
			if (board.xWins() == true)
			{
				frame.textArea.append("Player X wins");
				opponent.frame.textArea.append("Player X wins");
				break;
			}
			
			if (board.isFull() == true)
			{	
				frame.textArea.append("Tie!");
				opponent.frame.textArea.append("Tie!");
				break;
			}
			
			opponent.makemove();
			
			if (board.oWins() == true)
			{	
				frame.textArea.append("Player O wins");
				opponent.frame.textArea.append("Player O wins");
				break;
			}
			
			if (board.xWins() == true)
			{
				frame.textArea.append("Player X wins");
				opponent.frame.textArea.append("Player X wins");
				break;
			}
			
			if (board.isFull() == true)
			{	
				frame.textArea.append("Tie!");
				opponent.frame.textArea.append("Tie!");
				break;
			}
			
		}			
	}
	

	public void getplayername ()
	{
		try 
		{
			sendstring("Please enter the name of " + mark + " player \0");
			while (name == null)
			{
				name = in.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	


	public void setopponent(Player player) {
		
		this.opponent = player;
		
	}

	
	public void setBoard(Board theBoard) {
		
		this.board = theBoard;
		
	}

	public void createFrame(Player Player) {
	
	GridFrame frame = new GridFrame(Player, name, 500, 500, mark);
	this.frame = frame;
	
		
	}





}
