
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 
/**
 * Creates a game which includes a board object and a referee object. 
 * Sets the players and the board of the game for the referee. 
 * 
 */

public class Game implements Constants, Runnable {
	/**
	 * The board in which the game is played 
	 */
	private Board theBoard;
	/**
	 * The ref which controls the turns and declares the winner 
	 */
	private Referee theRef;
	
    public Game( ) {
        theBoard  = new Board();
	}
    /**
     * Appoints a referee and begins the game 
     * @param object of type referee, the ref that controls the turns and declares the winner
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
		theRef.setBoard(theBoard);
		theRef.getxPlayer().setBoard(theBoard);
		theRef.getoPlayer().setBoard(theBoard);
    }
	
	
	public void run()
	{
			try {
				theRef.runTheGame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	

}
