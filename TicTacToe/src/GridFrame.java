import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridFrame extends Frame {
	
	JButton [] buttons;
	GridListener listener;
	JPanel subpanel;
	JTextArea textArea;
	JPanel subpanel2;
	char mark;
	Player player;
	JLabel label;
	JLabel marklabel;
	JTextField text;
	JScrollPane scrollPane;

	
	public GridFrame(Player player, String name, int width, int height, char mark)
	{
		this.player = player;
		this.mark = mark;
		
		setTitle("");
		setSize(width, height);
		
		subpanel = new JPanel();
		listener = new GridListener(this, player);
		subpanel.setLayout(new GridLayout(3, 3));
		buttons = new JButton[9];
		
		for (int i = 0; i < 9; i++)
		{
			buttons[i] = new JButton("");
	        buttons[i].addActionListener(listener);
	        
	        subpanel.add(buttons[i]);		
		}
		
		textArea = new JTextArea(5, 20);
		scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		
		subpanel2 = new JPanel();
		label = new JLabel("User Name:");
		text = new JTextField(10);
		marklabel = new JLabel("Player: " + mark);
		subpanel2.add(label);
		subpanel2.add(text);
		subpanel2.add(marklabel);
		
		setLayout(new BorderLayout());
		add("Center", subpanel);
		add("East", scrollPane);
		add("South", subpanel2);
		
		setVisible(true);
			
	}

}
