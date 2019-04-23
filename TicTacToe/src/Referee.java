import java.io.IOException;

/***
@ A Hassam
@ Version 1
@ Feb 2
*/
/**
 * 
 * sets the two players, sets the board, sets one player as the opponent of another players 
 * and starts the game
 *
 */
public class Referee {
	/**
	 * player1
	 */
	Player xPlayer;
	/**
	 * player2
	 */
	Player oPlayer;
	/**
	 * object of type board 
	 */
	Board board;

	
	public void setBoard(Board theBoard) {
	
		this.board = theBoard;
		
	}

	public void setoPlayer(Player oPlayer) {
		
		this.oPlayer = oPlayer;
	}

	public void setxPlayer(Player xPlayer) {
		
		this.xPlayer = xPlayer;		
	}
	public Player getxPlayer()
	{
		return xPlayer;
	}
	public Player getoPlayer()
	{
		return oPlayer;
	}
	/**
	 * set playero as opponent to playerx. Display the board and allow player x to take their first turn. 
	 * @throws IOException 
	 */
	public void runTheGame() throws IOException {
		
		xPlayer.setopponent(oPlayer);
		oPlayer.setopponent(xPlayer);
		
		xPlayer.createFrame(xPlayer);
		oPlayer.createFrame(oPlayer);
		
		xPlayer.play();
		
	}



}
