import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class GridListener implements ActionListener {
	private GridFrame frame;
	private Player player;

	// constructor
	public GridListener(GridFrame g, Player player) {
		frame = g;
		this.player = player;
	}

	// performs an action in response to the event
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() ==frame.buttons[0]) 
		{
			player.frame.buttons[0].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[0].setText(Character.toString(player.mark));
			player.board.addMark(0, 0, player.mark);
		}
		if (e.getSource() ==frame.buttons[1]) 
		{
			player.frame.buttons[1].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[1].setText(Character.toString(player.mark));
			player.board.addMark(0, 1, player.mark);

		}
		if (e.getSource() ==frame.buttons[2]) 
		{
			player.frame.buttons[2].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[2].setText(Character.toString(player.mark));
			player.board.addMark(0, 2, player.mark);

		}
		if (e.getSource() ==frame.buttons[3]) 
		{
			player.frame.buttons[3].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[3].setText(Character.toString(player.mark));
			player.board.addMark(1, 0, player.mark);

		}
		if (e.getSource() ==frame.buttons[4]) 
		{
			player.frame.buttons[4].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[4].setText(Character.toString(player.mark));
			player.board.addMark(1, 1, player.mark);

		}
		if (e.getSource() ==frame.buttons[5]) 
		{
			player.frame.buttons[5].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[5].setText(Character.toString(player.mark));
			player.board.addMark(1, 2, player.mark);

		}
		if (e.getSource() ==frame.buttons[6]) 
		{
			player.frame.buttons[6].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[6].setText(Character.toString(player.mark));
			player.board.addMark(2, 0, player.mark);

		}
		if (e.getSource() ==frame.buttons[7]) 
		{
			player.frame.buttons[7].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[7].setText(Character.toString(player.mark));
			player.board.addMark(2, 1, player.mark);

		}		
		if (e.getSource() ==frame.buttons[8]) 
		{
			player.frame.buttons[8].setText(Character.toString(player.mark));
			player.opponent.frame.buttons[8].setText(Character.toString(player.mark));
			player.board.addMark(2, 2, player.mark);

		}

	}

	
}